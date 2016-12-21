package lt.itakademija.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Pavel on 2016-12-21.
 *
 * Papildoma užduotis, tikrinau konsoleje, veikia;]
 */
public class MyLoggingFilter extends HttpFilter {
    @Autowired
    RequestFormatter rf;

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Logger logger = LoggerFactory.getLogger(MyLoggingFilter.class);
        logger.info(rf.formatForLog(request));
        chain.doFilter(request, response);
    }
}
