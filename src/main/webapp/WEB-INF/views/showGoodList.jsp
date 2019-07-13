<%@ page language="java" contentType="text/html; 
charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/Resources/css/amazeui.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/Resources/css/admin.css">
<link href="${pageContext.request.contextPath }/Resources/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<link href="${pageContext.request.contextPath }/Resources/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath }/Resources/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/Resources/js/app.js"></script>
</head>
<body>
<header class="am-topbar admin-header">
</header>

<div class="am-cf admin-main"> 

<div class="nav-navicon admin-main admin-sidebar">
	<jsp:include page="menu.jsp"></jsp:include>
</div>
</div>

<div class=" admin-content">
	
		<div class="daohang">
			<ul>
				<%--<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs"> 首页 </li>--%>
				<%--<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">帮助中心<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>--%>
				<%--<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">奖金管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>--%>
				<%--<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">产品管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>--%>
				<%----%>
				
			</ul>

       

	
</div>
<div class="admin">


	<div class="admin-biaoge">
      <table width="200%" border="1">
          <tr class="CustomerStyle">
          	<th>商品图片</th>
            <th>商品名称</th>
            <th>商品类型</th>
            <th>商品价格</th>
            <th>商品存货</th>
            <th>商品描述</th>
            <th>操作</th>
          </tr>
        <tbody>
        <c:forEach var="GoodList" items="${GoodList}">
			<tr class="CustomerStyle">
				<td class="ring-in" width="10%"><img src="${GoodList.goodPic}" class="img-responsive" width="200" height="80"></td>
				<td width="10%"><span>${GoodList.goodName}</span></td>
				<td width="10%"><span>${GoodList.goodType}</span></td>
				<td width="10%"><span>${GoodList.goodPrice}</span></td>
				<td width="10%"><span>${GoodList.goodStock}</span></td>
				<td width="15%"><span>${GoodList.goodDescription}</span></td>
                <td width="10%">

                    <c:url var="deleteGood" value="/admin/deleteGood">
                        <c:param name="gId" value="${GoodList.GId}" />
                    </c:url>
                    <a href="${deleteGood}" onclick="if (!(confirm('你确定要删除此商品吗?'))) return false">删除商品</a>
                </td>
			</tr>
		</c:forEach>      
        </tbody>
      </table> 
	</div>
    <div class="foods">
    	<dl><a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a></dl>
    </div>

</div>

</div>


</div>

<script src="assets/js/amazeui.min.js"></script>


</body>
</html>