import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './component/home/home.component';
import {EmployeeComponent} from './component/employee/employee.component';
import {AddEmployeeComponent} from './component/employee/add-employee/add-employee.component';
import {SkillComponent} from './component/skill/skill.component';
import {EditEmployeeComponent} from './component/employee/edit-employee/edit-employee.component';
import {AddSkillComponent} from './component/skill/add-skill/add-skill.component';
import {EditSkillComponent} from './component/skill/edit-skill/edit-skill.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'employee', component: EmployeeComponent},
  {path: 'addEmployee', component: AddEmployeeComponent},
  {path: 'editEmployee/:id', component: EditEmployeeComponent},
  {path: 'skill/:employeeId', component: SkillComponent},
  {path: 'addSkill/:id', component: AddSkillComponent},
  {path: 'editSkill/:employeeId/:skillId', component: EditSkillComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
