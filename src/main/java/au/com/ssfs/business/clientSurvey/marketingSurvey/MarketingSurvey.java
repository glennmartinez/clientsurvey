package au.com.ssfs.business.clientSurvey.marketingSurvey;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class MarketingSurvey implements Serializable {

	private static final long serialVersionUID = 4521889822259997753L;

	private Integer id;
	private Date startDate;
	private Date endDate;
	private Date runDate;
	private String clientId;
	private String clientType;
	private String plannerCode;
	private String plannerName;
	private String plannerRegion;
	private String contact;
	private String gender;
	private Date dateofBirth;
	private String email;
	private Date interviewDate;
	private Integer ifBalance;
	private Integer prpBalance;
	private Integer tapBalance;
	private Integer fuaValue;
	private Date invstEventDate;
	private String scheme;
	private Integer clientEmail;
	private Integer clientNoemail;
	private Integer prospectEmail;
	private Integer prospectNoemail;
	private Integer percentClientEmail;
	private Integer percentClientNoemail;
	private Integer percentProsEmail;
	private Integer percentProsNoemail;
	private Integer percentTotalemail;
	
	private String sStart;
	private String sAmount;
	private String sEcho;
	private String sCol;
	private String sdir;
	private String dir;
	private String sSearch;
	private String intDate;
	private String dob;
	private Integer iTotalRecords;
	private Integer iTotalDisplayRecords;
	private Integer iEcho;
	
	
	


	

	public MarketingSurvey() {
			// TODO Auto-generated constructor stub
		}
		
		public MarketingSurvey(String sdir,String sStart,String sAmount,String sEcho,String sCol,String dir,String sSearch,String clientId,String contact,
				String intDate,String clientType,String plannerName,String dob,String plannerRegion,String email){
			
			this.sdir = sdir;
			this.sStart = sStart;
			this.sAmount = sAmount;
			this.sEcho = sEcho;
			this.sCol = sCol;
			this.dir = dir;
			this.sSearch = sSearch;
			this.clientId = clientId;
			this.contact = contact;
			this.intDate = intDate;
			this.clientType = clientType;
			this.plannerName = plannerName;
			this.dob = dob;
			this.plannerRegion = plannerRegion;
			this.email = email;
		}
	
		
		public Integer getiTotalRecords() {
			return iTotalRecords;
		}

		public void setiTotalRecords(Integer iTotalRecords) {
			this.iTotalRecords = iTotalRecords;
		}

		public Integer getiTotalDisplayRecords() {
			return iTotalDisplayRecords;
		}

		public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
			this.iTotalDisplayRecords = iTotalDisplayRecords;
		}

		public String getIntDate() {
			return intDate;
		}

		public void setIntDate(String intDate) {
			this.intDate = intDate;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getDir() {
			return dir;
		}

		public void setDir(String dir) {
			this.dir = dir;
		}

		public String getsSearch() {
			return sSearch;
		}

		public void setsSearch(String sSearch) {
			this.sSearch = sSearch;
		}

	public String getsStart() {
		return sStart;
	}

	public void setsStart(String sStart) {
		this.sStart = sStart;
	}

	public String getsAmount() {
		return sAmount;
	}

	public void setsAmount(String sAmount) {
		this.sAmount = sAmount;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsCol() {
		return sCol;
	}

	public void setsCol(String sCol) {
		this.sCol = sCol;
	}

	public String getSdir() {
		return sdir;
	}

	public void setSdir(String sdir) {
		this.sdir = sdir;
	}

	public Integer getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(Integer clientEmail) {
		this.clientEmail = clientEmail;
	}

	public Integer getClientNoemail() {
		return clientNoemail;
	}

	public void setClientNoemail(Integer clientNoemail) {
		this.clientNoemail = clientNoemail;
	}

	public Integer getProspectEmail() {
		return prospectEmail;
	}

	public void setProspectEmail(Integer prospectEmail) {
		this.prospectEmail = prospectEmail;
	}

	public Integer getProspectNoemail() {
		return prospectNoemail;
	}

	public void setProspectNoemail(Integer prospectNoemail) {
		this.prospectNoemail = prospectNoemail;
	}

	public Integer getPercentClientEmail() {
		return percentClientEmail;
	}

	public void setPercentClientEmail(Integer percentClientEmail) {
		this.percentClientEmail = percentClientEmail;
	}

	public Integer getPercentClientNoemail() {
		return percentClientNoemail;
	}

	public void setPercentClientNoemail(Integer percentClientNoemail) {
		this.percentClientNoemail = percentClientNoemail;
	}

	public Integer getPercentProsEmail() {
		return percentProsEmail;
	}

	public void setPercentProsEmail(Integer percentProsEmail) {
		this.percentProsEmail = percentProsEmail;
	}

	public Integer getPercentProsNoemail() {
		return percentProsNoemail;
	}

	public void setPercentProsNoemail(Integer percentProsNoemail) {
		this.percentProsNoemail = percentProsNoemail;
	}

	public Integer getPercentTotalemail() {
		return percentTotalemail;
	}

	public void setPercentTotalemail(Integer percentTotalemail) {
		this.percentTotalemail = percentTotalemail;
	}

	public Date getRunDate() {
		return runDate;
	}

	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getPlannerCode() {
		return plannerCode;
	}

	public void setPlannerCode(String plannerCode) {
		this.plannerCode = plannerCode;
	}

	public String getPlannerName() {
		return plannerName;
	}

	public void setPlannerName(String plannerName) {
		this.plannerName = plannerName;
	}

	public String getPlannerRegion() {
		return plannerRegion;
	}

	public void setPlannerRegion(String plannerRegion) {
		this.plannerRegion = plannerRegion;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public Integer getIfBalance() {
		return ifBalance;
	}

	public void setIfBalance(Integer ifBalance) {
		this.ifBalance = ifBalance;
	}

	public Integer getPrpBalance() {
		return prpBalance;
	}

	public void setPrpBalance(Integer prpBalance) {
		this.prpBalance = prpBalance;
	}

	public Integer getTapBalance() {
		return tapBalance;
	}

	public void setTapBalance(Integer tapBalance) {
		this.tapBalance = tapBalance;
	}

	public Integer getFuaValue() {
		return fuaValue;
	}

	public void setFuaValue(Integer fuaValue) {
		this.fuaValue = fuaValue;
	}

	public Date getInvstEventDate() {
		return invstEventDate;
	}

	public void setInvstEventDate(Date invstEventDate) {
		this.invstEventDate = invstEventDate;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof MarketingSurvey)) {
			return false;
		}
		MarketingSurvey object = (MarketingSurvey) obj;
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(object.startDate, startDate);
		builder.append(object.endDate, endDate);
		return builder.isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(startDate);
		builder.append(endDate);
		return builder.hashCode();
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append(id);
		builder.append(startDate);
		builder.append(endDate);
		return builder.toString();
	}

	public void setiEcho(Integer iEcho) {
		this.iEcho = iEcho;
	}

	public Integer getiEcho() {
		return iEcho;
	}

}
