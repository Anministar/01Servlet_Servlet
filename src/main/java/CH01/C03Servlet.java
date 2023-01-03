package CH01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth/login.do") //URL Mapping
public class C03Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DOGET!!");
		//Forwarding(request공유) vs Redirect(requeset새로)
		
//		String path = req.getContextPath();
//		forwarding 방식은 ContextPath를 넣어줄 필요가 없음. Redirect는 필요
		
		req.getRequestDispatcher("/Ch01/03Login.jsp").forward(req, resp);
		//resp.sendRedirect(path + "/Ch01/03Login.jsp");
		return ;
		//여기 페이지를 띄워서 제출하면 POST방식으로 SUBMIT되기 때문에 밑에서 처리해줘야함.
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DOPOST!!");
		//1 파라미터 받기
		String email = req.getParameter("email");
		
		//2 입력값 검증
		
		//3 Service
		HttpSession session = req.getSession();
		session.setAttribute("eamil", email);
		
		//4 view(Redirect로 해보기~)
		resp.sendRedirect("/01Servlet/Ch01/03Main.jsp");
		
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("SERVICE!!");
		
		String method = req.getMethod();
		System.out.println("METHOD : " + method);
		if(method.equals("GET")) {
			doGet(req,res);
		}else if(method.equals("POST")) {
			doPost(req,res);
		}
		
	}
 
	//dohandle(별도정의)
	
}
