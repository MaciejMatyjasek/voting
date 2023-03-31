package pl.maciej.matyjasek.voting.app.candidate.infrastructure.web;

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
import pl.maciej.matyjasek.voting.app.candidate.dto.CandidateDto;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/candidate")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CandidateController {

	CandidateFacade candidateFacade;

	@GetMapping
	ResponseEntity<List<CandidateDto>> showCandidates() {
		return ResponseEntity.ok(candidateFacade.showCandidates());
	}

	@PostMapping
	ResponseEntity<?> addCandidate(@RequestBody CandidateDto candidateDto) {
		candidateFacade.addCandidate(candidateDto);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}
}
