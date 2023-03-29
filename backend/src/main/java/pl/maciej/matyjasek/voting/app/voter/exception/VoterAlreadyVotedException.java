package pl.maciej.matyjasek.voting.app.voter.exception;

public class VoterAlreadyVotedException extends RuntimeException {
	public VoterAlreadyVotedException(String message) {
		super(message);
	}
}
