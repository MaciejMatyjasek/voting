import {Component, OnInit} from '@angular/core';
import {Candidate} from "./models/candidate";
import {Voter} from "./models/voter";

@Component({
  selector: 'vote-component',
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.scss']
})
export class VoteComponent implements OnInit {

  candidates: Candidate[] = [
    {
      uuid: 'c31d2e38-43c4-468d-a80a-30d89e8716f7',
      firstName: 'Szef',
      lastName: 'Wszystkich-Szefów',
      votesQuantity: 0
    }
  ]
  voters: Voter[] = [
    {
      uuid: '40388a3a-7ece-400b-9c70-5e952911fc4e',
      firstName: 'Maciej',
      lastName: 'Maciejewski',
      hasVoted: false
    },
    {
      uuid: '2e0f6119-d033-43f0-b0aa-6cd7a0486182',
      firstName: 'Kasia',
      lastName: 'Maciejewska',
      hasVoted: false
    }
  ]

  constructor() {
  }

  ngOnInit() {

  }
}
