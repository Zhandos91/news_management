
<%--<jsp:forward page="WEB-INF/jsp/test.jsp"/>--%>

<%--<jsp:forward page="/invitation.do"/>--%>

<%--<jsp:forward page="/invitation"></jsp:forward>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<logic:redirect action="/news?action=News List"/>


</body>
</html>

