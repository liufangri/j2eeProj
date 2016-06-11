<%-- 
    Document   : addBook
    Created on : 2016-6-5, 16:09:46
    Author     : Y400
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <mvc:form modelAttribute="book" action="addBookAction.htm" method="post" enctype="multipart/form-data">
            <table>
                <tr><td><mvc:label path="title">Title</mvc:label></td><td><mvc:input path="title"/></td></tr>
                <tr><td><mvc:label path="author">Author</mvc:label></td><td><mvc:input path="author"/></td></tr>
                <tr><td><mvc:label path="summary">Summary</mvc:label></td><td><mvc:textarea path="summary"/></td></tr>
                <tr><td><mvc:input type="file" path="coverImg"/></td></tr>    
                <tr><td><input type="submit" value="submit"/></td></tr>
            </table>
        </mvc:form>
        <table>
            <tr><td>title:</td><td>${book.title}</td></tr>
            <tr><td>author:</td><td>${book.author}</td></tr>
            <tr><td>summary:</td><td>${book.summary}</td></tr>
            <tr><td>cover:</td><td>${book.title}</td></tr>
            <tr><td>title:</td><td>${book.title}</td></tr>
        </table>
    </body>
</html>
