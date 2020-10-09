<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>码蚁商城</title>
    <link rel="stylesheet" href="style/index.css">
    <link rel="stylesheet" href="style/index.css">
    <link rel="stylesheet" href="style/pageStyle.css">
</head>
<body>
<!-- 导入hearder.jsp  -->
<%@include file ="/header.jsp" %>
<!--广告页-->
<div id="ad">
    <img src="images/goods/ad.jpg" alt="">
</div>

<!--秒杀-->
<div id="ms">
    <div class="ms_title">
        <span>码蚁秒杀</span>
        <span>总有你想不到的低价</span>
    </div>

    <div class="ms_body">
        <ul>
            <li>
                <a href="detail.jsp">
                    <img src="images/goods/good1.png" alt="">
                    <p>小米 红米5A 全网通版 2GB+16GB</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods2.png" alt="">
                    <p>戴尔DELL灵越5000 14英寸酷睿i5</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods3.png" alt="">
                    <p>华硕a豆 adolbook14 2020 增强版</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods4.png" alt="">
                    <p>美的（Midea）电饭煲电饭锅5L大容量智能预约</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="images/goods/goods5.png" alt="">
                    <p>小米电视4A 60英寸 L60M5-4A 4K超高清 HDR</p>
                    <i class="yuan">￥</i><span class="price">599</span>
                </a>
            </li>
        </ul>
    </div>
</div>

<!--热买商品-->
<div id="hot_goods">
    <h3 class="hot_goods_title">热卖商品</h3>
    <div class="hot_goods_body">
        <ul>
           <c:if test="${empty allGoods }">
           		没有商品
           </c:if>
           
           <c:forEach items="${allGoods }" var="goods">
           		<li>
                	<a href="">
                    	<img src="images/pimages/${goods.image }" alt="">
                    	<p>${goods.name }</p>
                    	<i class="yuan">￥</i><span class="price">${goods.price }</span>
                	</a>
            	</li>
           </c:forEach> 
        </ul>
    </div>
     <!--分页-->
    <div id="page" class="page_div"></div>
</div>

<!--尾部-->
<%@include file="/footer.jsp" %>

<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/paging.js"></script>
<script>
    //分页
    $("#page").paging({
        pageNo:5,
        totalPage: 10,
        totalSize: 300,
        callback: function(num) {
            alert(num);
        }
    })
</script>
</body>
</html>


    