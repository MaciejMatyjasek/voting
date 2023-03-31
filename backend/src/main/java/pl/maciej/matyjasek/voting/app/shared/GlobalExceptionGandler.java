package pl.maciej.matyjasek.voting.app.shared;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.maciej.matyjasek.voting.app.candidate.exception.CandidateNotFoundException;
import pl.maciej.matyjasek.voting.app.voter.exception.VoterAlreadyVotedException;
import pl.maciej.matyjasek.voting.app.voter.exception.VoterNotFoundException;

@ControllerAdvice
public class GlobalExceptionGandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value
			= { RuntimeException.class, CandidateNotFoundException.class, VoterNotFoundException.class,
			VoterAlreadyVotedException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Exception reason: " + ex.getMessage() + " for request: " + ((ServletWebRequest) request).getRequest().getRequestURL();
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

}
