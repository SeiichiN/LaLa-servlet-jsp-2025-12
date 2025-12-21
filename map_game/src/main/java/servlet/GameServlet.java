package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import main.GameManager;
import main.Player;
import tools.BrowserInput;
import tools.BrowserOutput;

@WebServlet(urlPatterns = {"/startGame", "/move", "/action"})
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/startGame" -> startGame(request, response);
		default -> System.out.println("default");
		}		
	}
	
	private void startGame(HttpServletRequest request, HttpServletResponse response) {
		GameManager gm = new GameManager(5, 5, new BrowserOutput(), new BrowserInput());
		gm.setMonster('s');
		gm.setMonster('g');
		gm.setItem('p');
		gm.setItem('e');
		Player player = new Player("player", gm);
		HttpSession session = request.getSession();
		session.setAttribute("gm", gm);
		session.setAttribute("player", player);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/move" -> move(request, response); 
		case "/action" -> action(request, response);
		}

	}

	private void move(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// GameManager gm = (GameManager) session.getAttribute("gm");
		Player player = (Player) session.getAttribute("player");
		
		String dir = request.getParameter("dir");
		switch (dir) {
		case "up" -> player.moveUp();
		case "down" -> player.moveDown();
		case "left" -> player.moveLeft();
		case "right" -> player.moveRight();
		}
		player.look();
	}
	
	private void action(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Player player = (Player) session.getAttribute("player");
		String action = request.getParameter("action");
		switch (action) {
		case "battle" -> player.getGm().battle(player);
		case "take" -> player.take();
		case "use" -> player.use();
		}
		player.look();
	}

}
