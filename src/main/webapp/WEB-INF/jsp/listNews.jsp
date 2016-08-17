<%--
  Created by IntelliJ IDEA.
  User: Zhandos_Suleimenov
  Date: 8/16/2016
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- BootStrapValidation CSS file -->
    <link rel="stylesheet" href="/bootstrap-validator/css/bootstrapValidator.min.css">

    <!-- Bootstrap JS -->
    <script src="/bootstrap-validator/js/bootstrapValidator.min.js" type="text/javascript"></script>
</head>
<body>


<div class="container">

    <form id="addNewsForm" class="form-horizontal" role="form" action="news" method="post">

        <div class="page-header"><h2>List news</h2></div>

        <c:forEach items="${sessionScope.list_news}" var="news">

            <div class="form-group">
                <label class="control-label">${news.getTitle()}</label>
                <label class="control-label col-md-offset-8">${news.getDate()}</label>

            </div>

            <div class="form-group">
                <label class="control-label">${news.getBrief()}</label>
            </div>

            <div class="form-group">
                <%--<input class="form-control" type="hidden" name="news_id" value=${news.getId()} />--%>
                <label class="control-label col-md-offset-9"><a href="/news.do?action=View News&news_id=${news.getId()}">view</a></label>
                <label class="control-label"><a href="/news.do?action=Add News">edit</a></label>
                <div class="checkbox-inline">
                    <label class="control-label"><input type="checkbox" value=""></label>
                </div>
            </div>


        </c:forEach>

        <div class="form-group">
            <div class="col-md-offset-9">
                <button type="submit" class="btn btn-primary" name="action" value="Delete News">DELETE</button>
            </div>
        </div>

    </form>
</div>

</body>
</html>
