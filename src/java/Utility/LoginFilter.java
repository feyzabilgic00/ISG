/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

/**
 *
 * @author Samsung
 */
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "loginFilter", urlPatterns = {"/faces/pages/*"})
public class LoginFilter implements Filter {

    /**
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession ses = reqt.getSession(false);

            String reqURI = reqt.getRequestURI();
            if (reqURI.contains("/faces/frontend/login/login.xhtml")
                    || (ses != null && ses.getAttribute("user") != null)
                    || reqURI.contains("/frontend/")
                    || reqURI.contains("javax.faces.resources")) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(reqt.getContextPath()
                        + "/faces/frontend/login/login.xhtml");
            }
        } catch (IOException | ServletException e) {
            System.out.println("doFilter Hatasi!!!" + e.getMessage());
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
