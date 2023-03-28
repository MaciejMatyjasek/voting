package pl.maciej.matyjasek.voting.app.candidate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import pl.maciej.matyjasek.voting.app.candidate.dto.CandidateDto;

import java.util.Arrays;

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

}
