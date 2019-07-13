<%@ page language="java" contentType="text/html; 
charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;"> 欢迎系统管理员：</div>
    <div class="sideMenu">
      <h3 class="am-icon-cart-plus"><em></em> <a href="#"> 发布信息管理</a></h3>
      <ul>
      	<c:url var="showLostList" value="/admin/showLostList"></c:url>
      	<li><a href="${ showLostList }">失物寻物信息(失物寻找)</a></li>
      	
      	<c:url var="showFindList" value="/admin/showFindList"></c:url>
      	<li><a href="${ showFindList }">失物寻物信息(失主找寻)</a></li>

        <c:url var="showAroundList" value="/admin/showAroundList"></c:url>
        <li><a href="${ showAroundList }">周边信息</a></li>

      	<c:url var="showCooperationList" value="/admin/showCooperationList"></c:url>
      	<li><a href="${ showCooperationList }">求助信息</a>

        <c:url var="showCampusList" value="/admin/showCampusList"></c:url>
        <li><a href="${ showCampusList }">校园资讯</a>

      </ul>
      <h3 class="am-icon-users"><em></em> <a href="#">用户管理</a></h3>
      <ul>
      	<c:url var="showNormalUserList" value="/admin/showNormalUserList"></c:url>
      	<li><a href="${ showNormalUserList }">正常用户</a></li>
      	<c:url var="showBannedUserList" value="/admin/showBannedUserList"></c:url>
        <li><a href="${ showBannedUserList }">封禁用户</a></li>
      </ul>
      <h3 class="am-icon-flag"><em></em> <a href="#">商品管理</a></h3>
      <ul>
        <c:url var="showAllGood" value="/admin/showGoodList"></c:url>
        <li><a href="${ showAllGood }">商品列表</a></li>
      </ul>
    </div>
    <!-- sideMenu End --> 
    
    <script type="text/javascript">
			jQuery(".sideMenu").slide({
				titCell:"h3", //鼠标触发对象
				targetCell:"ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
				effect:"slideDown", //targetCell下拉效果
				delayTime:300 , //效果时间
				triggerTime:150, //鼠标延迟触发时间（默认150）
				defaultPlay:true,//默认是否执行效果（默认true）
				returnDefault:true //鼠标从.sideMen移走后返回默认状态（默认false）
				});
		</script>   
</body>
</html>