import { InitService } from './init-service.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  // tslint:disable-next-line
  selector: 'body',
  template: '<router-outlet></router-outlet>'
})
export class AppComponent {
  constructor(isavalible: InitService, private router: Router) {
    isavalible.getDataPost({}, this.onSuccess.bind(this), this.onError.bind(this));
  }
  onSuccess(data) {
    if (data.isavalible === 'true') {
      this.renderLogin();
    } else if (data.isavalible === 'false') {
      this.renderMaintenance();
    } else {
      this.renderPageError();
    }
  }
  onError(data) {
    this.renderPageError();
  }
  renderLogin() {
    this.router.navigate(['/login']);
  }
  renderPageError() {
    this.router.navigate(['/errorpage']);
  }
  renderMaintenance() {
    this.router.navigate(['/maintenance']);
  }

}
