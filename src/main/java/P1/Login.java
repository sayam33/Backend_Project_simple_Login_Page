package P1;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/verifylogin")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public Login() {
        super();      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		String password = request.getParameter("password");
		
		System.out.println(email);
		
		System.out.println(password);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection c=	DriverManager.getConnection
				("jdbc:mysql://localhost:3306/dec_login_db" , "root" , "sayam");
		
		Statement s = c.createStatement();
		
		ResultSet r = s.executeQuery
				("select * from login where email='"+email+"' and password='"+password+"'");
		
		if (r.next()) {
			System.out.println("Wellcom");
		}else {
			System.out.println("Invalid username/password");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
