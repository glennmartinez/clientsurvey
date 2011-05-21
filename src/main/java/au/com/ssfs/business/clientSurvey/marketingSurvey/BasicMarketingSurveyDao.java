package au.com.ssfs.business.clientSurvey.marketingSurvey;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.apache.poi.*;

public final class BasicMarketingSurveyDao implements MarketingSurveyDao {

	private static Logger logger = LoggerFactory.getLogger(BasicMarketingSurveyDao.class);

	private JdbcTemplate jdbcTemplate;
	private JdbcTemplate jdbcTemplate2;
		
	
	@Autowired
	public BasicMarketingSurveyDao(DataSource sqldataSource, DataSource infodataSource) {
		this.jdbcTemplate = new JdbcTemplate(sqldataSource);
		this.jdbcTemplate2 = new JdbcTemplate(infodataSource);
		
	}

	public List<MarketingSurvey> getMarketingSurveyList() {
		logger.debug("Getting marketing survey list.");
		return jdbcTemplate.query("select * from marketing limit 200", new RowMapper<MarketingSurvey>() {

			public MarketingSurvey mapRow(ResultSet rs, int rowNum) throws SQLException {
				MarketingSurvey marketingSurvey = new MarketingSurvey();
				marketingSurvey.setStartDate(rs.getDate("mks_rpsdate"));
				marketingSurvey.setEndDate(rs.getDate("mks_rpedate"));
				marketingSurvey.setRunDate(rs.getDate("mks_rundate"));
				marketingSurvey.setInterviewDate(rs.getDate("mks_interviewdate"));
				marketingSurvey.setClientId(rs.getString("mks_prospectid"));
				marketingSurvey.setClientType(rs.getString("mks_clienttype"));
				marketingSurvey.setContact(rs.getString("mks_contact"));
				marketingSurvey.setPlannerName(rs.getString("mks_plannername"));
				marketingSurvey.setPlannerRegion(rs.getString("mks_plannerregion"));
				marketingSurvey.setEmail(rs.getString("mks_prefer_email"));
				
				return marketingSurvey;
			}

		});
	}
	
	public List<MarketingSurvey> getPlannerTotalsList2(MarketingSurvey params2){
		
		final String rundate = params2.getIntDate();
		
		
		return jdbcTemplate.execute("{call myprod(?)}", new CallableStatementCallback<List<MarketingSurvey>>(){
			
		public List<MarketingSurvey> doInCallableStatement(CallableStatement cs) throws SQLException,
		DataAccessException{
			
			 	cs.setString(1, rundate);
			 	ResultSet rs = null;
			 	List<MarketingSurvey> marketingSurveyList = new ArrayList<MarketingSurvey>();
			 	                               try {
			 	                                       rs = cs.executeQuery();
			 	                                       while (rs.next()) {
			 	                                            MarketingSurvey marketingSurvey = new MarketingSurvey();
			 	                                           	                                             
			 	                                 			marketingSurvey.setClientId(rs.getString("mks_prospectid"));
			 	                                 			marketingSurvey.setContact(rs.getString("mks_contact"));
			 	                                 			marketingSurvey.setInterviewDate(rs.getDate("mks_interviewDate"));
			 	                                 			marketingSurvey.setClientType(rs.getString("mks_clienttype"));
			 	                                 			marketingSurvey.setPlannerName(rs.getString("mks_plannername"));
			 	                                 			marketingSurvey.setDateofBirth(rs.getDate("mks_dateofbirth"));
			 	                                 			marketingSurvey.setPlannerRegion(rs.getString("mks_plannerregion"));
			 	                                 			marketingSurvey.setEmail(rs.getString("mks_prefer_email"));

			 	                                               marketingSurveyList.add(marketingSurvey);
			 	                                       }
			 	                               }
			 	                               finally {
			 	                                       rs.close();
			 	                               }
			 	                               return marketingSurveyList;
			 	                       }
			 	               });
		}
		
		
	
	
	public List<MarketingSurvey> getPlannerTotalsList(MarketingSurvey params2) {
			//SimpleDateFormat checkIT = new SimpleDateFormat("yyyy-mm-dd");
			//Date coolDate = null;
			String rundate2 = params2.getIntDate();
			//if (rundate2 == null){
				
			//	rundate2 = "syd1";
		//	}
			
			//try {
				 
			//	 Date coolDate2 = checkIT.parse(rundate);
				 
				 
			//} catch (ParseException e) {
			//	System.out.println("Invalid Date Parser Exception ");
			//	e.printStackTrace();
			//}
			
			String sqlbuilder = "select * from marketing";
			String sqlbuilder2 = " where mks_plannerregion =" + "'" + rundate2 + "'";
			
			
			String finalSQL = sqlbuilder + sqlbuilder2;	         
     
        return jdbcTemplate.query(finalSQL, new RowMapper<MarketingSurvey>() {

			public MarketingSurvey mapRow(ResultSet rs, int rowNum) throws SQLException {
				MarketingSurvey marketingSurvey = new MarketingSurvey();
				marketingSurvey.setClientId(rs.getString("mks_prospectid"));
				marketingSurvey.setContact(rs.getString("mks_contact"));
				marketingSurvey.setInterviewDate(rs.getDate("mks_interviewDate"));
				marketingSurvey.setClientType(rs.getString("mks_clienttype"));
				marketingSurvey.setPlannerName(rs.getString("mks_plannername"));
				marketingSurvey.setDateofBirth(rs.getDate("mks_dateofbirth"));
				marketingSurvey.setPlannerRegion(rs.getString("mks_plannerregion"));
				marketingSurvey.setEmail(rs.getString("mks_prefer_email"));
				
				return marketingSurvey;
				
				
										
				
			}
				
		});
        
	
			} 

	public MarketingSurvey getMarketingSurvey(Integer id) {
		throw new NotImplementedException();
	}

	public void saveMarketingSurvey(MarketingSurvey marketingSurvey) {
		throw new NotImplementedException();
	}

	public void deleteMarketingSurvey(List<Integer> idList) {
		throw new NotImplementedException();
	}

	public boolean getMarketingSurvey(Date startDate) {
		logger.debug("Getting marketing survey by start date.");
		String sql = "select distinct mks_rpsdate from marketing where mks_rpsdate = ?";
		Date reportStartDate = jdbcTemplate.queryForObject(sql, new RowMapper<Date>() {

			public Date mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getDate("mks_rpsdate");
			}

		}, startDate);

		if (reportStartDate != null) {
			return true;
		}
		return false;
	}

	public void executeClientSurveyProcedure(final Date startDate, final Date endDate) {
		List<SqlParameter> declaredParameters = new ArrayList<SqlParameter>();
		declaredParameters.add(new SqlParameter(Types.DATE));
		declaredParameters.add(new SqlParameter(Types.DATE));

		jdbcTemplate.call(new CallableStatementCreator() {

			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cs = con.prepareCall("{call clientsurvey(?, ?)}");
				cs.setDate(1, new java.sql.Date(startDate.getTime()));
				cs.setDate(2, new java.sql.Date(endDate.getTime()));
		
				return cs;
			}

		}, declaredParameters);
	}

	@Override
	public searchParameters getParameters(MarketingSurvey params) {
		String sql = "select * from marketing ";
		String[] cols = { "mks_prospectid", "mks_contact", "mks_interviewDate", "mks_clienttype", "mks_plannername","mks_dateofbirth","mks_plannerregion","mks_prefer_email" };
		int amount = 10;
		int start = 0;
		int echo = 0;
		int col = 0;
		String dir = "asc";
		
		List<String> sArray = new ArrayList<String>();
		if (!params.getClientId().equals("")) {
			String sclientId = " mks_prospectid like '%" + params.getClientId() + "%'";
			sArray.add(sclientId);
			//or combine the above two steps as:
			//sArray.add(" engine like '%" + engine + "%'");
			//the same as followings
		}
		if (!params.getContact().equals("")) {
			String sContact = " mks_contact like '%" + params.getContact() + "%'";
			sArray.add(sContact);
		}
		if (!params.getIntDate().equals("")) {
			String sPlatform = " mks_interviewDate like '%" + params.getIntDate() + "%'";
			sArray.add(sPlatform);
		}
		if (!params.getClientType().equals("")) {
			String sClientType = " mks_clienttype like '%" + params.getClientType() + "%'";
			sArray.add(sClientType);
		}
		if (!params.getPlannerName().equals("")) {
			String sPlannerName = " mks_plannername like '%" + params.getPlannerName() + "%'";
			sArray.add(sPlannerName);
		}
		if (!params.getDob().equals("")) {
			String sDob = " mks_dateofbirth like '%" + params.getDob() + "%'";
			sArray.add(sDob);
		}
		if (!params.getPlannerRegion().equals("")) {
			String sPlannerRegion = " mks_plannerregion like '%" + params.getPlannerRegion() + "%'";
			sArray.add(sPlannerRegion);
		}
		if (!params.getEmail().equals("")) {
			String sEmail = " mks_prefer_email like '%" + params.getPlannerName() + "%'";
			sArray.add(sEmail);
		}
		
		String individualSearch = "";
		if(sArray.size()==1){
			individualSearch = sArray.get(0);
		}else if(sArray.size()>1){
			for(int i=0;i<sArray.size()-1;i++){
				individualSearch += sArray.get(i)+ " and ";
			}
			individualSearch += sArray.get(sArray.size()-1);
		}
		
		if (params.getsStart() != null) {
			start = Integer.parseInt(params.getsStart());
			if (start < 0)
				start = 0;
		}
		if (params.getsAmount() != null) {
			amount = Integer.parseInt(params.getsAmount());
			if (amount < 10 || amount > 100)
				amount = 10;
		}
		if (params.getsEcho() != null) {
			echo = Integer.parseInt(params.getsEcho());
		}
		if (params.getsCol() != null) {
			col = Integer.parseInt(params.getsCol());
			if (col < 0 || col > 8)
				col = 0;
		}
		if (params.getSdir() != null) {
			if (!params.getSdir().equals("asc"))
				dir = "desc";
		}
		String colName = cols[col];
		int total = 0;
				
		String sql2 = "select count(*) from marketing";
		int count = jdbcTemplate.queryForInt(sql2);
		final int mycount = count;
		total = count;
		int totalAfterFilter = total;
		/////////////////////////////////////////////
		
			String searchSQL = "";
			String sql3 = "SELECT * FROM marketing";
			String searchTerm = params.getsSearch();
			String globeSearch =  " where (mks_prospectid like '%"+searchTerm+"%'"
									+ " or mks_contact like '%"+searchTerm+"%'"
									+ " or mks_interviewDate like '%"+searchTerm+"%'"
									+ " or mks_clienttype like '%"+searchTerm+"%'"
									+ " or mks_plannername like '%"+searchTerm+"%'"
									+ " or mks_dateofbirth like '%"+searchTerm+"%'"
									+ " or mks_plannerregion like '%"+searchTerm+"%'"
									+ " or mks_prefer_email like '%"+searchTerm+"%')";
									
			if(searchTerm!=""&&individualSearch!=""){
				searchSQL = globeSearch + " and " + individualSearch;
			}
			else if(individualSearch!=""){
				searchSQL = " where " + individualSearch;
			}else if(searchTerm!=""){
				searchSQL=globeSearch;
			}
			sql3 += searchSQL;
			sql3 += " order by " + colName + " " + dir;
			//sql3 += " limit " + start + ", " + amount;
			
			
			int count2 = 0;
			String sql4 = "SELECT count(*) FROM marketing";
			if (searchTerm != "") {
					sql4 += searchSQL;
					 count2 = jdbcTemplate.queryForInt(sql4);
					  
								
			}
			
			
			List<MarketingSurvey> marketingSurvey  = jdbcTemplate.query(sql3, new RowMapper<MarketingSurvey>() {

				public MarketingSurvey mapRow(ResultSet rs, int rowNum) throws SQLException {
					MarketingSurvey marketingSurvey = new MarketingSurvey();
					marketingSurvey.setClientId(rs.getString("mks_prospectid"));
					marketingSurvey.setContact(rs.getString("mks_contact"));
					marketingSurvey.setInterviewDate(rs.getDate("mks_interviewDate"));
					marketingSurvey.setClientType(rs.getString("mks_clienttype"));
					marketingSurvey.setPlannerName(rs.getString("mks_plannername"));
					marketingSurvey.setDateofBirth(rs.getDate("mks_dateofbirth"));
					marketingSurvey.setPlannerRegion(rs.getString("mks_plannerregion"));
					marketingSurvey.setEmail(rs.getString("mks_prefer_email"));
					
					return marketingSurvey;
														
					
				}
							
			});
			
			searchParameters results = new searchParameters();
			results.setMarketingSurvey(marketingSurvey);
			results.setTotalDisplay(count);
			results.setAfterDisplay(count2);
			results.setEcho(echo);
			
			return results;
			
							
		}

	@Override
	public Integer getiTotalRecords(MarketingSurvey params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getiTotalDisplayRecords(MarketingSurvey params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getisEcho(MarketingSurvey params) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
