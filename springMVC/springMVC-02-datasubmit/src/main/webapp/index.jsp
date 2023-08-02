<%--
  Created by IntelliJ IDEA.
  User: hallen
  Date: 2023/8/2
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/req.action" method="post">
    <input type="submit" value="提交"/>
</form>
<h2>第一种数据提交方式:单数据提交</h2>
<form action="${pageContext.request.contextPath}/one.action" method="post">
    姓名:<input type="text" name="myname">
    年龄:<input type="text" name="age">
    <input type="submit" value="提交">
</form>
<h2>第二种数据提交方式:数据封装提交</h2>
<form action="${pageContext.request.contextPath}/two.action" method="post">
    姓名:<input type="text" name="myname">
    年龄:<input type="text" name="age">
    <input type="submit" value="提交">
</form>
<br>
<h2>第三种数据提交方式:动态占位符提交</h2>
<a href="${pageContext.request.contextPath}/three/张三/13.action" >提交</a>
<br>
<h2>第四种数据提交方式:参数名称不一致的解决方案</h2>
<form action="${pageContext.request.contextPath}/four.action" method="post">
    姓名:<input type="text" name="name">
    年龄:<input type="text" name="age">
    <input type="submit" value="提交">
</form>

<h2>第五种数据提交方式:手动提取数据</h2>
<form action="${pageContext.request.contextPath}/five.action" method="post">
    姓名:<input type="text" name="name">
    年龄:<input type="text" name="age">
    <input type="submit" value="提交">
</form>
</body>
</html>
