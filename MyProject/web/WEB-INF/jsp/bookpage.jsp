<%-- 
    Document   : bookpage
    Created on : 2016-6-4, 15:56:55
    Author     : Y400
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
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
                    <div class="col-sm-6 col-md-6">
                        <div class="caption">
                            <h3>${book.title}</h3>
                            <h4>${book.id}</h4>
                            <p>${book.summary}</p>
                        </div>

                    </div>
                </div>
            </div>
            <mvc:form action="submit.htm" modelAtrribute="comment" method="post">
                <div class="span3">
                    <input type="text" value="" placeholder="Inactive" class="span3">
                </div>
                <div style="margin-top: 20px;margin-bottom: 20px">
                    <button type="submit" class="btn btn-primary">评论</button>
                </div>
            </mvc:form>
        </div>
    </body>
</html>
