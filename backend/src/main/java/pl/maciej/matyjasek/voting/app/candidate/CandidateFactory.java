package pl.maciej.matyjasek.voting.app.candidate;

import pl.maciej.matyjasek.voting.app.candidate.dto.CandidateDto;

class CandidateFactory {

	Candidate create(CandidateDto candidateDto) {
		return Candidate.builder()
				.firstName(candidateDto.getFirstName())
				.lastName(candidateDto.getLastName())
				.hasVoted(candidateDto.getHasVoted())
				.build();
	}
}
