<%--
  Created by IntelliJ IDEA.
  User: Zhandos_Suleimenov
  Date: 8/17/2016
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="page-header">View News</div>

    <div class="form-group">
        <label class="control-label col-md-2">News Title</label>
        <label class="control-label col-md-10">${news.getTitle()}</label>
    </div>

    <div class="form-group">
        <label class="control-label col-md-2">News Date</label>
        <label class="control-label col-md-10">${news.getDate()}</label>
    </div>

    <div class="form-group">
        <label class="control-label col-md-2">Brief</label>
        <label class="control-label col-md-10">${news.getBrief()}</label>
    </div>

    <div class="form-group">
        <label class="control-label col-md-2">Content</label>
        <label class="control-label col-md-10">${news.getContent()}</label>
    </div>

    <div class="col-md-offset-9">
        <button type="submit" class="btn btn-primary" name="action" value="Edit News">EDIT</button>
        <button type="submit" class="btn btn-primary" name="action" value="Delete News">DELETE</button>
    </div>


</div>
</body>
</html>
