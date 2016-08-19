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
<bean:define id="news" property="newsMessage" name="newsForm"></bean:define>
<html>
<head>
    <title><bean:message key="page.add.title"/></title>
</head>
<body>

<h4>Edit News</h4>

<html:form action="/news?action=Save News">

<table>
    <tr>
        <html:hidden property="id" value="${news.id}"></html:hidden>
        <td> <bean:message key="news.title"></bean:message></td>
        <td><html:text size="56" property="title" value="${news.title}"></html:text></td>
    </tr>

    <tr>
        <td><bean:message key="news.date"></bean:message></td>
        <td><html:text property="date" value="${news.date}"></html:text></td>
    </tr>

    <tr>
        <td><bean:message key="news.brief"></bean:message></td>
        <td><html:textarea rows="6" cols="80" property="brief" value="${news.brief}"></html:textarea></td>
    </tr>

    <tr>
        <td><bean:message key="news.content"></bean:message></td>
        <td><html:textarea rows="8" cols="80" property="content" value="${news.content}"></html:textarea></td>
    </tr>
</table>


    <div style="margin-left: 250px; margin-top: 20px">
        <html:submit>
            <bean:message key="button.save"></bean:message>
        </html:submit>
            <%--<html:link action="/news.do?action=Save News&news_id=${news.id}" ><button type="button"><bean:message key="button.save"></bean:message></button></html:link>--%>
        <html:link action="/news.do?action=Cancel News" ><button type="button"><bean:message key="button.cancel"></bean:message></button></html:link>
    </div>

</html:form>


</body>
</html>
