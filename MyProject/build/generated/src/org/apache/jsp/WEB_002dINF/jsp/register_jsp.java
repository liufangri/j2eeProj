package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_mvc_form_modelAttribute_method_cssClass_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_mvc_radiobuttons_path_items_cssClass_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_mvc_form_modelAttribute_method_cssClass_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_mvc_radiobuttons_path_items_cssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_mvc_form_modelAttribute_method_cssClass_action.release();
    _jspx_tagPool_mvc_radiobuttons_path_items_cssClass_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"right\">\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <h4>注册</h4>\n");
      out.write("                            <br/>\n");
      out.write("                            ");
      if (_jspx_meth_mvc_form_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <form role=\"form\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label class=\"radio\">\n");
      out.write("                                        <input type=\"radio\" data-toggle=\"radio\" name=\"optionsRadios\" id=\"optionsRadios1\" value=\"option1\" data-radiocheck-toggle=\"radio\" required>\n");
      out.write("                                        Radio is off\n");
      out.write("                                    </label>\n");
      out.write("                                    <label class=\"radio\">\n");
      out.write("                                        <input type=\"radio\" data-toggle=\"radio\" name=\"optionsRadios\" id=\"optionsRadios2\" value=\"option1\" data-radiocheck-toggle=\"radio\" checked=\"\">\n");
      out.write("                                        Radio is on\n");
      out.write("                                    </label>\n");
      out.write("\n");
      out.write("                                    <label class=\"radio\">\n");
      out.write("                                        <input type=\"radio\" data-toggle=\"radio\" name=\"optionsRadiosDisabled\" id=\"optionsRadios3\" value=\"option2\" data-radiocheck-toggle=\"radio\" disabled=\"\">\n");
      out.write("                                        Disabled radio is off\n");
      out.write("                                    </label>\n");
      out.write("                                    <label class=\"radio\">\n");
      out.write("                                        <input type=\"radio\" data-toggle=\"radio\" name=\"optionsRadiosDisabled\" id=\"optionsRadios4\" value=\"option2\" data-radiocheck-toggle=\"radio\" checked=\"\" disabled=\"\">\n");
      out.write("                                        Disabled radio is on\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-sm btn-primary\">Submit</button>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div><!-- /.row -->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_mvc_form_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mvc:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_mvc_form_0 = (org.springframework.web.servlet.tags.form.FormTag) _jspx_tagPool_mvc_form_modelAttribute_method_cssClass_action.get(org.springframework.web.servlet.tags.form.FormTag.class);
    _jspx_th_mvc_form_0.setPageContext(_jspx_page_context);
    _jspx_th_mvc_form_0.setParent(null);
    _jspx_th_mvc_form_0.setAction("registerAction.htm");
    _jspx_th_mvc_form_0.setModelAttribute("user");
    _jspx_th_mvc_form_0.setMethod("post");
    _jspx_th_mvc_form_0.setCssClass("form");
    int[] _jspx_push_body_count_mvc_form_0 = new int[] { 0 };
    try {
      int _jspx_eval_mvc_form_0 = _jspx_th_mvc_form_0.doStartTag();
      if (_jspx_eval_mvc_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\n");
          out.write("                                <div class=\"form-group\"><label class=\"\">用户名：</label>\n");
          out.write("                                    <input type=\"text\" name=\"name\" class=\"form-control\"/>\n");
          out.write("                                    <label class=\"control-label\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</label>\n");
          out.write("                                </div>\n");
          out.write("                                <label>密码：</label>\n");
          out.write("                                <div class=\"form-group ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${has_error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                    <input type=\"password\" name=\"password\" id=\"password\" class=\"form-control\"/>\n");
          out.write("                                    <label class=\"control-label\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error_prassword}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</label>\n");
          out.write("                                </div>\n");
          out.write("                                <label>确认密码：</label>\n");
          out.write("                                <div class=\"form-group ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${has_error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                    <input type=\"password\" name=\"password_re\" id=\"password2\" class=\"form-control\"/>\n");
          out.write("                                    <label class=\"control-label\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error_password_re}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</label>\n");
          out.write("                                </div>\n");
          out.write("                                <label>邮箱：</label>\n");
          out.write("                                <div class=\"form-group ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${has_error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                    <input type=\"text\" name=\"email\" placeholder=\"123@qq.com\" class=\"form-control\"/>\n");
          out.write("                                    <label class=\"control-label\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error_email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</label>\n");
          out.write("                                </div>\n");
          out.write("                                <label>手机：</label>\n");
          out.write("                                <div class=\"form-group ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${has_error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                    <input type=\"tel\" name=\"pNum\" placeholder=\"12345678900\" class=\"form-control\"/>\n");
          out.write("                                    <label class=\"control-label\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error_pNum}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</label>\n");
          out.write("                                </div>\n");
          out.write("                                <label>年龄：</label>\n");
          out.write("                                <div class=\"form-group ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${has_error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                    <input type=\"number\" name=\"age\" class=\"form-control\"/>\n");
          out.write("                                    <label class=\"control-label\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error_age}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</label>\n");
          out.write("                                </div>\n");
          out.write("\n");
          out.write("                                <div class=\"form-group\">\n");
          out.write("                                    <label>性别：</label>\n");
          out.write("                                    <!--");
          if (_jspx_meth_mvc_radiobuttons_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_mvc_form_0, _jspx_page_context, _jspx_push_body_count_mvc_form_0))
            return true;
          out.write("!-->\n");
          out.write("                                    <label class=\"radio\"><input type=\"radio\" data-toggle=\"radio\" name=\"gender\" id=\"genders_male\" value=\"男\" data-radiocheck-toggle=\"radio\" required/>男</label>\n");
          out.write("                                    <label class=\"radio\"><input type=\"radio\" data-toggle=\"radio\" name=\"gender\" id=\"genders_female\" value=\"女\" data-radiocheck-toggle=\"radio\" checked=\"\"/>女</label>\n");
          out.write("                                </div>\n");
          out.write("                                <label>个人简介：</label>\n");
          out.write("                                <div class=\"form-group\">\n");
          out.write("                                    <textarea type=\"textarea\" name=\"summary\" class=\"form-control\"></textarea>\n");
          out.write("                                </div>\n");
          out.write("                                <button type=\"submit\"  class=\"btn btn-default\">确认注册</button>\n");
          out.write("\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_mvc_form_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_mvc_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_mvc_form_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_mvc_form_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_mvc_form_0.doFinally();
      _jspx_tagPool_mvc_form_modelAttribute_method_cssClass_action.reuse(_jspx_th_mvc_form_0);
    }
    return false;
  }

  private boolean _jspx_meth_mvc_radiobuttons_0(javax.servlet.jsp.tagext.JspTag _jspx_th_mvc_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_mvc_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mvc:radiobuttons
    org.springframework.web.servlet.tags.form.RadioButtonsTag _jspx_th_mvc_radiobuttons_0 = (org.springframework.web.servlet.tags.form.RadioButtonsTag) _jspx_tagPool_mvc_radiobuttons_path_items_cssClass_nobody.get(org.springframework.web.servlet.tags.form.RadioButtonsTag.class);
    _jspx_th_mvc_radiobuttons_0.setPageContext(_jspx_page_context);
    _jspx_th_mvc_radiobuttons_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_mvc_form_0);
    _jspx_th_mvc_radiobuttons_0.setPath("gender");
    _jspx_th_mvc_radiobuttons_0.setCssClass("custom-radio");
    _jspx_th_mvc_radiobuttons_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${genders}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_mvc_radiobuttons_0 = new int[] { 0 };
    try {
      int _jspx_eval_mvc_radiobuttons_0 = _jspx_th_mvc_radiobuttons_0.doStartTag();
      if (_jspx_th_mvc_radiobuttons_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_mvc_radiobuttons_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_mvc_radiobuttons_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_mvc_radiobuttons_0.doFinally();
      _jspx_tagPool_mvc_radiobuttons_path_items_cssClass_nobody.reuse(_jspx_th_mvc_radiobuttons_0);
    }
    return false;
  }
}
