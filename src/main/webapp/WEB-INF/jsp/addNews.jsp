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
<%@ taglib prefix="hmml" uri="http://struts.apache.org/tags-html" %>
<html>
<head>
    <title><bean:message key="page.add.title"/></title>
</head>
<body>

<html:form action="/news">

<div>
    <bean:message key="news.title"></bean:message>
    <html:text property="title"></html:text>
</div>

<div>
    <bean:message key="news.date"></bean:message>
    <hmml:text property="date"></hmml:text>
</div>

<div>
    <bean:message key="news.brief"></bean:message>
    <html:textarea property="brief"></html:textarea>
</div>

<div>
    <bean:message key="news.content"></bean:message>
    <html:textarea property="content"></html:textarea>
</div>

<div style="margin-left:150px">
    <html:submit property="action" value="Save News">
        <bean:message key="button.save"></bean:message>
    </html:submit>

    <html:submit property="action" value="Cancel News">
    <bean:message key="button.cancel"></bean:message>
    </html:submit>

</div>
    </html:form>


<%--<div class="container">--%>

<%--<form id="addNewsForm" class="form-horizontal" role="form" action="news" method="post">--%>

<%--<div class="page-header"><h2>Add news</h2></div>--%>

<%--<div class="form-group">--%>
<%--<label class="control-label col-md-2" for="news_title">News Title:</label>--%>
<%--<div class="col-md-10">--%>
<%--<input type="text" class="form-control" id="news_title" name="news_title">--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="form-group">--%>
<%--<label class="control-label col-md-2" for="news_date">News Date:</label>--%>
<%--<div class="col-md-10">--%>
<%--<input type="text" class="form-control" id="news_date" name="news_date">--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="form-group">--%>
<%--<label class="control-label col-md-2" for="news_brief">Brief:</label>--%>
<%--<div class="col-md-10">--%>
<%--<textarea class="form-control" rows="4" id="news_brief" name="news_brief"></textarea>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="form-group">--%>
<%--<label class="control-label col-md-2" for="news_content">Content:</label>--%>
<%--<div class="col-md-10">--%>
<%--<textarea class="form-control" rows="6" id="news_content" name="news_content"></textarea>--%>
<%--</div>--%>
<%--</div>--%>


<%--<div class="form-group">--%>
<%--<div class="col-md-offset-2 col-md-10">--%>
<%--<button type="submit" class="btn btn-primary" name="action" value="Save News">SAVE</button>--%>
<%--<button type="submit" class="btn btn-primary" name="action" value="Cancel News">CANCEL</button>--%>
<%--</div>--%>
<%--</div>--%>

<%--</form>--%>
<%--</div>--%>

</body>
</html>
