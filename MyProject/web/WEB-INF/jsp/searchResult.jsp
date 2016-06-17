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
        <title><%= session.getAttribute("project_name") %> 搜索结果</title>
        <%
            boolean loginState = (Boolean) session.getAttribute("login_state");
            String path = request.getContextPath();
        %>
        <script type="text/javascript">
            function MySubmit(id){
                var form = document.getElementById(id);
                form.submit();
            }
        </script>
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
            <div class="col-sm-12">
                <div class="col-sm-1"></div>
                <div class="col-sm-11">
                    <h5 style="width: fit-content">
                        <a href="book.htm?bookId=<%=b.getId()%>" class="text-primary" style="width: fit-content"><%=b.getTitle()%></a>
                        <form method="post" action="search.htm" id="<%= b.getId()%>">
                            <input hidden="true" type="text" value="<%= b.getAuthor()%>" name="query">
                            <input type="submit" hidden="true" />
                            <p class="text-right">
                                <a href="javascript:void(0);" type="submit" onclick="MySubmit('<%=b.getId()%>')">
                                    <em><%= b.getAuthor()%></em></a>
                            </p>
                        </form>

                    </h5>
                    <div class="row">
                        <div class="col-sm-2"><p class="text-center text-info"><strong>简介：</strong></p></div>
                        <div class="col-sm-10"><p class="text-muted"><%= b.getBriefSummary()%></p></div>
                    </div>
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
