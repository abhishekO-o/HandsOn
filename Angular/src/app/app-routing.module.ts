import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditEmpReactiveComponent } from './edit-emp-reactive/edit-emp-reactive.component';
import { EditEmpTemplateDriveComponent } from './edit-emp-template-drive/edit-emp-template-drive.component';
import { EditEmpComponent } from './edit-emp/edit-emp.component';
import { LoginComponent } from './login/login.component';
import { QuantityIncrementComponent } from './quantity-increment/quantity-increment.component';
import { UserComponent } from './user/user.component';
import { ViewEmpComponent } from './view-emp/view-emp.component';

const routes: Routes = [{ path: 'view-emp', component: ViewEmpComponent },
{ path: 'edit-emp', component:EditEmpComponent },
{ path: 'quantity-increment', component:QuantityIncrementComponent },
{path: 'edit-emp-template-drive',component:EditEmpTemplateDriveComponent},
{path:  'edit-emp-reactive',component:EditEmpReactiveComponent},
{path: 'login', component: LoginComponent},
{path: 'user', component: UserComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
