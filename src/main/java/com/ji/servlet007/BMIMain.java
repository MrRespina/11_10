package com.ji.servlet007;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/BMIMain")
public class BMIMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BMIMain() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// bmi = weight / (height * height) /height는 미터 단위로!

		// 18.5 미만 : 저체중 , 18.5 이상 : 정상 , 25 이상 : 과체중 , 30 이상 : 경도비만 , 35 이상 : 중등도비만 ,
		// 40이상 : 고도비만

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
		String result = "저체중";

		if (bmi >= 40) {
			result = "고도비만";
		} else if (bmi >= 35) {
			result = "중등도비만";
		} else if (bmi >= 30) {
			result = "경도비만";
		} else if (bmi >= 25) {
			result = "과체중";
		} else if (bmi >= 18.5) {
			result = "정상";
		}

		PrintWriter pw = response.getWriter();

		pw.print("<html>");
		pw.print("<head><meta charset=\"UTF-8\"><title>BMI 계산!");
		pw.print("</title>");
		pw.print("</head>");
		pw.print("<body>");
		pw.print("<table style='background-color:black; color:white; font-size:30px' border='1' align='center'>");
		pw.print("<tr><td>");
		pw.print("<h>이름 : " + name + "</h><br>");
		pw.print("<h>키 : " + height + "cm</h><br>");
		pw.print("<h>몸무게 : " + weight + "kg</h><br>");
		pw.print("<h>BMI 지수 : " + bmi + "%</h><br>");
		pw.print("<h>결과 : " + result + "</h><br>");
		pw.printf("<img src='image/%s'>", fileName);
		pw.print("</td></tr>");
		pw.print("</table>");
		pw.print("</body>");
		pw.print("</html>");

	}

}
