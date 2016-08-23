<%--
  Created by IntelliJ IDEA.
  User: Zhandos_Suleimenov
  Date: 7/8/2016
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<body>--%>
<%--<a href="Link.do?method=friends" >Friends</a><br>--%>
<%--<a href="Link.do?method=office" >The Office</a>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>


<html>
<body>
<div style="background-color: green;margin-top: 50px;position: fixed;width: 19.5%;top:83px">

    <div sty>
        <h4 align="center"><bean:message key="main.menu.header"/></h4>
    </div>
    <div >
        <ul>
            <li><a href="/news.do?action=News List"><bean:message key="main.menu.list1"/></a></li>
            <li><a href="/addNews.do"><bean:message key="main.menu.list2"/></a></li>
        </ul>
    </div>

</div>
<br>

</body>
</html>