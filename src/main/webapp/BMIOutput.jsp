<%@page import="java.io.PrintWriter"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		Servlet : Java �ڵ� �ȿ��� html�� ����
		jsp : html���� java�ڵ�� �ۼ��� ����
	 -->
	<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");	

	String path = request.getServletContext().getRealPath("image");
	MultipartRequest mr = new MultipartRequest(request, path, 30*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
	
	System.out.println(path);

	String name = mr.getParameter("names");
	String he = (mr.getParameter("height"));
	double height = Double.parseDouble(he);
	String we = (mr.getParameter("weight"));
	double weight = Double.parseDouble(we);
	String fileName = mr.getFilesystemName("photo");

	fileName = URLEncoder.encode(fileName, "UTF-8");
	fileName = fileName.replace(" ", "+");

	double bmi = weight / ((height / 100) * (height / 100));
	String result = "��ü��";

	if (bmi >= 40) {
		result = "����";
	} else if (bmi >= 35) {
		result = "�ߵ��";
	} else if (bmi >= 30) {
		result = "�浵��";
	} else if (bmi >= 25) {
		result = "��ü��";
	} else if (bmi >= 18.5) {
		result = "����";
	}


	// �Ҽ� ��°�ڸ�
	String bmi2 = String.format("%.2f", bmi);

	String image = mr.getFilesystemName("photo");
	image = URLEncoder.encode(image, "UTF-8");
	image = image.replace(" ", "+");
	%>

	<table border="1">
		<tr>
			<th colspan="5">BMI Result</th>
		</tr>
		<tr>
			<td width ="100px" align="center">�̸�</td>
			<td align="center"><%=name%></td>
		</tr>
		<tr>
			<td align="center">Ű</td>
			<td align="center"><%=height%>cm</td>
		</tr>
		<tr>
			<td align="center">������</td>
			<td align="center"><%=weight%>kg</td>
		</tr>
		<tr>
			<td align="center">BMI</td>
			<td align="center"><%=bmi2%></td>
		</tr>
		<tr>
			<td align="center">���</td>
			<td align="center"><%=result%></td>
		</tr>
		<tr>
			<td align="center"  colspan="5"><img src="image/<%=image%>" style="min-width:60%;"></td>
		</tr>
	</table>
</body>
</html>