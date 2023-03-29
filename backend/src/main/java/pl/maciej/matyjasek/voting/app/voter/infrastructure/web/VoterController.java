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
import pl.maciej.matyjasek.voting.app.candidate.CandidateFacade;
import pl.maciej.matyjasek.voting.app.voter.VoterFacade;
import pl.maciej.matyjasek.voting.app.voter.dto.UpdateVoterDto;
import pl.maciej.matyjasek.voting.app.voter.dto.VoterDto;

@AllArgsConstructor
@RestController
@RequestMapping("/voter")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VoterController {

	VoterFacade voterFacade;
	CandidateFacade candidateFacade;

	@GetMapping
	Page<VoterDto> showVoters(Pageable pageable) {
		return voterFacade.showVoters(pageable);
	}

	@PostMapping
	HttpEntity<?> addVoter(@RequestBody VoterDto voterDto) {
		voterFacade.addVoter(voterDto);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}

	@PostMapping("vote")
	HttpEntity<VoterDto> vote(@RequestBody UpdateVoterDto updateVoterDto) {
		VoterDto voterDto = voterFacade.vote(updateVoterDto.getUuid());
		candidateFacade.addVote(updateVoterDto.getCandidateUUID());
		return ResponseEntity.ok(voterDto);
	}
}
