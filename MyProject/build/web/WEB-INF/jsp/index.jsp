<%@page import="com.sxy.j2ee.project.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <jsp:include page="header.jsp"/>
        <title>首页</title>
        <%
            boolean loginState = (Boolean) session.getAttribute("login_state");
            String path = request.getContextPath();
            ArrayList<Book> books = (ArrayList<Book>) request.getAttribute("books");

        %>
    </head>
    <body>
        <jsp:include page="staticbar.jsp" />
        <div class="container">
            <div class="col-md-12">
                <div class="row">

                    <%			for (Book b : books) {
                    %>
                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail" style="min-height: 340px">
                            <a href="#"><img src="<%=path%>/dist/img/bookcovers/<%= b.getId()%>.jpg" alt="" width="150px" height="300px"/></a>
                            <div class="caption">
                                <h3 ><%= b.getTitle()%></h3>
                                <p><a role="button" class="btn btn-primary" href="book.htm?bookId=<%= b.getId()%>">View</a></p>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                    %>


                </div>
            </div>


        </div>
        <jsp:include page="footer.jsp"/>
    </body>


</html>
