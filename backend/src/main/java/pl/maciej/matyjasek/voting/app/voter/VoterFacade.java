package pl.maciej.matyjasek.voting.app.voter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.transaction.annotation.Transactional;
import pl.maciej.matyjasek.voting.app.voter.dto.VoterDto;
import pl.maciej.matyjasek.voting.app.voter.exception.VoterAlreadyVotedException;
import pl.maciej.matyjasek.voting.app.voter.exception.VoterNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

	public List<VoterDto> showVoters() {
		return voterRepository.findAll().stream().map(Voter::toDto).collect(Collectors.toList());
	}

	public VoterDto vote(UUID uuid) {
		Voter voterFromDb = voterRepository
				.findOneByUuid(uuid)
				.orElseThrow(() -> new VoterNotFoundException("Cannot find Voter with given UUID=" + uuid + " in database"));
		if (voterFromDb.getHasVoted()) {
			throw new VoterAlreadyVotedException("Voter " + voterFromDb.getFirstName() + " " + voterFromDb.getLastName() + " already voted.");
		}
		update(voterFromDb);
		return voterFromDb.toDto();
	}

	private void update(Voter voter) {
		voter.setHasVoted(true);
	}
}
