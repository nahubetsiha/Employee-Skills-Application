import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HeaderComponent} from './component/header/header.component';
import {FooterComponent} from './component/footer/footer.component';
import {HomeComponent} from './component/home/home.component';
import { EmployeeComponent } from './component/employee/employee.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AddEmployeeComponent } from './component/employee/add-employee/add-employee.component';
import { SkillComponent } from './component/skill/skill.component';
import { EditEmployeeComponent } from './component/employee/edit-employee/edit-employee.component';
import { AddSkillComponent } from './component/skill/add-skill/add-skill.component';
import { EditSkillComponent } from './component/skill/edit-skill/edit-skill.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    EmployeeComponent,
    AddEmployeeComponent,
    SkillComponent,
    EditEmployeeComponent,
    AddSkillComponent,
    EditSkillComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
