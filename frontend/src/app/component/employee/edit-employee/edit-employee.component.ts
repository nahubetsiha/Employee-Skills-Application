import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {SkillService} from '../../../service/SkillService';
import {EmployeeService} from '../../../service/EmployeeService';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
  id: string;
  employeeForm: FormGroup;
  // tslint:disable-next-line:max-line-length
  constructor(private route: ActivatedRoute, private employeeService: EmployeeService, private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.route.data.subscribe(res => {
      this.route.params.subscribe(value => {
        this.id = value.id;
      });
    });

    this.employeeForm = this.formBuilder.group({
      employee: this.formBuilder.group({
        id: [this.id],
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

  editEmployee(): void{
    this.employeeService.editEmployee(this.id, this.employeeForm.value.employee).subscribe(
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
