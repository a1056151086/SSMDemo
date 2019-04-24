<%--
  Created by IntelliJ IDEA.
  User: CYC
  Date: 2019/3/31
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>ListCategory</title>
    <script type="text/javascript" src="jquery.min.js"></script>
</head>
<body>

<script type="text/javascript">
    /*将post method 改变为delete*/
    $(function () {
        $(".delete").click(function () {
            var href = $(this).attr("href");
            $("#formdelete").attr("action", href).submit();
            return false;
        })
    })
</script>

<div style="width:500px;margin:0px auto;text-align:center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${categories}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="categories/${c.id}">编辑</a></td>
                <td><a class="delete" href="categories/${c.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <div style="text-align:center">
        <a href="?start=0">首 页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末 页</a>
    </div>


    <div style="text-align:center;margin-top:40px">
        <form method="POST" action="categories">
            分类名称： <input name="name" value="" type="text"> <br><br>
            <input type="submit" value="增加分类">
        </form>
    </div>
</div>

<form id="formdelete" action="" method="POST">
    <input type="hidden" name="_method" value="DELETE">
</form>

<%--<table align='center' border='1' cellspacing='0'>--%>
<%--<tr>--%>
<%--<td>id</td>--%>
<%--<td>name</td>--%>
<%--<td>编辑</td>--%>
<%--<td>删除</td>--%>
<%--</tr>--%>
<%--<c:forEach items="${categories}" var="c" varStatus="st">--%>
<%--<tr>--%>
<%--<td>${c.id}</td>--%>
<%--<td>${c.name}</td>--%>
<%--<td><a href="editCategory?id=${c.id}">编辑</a></td>--%>
<%--<td><a href="deleteCategory?id=${c.id}">删除</a></td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<%--<div style="text-align: center">--%>
<%--<a href="?start=0">首 页</a>--%>
<%--<a href="?start=${page.start-page.count}">上一页</a>--%>
<%--<a href="?start=${page.start+page.count}">下一页</a>--%>
<%--<a href="?start=${page.last}">尾 页</a>--%>
<%--</div>--%>

<%--<div style="text-align:center;margin-top:40px">--%>
<%--<form method="post" action="addCategory">--%>
<%--添加name： <input type="text" name="name">--%>
<%--<input type="submit" value="添加">--%>
<%--</form>--%>
<%--</div>--%>
<%--</body>--%>
</html>
