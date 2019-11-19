<%--
  Created by IntelliJ IDEA.
  User: 63237
  Date: 2019/3/14
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>

    <script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
</head>
<body>
    <script type="text/javascript" >
        $(document).ready(function () {
            var max = 10000                                                                                                                                                                                                                                                                                                                                                                                                ;
            for(var i = 1; i <= max; i++){
                $.get({
                    url:'/goodsType/goodsTypes',
                    success: function () {

                    }
                });
            }
        });
    </script>
</body>
</html>
