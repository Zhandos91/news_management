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

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>



<html>
<body>
<div class="menu">

    <div class="menu_list">
        <h4 align="center">News</h4>
        <ul>
            <li><a href="/news.do?action=News List">News List</a></li>
            <li><a href="/addNews.do" >Add News</a></li>



        </ul>
    </div>
</div>
<br>

</body>
</html>