import { NgModule } from '@angular/core';
import { Routes,
     RouterModule } from '@angular/router';

import { ErrorPageComponent } from './errorpage.component';

const routes: Routes = [
  {
    path: 'errorpage',
    component: ErrorPageComponent,
    data: {
      title: 'Error Page'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ErrorPageRoutingModule {}
