/*
 * JSP generated by Resin-3.0.28 (built Mon, 18 May 2009 02:16:38 PDT)
 */

package _jsp._web_22dinf._view._xqwy._gl._bx;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _bxlist__jsp extends com.caucho.jsp.JavaPage{
  private boolean _caucho_isDead;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.Application _jsp_application = _caucho_getApplication();
    javax.servlet.ServletContext application = _jsp_application;
    com.caucho.jsp.PageContextImpl pageContext = com.caucho.jsp.QJspFactory.allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
      _caucho_expr_0.print(out, pageContext, false);
      out.write(_jsp_string1, 0, _jsp_string1.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      com.caucho.jsp.QJspFactory.freePageContext(pageContext);
    }
  }

  private java.util.ArrayList _caucho_depends = new java.util.ArrayList();

  public java.util.ArrayList _caucho_getDependList()
  {
    return _caucho_depends;
  }

  public void _caucho_addDepend(com.caucho.make.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;
    if (com.caucho.util.CauchoSystem.getVersionId() != -4644494061398360982L)
      return true;
    for (int i = _caucho_depends.size() - 1; i >= 0; i--) {
      com.caucho.make.Dependency depend;
      depend = (com.caucho.make.Dependency) _caucho_depends.get(i);
      if (depend.isModified())
        return true;
    }
    return false;
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("WEB-INF/view/xqwy/gl/bx/bxlist.jsp"), -7036836125259273071L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }
  private final static com.caucho.el.Expr _caucho_expr_0 =
    new com.caucho.el.IdExpr("baseUrl");

  private final static char []_jsp_string1;
  private final static char []_jsp_string0;
  static {
    _jsp_string1 = "/res/js/xqwy/gl/bx/bxlist.js\"\r\n	type=\"text/javascript\"></script>\r\n	<script type=\"text/javascript\">\r\n	$(document).ready(function(){\r\n	$.initDataTable();\r\n	$.initButtonClick();\n	});\n</script>\r\n".toCharArray();
    _jsp_string0 = "\r\n	<div class=\"row-fluid\" style=\"height: 20px;\"></div>\r\n	<div class=\"row-fluid\">\r\n	<div class=\"span8\">\r\n	&nbsp;&nbsp;&nbsp;&nbsp;\u62a5\u4fee\u4eba\uff1a<input type=\"text\" id=\"bxr\">\r\n	\u62a5\u4fee\u7c7b\u522b\uff1a<input type=\"text\" id=\"bxlb\">\r\n	<a id=\"searchbxButton\" class=\"btn\" href=\"javaScript:void(0)\" style=\"float: right;\">\u67e5\u8be2</a>\r\n	</div>\r\n	<div class=\"span4\">\r\n	<a id=\"addbx\" class=\"btn\" href=\"javaScript:void(0)\" style=\"float: left;\">\u6dfb\u52a0</a>\r\n	</div>\r\n	</div>\r\n		<div class=\"portlet-body\" id=\"loadingDiv\">\r\n									<form id=\"dataTableForm\" name=\"dataTableForm\">\r\n										<input id=\"aoDataInputId\" name=\"aoData\" type=\"hidden\" />\r\n			<table class=\"table table-striped table-bordered table-hover\"\r\n															id=\"dataTableId\">\r\n															<thead>\r\n																<tr> \r\n																<th class=\"hidden-480\">\u62a5\u4fee\u4eba</th>\r\n																	<th class=\"hidden-480\">\u62a5\u4fee\u65e5\u671f</th>\r\n																	<th class=\"hidden-480\">\u5730\u5740</th>\r\n																	<th class=\"hidden-480\">\u62a5\u4fee\u7c7b\u522b</th>\r\n																	<th class=\"hidden-480\">\u62a5\u4fee\u5185\u5bb9</th>\r\n																	<th class=\"hidden-480\">\u64cd\u4f5c</th>\r\n																</tr>\r\n															</thead>\r\n															<tbody id=\"qjblListTbody\">\r\n													\r\n															</tbody>\r\n														</table>\r\n														</form>\r\n														\r\n				</div>\r\n	<script\r\n	src=\"".toCharArray();
  }
}
