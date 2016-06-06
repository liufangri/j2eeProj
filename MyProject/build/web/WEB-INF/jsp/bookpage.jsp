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
            String path = request.getContextPath();
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
            </div>

    </body>
</html>
