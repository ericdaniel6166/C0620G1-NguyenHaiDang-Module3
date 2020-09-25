<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/24/2020
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Product Discount Calculator</h2>
  <form action="/discount" method="post">
    <input type="text" name="productDescription" placeholder="Enter Product Description: "/>
    <input type="text" name="listPrice" placeholder="Enter List Price: "/>
    <input type="text" name="discountPercent" placeholder="Enter Discount Percent: "/>
    <input type="submit" id="submit" value="Submit"/>
  </form>
  </body>
</html>
