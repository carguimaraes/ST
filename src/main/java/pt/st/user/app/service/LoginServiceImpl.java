package pt.st.user.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import pt.st.infra.exception.FalhaAutenticacaoException;
import pt.st.infra.security.TsTokenService;
import pt.st.user.app.model.LoginRequest;
import pt.st.user.app.model.LoginResponse;

public class LoginServiceImpl implements  LoginService{
	
	@Autowired
	private TsTokenService tsTokenService;
	
	@Autowired
	private AutenticacaoSerivce autenticacaoService;
	
	 

	@Override
	public LoginResponse autenticar(LoginRequest login) throws FalhaAutenticacaoException {
		
		
		if(login==null ) {
			throw new FalhaAutenticacaoException(new String[] {"CMensagensUtil.MSG_FALHA_AUTENTICACAO_USUARIO_OU_SENHA_INVALIDO"});
		}
		
		autenticacaoService.autenticar(login.getUsername(), login.getPassword() );
		
		LoginResponse loginResponse = new LoginResponse();
			 
		loginResponse.setUserName(login.getUsername());
		loginResponse.setEmail("USU_01@VALOR.TESTE.COM");
		loginResponse.setNomeUsuario("NOME USUARIO 01");
		 
			 
		String JWT=tsTokenService.gerarToken(loginResponse.getUserName());
		loginResponse.setToken(JWT);
		
	 
	
	 
		
	    return loginResponse;
	}

}
