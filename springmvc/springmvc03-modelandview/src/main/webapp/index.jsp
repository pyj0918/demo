<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<body>
 <a href="springmvc/testmodelandview">test modelandview</a><br>
  <a href="springmvc/testmap">test map</a><br>
  <a href="springmvc/testsessionattributes">test sessionattributes</a><br>
  
  <!-- 
  
  	模拟修改操作：
  	1.原始数据为：1，tom,123,123@qq.com,12
  	2.密码不能被修改
  	3.表单回显，模拟操作直接在表单填写对应的属性值
   -->
  <form action="springmvc/testmodelattribute" method="post">
  	<input type="hidden" name="id" value="1" />
  	username:<input type="text" name="username" value="tome" /><br>
  	email:<input type="text" name="email" value="123@qq.com" /><br>
  	age:<input type="text" name="age" value="12" /><br>
  	<input type="submit" value="提交"/>
  </form>
</body>
</html>
