package pl.maciej.matyjasek.voting.app.candidate;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import pl.maciej.matyjasek.voting.app.candidate.dto.CandidateDto;
import pl.maciej.matyjasek.voting.app.shared.BaseEntity;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class Candidate extends BaseEntity {

	String firstName;
	String lastName;
	Integer votesQuantity;

	CandidateDto toDto() {
		return new CandidateDto(firstName, lastName, votesQuantity);
	}
}
