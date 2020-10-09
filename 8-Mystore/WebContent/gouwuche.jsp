<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>蚂蚁购物车</title>
    <link rel="stylesheet" href="css/cart.css">
    <!--链接外部样式-->
    <link rel="stylesheet" href="style/headerStyle.css">
    <!--设置标签图标-->
    <link href="favicon.ico" rel="shortcut icon">
    
</head>

<body>
    <%@include file ="/header.jsp" %>
    <div class="float-box">

        <div class="confirm-box">

            <h4 class="confirm-title">
                <span></span>
                <i class="close-btn">

                    <span class="line-left"></span>
                    <span class="line-right"></span>

                </i>
            </h4>

            <div class="confirm-content">

                请选择您要删除的商品？

            </div>

            <div class="confirm-btn">

                <a href="javascript:;" class="delete">删除</a>
                <a href="javascript:;" class="cancel">取消</a>

            </div>

        </div>

    </div>

    <div class="header">
        <div class="header-center">
        </div>
    </div>


    <div class="mz-foot"></div>


    <script src="js/jquery.min.js"></script>
    <script src="js/cart.js"></script>
	<%@include file="/footer.jsp" %>
</body>

</html>