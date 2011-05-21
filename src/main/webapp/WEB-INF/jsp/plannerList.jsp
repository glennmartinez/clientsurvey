<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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