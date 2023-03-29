package pl.maciej.matyjasek.voting.app.candidate;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import pl.maciej.matyjasek.voting.app.candidate.dto.CandidateDto;
import pl.maciej.matyjasek.voting.app.shared.BaseEntity;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class Candidate extends BaseEntity {

	String firstName;
	String lastName;
	@Setter
	Integer votesQuantity;

	CandidateDto toDto() {
		return new CandidateDto(firstName, lastName, votesQuantity);
	}
}
