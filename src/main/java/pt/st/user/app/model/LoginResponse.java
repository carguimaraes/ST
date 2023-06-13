package pt.st.user.app.model;

import lombok.Data;

@Data
public class LoginResponse {
	
	private String token;
	private String userName;
	private String nomeUsuario;
	private String email;
	 

}
