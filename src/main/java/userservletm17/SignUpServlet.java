package userservletm17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import userservletm17.dao.UserDao;
import userservletm17.dto.User;
@WebServlet("/signup")
public class SignUpServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
	String name=req.getParameter("userName");
    String email=req.getParameter("userEmail");
    String password=req.getParameter("userPassword");
    String phone=req.getParameter("userPhone");
    long phoneNumber=Long.parseLong(phone);
    
    User user=new User();
    user.setEmail(email);
    user.setName(name);
    user.setPassword(password);
    user.setPhone(phoneNumber);
    
    
    UserDao dao=new UserDao();
    dao.saveUser(user);
   
    PrintWriter printWriter=res.getWriter();
    printWriter.print("SignedUpSuccessfully !!!!!!!!!!! thank youuuuuu!");
    RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
    dispatcher.forward(req, res);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	}

}
