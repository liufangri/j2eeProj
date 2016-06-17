<%-- 
    Document   : addBook
    Created on : 2016-6-5, 16:09:46
    Author     : Y400
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.sxy.j2ee.project.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <title><%= session.getAttribute("project_name") %> 上传书籍</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="header.jsp"/>
        <title>JSP Page</title>
        <%
            String path = request.getContextPath();
            ArrayList<String> administrators = (ArrayList<String>)request.getAttribute("administrators");
            if((Boolean) session.getAttribute("login_state") && administrators.contains(((User)session.getAttribute("user")).getName())){
        %>
    </head>
    <body>
        <jsp:include page="staticbar.jsp" />
        <div class="container">
            <div class="col-md-9">
                <mvc:form modelAttribute="book" action="addBookAction.htm" method="post" enctype="multipart/form-data" cssClass="form">
                    <div class="form-group ${title_has_error}">
                        <mvc:label path="title">Title</mvc:label><mvc:input cssClass="form-control" path="title"/>
                        <label class="control-label">${error_title}</label>
                    </div>
                    <div class="form-group ${author_has_error}">
                        <mvc:label path="author">Author</mvc:label><mvc:input cssClass="form-control" path="author"/>
                        <label class="control-label">${error_author}</label>
                    </div>
                    <div class="form-group ${summary_has_error}">
                    <mvc:label path="summary">Summary</mvc:label><mvc:textarea cssClass="form-control" rows="6" path="summary"/>
                    <label class="control-label">${error_summary}</label>
                    </div>
                    <div class="form-group ${coverImg_has_error}">
                        <mvc:label path="coverImg">Book Cover</mvc:label><mvc:input type="file" path="coverImg" cssClass="form-control"/>    
                        <label class="control-label">${error_coverImg}</label>
                    </div>
                    <div >   
                        <button type="submit" class="btn btn-primary">上传</button>
                        
                    </div>
                </mvc:form>
                <p>title:${book.title}</p>
                <p>author:${book.author}</p>
                <p>summary:${book.summary}</p>
                <p>cover:<img src="<%=path%>/dist/img/bookcovers/${book.id}.jpg" alt="无"></p>
            </div>
        </div>
    </body>
    <%
    }else{
    response.sendRedirect("login.htm");
}
    %>
</html>
