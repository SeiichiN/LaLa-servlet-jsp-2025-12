package servlet;

import java.io.IOException;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Pattern ID_PATTERN = 
			Pattern.compile("^[0-9a-zA-Z]{4}$");

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		String msg = "";
		if (ID_PATTERN.matcher(id).matches()) {
			msg = "ようこそ、" + id + "さん";
		} else {
			msg = "idが違います";
		}
		System.out.println(msg);
	}
}
