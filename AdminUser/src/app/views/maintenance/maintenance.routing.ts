import { NgModule } from '@angular/core';
import { Routes,
     RouterModule } from '@angular/router';

import { MaintenanceComponent } from './maintenance.component';

const routes: Routes = [
  {
    path: 'maintenance',
    component: MaintenanceComponent,
    data: {
      title: 'Mantenimiento'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MintenanceRoutingModule {}
