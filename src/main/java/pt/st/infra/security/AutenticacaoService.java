package pt.st.infra.security;

import pt.st.infra.exception.FalhaAutenticacaoException;

public interface AutenticacaoService {
	
	boolean autenticar(String usuario, String senha) throws FalhaAutenticacaoException;

}
