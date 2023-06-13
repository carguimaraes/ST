package pt.st.user.app.model;

import lombok.Data;

@Data
public class LoginRequest {
	
	
//	{
//	     "username" : name,
//	    "password" : password
//	}


	private String username;
	private String password;

}
