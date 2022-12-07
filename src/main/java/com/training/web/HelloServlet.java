package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	String msg;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	msg = "John";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("uname");
		String pass = request.getParameter("pwd");
		boolean isValid = false;
		
		try {
						
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String url = "jdbc:sqlserver://localhost:1433;"+
						"databaseName=mars_sept";
			
			String user = "sa";
			
			String password = "root";
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from user1");
			
			while(rs.next()) {
				//System.out.println(rs.getString(2)+": "+rs.getString(3));
				if(userName.equalsIgnoreCase(rs.getString(2)) && pass.equalsIgnoreCase(rs.getString(3))) {
					isValid = true;
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("name", userName);
		
		if(isValid) {
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

// Create a login page with username and password field and a submit button
// Authenticate the user with hard coded values
// If user is valid then forward it to a success page with a message "Welcome <username>
// else forward it to failure page with a message "Incorrect credentials..please try again"

// JDBC : Java Database Connectivity
