<%-- 
    Document   : register
    Created on : 2016-5-25, 19:17:17
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
        <title><%= session.getAttribute("project_name") %> 注册</title>
    </head>
    <body>
        <jsp:include page="staticbar.jsp" />
        <div class="container">
            <div class="row">
                <div class="right">
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <h4>注册</h4>
                            <br/>
                            <mvc:form action="registerAction.htm" modelAttribute="user" method="post" cssClass="form">
                                <div class="form-group-sm ${name_has_error}"><label>用户名(必填)：</label>
                                    <input type="text" name="name" class="form-control" value="${user.name}"/>
                                    <label class="control-label">${error_name}</label>
                                </div>
                                <label>密码(必填)：</label>
                                <div class="form-group-sm ${password_has_error}">
                                    <input type="password" name="password" id="password" class="form-control"/>
                                    <label class="control-label">${error_password}</label>
                                </div>
                                <label>确认密码(必填)：</label>
                                <div class="form-group-sm ${password_re_has_error}">
                                    <input type="password" name="password_re" id="password2" class="form-control"/>
                                    <label class="control-label">${error_password_re}</label>
                                </div>
                                <label>邮箱(必填)：</label>
                                <div class="form-group-sm ${email_has_error}">
                                    <input type="text" name="email" placeholder="123@qq.com" class="form-control" value="${user.email}"/>
                                    <label class="control-label">${error_email}</label>
                                </div>
                                <label>手机：</label>
                                <div class="form-group-sm ${pNum_has_error}">
                                    <input type="tel" name="pNum_string" placeholder="12345678900" class="form-control" value="${user.pNum_string}"/>
                                    <label class="control-label">${error_pNum}</label>
                                </div>
                                <!--<label>年龄：</label>
                                <div class="form-group-sm ${age_has_error}">
                                    <input type="number" name="age_string" class="form-control" value="${user.age_string}"/>
                                    <label class="control-label">${error_age}</label>
                                </div>
                                !-->
                                <div class="form-group-sm">
                                    <label>性别：</label>
                                    <label class="radio"><input type="radio" data-toggle="radio" name="gender" id="genders_male" value="男" data-radiocheck-toggle="radio" required/>男</label>
                                    <label class="radio"><input type="radio" data-toggle="radio" name="gender" id="genders_female" value="女" data-radiocheck-toggle="radio" checked=""/>女</label>
                                </div>
                                <label>个人简介：</label>
                                <div class="form-group">
                                    <textarea type="textarea" name="summary" class="form-control">${user.summary}</textarea>
                                </div>


                                <div style="margin-top: 20px;margin-bottom: 20px">
                                    <button type="submit"  class="btn btn-primary">确认注册</button>
                                </div>

                            </mvc:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
