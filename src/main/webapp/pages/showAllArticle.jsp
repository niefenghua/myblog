<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
    <title>index</title>
</head>
<body>
<s:debug></s:debug>

<s:iterator value="#result.list" id="art" status="sta">
    标题:<s:property value="#art.title"/><br/>
</s:iterator>

当前第<s:property value="#result.page.currentPage"/>页，
一共<s:property value="#result.page.totalPage"/>页，
每页显示<s:property value="#result.page.pageSize"/>条记录
<br/>
<s:if test="#result.page.haspre">
    <a href="showAllArticle.action?currentPage=1">首页</a>
    <a href="showAllArticle.action?currentPage=${requestScope.result.page.currentPage-1}">上一页</a>
</s:if>
<s:else>
    首页 上一页
</s:else>

<s:if test="#result.page.hasnext">
    <a href="showAllArticle.action?currentPage=${requestScope.result.page.currentPage+1}">下一页</a>
    <a href="showAllArticle.action?currentPage=${requestScope.result.page.totalPage}">尾页</a>
</s:if>
<s:else>
    下一页 首页
</s:else>

</body>
</html>
