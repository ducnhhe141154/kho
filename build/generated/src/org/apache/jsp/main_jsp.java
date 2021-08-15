package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <title>Home</title>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Montserrat\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("    \n");
      out.write("    <style>\n");
      out.write("        body,h1,h2,h3,h4,h5,h6 {font-family: \"Lato\", sans-serif}\n");
      out.write("        .w3-bar,h1,button {font-family: \"Montserrat\", sans-serif}\n");
      out.write("        .fa-anchor,.fa-coffee {font-size:200px}\n");
      out.write("        body,h1,h2,h3,h4,h5,h6 {font-family: \"Raleway\", sans-serif}\n");
      out.write("\n");
      out.write("        body, html {\n");
      out.write("            height: 100%;\n");
      out.write("            line-height: 1.8;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Full height image header */\n");
      out.write("        .bgimg-1 {\n");
      out.write("            background-position: center;\n");
      out.write("            background-size: cover;\n");
      out.write("            background-image: url(\"image/background.png\");\n");
      out.write("            min-height: 100%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .w3-bar .w3-button {\n");
      out.write("            padding: 16px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <style>\n");
      out.write("        body {font-family: Arial, Helvetica, sans-serif;}\n");
      out.write("\n");
      out.write("        /* Set a style for all buttons */\n");
      out.write("        button {\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("            padding: 14px 20px;\n");
      out.write("            margin: 8px 0;\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("            width: 100%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        button:hover {\n");
      out.write("            opacity: 0.8;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Extra styles for the cancel button */\n");
      out.write("        .cancelbtn {\n");
      out.write("            width: auto;\n");
      out.write("            padding: 10px 18px;\n");
      out.write("            background-color: #999999;\n");
      out.write("        }\n");
      out.write("        table tr td{\n");
      out.write("            text-align: center;\n");
      out.write("            border: 1px solid;\n");
      out.write("        }\n");
      out.write("        table{\n");
      out.write("            width: 100%;\n");
      out.write("        }\n");
      out.write("        h1{ \n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        /* Center the image and position the close button */\n");
      out.write("\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            padding: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        span.psw {\n");
      out.write("            float: right;\n");
      out.write("            padding-top: 16px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* The Modal (background) */\n");
      out.write("        .modal {\n");
      out.write("            display: none; /* Hidden by default */\n");
      out.write("            position: fixed; /* Stay in place */\n");
      out.write("            z-index: 1; /* Sit on top */\n");
      out.write("            left: 0;\n");
      out.write("            top: 0;\n");
      out.write("            width: 100%; /* Full width */\n");
      out.write("            height: 100%; /* Full height */\n");
      out.write("            overflow: auto; /* Enable scroll if needed */\n");
      out.write("            background-color: rgb(0,0,0); /* Fallback color */\n");
      out.write("            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */\n");
      out.write("            padding-top: 60px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Modal Content/Box */\n");
      out.write("        .modal-content {\n");
      out.write("            background-color: #fefefe;\n");
      out.write("            margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */\n");
      out.write("            border: 1px solid #888;\n");
      out.write("            width: 30%; /* Could be more or less, depending on screen size */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* The Close Button (x) */\n");
      out.write("        .close {\n");
      out.write("            position: absolute;\n");
      out.write("            right: 25px;\n");
      out.write("            top: 0;\n");
      out.write("            color: #000;\n");
      out.write("            font-size: 35px;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .close:hover,\n");
      out.write("        .close:focus {\n");
      out.write("            color: red;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Add Zoom Animation */\n");
      out.write("        .animate {\n");
      out.write("            -webkit-animation: animatezoom 0.6s;\n");
      out.write("            animation: animatezoom 0.6s\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        @-webkit-keyframes animatezoom {\n");
      out.write("            from {-webkit-transform: scale(0)} \n");
      out.write("            to {-webkit-transform: scale(1)}\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        @keyframes animatezoom {\n");
      out.write("            from {transform: scale(0)} \n");
      out.write("            to {transform: scale(1)}\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Change styles for span and cancel button on extra small screens */\n");
      out.write("        @media screen and (max-width: 300px) {\n");
      out.write("            span.psw {\n");
      out.write("                display: block;\n");
      out.write("                float: none;\n");
      out.write("            }   \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        <header class=\"bgimg-1 w3-display-container w3-grayscale-min\" id=\"home\">\n");
      out.write("            <div class=\"w3-display-left w3-text-white\" style=\"padding:48px\">\n");
      out.write("                <span class=\"w3-jumbo w3-hide-small\">Chăn Ga Tấn Dũng</span><br>\n");
      out.write("                <span class=\"w3-large\">Chất lượng tạo thương hiệu</span>\n");
      out.write("                <p><a href=\"https://www.youtube.com/\" class=\"w3-button w3-white w3-padding-large w3-large w3-margin-top w3-opacity w3-hover-opacity-off\">Learn more and start today</a></p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("        <div class=\"w3-top\">\n");
      out.write("            <div style=\"background-color: #cccccc\">\n");
      out.write("                <a class=\"w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red\" href=\"javascript:void(0);\" onclick=\"myFunction()\" title=\"Toggle Navigation Menu\"><i class=\"fa fa-bars\"></i></a>\n");
      out.write("                <a href=\"main\" class=\"w3-bar-item w3-button w3-padding-large w3-white\">Home</a>\n");
      out.write("                <div class=\"w3-dropdown-hover w3-hide-small\">\n");
      out.write("                    <button class=\"w3-button\" title=\"Hóa Đơn Nhập\">Hóa đơn nhập(Inport)<i class=\"fa fa-caret-down\"></i></button>     \n");
      out.write("                    <div class=\"w3-dropdown-content w3-card-4 w3-bar-block\">\n");
      out.write("                        <a href=\"hdnhap\" class=\"w3-bar-item w3-button\">Thêm hóa đơn nhập hàng</a>\n");
      out.write("                        <a href=\"searchnhap\" class=\"w3-bar-item w3-button\">Tra cứu</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"w3-dropdown-hover w3-hide-small\">\n");
      out.write("                    <button class=\"w3-button\" title=\"Hóa Đơn Xuất\">Hóa đơn xuất(Export)<i class=\"fa fa-caret-down\"></i></button>     \n");
      out.write("                    <div class=\"w3-dropdown-content w3-card-4 w3-bar-block\">\n");
      out.write("                        <a href=\"hdthongke\" class=\"w3-bar-item w3-button\">Thêm thống kê hôm nay</a>\n");
      out.write("                        <a href=\"searchxuat\" class=\"w3-bar-item w3-button\">Tra cứu</a>\n");
      out.write("                         <a href=\"TKThang.jsp\" class=\"w3-bar-item w3-button\">Doanh thu tháng</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"w3-dropdown-hover w3-hide-small\">\n");
      out.write("                    <button class=\"w3-button\" onclick=\"document.getElementById('id01').style.display = 'block'\" style=\"width:auto;\">Kho</button>\n");
      out.write("                    <div id=\"id01\" class=\"modal\" style=\"overflow-style: scrollbar;\">\n");
      out.write("                        <form class=\"modal-content animate\" action=\"/action_page.php\" method=\"post\">\n");
      out.write("                            <div class=\"container\">\n");
      out.write("                                <h1>Kho</h1>\n");
      out.write("                                <table style=\"border: 2px solid;size: 900px\">\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Id</td>\n");
      out.write("                                        <td>Loại hàng</td>\n");
      out.write("                                        <td>Số lượng trong kho</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                </table>\n");
      out.write("                                      <button type=\"button\" onclick=\"document.getElementById('id01').style.display='none'\" class=\"cancelbtn\">Xong</button>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"w3-dropdown-hover w3-hide-small\">\n");
      out.write("                    <a href=\"login.jsp\"><button class=\"w3-button\">Đăng xuất(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")</button></a> \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.kho}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("k");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                        <tr style=\"text-align: center;border: 1px solid; padding: 8px;\">\n");
          out.write("                                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${k.idsp}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${k.namesp}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${k.soluong}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        </tr>\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
