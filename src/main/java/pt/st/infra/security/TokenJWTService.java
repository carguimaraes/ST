package pt.st.infra.security;

 

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class TokenJWTService implements TsTokenService{
	
	
	@Value("${seguranca.jwtSECRET}")
	private String SECRET;
	private static final long EXPIRATIONTIME = 864000000;
	private static final String TOKEN_PREFIX = "Bearer";
	private static final String HEADER_STRING = "Authorization";

	@Override
	public String gerarToken(String username) {

		String JWT = Jwts
				.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();

		return JWT;
	}


	 
	@Override
	public Authentication getAuthentication(HttpServletRequest request) {
		
		 
		String token = request.getHeader(HEADER_STRING);
		if (token != null) {
			return getByToken(token);
		}
		return null;
	}
	
	 
	 

	private Authentication getByToken(String token) {

		// , UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException
		
		String user =null;
		try {
			 user = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
					.getBody()
					.getSubject();
			 
			 return user != null ? new UsernamePasswordAuthenticationToken(user, null, null) : null; 
			
		}  catch (ExpiredJwtException e) {
		  
			//TODO trarar quando exporar o token
			return null;
			 
		}
		 

		
	}
	
	/*
	private  void addAuthentication(HttpServletResponse res, String username) {

		String JWT = gerarToken(username);

		String token = TOKEN_PREFIX + " " + JWT;
		res.addHeader(HEADER_STRING, token);

		try {
			res.getOutputStream().print(token);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    */
}
