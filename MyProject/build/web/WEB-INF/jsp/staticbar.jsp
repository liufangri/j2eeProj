<%-- 
    Document   : staticbar
    Created on : 2016-6-2, 13:17:54
    Author     : Y400
--%>

<%@page import="com.sxy.j2ee.project.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<% if (session.getAttribute("login_state") == null) {
        session.setAttribute("login_state", false);
    }
    session.setAttribute("project_name", "Project NX");
%>
<style>
    body {
        padding-top: 70px;
    }
</style>
<script type="text/javascript">
    function checkSearchContent(){
        var search = document.getElementById("navbarInput-01");
        if(search.value===null||search.value===""){
            alert("需要输入搜索内容！");
            return false;
        }else{
            return true;
        }
    }
    </script>
<!-- Static navbar -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
            </button>
            <a class="navbar-brand" href="index.htm"><%=(String) session.getAttribute("project_name")%></a>
        </div>
        <div class="navbar-collapse collapse">

            <ul class="nav navbar-nav">
                <li id="home"><a href="index.htm">主页</a></li>
                <li id="about"><a href="about.htm">关于</a></li>
                <li id="contact"><a href="contact.htm">联系我们</a></li>
            </ul>
            <form class="navbar-form navbar-left" action="search.htm" role="search" method="post" onsubmit="return checkSearchContent()">
                <div class="form-group">
                    <div class="input-group">
                        <input class="form-control" id="navbarInput-01" type="search" placeholder="Search" name="query"/>
                        <span class="input-group-btn">
                            <button type="submit" class="btn"><span class="fui-search"></span></button>
                        </span>
                    </div>
                </div>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <%
                    if ((Boolean) session.getAttribute("login_state") != null && ((Boolean) session.getAttribute("login_state")).booleanValue()) {
                %>
                <li><a>您好，<%= ((User) session.getAttribute("user")).getName()%></a></li>
                <li class="active"><a href="logout.htm" >退出登录</a></li>
                    <%} else {%>
                <li><a href="login.htm">登录</a></li>
                <li><a href="register.htm">注册</a></li>
                    <%}%>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
