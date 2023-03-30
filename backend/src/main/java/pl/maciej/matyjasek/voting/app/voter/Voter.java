package pl.maciej.matyjasek.voting.app.voter;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import pl.maciej.matyjasek.voting.app.shared.BaseEntity;
import pl.maciej.matyjasek.voting.app.voter.dto.VoterDto;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class Voter extends BaseEntity {

	String firstName;
	String lastName;
	@Setter
	Boolean hasVoted;

	VoterDto toDto() {
		return new VoterDto(super.getUuid() ,firstName, lastName, hasVoted);
	}
}
