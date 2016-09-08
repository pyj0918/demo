<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<body>
<a href="springmvc/testrequestmapping">requestmapping</a></br>
<a href="springmvc/testmethod">requestmethod</a></br>

<form action="springmvc/testmethod" method="post">
<input type="submit" value="submit" />
</form>
<br>
<a href="springmvc/testparamsandheaders?username=atguigu&age=11">request params and headers</a></br>

<a href="springmvc/test/nfff/mm/abc">通配符</a></br>
<a href="springmvc/testpathvar/1">variable</a></br>

restful:<br>
<form action="springmvc/testpost" method="post">
	<input type="submit" value="restful post" />
</form><br>

<a href="springmvc/testget/1">restful get</a></br>

<form action="springmvc/testput/1" method="post">
	<input type="hidden" name="_method" value="put" />
	<input type="submit" value="restful put" />
</form><br>
<form action="springmvc/testdelete/1" method="post">
	<input type="hidden" name="_method" value="delete" />
	<input type="submit" value="restful delete" />
</form><br>

<a href="springmvc/testparams?username=pyj&age=30">test requestparam</a><br>

test pojo:<br>
<form action="springmvc/testpojo" method="post">
	username:<input type="text" name="username" /><br>
	password:<input type="text" name="password" /><br>
	email:<input type="text" name="email" /><br>
	age:<input type="text" name="age" /><br>
	privince:<input type="text" name="address.province" /><br>
	city:<input type="text" name="address.city" /><br>
	<input type="submit" value="test pojo" />
</form><br>


<a href="springmvc/testservletapi">test requestparam</a><br>

</body>
</html>
