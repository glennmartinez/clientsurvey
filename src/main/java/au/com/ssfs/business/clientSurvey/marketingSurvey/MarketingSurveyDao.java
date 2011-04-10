package au.com.ssfs.business.clientSurvey.marketingSurvey;

import java.util.Date;
import java.util.List;

public interface MarketingSurveyDao {

	public List<MarketingSurvey> getMarketingSurveyList();

	public MarketingSurvey getMarketingSurvey(Integer id);

	public void saveMarketingSurvey(MarketingSurvey marketingSurvey);

	public void deleteMarketingSurvey(List<Integer> idList);

	public boolean getMarketingSurvey(Date startDate);

	public void executeClientSurveyProcedure(Date startDate, Date endDate);
	
	public List<MarketingSurvey> getPlannerTotalsList(MarketingSurvey params2);
		
	public searchParameters getParameters(MarketingSurvey params);
	
	public Integer getiTotalRecords(MarketingSurvey params);
	public Integer getiTotalDisplayRecords(MarketingSurvey params);
	public Integer getisEcho(MarketingSurvey params);
}
