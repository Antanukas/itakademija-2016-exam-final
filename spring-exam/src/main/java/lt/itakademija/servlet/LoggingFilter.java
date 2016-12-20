package lt.itakademija.servlet;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingFilter extends HttpFilter {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
    private RequestFormatter formatter;
    
    public LoggingFilter() {
        this.formatter = new RequestFormatter();
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws IOException, ServletException {
    
        logger.info(formatter.formatForLog(request));
        chain.doFilter(request, response);
    }

}
