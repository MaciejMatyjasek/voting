package pl.maciej.matyjasek.voting.app.candidate.exception;

public class CandidateNotFoundException extends RuntimeException {
	public CandidateNotFoundException(String message) {
		super(message);
	}
}
