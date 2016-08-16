<%--
  Created by IntelliJ IDEA.
  User: Zhandos_Suleimenov
  Date: 8/16/2016
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add News</title>
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

        <div class="page-header"><h2>Add news</h2></div>

        <div class="form-group">
            <label class="control-label col-md-2" for="news_title">News Title:</label>
            <div class="col-md-10">
                <input type="text" class="form-control" id="news_title" name="news_title"
                       placeholder="Enter News Title">
            </div>
        </div>



        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <button type="submit" class="btn btn-primary" name="action" value="Save News">SAVE</button>
                <button type="submit" class="btn btn-primary" name="action" value="Cancel News">CANCEL</button>
            </div>
        </div>

    </form>
</div>

</body>
</html>
