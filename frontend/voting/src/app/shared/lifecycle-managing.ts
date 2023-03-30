import {Component, OnDestroy} from '@angular/core';
import {Subscription} from 'rxjs';

@Component(({
  template:''
}))
export abstract class LifecycleManaging implements OnDestroy {

  protected alive = true;
  sources: Array<Subscription> = [];

  ngOnDestroy(): void {
    this.sources.forEach(s => s.unsubscribe());
    this.alive = false;
  }
}
