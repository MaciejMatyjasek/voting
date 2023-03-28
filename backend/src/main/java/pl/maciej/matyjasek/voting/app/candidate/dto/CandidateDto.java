package pl.maciej.matyjasek.voting.app.candidate.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class CandidateDto {

	@NonNull
	String firstName;
	@NonNull
	String lastName;
	@NonNull
	Boolean hasVoted;
}
