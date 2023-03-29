package pl.maciej.matyjasek.voting.app.candidate;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CandidateConfiguration {

	CandidateFacade candidateFacade(){
		CandidateRepository candidateRepository = new InMemoryCandidateRepository();
		return candidateFacade(candidateRepository);
	}

	@Bean
	CandidateFacade candidateFacade(CandidateRepository candidateRepository){
		CandidateFactory candidateFactory = new CandidateFactory();
		return new CandidateFacade(candidateFactory, candidateRepository);
	}

}
