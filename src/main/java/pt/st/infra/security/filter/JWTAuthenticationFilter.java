package pt.st.infra.security.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import pt.st.infra.security.TsTokenService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class JWTAuthenticationFilter extends GenericFilterBean{
	
	@Autowired
	private TsTokenService  tsTokenService;
	
	public void doFilter(
						 ServletRequest request, 
						 ServletResponse response,
					     FilterChain filterChain
					) throws IOException, ServletException {

	Authentication authentication = tsTokenService.getAuthentication((HttpServletRequest) request);
	
	SecurityContextHolder.getContext().setAuthentication(authentication);
	
	filterChain.doFilter(request, response);
}


}
