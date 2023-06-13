package pt.st.infra.exception;

import lombok.Getter;

public class FalhaPreCondicaoException extends Exception{

	@Getter
	private String[] errors;
	
	public FalhaPreCondicaoException(String ... erros) {
		super();
		this.errors = erros;
	}
}
