import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';

import { ErrorPageComponent } from './errorpage.component';
import { ErrorPageRoutingModule } from './errorpage.routing';

@NgModule({
    imports: [
      ErrorPageRoutingModule,
      ChartsModule
    ],
    declarations: [ErrorPageComponent]
})
export class ErrorPageModule { }
