package pt.st.user.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import pt.st.infra.exception.FalhaAutenticacaoException;
import pt.st.user.app.model.LoginRequest;
import pt.st.user.app.model.LoginResponse;
import pt.st.user.app.service.LoginService;

/*
 
http://localhost:8083/service-track/v1/login
{
    "username": "gma",
    "password": "1967"
}
*/

@RestController
@RequestMapping(value = "/v1/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	 
	@RequestMapping(produces = { "application/json" }, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody  LoginRequest login) throws FalhaAutenticacaoException   {

	  return loginService.autenticar(login);

    }

}