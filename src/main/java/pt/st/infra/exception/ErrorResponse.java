package pt.st.infra.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_EMPTY)
public class ErrorResponse {
	
	
	@Getter @Setter
	private String code;
	@Getter @Setter
	private String description;
	@Getter @Setter
	private String[] mensagens;

	 
	public ErrorResponse() {}
	
	public ErrorResponse(HttpStatus httpStatus,  String[] message) {
		 
		//this.code = httpStatus.value()+"";
		//this.description = httpStatus.name();
		
		this.mensagens = message;
		
	//	for(String m : message) {
	//		this.message=this.message+", "+m;
	//	}
		
	}
}
