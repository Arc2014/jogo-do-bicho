package br.com.jogo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterLogin implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //Verifica se a sessão não expirou, se sim volta para a página de login
        HttpSession session = ((HttpServletRequest)request).getSession(false);
        if(session != null && !session.isNew()) {
            chain.doFilter(request, response);
        } else {
            //Retorna para a página de login
            ((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/index.xhtml");
        }
    }

    public void destroy() {

    }
}
