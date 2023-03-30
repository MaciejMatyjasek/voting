package pl.maciej.matyjasek.voting.app.candidate.dto;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class CandidateDto {

	UUID uuid;
	@NonNull
	String firstName;
	@NonNull
	String lastName;
	Integer votesQuantity;
}
