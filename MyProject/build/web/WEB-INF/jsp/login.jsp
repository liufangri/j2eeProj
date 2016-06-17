<%-- 
    Document   : login
    Created on : 2016-5-25, 19:17:51
    Author     : Y400
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <%
        session.setAttribute("project_name", "Project NX");
        %>
        <jsp:include page="header.jsp"/>
        <title><%= session.getAttribute("project_name") %> 登录</title>
    </head>
    <body>
        <jsp:include page="staticbar.jsp" />
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-6">
                        <h4>登录</h4>
                        <br/>
                        <mvc:form action="loginAction.htm" modelAttribute="user" method="post" cssClass="form">
                            <div class="form-group ${email_has_error}"><label>邮箱</label>
                                <input type="email" name="email" class="form-control" value="${user.email}" autocomplete="false"/>
                                <label class="control-label">${error_email}</label>
                            </div>
                            <div class="form-group ${password_has_error}"><label>密码</label>
                                <input type="password" name="password" class="form-control" value="${user.password}" autocomplete="false"/>
                                <label class="control-label ">${error_password}</label>
                            </div>
                            <div style="margin-top: 20px;margin-bottom: 20px"> 
                                <button type="submit"  class="btn btn-primary">登录</button>
                                <a href="register.htm" style="margin-left: 30px">注册</a>
                            </div>
                        </mvc:form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
