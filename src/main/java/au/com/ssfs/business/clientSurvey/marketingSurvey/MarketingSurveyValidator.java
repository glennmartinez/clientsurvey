package au.com.ssfs.business.clientSurvey.marketingSurvey;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MarketingSurveyValidator implements Validator {

	private MarketingSurveyDao marketingSurveyDao;

	public MarketingSurveyValidator(MarketingSurveyDao marketingSurveyDao) {
		this.marketingSurveyDao = marketingSurveyDao;
	}

	public boolean supports(Class<?> clazz) {
		return MarketingSurvey.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		MarketingSurvey marketingSurvey = (MarketingSurvey) target;
		ValidationUtils.rejectIfEmpty(errors, "startDate", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "endDate", "field.required");
		

		if (marketingSurveyDao.getMarketingSurvey(marketingSurvey.getStartDate())) {
			errors.reject("marketingSurvey.startDate.duplicate");
		}
	}

}
