package pl.maciej.matyjasek.voting.app.voter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import pl.maciej.matyjasek.voting.app.voter.dto.VoterDto;

import java.util.Arrays;

@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VoterFacade {

	VoterFactory voterFactory;
	VoterRepository voterRepository;

	public void addVoter(VoterDto... voterDtos) {
		Arrays.stream(voterDtos)
				.map(voterFactory::create)
				.forEach(voterRepository::save);
	}

	public Page<VoterDto> showVoters(Pageable pageable) {
		return voterRepository.findAll(pageable).map(Voter::toDto);
	}

}
