package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GetId")
public class GetIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Pattern PATTERN = 
			Pattern.compile("^[0-9a-zA-Z]{4}$");
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		List<String> errors = new ArrayList<>();
		if (id == null || id.length() == 0) {
			errors.add("未入力です");
		} else if (PATTERN.matcher(id).matches() == false) {
			errors.add("IDが不正です");
		}
	}

}
