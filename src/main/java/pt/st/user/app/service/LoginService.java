package pt.st.user.app.service;

import pt.st.infra.exception.FalhaAutenticacaoException;
import pt.st.user.app.model.LoginRequest;
import pt.st.user.app.model.LoginResponse;

public interface LoginService {
	
	LoginResponse autenticar(LoginRequest login) throws FalhaAutenticacaoException ;

}
