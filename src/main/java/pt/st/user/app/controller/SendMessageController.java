package pt.st.user.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import pt.st.infra.exception.FalhaAutenticacaoException;
import pt.st.user.app.model.LoginRequest;
import pt.st.user.app.model.LoginResponse;
import pt.st.user.app.model.SendMessageRequest;
import pt.st.user.app.model.SendMessageResponse;
import pt.st.user.app.model.UserModel;
import pt.st.user.app.service.LoginService;

//localhost:8083/service-track/v1/user/mostrar

@RestController
@RequestMapping(value = "/v1/user")
public class SendMessageController {
	
	@Autowired
	private LoginService loginService;

	@GetMapping(value = "/mostrar", produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public UserModel mostrar() {

		UserModel u = new UserModel();

		u.setName("CARLOS ALBERTO");
		u.setEmail("carguimaraesgma@gmail.com");

		return u;
	}

	@RequestMapping(produces = { "application/json" }, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public LoginResponse login(@RequestBody LoginRequest login) throws FalhaAutenticacaoException {

		return loginService.autenticar(login);

	}

}
