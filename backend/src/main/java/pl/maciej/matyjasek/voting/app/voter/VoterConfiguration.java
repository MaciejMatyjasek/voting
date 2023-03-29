package pl.maciej.matyjasek.voting.app.voter;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.maciej.matyjasek.voting.app.candidate.CandidateFacade;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VoterConfiguration {

	VoterFacade voterFacade() {
		VoterRepository voterRepository = new InMemoryVoterRepository();
		return voterFacade(voterRepository);
	}

	@Bean
	VoterFacade voterFacade(VoterRepository voterRepository) {
		VoterFactory voterFactory = new VoterFactory();
		return new VoterFacade(voterFactory, voterRepository);
	}
}
