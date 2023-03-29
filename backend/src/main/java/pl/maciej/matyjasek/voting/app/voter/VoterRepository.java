package pl.maciej.matyjasek.voting.app.voter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface VoterRepository extends Repository<Voter, Long> {
	void save(Voter voter);

	Page<Voter> findAll(Pageable pageable);
}

class InMemoryVoterRepository implements VoterRepository {
	private final Map<Long, Voter> votersStorage = new HashMap<>();

	@Override public void save(Voter voter) {
		votersStorage.put(voter.getId(), voter);
	}

	@Override public Page<Voter> findAll(Pageable pageable) {
		return new PageImpl<>(new ArrayList<>(votersStorage.values()));
	}
}
