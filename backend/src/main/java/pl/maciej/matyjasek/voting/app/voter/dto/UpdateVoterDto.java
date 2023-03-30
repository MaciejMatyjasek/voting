package pl.maciej.matyjasek.voting.app.voter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateVoterDto {

	@NonNull UUID uuid;
	@NonNull UUID candidateUUID;
}
