package pt.st.user.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pt.st.user.app.model.UserModel;
import pt.st.user.app.service.LoginService;

//localhost:8083/service-track/v1/user/mostrar

 
@RestController
@RequestMapping(value = "/v1/user")
public class SendMessageController {
	
	 

	@GetMapping(value = "/mostrar", produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public UserModel mostrar() {

		UserModel u = new UserModel();

		u.setName("CARLOS ALBERTO");
		u.setEmail("carguimaraesgma@gmail.com");

		return u;
	}

	 

}
