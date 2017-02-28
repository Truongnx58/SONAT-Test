<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert User</title>
<link rel="stylesheet" href="style.css" />
</head>

<body>
	<div>
	<h1 align="center">Add User</h1>
		<fieldset>
		<legend><h3>Nhập thông tin</h3></legend>
		<form method="post" action="insert" onsubmit="return check()" >
			<table class="tb">
				<tr>
					<td>Họ tên</td>
					<td><input type="text" placeholder="Họ tên" name="name" id="name"/></td>
				</tr>
				<tr>
					<td>Giới tính</td>
					<td>
						<input type="radio" value="M" name="gender" checked="checked" id="gender"/>Nam
						<input type="radio" value="F" name="gender" id="gender"/>Nữ
					</td>
				</tr>
				<tr>
					<td>Tuổi</td>
					<td><input type="text" placeholder="Tuổi" name="age" id="age"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" name="insert" value="Thêm" />
					</td>
				</tr>
			</table>
		</form>
		</fieldset>
		<script>
			function check() {
			    var name = document.getElementById("name").value;
			    var gender = document.getElementById("gender").value;
			    var age = document.getElementById("age").value;
			    
			    if(name==""||gender==""||age==""){
			    	alert("Vui lòng nhập đầy đủ thông tin!");
			    	return false;
			    }
			    else{
			    	if(parseInt(age)!=age||parseInt(age)<=0){
			    		alert("Tuổi không hợp lệ!");
			    		return false;
			    	}
			    	else return true;
			    }
			    
			}
		</script>
	</div>
</body>
</html>