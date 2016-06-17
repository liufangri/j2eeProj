<%-- 
    Document   : bookpage
    Created on : 2016-6-4, 15:56:55
    Author     : Y400
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sxy.j2ee.project.model.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sxy.j2ee.project.model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <title><%= session.getAttribute("project_name")%> ${book.title}</title>
        <%
            boolean loginState = (Boolean) session.getAttribute("login_state");
            String path = request.getContextPath();
            Book book = (Book) request.getAttribute("book");
            ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");
            SimpleDateFormat df = new SimpleDateFormat("MM.dd HH:mm");
            request.setAttribute("book", book);
        %>
        <script type="text/javascript">
            function check() {
                var content = document.getElementById("content");
                if (content === null || content.value === "") {
                    alert("请输入评论内容！");
                    return false;
                }else{
                    return true;
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="staticbar.jsp" />
        <div class="container">
            <div class="col-md-12">
                <div class="row" style="min-height: 300px">
                    <div class="col-sm-6 col-md-6">
                        <div class="row">
                            <div class="caption">
                                <h3>《${book.title}》</h3>
                                <h5 style="align-right:true">${book.author}</h5>
                                <p>${book.summary}</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <img src="<%=path%>/dist/img/bookcovers/${book.id}.jpg" class="img-rounded" alt="暂无封面" width="150px"/>
                    </div>
                </div>


                <%if (comments.size() != 0) {

                %>
                <h5 class="text-primary">Comments:</h5>
                <%			for (Comment c : comments) {
                %>
                <div class="row">
                    <div class="col-sm-8">
                        <div class="col-sm-3"><p class="text-primary"><%= c.getSubmitter()%></p></div>
                        <div class="col-sm-5"><p>(  <%= df.format(new Date(c.getTime().getTime()))%>)</p></div>
                    </div>
                </div>
                <div class="col-sm-7"><p><%= c.getContent()%></p></div>
                        <%}%>
                        <%} else {%>
                <h5 class="text-primary">暂无评论</h5>
                <%}%>
                <div class="col-sm-9">
                    <%
                        if (loginState) {
                    %>
                    <mvc:form action="submitComment.htm" method="post" cssClass="form" modelAttribute="comment" onsubmit="return check()">
                        <input type="text" hidden="true" name="bookId" value="${book.id}">
                        <div class="form-group">
                            <textarea type="textarea" name="content" class="form-control" id="content"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary" >comment</button>
                    </mvc:form>
                    <%
                    } else {
                    %>
                    <p><a href="login.htm">登录</a>后进行评论</p>
                    <%}%>

                    <label class="text-danger">${errorMessage}</label>
                </div>


            </div>
        </div>
    </body>
</html>
