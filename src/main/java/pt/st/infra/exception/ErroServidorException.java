package pt.st.infra.exception;

import lombok.Getter;

//400
//public class DadoInvalidoException extends RuntimeException 
public class ErroServidorException extends RuntimeException {

	private static final long serialVersionUID = 3857698137429235523L;
	
	@Getter
	private String[] errors;
	
	public ErroServidorException(String ...erros) {
		super();
		this.errors = erros;
	}

}
