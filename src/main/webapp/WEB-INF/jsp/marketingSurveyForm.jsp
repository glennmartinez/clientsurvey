<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2> Welcome to Client Survey Report Generation</h2>

<form:form commandName="marketingSurvey">
	<div>
		<label for="startDate">Report Start Date:</label>
		<form:input path="startDate" />
		<form:errors path="startDate" />
	</div>
	<div>
		<label for="endDate">Report End Date:</label>
		<form:input path="endDate" />
		<form:errors path="endDate" />
	</div>
	<div>
		<input type="submit" name="SUBMIT" />
	</div>
</form:form>
