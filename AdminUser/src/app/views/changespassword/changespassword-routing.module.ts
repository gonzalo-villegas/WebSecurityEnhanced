import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ChangespasswordComponent } from './changespassword.component';

const routes: Routes = [
  {
    path: '',
    data: {
      title: 'Usuario'
    },
    children: [
      {
        path: 'changespassword',
        component: ChangespasswordComponent,
        data: {
          title: 'Cambiar Contrasenna'
        }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ChangespasswordRoutingModule {}
