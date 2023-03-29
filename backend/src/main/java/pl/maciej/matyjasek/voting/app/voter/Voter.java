package pl.maciej.matyjasek.voting.app.voter;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import pl.maciej.matyjasek.voting.app.shared.BaseEntity;
import pl.maciej.matyjasek.voting.app.voter.dto.VoterDto;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class Voter extends BaseEntity {

	String firstName;
	String lastName;
	Boolean hasVoted;

	VoterDto toDto() {
		return new VoterDto(firstName, lastName, hasVoted);
	}
}
