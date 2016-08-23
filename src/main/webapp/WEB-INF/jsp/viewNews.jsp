<%--
  Created by IntelliJ IDEA.
  User: Zhandos_Suleimenov
  Date: 8/17/2016
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<bean:define id="news" property="newsMessage" name="newsForm"></bean:define>
<html>
<head>
</head>
<body>

<h4><bean:message key="page.view.title"/></h4>

<%--<html:form action="/news?">--%>
<table>
    <tr>
        <td><bean:message key="news.title"></bean:message></td>
        <td><bean:write name="news" property="title"></bean:write></td>
    </tr>

    <tr>
        <td><bean:message key="news.date"></bean:message></td>
        <td><bean:write name="news" property="date"></bean:write></td>
    </tr>

    <tr>
        <td><bean:message key="news.brief"></bean:message></td>
        <td><bean:write name="news" property="brief"></bean:write></td>
    </tr>

    <tr>
        <td><bean:message key="news.content"></bean:message></td>
        <td><bean:write name="news" property="content"></bean:write></td>
    </tr>
</table>
<br/>
<div>
    <html:link action="/news.do?action=Edit News&news_id=${news.id}">
        <button type="button"><bean:message key="button.edit"></bean:message></button>
    </html:link>
    <html:link action="/news.do?action=Delete News&news_id=${news.id}">
        <button type="button" onclick="javascript:return confirm('are you sure?');"><bean:message
                key="button.delete"></bean:message></button>
    </html:link>
</div>


</body>
</html>
