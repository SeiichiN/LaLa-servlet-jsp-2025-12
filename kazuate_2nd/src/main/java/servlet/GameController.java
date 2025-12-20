package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Kazu;
import model.KazuateLogic;

import java.io.IOException;

@WebServlet("/GameController")
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Kazu kazu = new Kazu();
		int kotae = (int) (Math.random() * 99) + 1;
		kazu.setKotae(kotae);
		request.setAttribute("kazu", kazu);
		String url = "WEB-INF/jsp/kazuate.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		int kotae = Integer.parseInt(request.getParameter("kotae"));
		Kazu kazu = new Kazu();
		kazu.setNum(num);
		kazu.setKotae(kotae);
		KazuateLogic logic = new KazuateLogic();
		logic.execute(kazu);
		request.setAttribute("kazu", kazu);
		String url = "WEB-INF/jsp/kazuate.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
