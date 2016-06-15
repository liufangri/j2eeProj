<%-- 
    Document   : searchResult
    Created on : 2016-6-7, 23:12:12
    Author     : JOHNKYON
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.sxy.j2ee.project.model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        ArrayList<Book> books = (ArrayList<Book>) request.getAttribute("books");
    %>
    <head>
        <jsp:include page="header.jsp"/>
        <title>搜索结果</title>
        <%
            boolean loginState = (Boolean) session.getAttribute("login_state");
            String path = request.getContextPath();
        %>
    </head>
    <body>
        <jsp:include page="staticbar.jsp" />

        <div class="container">
            <%
            if (books.size() != 0) {
        %>
            <p>搜索"${query}"的结果：</p>

            <%
                for (Book b : books) {
            %>
            <a href="book.htm?bookId=<%=b.getId()%>" class="btn btn-large btn-block btn-primary"><%=b.getTitle()%></a>

            <div class="row">
                <div class="col-sm-12">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-11"><p class="text-primary"><%= b.getSummary()%></p></div>
                </div>
            </div>
            <%
                }
            } else {

            %>
            <p>无搜索结果！</p>
            <%}%>
        </div>
    </body>
</html>
