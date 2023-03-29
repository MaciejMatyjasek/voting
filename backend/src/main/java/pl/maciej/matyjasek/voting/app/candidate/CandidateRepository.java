package pl.maciej.matyjasek.voting.app.candidate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.*;

public interface CandidateRepository extends Repository<Candidate, Long> {
	void save(Candidate candidate);

	Page<Candidate> findAll(Pageable pageable);

	Optional<Candidate> findOneByUuid(UUID uuid);
}

class InMemoryCandidateRepository implements CandidateRepository {
	private final Map<UUID, Candidate> candidatesStorage = new HashMap<>();

	@Override public void save(Candidate candidate) {
		candidatesStorage.put(candidate.getUuid(), candidate);
	}

	@Override public Page<Candidate> findAll(Pageable pageable) {
		return new PageImpl<>(new ArrayList<>(candidatesStorage.values()));
	}

	@Override public Optional<Candidate> findOneByUuid(UUID uuid) {
		return Optional.ofNullable(candidatesStorage.get(uuid));
	}
}
