package pl.maciej.matyjasek.voting.app.candidate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import pl.maciej.matyjasek.voting.app.candidate.dto.CandidateDto;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	Long id;

	String firstName;
	String lastName;
	Boolean hasVoted;

	CandidateDto toDto() {
		return new CandidateDto(firstName, lastName, hasVoted);
	}
}
