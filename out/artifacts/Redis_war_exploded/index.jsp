<%--
  Created by IntelliJ IDEA.
  User: xiaokai
  Date: 2022/3/20
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String basePath = request.getScheme() + "://" + request.getServletPath() +":"+ request.getContextPath() + "/";
%>
<html>
  <head>
    <title>秒杀活动</title>
    <base herf="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-1.11.3/jquery.js"></script>
    <script type="text/javascript">

//       $("#skfrom").on('submit',function () {
//         $.ajax({
//           url: "test1",
//           method: "POST",
//
//           data: das,
//           // //指定参数格式类型
//           // contentType:'application/x-www-form-urlencoded',
//           success: function (das) {
//             alert(das);
//           }
//         });
//
//
//       })


    </script>
  </head>
  <body>

  <h>
    在线秒杀活动
  </h>
  <form id="skfrom" action="Seckill.do" method="post" >
    <input type="hidden" name="proid" value="0101">
    <input type="submit"  value="click!">
  </form>

  </body>
</html>
