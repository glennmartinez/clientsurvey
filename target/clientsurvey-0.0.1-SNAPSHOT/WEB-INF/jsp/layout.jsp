<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/clientsurvey/css/default.css" />
	<link rel="stylesheet" type="text/css" href="/clientsurvey/css/cs-dataTables.css" />
	<link rel="stylesheet" type="text/css" href="/clientsurvey/css/TableTools.css" />
	<title><tiles:insertAttribute name="title" /></title>
	
<div id="contentWrapper">
</head>
<body >
<div id="outerWrapper">
<div id="header">
	<tiles:insertAttribute name="header" />
</div>
<div id="contentWrapper">
<div id="menu">
	<tiles:insertAttribute name="menu" />
</div>

<div id="content">
	<div id="messages">
		<c:forEach items="${sessionScope.messageList}" var="message" varStatus="status">
			<span class="message">${message}</span>${status.last ? '' : '<br />'}
		</c:forEach>
	</div>
	<c:remove var="messageList" scope="session" />
	<tiles:insertAttribute name="body" />
</div>

<script type="text/javascript" src="/clientsurvey/js/jquery.js"></script>
<script type="text/javascript" src="/clientsurvey/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/clientsurvey/js/csurvey.js"></script>
<script type="text/javascript" src="/clientsurvey/js/TableTools.js"></script>
<script type="text/javascript" src="/clientsurvey/js/ZeroClipboard.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var jsFunctionName = '<tiles:insertAttribute name="jsFunctionName" />';
	if (jsFunctionName) {
		eval(jsFunctionName + '()');
	}
});
</script>
</div>
<div id="footer">
<tiles:insertAttribute name="footer" />
</div>
</div>
</body>
</html>
