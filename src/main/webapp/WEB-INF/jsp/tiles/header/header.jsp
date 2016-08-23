<%--
  Created by IntelliJ IDEA.
  User: Zhandos_Suleimenov
  Date: 7/8/2016
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<div style="padding: 15px;background-color: white" align="left">
    <h1><bean:message key="main.header"/></h1>
    <div style="float:right">
    <html:link action="/changeLocale.do?action=en" ><bean:message key="main.language.english"/></html:link>
    <html:link action="/changeLocale.do?action=ru" ><bean:message key="main.language.russian"/></html:link>
    </div>
</div>