<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
    <title>Title</title>
</head>
<body>
<s:debug></s:debug>
<h3><s:property value="#barticle.title"/></h3>
<s:property value="#barticle.content" escape="false"/>

</body>
</html>
