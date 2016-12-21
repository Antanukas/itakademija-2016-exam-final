package lt.itakademija.servlet;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingFilter extends HttpFilter {

	private static final Logger logger = LoggerFactory.getLogger(RequestFormatter.class);

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info(new RequestFormatter().formatForLog(request));

		chain.doFilter(request, response);
	}
}
