package pt.st.infra.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

public interface TsTokenService {

	String gerarToken(String userName);

	Authentication getAuthentication(HttpServletRequest request);

}
