<%-- 
    Document   : bookpage
    Created on : 2016-6-4, 15:56:55
    Author     : Y400
--%>

<%@page import="com.sxy.j2ee.project.model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <title>${book.title}</title>
        <%
            boolean loginState = (Boolean) session.getAttribute("login_state");
            String path = request.getContextPath();
            Book book = (Book) request.getAttribute("book");
            request.setAttribute("book", book);
            session.setAttribute("bookId", book.getId());
        %>
    </head>
    <body>
        <jsp:include page="staticbar.jsp" />
        <div class="container">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-sm-6 col-md-6">
                        <div class="row">
                            <div class="caption">
                                <h3>《${book.title}》</h3>
                                <h5 style="align-right:true">${book.author}</h5>
                                <p>${book.summary}</p>
                            </div>
                        </div>

                    </div>
                    <div class="col-sm-6 col-md-6">
                        <img src="<%=path%>/dist/img/bookcovers/${book.id}.jpg" alt="..."/>
                    </div>
                </div>
                <%
                    if (loginState) {
                %>
                <mvc:form action="submitComment.htm" method="post" cssClass="form" modelAttribute="comment">
                    <div class="form-group">
                        <textarea type="textarea" name="content" class="form-control"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">comment</button>
                </mvc:form>
                <%
                } else {
                %>
                <a href="login.htm">登录后进行评论</a>
                <%}%>
            </div>

    </body>
</html>
