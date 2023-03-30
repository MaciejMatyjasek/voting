import {NgModule} from '@angular/core';
import {VoteComponent} from "./vote.component";
import {CommonModule} from "@angular/common";
import {VoterService} from "./voter/voter.service";
import {CandidateService} from "./candidate/candidate.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  exports: [
    VoteComponent
  ],
  declarations: [
    VoteComponent
  ],
  providers: [
    VoterService,
    CandidateService
  ]
})
export class VoteModule {
}
