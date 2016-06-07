<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sxy.j2ee.project.model.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sxy.j2ee.project.model.Book"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
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
        <div class="container">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail" style="min-height: 340px">
                            <a href="#"><img src="<%=path%>/dist/img/bookcovers/631BCEF55B51E2B6.jpg" alt="{}" width="150px" height="300px"/></a>
                            <div class="caption">
                                <h3>${book.title}</h3>
                                <p>${book.summary}</p>
                                <p><a role="button" class="btn btn-primary" href="book.htm?bookId=631BCEF55B51E2B6">View</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail" style="min-height: 300px">
                            <a href="#" style=""><img src="<%=path%>/dist/img/bookcovers/3FD33040AEB091BE.jpg" alt="{}" height="100%"/></a>
                            <div class="caption" >
                                <h3>${book.title}</h3>
                                <p>${book.summary}</p>
                                <p><a role="button" class="btn btn-primary" href="book.htm?bookId=3FD33040AEB091BE">View</a></p>
                            </div>
                        </div>
                    </div>
                                
                </div>
            </div>


        </div>
        <jsp:include page="footer.jsp"/>
    </body>


</html>
