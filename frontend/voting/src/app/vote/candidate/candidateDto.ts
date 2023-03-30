export class CandidateDto {
  uuid: string;
  firstName: string;
  lastName: string;
  votesQuantity: number;


  constructor(uuid: string, firstName: string, lastName: string, votesQuantity: number) {
    this.uuid = uuid;
    this.firstName = firstName;
    this.lastName = lastName;
    this.votesQuantity = votesQuantity;
  }
}
