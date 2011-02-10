package au.com.ssfs.business.clientSurvey.marketingSurvey;

import java.util.List;

public class searchParameters {
	
	public List<MarketingSurvey> marketingSurvey;
	public Integer totalDisplay;
	public Integer afterDisplay;
	public Integer echo;
	
	public List<MarketingSurvey> getMarketingSurvey() {
		return marketingSurvey;
	}
	public void setMarketingSurvey(List<MarketingSurvey> marketingSurvey) {
		this.marketingSurvey = marketingSurvey;
	}
	public Integer getTotalDisplay() {
		return totalDisplay;
	}
	public void setTotalDisplay(Integer totalDisplay) {
		this.totalDisplay = totalDisplay;
	}
	public Integer getAfterDisplay() {
		return afterDisplay;
	}
	public void setAfterDisplay(Integer afterDisplay) {
		this.afterDisplay = afterDisplay;
	}
	public Integer getEcho() {
		return echo;
	}
	public void setEcho(Integer echo) {
		this.echo = echo;
	}


	

}
