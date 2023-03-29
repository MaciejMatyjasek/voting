package pl.maciej.matyjasek.voting.app.voter;

import pl.maciej.matyjasek.voting.app.voter.dto.VoterDto;

class VoterFactory {

	Voter create(VoterDto voterDto) {
		return Voter.builder()
				.firstName(voterDto.getFirstName())
				.lastName(voterDto.getLastName())
				.hasVoted(voterDto.getHasVoted())
				.build();
	}
}
