<%@ page contentType="text/html;charset=gb2312"%>
<script language="javascript">
function on_submit()
{//��֤���ݵĺϷ���
if (form1.username.value == "")
{
	alert("�û�������Ϊ�գ��������û�����");
	form1.username.focus();
	return false;
}
if (form1.userpassword.value == "")
{
     alert("�û����벻��Ϊ�գ����������룡");
     form1.userpassword.focus();
     return false;
}
if (form1.reuserpassword.value == "")
{
     alert("�û�ȷ�����벻��Ϊ�գ����������룡");
     form1.reuserpassword.focus();
     return false;
}
if (form1.userpassword.value != form1.reuserpassword.value)
{    
     alert("������ȷ�����벻ͬ");
     form1.userpassword.focus();
     return false;
}
if (form1.email.value.length!= 0)
{
    for (i=0; i<form1.email.value.length; i++)
       if (form1.email.value.charAt(i)=="@")
             break;
if (i==form1.email.value.length)
{
     alert("�Ƿ�EMail��ַ��");
     form1.email.focus();
     return false;
}	
}
else
{
    alert("������Email��");
    form1.email.focus();
     return false;
}
}
</script>
<html>
<head>
<title>���û�ע��</title>
</head>
<body>
<form method="POST" action="/test/Servlet/acceptUserRegist" name="form1" onsubmit="return on_submit()">
���û�ע��<br>
�û���(*)��<input type="text" name="username" size="20"><br>
��&nbsp; ��(*)��<input type="password" name="userpassword" size="20"><br> 
����һ������(*)��<input type="password" name="reuserpassword" size="20"><br>
�Ա�<input type="radio" value="��" checked name="sex">��<input type="radio" name="sex" 

value="Ů">Ů<br>
�������£�<input name="year" size="4"  maxlength=4>��  
<select name="month">
<option value="1" selected>1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="8">7</option>
<option value="9">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
</select>�� 
<input name="day" size="3"  maxlength=4>��<br>
��������(*)��<input name="email"  maxlength=28><br>
��ͥסַ��<input type="text" name="address" size="20"><br>
<input type="submit" value="�ύ" name="B1"><input type="reset" value="ȫ����д" 

name="B2"><br>
</form>
</body>
</html>