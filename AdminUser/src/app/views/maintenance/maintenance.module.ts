import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';

import { MaintenanceComponent } from './maintenance.component';
import { MintenanceRoutingModule } from './maintenance.routing';

@NgModule({
    imports: [
      MintenanceRoutingModule,
      ChartsModule
    ],
    declarations: [MaintenanceComponent]
})
export class MaintenanceModule { }
