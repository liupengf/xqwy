/*
 * JSP generated by Resin-3.0.28 (built Mon, 18 May 2009 02:16:38 PDT)
 */

package _jsp._web_22dinf._view._xqwy._jbxx._zhxx;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _edit__jsp extends com.caucho.jsp.JavaPage{
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("WEB-INF/view/xqwy/jbxx/zhxx/edit.jsp"), -6067388745647261441L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }
  private final static com.caucho.el.Expr _caucho_expr_0 =
    new com.caucho.el.IdExpr("sfz");

  private final static char []_jsp_string0;
  private final static char []_jsp_string1;
  static {
    _jsp_string0 = "\r\n\r\n<div class=\"dialog-content\">\r\n	<div class=\"row-fluid\">\r\n		<form id=\"operateFormId\" class=\"form-horizontal\">\r\n			<div class=\"tabbable tabbable-custom tabbable-full-width\"\r\n				style=\"width: 800px; height: auto;\">\r\n				<div class=\"tab-content\">\r\n					<div class=\"row-fluid\" id=\"swformdiv\">\r\n						<div class=\"row-fluid \">\r\n							<!--\u6307\u6807\u540d\u79f0-->\r\n							<div class=\"span12 \">\r\n								<div class=\"control-group\">\r\n									<label class=\"control-label\" for=\"sfz\">\u8eab\u4efd\u8bc1\u53f7<span\r\n										class=\"required\">*</span></label>\r\n									<div class=\"controls\">\r\n										<input type=\"text\"  id=\"sfz\" class=\"m-wrap\" placeholder=\"\"\r\n											name=\"sfz\"/>\r\n											<input name=\"ysfz\" id=\"ysfz\" type=\"hidden\"/>\r\n									</div>\r\n								</div>\r\n							</div>\r\n						</div>\r\n						<div class=\"row-fluid \">\r\n							<!--\u6307\u6807\u540d\u79f0-->\r\n							<div class=\"span12 \">\r\n								<div class=\"control-group\">\r\n									<label class=\"control-label\" for=\"xqmc\">\u5c0f\u533a\u540d\u79f0<span\r\n										class=\"required\">*</span></label>\r\n									<div class=\"controls\">\r\n										<input type=\"text\"  id=\"xqmc\" class=\"m-wrap\" placeholder=\"\"\r\n											name=\"xqmc\"/>\r\n									</div>\r\n								</div>\r\n							</div>\r\n						</div>\r\n						<div class=\"row-fluid \">\r\n							<!--\u6307\u6807\u540d\u79f0-->\r\n							<div class=\"span12 \">\r\n								<div class=\"control-group\">\r\n									<label class=\"control-label\" for=\"xm\">\u59d3\u540d<span\r\n										class=\"required\">*</span></label>\r\n									<div class=\"controls\">\r\n										<input type=\"text\" id=\"xm\" class=\"m-wrap\" placeholder=\"\"\r\n											name=\"xm\" value=\"\">\r\n									</div>\r\n								</div>\r\n							</div>\r\n						</div>\r\n						<div class=\"row-fluid \">\r\n							<!--\u6307\u6807\u540d\u79f0-->\r\n							<div class=\"span6 \">\r\n								<div class=\"control-group\">\r\n									<label class=\"control-label\" for=\"address\">\u5730\u5740<span\r\n										class=\"required\">*</span></label>\r\n									<div class=\"controls\">\r\n										<input type=\"text\" id=\"address\" class=\"m-wrap\" placeholder=\"\"\r\n											name=\"address\" value=\"\">\r\n									</div>\r\n								</div>\r\n							</div>\r\n					\r\n						</div>\r\n					</div>\r\n				</div>\r\n			</div>\r\n		</form>\r\n	</div>\r\n</div>\r\n<script type=\"text/javascript\">\r\n$(document).ready(function(){\r\n$.rest.loadData(\"".toCharArray();
    _jsp_string1 = "\");\r\n});\r\n</script>".toCharArray();
  }
}
