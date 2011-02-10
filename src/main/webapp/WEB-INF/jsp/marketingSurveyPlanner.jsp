<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<table id="table2" class="display">
<thead>

<input type="text" name="rundate" value="" id="rundate" >

<input type="submit" name="SUBMIT" id="submit" />
<tr>
	<th>Client ID</th>
	<th>Client Name</th>
	<th>Interview Date</th>
	<th>Client Type</th>
	<th>Planner Name</th>
	<th>Date of Birth</th>
	<th>Planner Region</th>
	<th>Client Email</th>
</tr>
</thead>
<tbody>
<c:forEach items="${marketingSurveyList}" var="marketingSurvey">
	<tr id>
		<td>${marketingSurvey.clientId}</td>
		<td>${marketingSurvey.contact}</td>
		<td><fmt:formatDate value="${marketingSurvey.interviewDate}" pattern="dd/MM/yyyy" /></td>
		<td>${marketingSurvey.clientType}</td>
		<td>${marketingSurvey.plannerName}</td>
		<td><fmt:formatDate value="${marketingSurvey.dateofBirth}" pattern="dd/MM/yyyy" /></td>
		<td>${marketingSurvey.plannerRegion}</td>
		<td>${marketingSurvey.email}</td>
		
	</tr>
</c:forEach>
</tbody>
</table>
