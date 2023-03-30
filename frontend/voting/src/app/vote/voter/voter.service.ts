import {Injectable} from '@angular/core';
import {ExtractModel, ObjectExtractor} from 'src/app/shared/object-extractor';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {VoterDto} from "./voterDto";
import {AppConstants} from "../../core/app-constants";
import {UpdateVoterDto} from "./updateVoterDto";

@Injectable()
export class VoterService {

  constructor(private http: HttpClient) {
  }

  save(model: VoterDto): Observable<any> {
    const firstName = new ExtractModel('firstName', 'firstName');
    const lastName = new ExtractModel('lastName', 'lastName');
    const hasVoted = new ExtractModel('hasVoted', 'hasVoted');

    const props = ['isNew', 'applicationTime', 'downloadTime', 'actualizationDelay', 'actualizationDelayUnit',
      'downloadDelay', 'downloadDelayUnit', firstName, lastName, hasVoted];

    return this.http.post(`${AppConstants.VOTER_URL}`, ObjectExtractor.prepareObject(model, props));
  }

  getVoters(): Observable<VoterDto[]> {
    return this.http.get<VoterDto[]>(`${AppConstants.VOTER_URL}`);
  }

  vote(model: UpdateVoterDto): Observable<any> {
    const uuid = new ExtractModel('uuid', 'uuid');
    const candidateUUID = new ExtractModel('candidateUUID', 'candidateUUID');

    const props = ['isNew', 'applicationTime', 'downloadTime', 'actualizationDelay', 'actualizationDelayUnit',
      'downloadDelay', 'downloadDelayUnit', uuid, candidateUUID];

    return this.http.post(`${AppConstants.VOTER_URL}/vote`, ObjectExtractor.prepareObject(model, props));
  }

}

