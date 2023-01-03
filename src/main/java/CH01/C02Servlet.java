package CH01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTest02")
public class C02Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoGet함수 실행");

		req.setCharacterEncoding("utf-8");
		resp.setHeader("Content-Type", "text/html; charset=utf-8");

		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");

		PrintWriter out = resp.getWriter();
		out.print("EMAIL : " + email + "<br>");
		out.print("PWD : " + pwd + "<br>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoPost함수 실행");

		req.setCharacterEncoding("utf-8");
		resp.setHeader("Content-Type", "text/html; charset=utf-8");

		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");

		PrintWriter out = resp.getWriter();
		out.print("EMAIL : " + email + "<br>");
		out.print("PWD : " + pwd + "<br>");

	}

}
