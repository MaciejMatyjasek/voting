package pl.maciej.matyjasek.voting.app.candidate;

import org.springframework.data.repository.Repository;

import java.util.*;

public interface CandidateRepository extends Repository<Candidate, Long> {
	void save(Candidate candidate);

	List<Candidate> findAll();

	Optional<Candidate> findOneByUuid(UUID uuid);
}

class InMemoryCandidateRepository implements CandidateRepository {
	private final Map<UUID, Candidate> candidatesStorage = new HashMap<>();

	@Override public void save(Candidate candidate) {
		candidatesStorage.put(candidate.getUuid(), candidate);
	}

	@Override public List<Candidate> findAll() {
		return new ArrayList<>(candidatesStorage.values());
	}

	@Override public Optional<Candidate> findOneByUuid(UUID uuid) {
		return Optional.ofNullable(candidatesStorage.get(uuid));
	}
}
