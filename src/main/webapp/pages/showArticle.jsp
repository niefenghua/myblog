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

<h2>正文</h2>
<h3><s:property value="#barticle.title"/></h3>
<s:property value="#barticle.content" escape="false"/>

<h2>评论</h2>
<h3>我的评论</h3>
<form action="addComments" method="post">
    <textarea rows="5" cols="60" name="comments"></textarea>
    <br/>
    <input type="submit" value="提交评论"/>
</form>

<h3>网友评论</h3>
<s:iterator value="#coms" id="coms1" status="sta">
    <s:property value="#coms1.contents"></s:property><br/>
</s:iterator>

</body>
</html>
