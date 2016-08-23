<%--
  Created by IntelliJ IDEA.
  User: Zhandos_Suleimenov
  Date: 8/16/2016
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
</head>
<body>
<h4><bean:message key="page.list.title"/></h4>

<div style="color:red">${deleteError}</div>
<html:form action="/news?action=Delete News">

    <logic:iterate id="news" property="newsList" name="newsForm">

        <div style="padding-top:50px; margin-bottom: 50px; border:1px solid; background-color: darkgoldenrod">
            <label><bean:write name="news" property="title"></bean:write></label>
            <label style="float: right"><u><bean:write name="news" property="date"></bean:write></u></label>
            <br/>

            <div style="padding-top:10px;width:80%">
                <bean:write name="news" property="brief"></bean:write>
            </div>
            <br/>

            <div style="float: right;">
                <html:link action="/news.do?action=View News&news_id=${news.getId()}"><bean:message
                        key="link.view"></bean:message></html:link>
                <html:link action="/news.do?action=Edit News&news_id=${news.getId()}"><bean:message
                        key="link.edit"></bean:message></html:link>
                <html:multibox property="checked" value="${news.getId()}"></html:multibox>
            </div>
        </div>

    </logic:iterate>

    <div style="padding-top:20px; float:right">
        <html:submit onclick="javascript:return confirm('are you sure?');">
            <bean:message key="button.delete"></bean:message>
        </html:submit>
    </div>

</html:form>


</body>
</html>
