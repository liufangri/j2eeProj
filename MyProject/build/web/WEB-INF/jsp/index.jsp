<%@page import="com.sxy.j2ee.project.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sxy.j2ee.project.model.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sxy.j2ee.project.model.Book"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%
            session.setAttribute("project_name", "Project NX");
            boolean loginState = (Boolean) session.getAttribute("login_state");
            String path = request.getContextPath();
            ArrayList<Book> books = (ArrayList<Book>) request.getAttribute("books");
        %>
        <jsp:include page="header.jsp"/>
        <title><%= session.getAttribute("project_name") %> 首页</title>
        
    </head>
    <body>
        <jsp:include page="staticbar.jsp" />
        <div class="container">
            <div class="col-md-12">
                <%
                    for (int index = 0; index < books.size(); index++) {
                        Book b = books.get(index);
                        if (index % 3 == 0) {
                %>   
                <div class="row">
                    <%
                        }
                    %>
                    <div class="col-md-4">
                        <div class="thumbnail" style="min-height: 400px">
                            <a href="book.htm?bookId=<%=b.getId()%>"><img src="<%=path%>/dist/img/bookcovers/<%= b.getId()%>.jpg" alt="暂无封面" width="150px" height="300px"/></a>
                            <div class="caption">
                                <h4><%= b.getTitle()%></h4>
                                <p><a role="button" class="btn btn-primary" href="book.htm?bookId=<%= b.getId()%>">View</a></p>
                            </div>
                        </div>
                    </div>

                    <%
                        if (index % 3 == 2) {
                    %>
                </div>
                <%
                        }
                    }
                %>


            </div>
        </div>

        <jsp:include page="footer.jsp"/>
    </div>

</body>

<script>
document.getElementById("home").setAttribute("class", "active");
</script>
</html>
