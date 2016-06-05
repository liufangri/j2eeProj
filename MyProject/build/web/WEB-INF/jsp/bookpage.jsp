<%-- 
    Document   : bookpage
    Created on : 2016-6-4, 15:56:55
    Author     : Y400
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <title>${book.title}</title>
        <%
            boolean loginState = (Boolean) session.getAttribute("login_state");
        %>
    </head>
    <body>
        <jsp:include page="staticbar.jsp" />
        <div class="container">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail">
                            <img data-src="holder.js/100%x200" alt="...">
                            <div class="caption">
                                <h3>${book.title}</h3>
                                <p>${book.summary}</p>
                                <p><a role="button" class="btn btn-primary" href="#">View</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

    </body>
</html>
