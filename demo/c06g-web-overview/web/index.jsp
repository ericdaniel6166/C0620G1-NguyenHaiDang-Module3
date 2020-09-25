<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Test web</title>
  </head>
  <body>
    <h2>Hello C0620G1!</h2>
    <form action="/abcServlet">
      <input type="text" name="num1" />
      <input type="text" name="num2" />
      <input type="submit" value="Save info" />
    </form>

<%--    ADVANCE--%>
<%--    <%--%>
<%--      String str = (String) request.getAttribute("total");--%>

<%--      if (str != null) {--%>
<%--    %>--%>
<%--    <h2 style="text-align: center; color: violet"><%=str%></h2>--%>
<%--    <%--%>
<%--      }--%>
<%--    %>--%>
  </body>
</html>
