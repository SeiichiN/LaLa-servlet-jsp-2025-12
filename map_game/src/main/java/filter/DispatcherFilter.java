package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import main.GameManager;

import java.io.IOException;

@WebFilter(urlPatterns = {"/startGame", "/move"})
public class DispatcherFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		chain.doFilter(request, response);
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		GameManager gm = (GameManager) session.getAttribute("gm");
		String message = gm.getOut().toString();
		request.setAttribute("message", message);
		gm.getOut().clear();
		String url = "WEB-INF/jsp/game.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
