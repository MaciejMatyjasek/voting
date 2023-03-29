import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {VoteModule} from "./vote/vote.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    VoteModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
