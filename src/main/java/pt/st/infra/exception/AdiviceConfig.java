package pt.st.infra.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import javax.validation.ConstraintViolationException;
import java.io.IOException;
 



@ControllerAdvice
@Slf4j
public class AdiviceConfig {
	
	@Autowired
	private ObjectMapper objectMapper;


	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	@ExceptionHandler({ RuntimeException.class })
	public ErrorResponse handleRunTimeException(RuntimeException ex) {

		log.error("Exception : ", ex);
		return  new ErrorResponse(HttpStatus.BAD_GATEWAY,new String[] { "Erro interno de processamento"  });
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	@ExceptionHandler({ Exception.class })
	public ErrorResponse handleRunTimeException(Exception ex) {
		log.error("Exception : ", ex);
		return  new ErrorResponse(HttpStatus.BAD_GATEWAY,new String[] { "Erro interno de processamento" });
	}
	
	@ResponseBody
	@ExceptionHandler(ErroServidorException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ErrorResponse   erroServidor(final ErroServidorException ex) {

		return  new ErrorResponse(HttpStatus.BAD_GATEWAY,ex.getErrors());
	}

	@ResponseBody
	@ExceptionHandler(FalhaAutenticacaoException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ErrorResponse   falhaAutenticacao(final FalhaAutenticacaoException ex) {

		return  new ErrorResponse(HttpStatus.UNAUTHORIZED,ex.getErrors());
	}

	@ResponseBody
	@ExceptionHandler(FalhaNaoAutorizadoException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorResponse   falhaNaoAutorizado(final FalhaNaoAutorizadoException ex) {

		return  new ErrorResponse(HttpStatus.FORBIDDEN,ex.getErrors());
	}

	@ResponseBody
	@ExceptionHandler(InformacaoNaoEncontradaException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse informacaoNaoEncontrada(final InformacaoNaoEncontradaException ex) {

		return  new ErrorResponse(HttpStatus.NOT_FOUND,ex.getErrors());
	}
	
	@ResponseBody
	@ExceptionHandler(DadoInvalidoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse dadoInvalido(final DadoInvalidoException ex) {	

		return  new ErrorResponse(HttpStatus.BAD_REQUEST,ex.getErrors());
	}

	@ResponseBody
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse violacaoDeConstraint(final ConstraintViolationException ex) {

		return  new ErrorResponse(HttpStatus.BAD_REQUEST,new String[] { ex.getMessage() });
	}

	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse argumentosInvalidos(final MethodArgumentNotValidException ex) {

		String[] errors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(x -> x.getDefaultMessage())
				.toArray(String[]::new);

		return  new ErrorResponse(HttpStatus.BAD_REQUEST,errors);
	 
	}
	 
	//TODO vai ser usado quando colocar o proxy
	@ResponseBody
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<ErrorResponse> feignException(final FeignException ex) {

		try {
			ErrorResponse errorResponse = objectMapper.readValue(ex.contentUTF8(), ErrorResponse.class);
			return new ResponseEntity<ErrorResponse >(errorResponse, HttpStatus.valueOf(ex.status()));

		} catch (IOException e1) {
			ErrorResponse errorResponse= new ErrorResponse(HttpStatus.BAD_GATEWAY, new String[] { "Erro interno de processamento - conversao retorno"});
			return new ResponseEntity<ErrorResponse >(errorResponse, HttpStatus.valueOf(ex.status()));
		}

	}

}
