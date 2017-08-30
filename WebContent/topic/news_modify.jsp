<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	var $selectIndex = $("#selectIndex");
	var currentPage =$("#currentPage").val();
	for(var i=1;i<=$("#maxPage").val();i++){
		var $option=$("<option>");
		$option.text("第"+i+"页");
		$option.val(i);
		if(currentPage==i){
			$option.attr("selected",true);
		}
		$selectIndex.append($option);
	}
	$selectIndex.change(function(){
		var option_val = $(this).find("option:selected").val();
		location.href="to_news_modify?index="+option_val;
	})
	$("#submit").click(function(){
		var $index = $("#index");
		if($index.val()>$("#maxPage").val()){
			alert("输入的页码过大");
		}else if($index.val()<1){
			alert("输入的页码过小");
		}else{
			location.href="to_news_modify?index="+$index.val();
		}
	})
})
</script>
</head>
<body>
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="../images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="../images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员： 登录  &#160;&#160;&#160;&#160; <a href="#">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <h1 id="opt_type"> 编辑新闻： </h1>
    <ul>
    <c:forEach items="${newsList}" var="news">
    <li><a href="to_news_update?id=${news.nid}">编辑</a>&nbsp;&nbsp;&nbsp;${news.ntitle}</li>
    </c:forEach>
    </ul>
    <a href="to_news_modify?index=1">首页</a>
    <a href="to_news_modify?index=${pageInfo.prevPage.currentPage}">上一页</a>
    <a href="to_news_modify?index=${pageInfo.nextPage.currentPage}">下一页</a>
    <a href="to_news_modify?index=${pageInfo.endPage}">尾页</a><br/>
    <label for="index">请输入页码</label><input style="width:25px;"type="text" id="index" name="index/">
    <input type="hidden" id="maxPage" value="${pageInfo.endPage}"/>
    <input type="hidden" id="currentPage" value="${pageInfo.currentPage}"/>
    <input type="button" id="submit" value="确定"/><br/>
    <select id="selectIndex">
    </select>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
