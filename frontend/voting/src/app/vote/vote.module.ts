import {NgModule} from '@angular/core';
import {VoteComponent} from "./vote.component";
import {CommonModule} from "@angular/common";


@NgModule({
  imports: [
    CommonModule
  ],
  exports: [
    VoteComponent
  ],
  declarations: [
    VoteComponent
  ]
})
export class VoteModule {
}
