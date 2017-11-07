import { NgModule } from '@angular/core';

import { ChangespasswordComponent } from './changespassword.component';
// Components Routing
import { ChangespasswordRoutingModule } from './changespassword-routing.module';

@NgModule({
  imports: [
    ChangespasswordRoutingModule
  ],
  declarations: [
    ChangespasswordComponent
  ]
})
export class ChangespasswordModule { }
