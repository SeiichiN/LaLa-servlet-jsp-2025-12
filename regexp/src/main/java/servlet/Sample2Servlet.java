package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.ParameterCheckV2;

@WebServlet("/Sample2Servlet")
public class Sample2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		ParameterCheckV2 check = new ParameterCheckV2();
		List<String> errors = check.checkId(id);
		request.setAttribute("errors", errors);
		request.getRequestDispatcher("/sample2.jsp").forward(request, response);
	}
}
