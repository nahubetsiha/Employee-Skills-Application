import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../../../service/EmployeeService';
import {Router} from '@angular/router';
import {Skill} from '../../../model/Skill';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  employeeForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private employeeService: EmployeeService, private router: Router) {
  }

  ngOnInit(): void {
    this.employeeForm = this.formBuilder.group({
      employee: this.formBuilder.group({
        firstName: ['', Validators.required],
        lastName: ['', Validators.required],
        address: this.formBuilder.group({
          street: ['', Validators.required],
          suite: ['', Validators.required],
          city: ['', Validators.required],
          region: ['', Validators.required],
          postal: ['', Validators.required],
          country: ['', Validators.required],
        }),
        email: ['', Validators.required],
        companyEmail: ['', Validators.required],
        birthDate: ['', Validators.required],
        hireDate: ['', Validators.required],
        role: ['', Validators.required],
        businessUnit: ['', Validators.required],
        skills: this.formBuilder.array([this.addSkillFormGroup()]),
      })
    });
  }

  // tslint:disable-next-line:typedef
  addEmployee() {
    this.employeeService.addEmployee(this.employeeForm.value.employee).subscribe(
      res => {
        console.log('res', res);
        this.employeeForm.reset();
        this.router.navigate(['/employee']);
      }
    );
  }

  addSkillFormGroup(): FormGroup {
    return this.formBuilder.group({
        //   this.formBuilder.group({
            field: this.formBuilder.group({
              name: ['', Validators.required],
              type: ['', Validators.required],
            }),
            experience: ['', Validators.required],
            summary: ['', Validators.required]
          // })
        // ]),
      });
  }

}
