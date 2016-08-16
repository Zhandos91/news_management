
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title" ignore="true" /></title>
</head>
<body>
<table border="1" width="100%" cellpadding="2" cellspacing="2">
    <tr>
        <td height="10%" colspan="2">
            <tiles:insert attribute="header" ignore="true" />
        </td>
    </tr>
    <tr>
        <td width="20%" height="450">
            <tiles:insert attribute="menu" />
        </td>
        <td>
            <tiles:insert attribute="body" />
        </td>
    </tr>
    <tr>
        <td height="10%" colspan="2">
            <tiles:insert attribute="footer" />
        </td>
    </tr>
</table>
</body>
</html>