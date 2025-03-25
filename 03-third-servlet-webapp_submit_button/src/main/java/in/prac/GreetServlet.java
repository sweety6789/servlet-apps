package in.prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GreetServlet
 */
//@WebServlet("/GreetServlet")
public class GreetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name"); // Get 'name' from query parameter
        if (name == null || name.trim().isEmpty()) {
            name = "Enter the name"; // Default name if input is empty
        }

//        response.getWriter().write(name + ", Good Evening!");
		// Get current time
        LocalTime now = LocalTime.now();
        int hour = now.getHour();

        // Determine greeting based on time
        String greeting;
        if (hour >= 6 && hour < 12) {
            greeting = "Good Morning!";
        } else if (hour >= 12 && hour < 17) {
            greeting = "Good Afternoon!";
        } else if (hour >= 17 && hour < 21) {
            greeting = "Good Evening!";
        } else {
            greeting = "Good Night!";
        }

        // Display greeting
        System.out.println(greeting);
        // TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		writer.append("<h1>"+name+ ", " + greeting +"..!! </h1>");
//		.append(request.getContextPath());
	}

}
