package au.com.ssfs.business.clientSurvey.marketingSurvey;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.google.common.collect.Lists;
import com.google.gson.Gson;

@RequestMapping(value = "/marketingSurvey")
public class MarketingSurveyController {

	private static final Logger logger = LoggerFactory.getLogger(MarketingSurveyController.class);

	private MarketingSurveyDao marketingSurveyDao;
	private MessageSource messageSource;

	@Autowired
	public MarketingSurveyController(MarketingSurveyDao marketingSurveyDao, MessageSource messageSource) {
		this.marketingSurveyDao = marketingSurveyDao;
		this.messageSource = messageSource;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.setValidator(new MarketingSurveyValidator(marketingSurveyDao));
		
		

	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String getMarketingSurveyForm(Model model) {
		model.addAttribute("marketingSurvey", new MarketingSurvey());
		return "marketingSurveyForm";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String callClientSurveyProcedure(@ModelAttribute MarketingSurvey marketingSurvey, BindingResult result, SessionStatus status, HttpSession session) {
		if (result.hasErrors()) {
			return "marketingSurveyForm";
		}

		List<String> messageList = Lists.newArrayList();

		try {
			Date startDate = marketingSurvey.getStartDate();
			Date endDate = marketingSurvey.getEndDate();
			marketingSurveyDao.executeClientSurveyProcedure(startDate, endDate);
			messageList.add(messageSource.getMessage("success.storedProcCall", null, null));
			status.setComplete();
		}
		catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
			messageList.add(messageSource.getMessage("failure.storedProcCall", null, null));
		}

		session.setAttribute("messageList", messageList);
		return "redirect:/marketingSurvey/form.html";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getMarketingSurveyList(Model model) {
		List<MarketingSurvey> marketingSurveyList = marketingSurveyDao.getMarketingSurveyList();
		model.addAttribute("marketingSurveyList", marketingSurveyList);
		return "marketingSurveyList";
	}
	
	@RequestMapping(value = "/json2", method = RequestMethod.GET)
	@ResponseBody
	public String getMarketingSurveyListasJson() {
		List<MarketingSurvey> marketingSurveyList = marketingSurveyDao.getMarketingSurveyList();
		String[][] aaData = new String[marketingSurveyList.size()][8];
		
		 
		for (int i=0; i<marketingSurveyList.size(); i++) {
			aaData[i][0] = marketingSurveyList.get(i).getClientId();
			aaData[i][1] = marketingSurveyList.get(i).getContact();
			aaData[i][2] = marketingSurveyList.get(i).getInterviewDate().toString();
			aaData[i][3] = marketingSurveyList.get(i).getClientType();
			aaData[i][4] = marketingSurveyList.get(i).getPlannerName();
			aaData[i][5] = marketingSurveyList.get(i).getRunDate().toString();
			aaData[i][6] = marketingSurveyList.get(i).getPlannerRegion();
			aaData[i][7] = marketingSurveyList.get(i).getEmail();
						
		}
		String obj = new Gson().toJson(aaData);
		obj =  "{\"aaData\":" + obj + "}";
		return obj;
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.GET)
		@ResponseBody
		public String getMarketingSurveyListasJson(HttpServletRequest request) {
			
			 MarketingSurvey params = new MarketingSurvey();
			 params.setsStart(request.getParameter("iDisplayStart"));
			 params.setsAmount(request.getParameter("iDisplayLength"));
			 params.setsEcho(request.getParameter("sEcho"));
			 params.setsCol(request.getParameter("iSortCol_0"));
			 params.setSdir(request.getParameter("sSortDir_0"));
			 params.setsSearch(request.getParameter("sSearch"));
			 params.setClientId(request.getParameter("sSearch_0"));
			 params.setContact(request.getParameter("sSearch_1"));
			 params.setIntDate(request.getParameter("sSearch_2"));
			 params.setClientType(request.getParameter("sSearch_3")); 
			 params.setPlannerName(request.getParameter("sSearch_4"));
			 params.setDob(request.getParameter("sSearch_5"));
			 params.setPlannerRegion(request.getParameter("sSearch_6"));
			 params.setEmail(request.getParameter("sSearch_7")); 
		
						 
			 int start = Integer.parseInt(request.getParameter("iDisplayStart"));		
			 int display = Integer.parseInt(request.getParameter("iDisplayLength"));
			
			searchParameters results = marketingSurveyDao.getParameters(params);
			List<MarketingSurvey> marketingSurveyList = results.getMarketingSurvey();			
			int iTotalRecords = results.getTotalDisplay();
			int iTotalDisplayRecords = results.getAfterDisplay();
			int sEcho2 = results.getEcho();
			
			if(display > iTotalDisplayRecords - start){
				display = iTotalDisplayRecords - start;
			}
			String[][] aaData = new String[display][8];
			
			List<MarketingSurvey> filteredRequest = new ArrayList<MarketingSurvey>();
			for (int i=start; i<display + start; i++) {
				filteredRequest.add(marketingSurveyList.get(i));
			}
			
			for (int i=0; i<display; i++) {
			aaData[i][0] = marketingSurveyList.get(i).getClientId();
			aaData[i][1] = marketingSurveyList.get(i).getContact();
			aaData[i][2] = marketingSurveyList.get(i).getInterviewDate().toString();
			aaData[i][3] = marketingSurveyList.get(i).getClientType();
			aaData[i][4] = marketingSurveyList.get(i).getPlannerName();
			aaData[i][5] = marketingSurveyList.get(i).getDateofBirth().toString();
			aaData[i][6] = marketingSurveyList.get(i).getPlannerRegion();
			aaData[i][7] = marketingSurveyList.get(i).getEmail();
			}
			String obj = new Gson().toJson(aaData);
			
										
			obj =  "{\"sEcho\":"   + sEcho2 +",\"iTotalRecords\":"   +  iTotalRecords +",\"iTotalDisplayRecords\":"   +  iTotalDisplayRecords  +",\"aaData\":" +   obj + "}";
			//obj =  "{\"aaData\":" + obj + "}";
			
		
			return obj;

		}
	
	@RequestMapping(value = "/planner", method = RequestMethod.GET)
	
	public String getPlannerTotalsList(Model model,HttpServletRequest request){
		MarketingSurvey params2 = new MarketingSurvey();
		params2.setIntDate(request.getParameter("sSearch_6"));
		List<MarketingSurvey> marketingSurveyList = marketingSurveyDao.getPlannerTotalsList(params2);
		model.addAttribute("marketingSurveyList", marketingSurveyList);
		return "marketingSurveyPlanner";
		
	}
	
	@RequestMapping(value = "/planner2", method = RequestMethod.GET)
	@ResponseBody
	public String getPlannerTotalsList(HttpServletRequest request) {
		MarketingSurvey params2 = new MarketingSurvey();
		params2.setIntDate(request.getParameter("runDate"));
		List<MarketingSurvey> marketingSurveyList = marketingSurveyDao.getPlannerTotalsList(params2);
		int listsize = marketingSurveyList.size();
		String[][] aaData = new String[marketingSurveyList.size()][8];
		
		for (int i=0; i<listsize; i++) {
			aaData[i][0] = marketingSurveyList.get(i).getClientId();
			aaData[i][1] = marketingSurveyList.get(i).getContact();
			aaData[i][2] = marketingSurveyList.get(i).getInterviewDate().toString();
			aaData[i][3] = marketingSurveyList.get(i).getClientType();
			aaData[i][4] = marketingSurveyList.get(i).getPlannerName();
			aaData[i][5] = marketingSurveyList.get(i).getDateofBirth().toString();
			aaData[i][6] = marketingSurveyList.get(i).getPlannerRegion();
			aaData[i][7] = marketingSurveyList.get(i).getEmail();
			}
			String obj = new Gson().toJson(aaData);
			obj =  "{\"aaData\":" + obj + "}";
			return obj;
			//return "marketingSurveyPlanner";
		//model.addAttribute("marketingSurveyList", marketingSurveyList);
		//return "marketingSurveyPlanner";
		//return marketingSurveyList;
	}
}
