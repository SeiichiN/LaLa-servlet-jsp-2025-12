package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Kazu;
import model.KazuateLogic;

@WebServlet("/GameController")
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Kazu kazu = new Kazu();
		int kotae = (int)(Math.random() * 99) + 1;
		kazu.setKotae(kotae);
		HttpSession session = request.getSession();
		session.setAttribute("kazu", kazu);
		String url = "WEB-INF/jsp/kazuate.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user = Integer.parseInt(request.getParameter("user"));
		HttpSession session = request.getSession();
		Kazu kazu = (Kazu)session.getAttribute("kazu");
		kazu.setUser(user);
		KazuateLogic kazuateLogic = new KazuateLogic();
		kazuateLogic.execute(kazu);
		// sessionスコープに保存しなくても、反映されている
		String url = "WEB-INF/jsp/kazuate.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
