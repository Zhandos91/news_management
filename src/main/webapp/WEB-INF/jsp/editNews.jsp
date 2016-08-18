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
hello

<html:form action="/news?action=Save News">


    <div>
        <html:hidden property="id" value="${news.id}"></html:hidden>
        <bean:message key="news.title"></bean:message>
        <html:text property="title" value="${news.title}"></html:text>
    </div>

    <div>
        <bean:message key="news.date"></bean:message>
        <html:text property="date" value="${news.date}"></html:text>
    </div>

    <div>
        <bean:message key="news.brief"></bean:message>
        <html:textarea property="brief" value="${news.brief}"></html:textarea>
    </div>

    <div>
        <bean:message key="news.content"></bean:message>
        <html:textarea property="content" value="${news.content}"></html:textarea>
    </div>

    <div>
        <html:submit>
            <bean:message key="button.save"></bean:message>
        </html:submit>
            <%--<html:link action="/news.do?action=Save News&news_id=${news.id}" ><button type="button"><bean:message key="button.save"></bean:message></button></html:link>--%>
        <html:link action="/news.do?action=Cancel News" ><button type="button"><bean:message key="button.cancel"></bean:message></button></html:link>
    </div>

</html:form>


</body>
</html>
