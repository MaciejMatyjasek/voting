package pl.maciej.matyjasek.voting.app.candidate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.transaction.annotation.Transactional;
import pl.maciej.matyjasek.voting.app.candidate.dto.CandidateDto;
import pl.maciej.matyjasek.voting.app.candidate.exception.CandidateNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CandidateFacade {

	CandidateFactory candidateFactory;
	CandidateRepository candidateRepository;

	public void addCandidate(CandidateDto... candidateDtos) {
		Arrays.stream(candidateDtos)
				.map(candidateFactory::create)
				.forEach(candidateRepository::save);
	}

	public List<CandidateDto> showCandidates() {
		return candidateRepository.findAll().stream().map(Candidate::toDto).collect(Collectors.toList());
	}

	public void addVote(UUID candidateUUID) {
		Candidate candidateFromDb = candidateRepository
				.findOneByUuid(candidateUUID)
				.orElseThrow(() -> new CandidateNotFoundException("Cannot find Candidate with given UUID=" + candidateUUID + " in database"));
		update(candidateFromDb);
	}

	private void update(Candidate candidateFromDb) {
		candidateFromDb.setVotesQuantity(candidateFromDb.getVotesQuantity() + 1);
	}
}
