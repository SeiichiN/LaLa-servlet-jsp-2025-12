package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Kazu;
import model.KazuateLogic;

@WebServlet("/GameController")
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Kazu kazu = new Kazu();
		int kotae = (int)(Math.random() * 99) + 1;
		kazu.setKotae(kotae);
		request.setAttribute("kazu", kazu);
		String url = "WEB-INF/jsp/kazuate.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int kotae = Integer.parseInt(request.getParameter("kotae"));
		int user = Integer.parseInt(request.getParameter("user"));
		Kazu kazu = new Kazu(kotae, user);
		KazuateLogic kazuateLogic = new KazuateLogic();
		kazuateLogic.execute(kazu);
		request.setAttribute("kazu", kazu);
		String url = "WEB-INF/jsp/kazuate.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
