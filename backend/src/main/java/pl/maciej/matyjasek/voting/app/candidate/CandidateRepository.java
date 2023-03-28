package pl.maciej.matyjasek.voting.app.candidate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface CandidateRepository extends Repository<Candidate, Long> {
	void save(Candidate candidate);
	Page<Candidate> findAll(Pageable pageable);
}

class InMemoryCandidateRepository implements CandidateRepository {
	private final Map<Long, Candidate> candidatesStorage = new HashMap<>();

	@Override public void save(Candidate candidate) {
		candidatesStorage.put(candidate.getId(), candidate);
	}

	@Override public Page<Candidate> findAll(Pageable pageable) {
		return new PageImpl<>(new ArrayList<>(candidatesStorage.values()));
	}
}
