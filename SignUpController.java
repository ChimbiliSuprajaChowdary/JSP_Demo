package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.RegistrationValidation;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
		rd.forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email"); 
		String password = request.getParameter("password"); 
		String confirmPassword = request.getParameter("confirmPassword"); 
	//	LocalDateTime date= LocalDateTime.now(); 
		System.out.println(email);
		System.out.println(password);
		System.out.println(confirmPassword);
		
		RegistrationValidation checkUser=new RegistrationValidation();
		
		if(checkUser.checkUserDetails(email, password, confirmPassword))
		{
			request.setAttribute("message", "Registration Successful");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("message", "Check your email and password");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
			rd.forward(request, response);
		}
		
		
	}

	}


