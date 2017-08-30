<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html >
<%@include file="console_element/top.jsp" %>
<script type="text/javascript">
	function check(){
		var tname = document.getElementById("tname");

		if(tname.value == ""){
			alert("请输入主题名称！！");
			tname.focus();
			return false;
		}		
		return true;
	}
</script>

<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <h1 id="opt_type">修改主题： </h1>
    <form action="topicController" method="post" onsubmit="return check()">
      <p>
        <label>主题名称 </label>
        <input name="tname" type="text" id="tname" class="opt_input" value=""/>
        <input name="tid" type="hidden" value="${param.id}" />
      </p>
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
      <input type="hidden" value="update" name="type"/>
    </form>
  </div>
</div>
<%@include file="console_element/bottom.html" %>
