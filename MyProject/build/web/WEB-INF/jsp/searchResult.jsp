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
        <title>首页</title>
        <%
            boolean loginState = (Boolean) session.getAttribute("login_state");
            String path = request.getContextPath();
        %>
    </head>
    <body>
        <jsp:include page="staticbar.jsp" />
        ${query}
        <%
            for (Book b: books){
        %>
        <a href="book.htm?bookId=<%=b.getId()%>" class="btn btn-large btn-block btn-primary"><%=b.getTitle()%></a>
        
        <div class="row">
            <div class="col-sm-7">
                <div class="col-sm-2"><p class="text-primary"><%= b.getSummary()%></p></div>
            </div>
        </div>
        <%
            }
        %>
    </body>
</html>
