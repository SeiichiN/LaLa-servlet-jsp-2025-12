package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = null;
		String action = request.getParameter("action");
		if (action == null) {
			forwardPath = "WEB-INF/jsp/registerForm.jsp";
		}
		else if (action.equals("done")) {
			HttpSession session = request.getSession();
			User registerUser = 
					(User) session.getAttribute("registerUser");
			RegisterUserLogic logic = new RegisterUserLogic();
			logic.execute(registerUser);
			session.removeAttribute("registerUser");
			forwardPath = "WEB-INF/jsp/registerDone.jsp";
		}
		RequestDispatcher d =
				request.getRequestDispatcher(forwardPath);
		d.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		User registerUser = new User(id, name, pass);
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);
		String url = "WEB-INF/jsp/registerConfirm.jsp";
		RequestDispatcher d =
				request.getRequestDispatcher(url);
		d.forward(request, response);
	}

}
