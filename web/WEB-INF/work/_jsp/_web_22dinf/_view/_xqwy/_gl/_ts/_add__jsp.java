/*
 * JSP generated by Resin-3.0.28 (built Mon, 18 May 2009 02:16:38 PDT)
 */

package _jsp._web_22dinf._view._xqwy._gl._ts;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _add__jsp extends com.caucho.jsp.JavaPage{
  private boolean _caucho_isDead;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    com.caucho.server.webapp.Application _jsp_application = _caucho_getApplication();
    javax.servlet.ServletContext application = _jsp_application;
    com.caucho.jsp.PageContextImpl pageContext = com.caucho.jsp.QJspFactory.allocatePageContext(this, _jsp_application, request, response, null, null, 8192, true, false);
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("WEB-INF/view/xqwy/gl/ts/add.jsp"), 1689706598173109921L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string0;
  static {
    _jsp_string0 = "\r\n\r\n<div class=\"dialog-content\">\r\n	<div class=\"row-fluid\">\r\n		<form id=\"operateFormId\" class=\"form-horizontal\">\r\n			<div class=\"tabbable tabbable-custom tabbable-full-width\"\r\n				style=\"width: 800px; height: auto;\">\r\n				<div class=\"tab-content\">\r\n					<div class=\"row-fluid\" id=\"swformdiv\">\r\n						<div class=\"row-fluid \">\r\n							<!--\u6307\u6807\u540d\u79f0-->\r\n							<div class=\"span12 \">\r\n								<div class=\"control-group\">\r\n									<label class=\"control-label\" for=\"tsr\">\u6295\u8bc9\u4eba<span\r\n										class=\"required\">*</span></label>\r\n									<div class=\"controls\">\r\n										<input type=\"text\" id=\"tsr\" class=\"m-wrap\" placeholder=\"\"\r\n											name=\"tsr\" />\r\n									</div>\r\n								</div>\r\n							</div>\r\n						</div>\r\n						<div class=\"row-fluid \">\r\n							<!--\u6307\u6807\u540d\u79f0-->\r\n							<div class=\"span12 \">\r\n								<div class=\"control-group\">\r\n									<label class=\"control-label\" for=\"tssj\">\u6295\u8bc9\u65e5\u671f<span\r\n										class=\"required\">*</span></label>\r\n\r\n									<div class=\"input-append date\" id=\"datetimepicker\"\r\n										data-date-format=\"yyyy-mm-dd\">\r\n										<input type=\"text\" id=\"tssj\"> <span class=\"add-on\"><i\r\n											class=\"icon-th\"></i></span>\r\n									</div>\r\n\r\n								</div>\r\n							</div>\r\n						</div>\r\n						<div class=\"row-fluid \">\r\n							<!--\u6307\u6807\u540d\u79f0-->\r\n							<div class=\"span12 \">\r\n								<div class=\"control-group\">\r\n									<label class=\"control-label\" for=\"jzxq\">\u5730\u5740<span\r\n										class=\"required\">*</span></label>\r\n									<div class=\"controls\">\r\n										<input type=\"text\" id=\"jzxq\" class=\"m-wrap\" placeholder=\"\"\r\n											name=\"jzxq\" value=\"\">\r\n									</div>\r\n								</div>\r\n							</div>\r\n						</div>\r\n						<div class=\"row-fluid \">\r\n							<!--\u6307\u6807\u540d\u79f0-->\r\n							<div class=\"span12 \">\r\n								<div class=\"control-group\">\r\n									<label class=\"control-label\" for=\"jzxq\">\u6295\u8bc9\u7c7b\u522b<span\r\n										class=\"required\">*</span></label>\r\n									<div class=\"controls\">\r\n										<select id=\"tslb\" name=\"tslb\">\r\n											<option value=\"\u566a\u97f3\">\u566a\u97f3</option>\r\n											<option value=\"\u6c61\u67d3\">\u6c61\u67d3</option>\r\n											<option value=\"\u5176\u4ed6\">\u5176\u4ed6</option>\r\n											<option></option>\r\n										</select>\r\n									</div>\r\n								</div>\r\n							</div>\r\n						</div>\r\n						<div class=\"row-fluid \">\r\n							<!--\u6307\u6807\u540d\u79f0-->\r\n							<div class=\"span12 \">\r\n								<div class=\"control-group\">\r\n									<label class=\"control-label\" for=\"tsnr\">\u6295\u8bc9\u5185\u5bb9<span\r\n										class=\"required\">*</span></label>\r\n									<div class=\"controls\">\r\n										<input type=\"text\" id=\"tsnr\" class=\"m-wrap\" placeholder=\"\"\r\n											name=\"tsnr\" value=\"\">\r\n									</div>\r\n								</div>\r\n							</div>\r\n						</div>\r\n					</div>\r\n				</div>\r\n			</div>\r\n		</form>\r\n	</div>\r\n	<script type=\"text/javascript\">\r\n	$(document).ready(function(){\r\n		$('#datetimepicker').datetimepicker();\r\n	});\r\n	</script>\r\n</div>".toCharArray();
  }
}