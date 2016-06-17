<%-- 
    Document   : contact
    Created on : 2016-6-13, 20:19:42
    Author     : JOHNKYON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp"/>
        <title><%= session.getAttribute("project_name") %> 联系我们</title>
    </head>
    <body>
        <jsp:include page="staticbar.jsp" />
        <div class="container">

            <h5>如有疑问请联系我们</h5>


            <div class="demo-text-box prl" >
                <p><strong>孙晓宇</strong> <a href="mailto:liufangri_sxy@163.com" target="_blank">liufangri_sxy@163.com</a></p>
                <p><strong>赵冯博</strong> <a href="mailto:zhaofengbo1321@163.com" target="_blank">zhaofengbo1321@163.com</a></p>
            </div>
        </div>
    </body>
    <script>
        document.getElementById("contact").setAttribute("class", "active")
    </script>
</html>
