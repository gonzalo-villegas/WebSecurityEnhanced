import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';

import { PageNotFoundComponent } from './page-not-found.component';
import { PageNotFoundRoutingModule } from './page-not-found.routing';

@NgModule({
    imports: [
      PageNotFoundRoutingModule,
      ChartsModule
    ],
    declarations: [PageNotFoundComponent]
})
export class PageNotFoundModule { }
