package pl.maciej.matyjasek.voting.app.voter.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class VoterDto {

	@NonNull
	String firstName;
	@NonNull
	String lastName;
	@NonNull
	Boolean hasVoted;
}
