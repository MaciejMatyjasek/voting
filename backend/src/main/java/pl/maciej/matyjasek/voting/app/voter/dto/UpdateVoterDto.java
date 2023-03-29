package pl.maciej.matyjasek.voting.app.voter.dto;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class UpdateVoterDto {

	@NonNull UUID uuid;
	@NonNull UUID candidateUUID;
}
