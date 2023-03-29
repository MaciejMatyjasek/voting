package pl.maciej.matyjasek.voting.app.voter.exception;

public class VoterNotFoundException extends RuntimeException {
	public VoterNotFoundException(String message) {
		super(message);
	}
}
