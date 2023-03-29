package pl.maciej.matyjasek.voting.app.voter.infrastructure.web;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maciej.matyjasek.voting.app.voter.VoterFacade;
import pl.maciej.matyjasek.voting.app.voter.dto.VoterDto;

@AllArgsConstructor
@RestController
@RequestMapping("/voter")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VoterController {

	VoterFacade voterFacade;

	@GetMapping
	Page<VoterDto> showVoters(Pageable pageable) {
		return voterFacade.showVoters(pageable);
	}

	@PostMapping
	HttpEntity<?> addVoter(@RequestBody VoterDto voterDto) {
		voterFacade.addVoter(voterDto);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}
}
