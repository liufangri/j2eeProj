<%-- 
    Document   : about
    Created on : 2016-6-13, 20:30:51
    Author     : JOHNKYON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <title>about</title>
    </head>
    <body>
        <jsp:include page="staticbar.jsp" />
        <div class="container">
            <h3>项目简介</h3>
            <p>此项目为<strong>书籍</strong>交流网站</p>
            <p>用户可以在线搜索并查看书籍的信息和简介，并可以对书籍进行评论，亦可以查看他人对此书的评论</p>
            <lable class="primary">如果首页没有书籍说明数据库里暂时没有添加书籍，请登录管理员账户然后在addBook.htm页手动添加</lable>
        </div>
    </body>
    <script>
        document.getElementById("about").setAttribute("class", "active");
    </script>
</html>
