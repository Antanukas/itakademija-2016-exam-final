package lt.itakademija.servlet;




import org.apache.log4j.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class HttpFilterImpl extends HttpFilter{

    final static Logger logger = Logger.getLogger(HttpFilterImpl.class);

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.error(new RequestFormatter().formatForLog(request));
        chain.doFilter(request,response);
    }
}
