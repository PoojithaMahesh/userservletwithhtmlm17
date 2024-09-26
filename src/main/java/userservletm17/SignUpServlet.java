package userservletm17;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/signup")
public class SignUpServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
	String name=req.getParameter("userName");
    String email=req.getParameter("userEmail");
    String password=req.getParameter("userPassword");
    String phone=req.getParameter("userPhone");
    long phoneNumber=Long.parseLong(phone);
    
    
    
    
    
	}

}
