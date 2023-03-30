export class UpdateVoterDto {
  uuid: string;
  candidateUUID: string;


  constructor(uuid: string, candidateUUID: string) {
    this.uuid = uuid;
    this.candidateUUID = candidateUUID;
  }
}
