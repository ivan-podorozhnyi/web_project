package servlets.filters;

import exceptions.BusinessException;
import validators.ValidationService;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/clients")
public class ClientFilter implements Filter {
    private ValidationService validationService;

    public ClientFilter(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String age = servletRequest.getParameter("age");
        try {
            validationService.validateAge(Integer.parseInt(age));
        } catch (NumberFormatException | BusinessException e) {
            PrintWriter writer = servletResponse.getWriter();
            writer.println("<h2> Wrong age!</h2>");
        }
    }

}
