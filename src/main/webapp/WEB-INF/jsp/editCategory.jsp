<%--
  Created by IntelliJ IDEA.
  User: CYC
  Date: 2019/4/10
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>

<div style="width:500px;margin:0px auto;text-align:center">
    <div style="text-align:center;margin-top:40px">
        <form method="post" action="../categories/${category.id}">
            <input type="hidden" name="_method" value="PUT">
            name: <input name="name" value="${category.name}" type="text"> <br><br>
            <input type="submit" value="确定修改">
        </form>

    </div>
</div>

<%--<div style="width:500px;margin:0px auto;text-align:center">--%>
<%--<div style="text-align:center;margin-top:40px">--%>
<%--<form method="post" action="updateCategory">--%>
<%--id: <input type="" readonly value="${category.id}" name="id"> <br>--%>
<%--name: <input type="text" name="name" value="${category.name}"><br>--%>
<%--<input type="submit" value="确定修改">--%>
<%--</form>--%>
<%--</div>--%>
<%--</div>--%>
</body>
</html>
