<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
    <title>编辑文章</title>
    <script src="../ckeditor/ckeditor.js"></script>
</head>
<body>
<h2>This is a JSP page.</h2>

<form action="saveArticle" method="post">
    title:<input type="text" name="title"/>
    content:<textarea rows="40" cols="60" name="content" id="content"></textarea>
    <script>
        CKEDITOR.replace('content');
    </script>
</form>

</body>
</html>
