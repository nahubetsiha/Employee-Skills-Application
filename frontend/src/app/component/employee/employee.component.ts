import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../../service/EmployeeService';
import {Employee} from '../../model/Employee';
import {Router} from '@angular/router';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  allEmployees: Employee[];
  employeeLength: number;

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
    this.listAllEmployees();
  }

  // tslint:disable-next-line:typedef
  listAllEmployees() {
    this.employeeService.getEmployeeList().subscribe(
      res => {
            this.allEmployees = res;
            this.employeeLength = res.length;
      }
    );
  }
  editEmployee(id: string): void{
    if (id){
      this.router.navigate(['editEmployee', id]);
    }
  }
  navigateToSkills(id: string): void{
    if (id){
      this.router.navigate(['skill', id]);
    }
  }
  deleteEmployee(id: string): void{
    this.employeeService.deleteEmployee(id).subscribe(res => {
      this.router.navigate(['/home']);
    });
  }
}
