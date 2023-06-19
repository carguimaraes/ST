package pt.st.infra.security;

import org.springframework.stereotype.Service;

import pt.st.infra.exception.FalhaAutenticacaoException;
import pt.st.user.app.service.AutenticacaoSerivce;

@Service
public class AutenticacaoSerivceImplDesenv implements AutenticacaoSerivce{
	
	 

		@Override
		public boolean autenticar(String usuario, String senha) throws FalhaAutenticacaoException {
		
			/*
			if(usuario==null || usuario.trim().isEmpty() || senha==null || 		senha.trim().isEmpty() 	) {
				
				throw new FalhaAutenticacaoException(new String[] {"Falha autenticação, usuário ou senha inválido" });
			}
				*/	 
			 
			 
			
		  return true;
		}


}
