package pl.maciej.matyjasek.voting.app.candidate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import pl.maciej.matyjasek.voting.app.candidate.dto.CandidateDto;
import pl.maciej.matyjasek.voting.app.candidate.exception.CandidateNotFoundException;

import java.util.Arrays;
import java.util.UUID;

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

	public Page<CandidateDto> showCandidates(Pageable pageable) {
		return candidateRepository.findAll(pageable).map(Candidate::toDto);
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
