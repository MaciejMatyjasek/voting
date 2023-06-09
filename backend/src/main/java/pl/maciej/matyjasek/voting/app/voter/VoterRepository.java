package pl.maciej.matyjasek.voting.app.voter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.*;

public interface VoterRepository extends Repository<Voter, Long> {
	void save(Voter voter);

	List<Voter> findAll();

	Optional<Voter> findOneByUuid(UUID uuid);
}

class InMemoryVoterRepository implements VoterRepository {
	private final Map<UUID, Voter> votersStorage = new HashMap<>();

	@Override public void save(Voter voter) {
		votersStorage.put(voter.getUuid(), voter);
	}

	@Override public List<Voter> findAll() {
		return new ArrayList<>(votersStorage.values());
	}

	@Override public Optional<Voter> findOneByUuid(UUID uuid) {
		return Optional.ofNullable(votersStorage.get(uuid));
	}

}
