package ro.teamnet.zth.file;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Alexandru.Vlad on 7/19/2017.
 */
public class HeadersLogFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

//        HttpServletRequest httpRequest = (HttpServletRequest) req;
//        Enumeration<String> headerNames = httpRequest.getHeaderNames();

//        if (headerNames != null) {
//            while (headerNames.hasMoreElements()) {
//                System.out.println("Header: " + httpRequest.getHeader(headerNames.nextElement()));
                LogFileWriter.logHeader("asd", "asde");
//            }
//        }



//        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
