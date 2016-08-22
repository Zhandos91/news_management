<%--
  Created by IntelliJ IDEA.
  User: Zhandos_Suleimenov
  Date: 8/16/2016
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title><bean:message key="page.add.title"/></title>
</head>
<body>
<c:set var="today" value="<%=new java.util.Date()%>" />
<p><fmt:formatDate var="now" value="${today}" pattern="yyyy-MM-dd" /> </p>

<h4>Add News</h4>
<div style="color: red">
<html:errors></html:errors>
</div>

<html:form action="/add?action=Add News">

    <table>
        <tr>
            <td><bean:message key="news.title"></bean:message></td>
            <td><html:text size="56" property="title"></html:text></td>
        </tr>

        <tr>
            <td><bean:message key="news.date"></bean:message></td>
            <td><html:text size="13" property="date" value="${now}"></html:text></td>
        </tr>

        <tr>
            <td><bean:message key="news.brief"></bean:message></td>
            <td><html:textarea rows="5" cols="58" property="brief"></html:textarea></td>
        </tr>

        <tr>
            <td><bean:message key="news.content"></bean:message></td>
            <td><html:textarea rows="8" cols="58" property="content"></html:textarea></td>
        </tr>
    </table>
    <br/><br/>
    <div style="margin-left:210px">
        <html:submit >
            <bean:message key="button.save"></bean:message>
        </html:submit>
            <%--<html:link action="/news.do?action=Save News&news_id=${news.id}" ><button type="button"><bean:message key="button.save"></bean:message></button></html:link>--%>
        <html:link action="/news.do?action=News List">
            <button type="button"><bean:message key="button.cancel"></bean:message></button>
        </html:link>
    </div>

</html:form>

</body>
</html>
