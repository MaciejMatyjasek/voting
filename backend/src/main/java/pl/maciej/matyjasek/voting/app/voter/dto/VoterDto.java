package pl.maciej.matyjasek.voting.app.voter.dto;

import lombok.*;

import java.util.UUID;

@Value
public class VoterDto {

	UUID uuid;
	@NonNull
	String firstName;
	@NonNull
	String lastName;
	@NonNull
	Boolean hasVoted;
}
