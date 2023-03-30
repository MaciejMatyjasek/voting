import {Component, OnInit} from '@angular/core';
import {CandidateDto} from "./candidate/candidateDto";
import {VoterDto} from "./voter/voterDto";
import {VoterService} from "./voter/voter.service";
import {LifecycleManaging} from "../shared/lifecycle-managing";
import {filter, map, Observable, Subject, takeWhile, tap} from "rxjs";
import {CandidateService} from "./candidate/candidate.service";
import {UpdateVoterDto} from "./voter/updateVoterDto";
import {MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'vote-component',
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.scss']
})
export class VoteComponent extends LifecycleManaging implements OnInit {

  voterChange = new Subject<VoterDto[]>();
  voterObservable: Observable<VoterDto[]>;
  voters: VoterDto[];
  candidateChange = new Subject<CandidateDto[]>();
  candidateObservable: Observable<CandidateDto[]>;
  candidates: CandidateDto[];
  updateVoterDto: UpdateVoterDto;
  voterDto: VoterDto;
  candidateDto: CandidateDto;
  selectedVoterUuid: string;
  selectedCandidateUuid: string;
  voterDialog: HTMLDialogElement;
  candidateDialog: HTMLDialogElement;
  voterFirstName: string;
  voterLastName: string;
  candidateFirstName: string;
  candidateLastName: string;
  dialog: MatDialogRef<any>;

  constructor(private voterService: VoterService, private candidateService: CandidateService) {
    super();
  }

  ngOnInit() {
    this.getVoters();
    this.voterObservable = this.voterChange.asObservable();
    this.getCandidates();
    this.candidateObservable = this.candidateChange.asObservable();
  }

  private getVoters() {
    this.voterService.getVoters()
      .pipe(
        takeWhile(() => this.alive),
        filter(voters => voters !== undefined),
        map(voters => this.voters = voters),
        tap(() => console.log('przypisano głosujących ', this.voters)),
        tap(voters => this.voterChange.next(voters))
      )
      .subscribe();
  }

  private getCandidates() {
    this.candidateService.getCandidates()
      .pipe(
        takeWhile(() => this.alive),
        filter(candidates => candidates !== undefined),
        map(candidates => this.candidates = candidates),
        tap(() => console.log('przypisano kandydatów ', this.candidates)),
        tap(candidates => this.candidateChange.next(candidates))
      )
      .subscribe();
  }

  vote() {
    if (this.selectedVoterUuid !== undefined && this.selectedCandidateUuid !== undefined) {
      this.updateVoterDto = new UpdateVoterDto(this.selectedVoterUuid, this.selectedCandidateUuid);
      console.log('wybrano głosującego z numerem uuid=', this.selectedVoterUuid)
      console.log('wybrano kandydata z numerem uuid=', this.selectedCandidateUuid)

      this.voterService.vote(this.updateVoterDto)
        .pipe(
          takeWhile(() => this.alive),
          tap(() => console.log('Głos został oddany pomyślnie '))
        )
        .subscribe();
      this.getCandidates()
      this.getVoters()
    } else {
      console.log('nie wybrano kandydata lub głosującego lub obu')
    }
  }

  addVoter() {
    console.log('Dodajesz głosującego ' + this.voterFirstName + ' ' + this.voterLastName)
    this.voterDto = new VoterDto('', this.voterFirstName, this.voterLastName, false)
    this.voterService.save(this.voterDto)
      .pipe(
        takeWhile(() => this.alive),
        tap(() => console.log('Trwa wysyłanie do zapisu nowego głosującego: ' + this.voterFirstName + ' ' + this.voterLastName))
      )
      .subscribe();
    this.getVoters()
    this.voterDialog.close()
  }

  addCandidate() {
    console.log('Dodajesz kandydata ' + this.candidateFirstName + ' ' + this.candidateLastName)
    this.candidateDto = new CandidateDto('', this.candidateFirstName, this.candidateLastName, 0)
    this.candidateService.save(this.candidateDto)
      .pipe(
        takeWhile(() => this.alive),
        tap(() => console.log('Trwa wysyłanie do zapisu nowego kandydata: ' + this.candidateFirstName + ' ' + this.candidateLastName))
      )
      .subscribe();
    this.getCandidates()
    this.candidateDialog.close();
  }
}
