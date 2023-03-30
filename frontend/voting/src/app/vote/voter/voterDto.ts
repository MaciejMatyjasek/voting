export class VoterDto {
  uuid: string;
  firstName: string;
  lastName: string;
  hasVoted: boolean;


  constructor(uuid: string, firstName: string, lastName: string, hasVoted: boolean) {
    this.uuid = uuid;
    this.firstName = firstName;
    this.lastName = lastName;
    this.hasVoted = hasVoted;
  }
}
