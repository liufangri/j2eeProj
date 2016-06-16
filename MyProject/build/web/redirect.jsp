<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Properties"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if (session.getAttribute("login_state") == null) {
        session.setAttribute("login_state", false);

    }
    session.setAttribute("project_name", "NX");
%>
<% response.sendRedirect("index.htm");%>
