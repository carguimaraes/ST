package pt.st.infra.exception;

import lombok.Getter;

//forbidden - 
//proibido
public class FalhaNaoAutorizadoException extends Exception {
private static final long serialVersionUID = 3877698137429235523L;
	
	@Getter
	private String[] errors;
	
	public  FalhaNaoAutorizadoException(String[] erros) {
		super();
		this.errors = erros;
	}
 
}
