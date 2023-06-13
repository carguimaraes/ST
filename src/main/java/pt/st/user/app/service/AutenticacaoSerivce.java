package pt.st.user.app.service;

import pt.st.infra.exception.FalhaAutenticacaoException;

public interface AutenticacaoSerivce {
	
	boolean autenticar(String usuario, String senha) throws FalhaAutenticacaoException;

}
