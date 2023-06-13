package pt.st.infra.exception;

import lombok.Getter;

//400
//public class DadoInvalidoException extends RuntimeException 
public class DadoInvalidoException extends Exception {

	private static final long serialVersionUID = 3857698137429235523L;
	
	@Getter
	private String[] errors;
	
	public DadoInvalidoException(String ...erros) {
		super();
		this.errors = erros;
	}

}
