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
    <title><bean:message key="page.list.title"/></title>
</head>
<body>


<html:form action="/news">

    <logic:iterate id="news" property="newsList" name="newsForm">
        <div class="padding-top:130px">
            <bean:write name="news" property="title"></bean:write>
            <bean:write name="news" property="date"></bean:write>
        </div>
        <br/>
        <div class="padding-top:130px">
            <bean:write name="news" property="brief"></bean:write>
        </div>
        <br/>
        <html:link action="/news.do?action=View News&news_id=${news.getId()}" ><bean:message key="link.view"></bean:message></html:link>
        <html:link action="/news.do?action=Edit News&news_id=${news.getId()}" ><bean:message key="link.edit"></bean:message></html:link>
        <%--<html:checkbox property="" value=""></html:checkbox>--%>
        <html:multibox property="checked" value="${news.getId()}"></html:multibox>
    </logic:iterate>
    <%--<a href="/news.do?action=View News&news_id=${news.getId()}">view</a>--%>

    <html:submit property="action" value="Delete News">
        <bean:message key="button.delete"></bean:message>
    </html:submit>
</html:form>


<%--<form id="addNewsForm" class="form-horizontal" role="form" action="news" method="post">--%>

<%--<div class="page-header"><h2>List news</h2></div>--%>

<%--<c:forEach items="${sessionScope.list_news}" var="news">--%>

<%--<div class="form-group">--%>
<%--<label class="control-label">${news.getTitle()}</label>--%>
<%--<label class="control-label col-md-offset-8">${news.getDate()}</label>--%>

<%--</div>--%>

<%--<div class="form-group">--%>
<%--<label class="control-label">${news.getBrief()}</label>--%>
<%--</div>--%>

<%--<div class="form-group">--%>
<%--&lt;%&ndash;<input class="form-control" type="hidden" name="news_id" value=${news.getId()} />&ndash;%&gt;--%>
<%--<label class="control-label col-md-offset-9"><a href="/news.do?action=View News&news_id=${news.getId()}">view</a></label>--%>
<%--<label class="control-label"><a href="/news.do?action=Add News">edit</a></label>--%>
<%--<div class="checkbox-inline">--%>
<%--<label class="control-label"><input type="checkbox" value=""></label>--%>
<%--</div>--%>
<%--</div>--%>


<%--</c:forEach>--%>

<%--<div class="form-group">--%>
<%--<div class="col-md-offset-9">--%>
<%--<button type="submit" class="btn btn-primary" name="action" value="Delete News">DELETE</button>--%>
<%--</div>--%>
<%--</div>--%>

<%--</form>--%>


</body>
</html>
