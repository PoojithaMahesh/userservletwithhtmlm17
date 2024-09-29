package userservletm17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userservletm17.dao.UserDao;
import userservletm17.dto.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("userEmail");
		String password=req.getParameter("userPassword");
		
		
		
		UserDao dao=new UserDao();
//		you need to get all the user data
		
		List<User> list=dao.findAllUser();
		boolean value=false;
		
		for(User user:list) {
			if(user.getEmail().equals(email)) {
				value=true;
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if(value) {
//			valid email
			User user=dao.findUserByEmail(email);
			if(user.getPassword().equals(password)) {
//				login success
				resp.sendRedirect("https://www.w3schools.blog/java-8-features-with-examples");
			}else {
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
				dispatcher.include(req, resp);
			}
		}else {
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		}
		
		
		
		
		
	}

}
