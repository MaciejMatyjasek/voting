import {Injectable} from '@angular/core';
import {ExtractModel, ObjectExtractor} from 'src/app/shared/object-extractor';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppConstants} from "../../core/app-constants";
import {CandidateDto} from "./candidateDto";

@Injectable()
export class CandidateService {

  constructor(private http: HttpClient) {
  }

  save(model: CandidateDto): Observable<any> {
    const firstName = new ExtractModel('firstName', 'firstName');
    const lastName = new ExtractModel('lastName', 'lastName');
    const votesQuantity = new ExtractModel('votesQuantity', 'votesQuantity');

    const props = ['isNew', 'applicationTime', 'downloadTime', 'actualizationDelay', 'actualizationDelayUnit',
      'downloadDelay', 'downloadDelayUnit', firstName, lastName, votesQuantity];

    return this.http.post(`${AppConstants.CANDIDATE_URL}`, ObjectExtractor.prepareObject(model, props));
  }

  getCandidates(): Observable<CandidateDto[]> {
    return this.http.get<CandidateDto[]>(`${AppConstants.CANDIDATE_URL}`);
  }
}

