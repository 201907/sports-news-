<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.jbit.news.bean.News" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <div id="welcome">&quot;欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="../images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="../images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员： 登录  &#160;&#160;&#160;&#160;<a href="#">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
	<%
		News news = (News)request.getAttribute("news");
	 %>
  <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <h1 id="opt_type"> 修改新闻： </h1>
    <form action="newsController?type=update" method="post">
      <p>
        <label> 主题 </label>
        <input name="tname" type="text" disabled="disabled" value="${topicName}" class="opt_input" />
      </p>
      <p>
        <label> 标题 </label>
        <input name="ntitle" type="text" value="<%=news.getNtitle() %>" class="opt_input" />
      </p>
      <p>
        <label> 作者 </label>
        <input name="nauthor" type="text" value="" value="<%=news.getNauthor() %>" class="opt_input" />
      </p>
      <p>
        <label> 摘要 </label>
        <textarea name="nsummary" cols="40" rows="3"><%=news.getNsummary() %></textarea>
      </p>
      <p>
        <label> 内容 </label>
        <textarea name="ncontent" cols="70" rows="10"><%=news.getNcontent() %></textarea>
      </p>
      <p>
        <label> 上传图片 </label>
        <input name="file" type="text" value="<%=news.getNpicpath() %>" class="opt_input" />
      </p>
      <input type= "hidden" name="nid" value="${news.nid}">
      <input type="submit" value="更新" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
