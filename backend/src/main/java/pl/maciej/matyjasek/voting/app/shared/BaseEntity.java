package pl.maciej.matyjasek.voting.app.shared;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private UUID uuid = UUID.randomUUID();

	public int hashCode() {
		return Objects.hash(uuid);
	}

	public boolean equals(Object that) {
		return this == that || that instanceof BaseEntity
				&& Objects.equals(uuid, ((BaseEntity) that).uuid);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getUuid() {
		return uuid;
	}
}
