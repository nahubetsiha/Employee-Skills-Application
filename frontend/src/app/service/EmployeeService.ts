import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class EmployeeService {
  private employeeApi: any = 'http://localhost:8080/employees';
  constructor(private httpClient: HttpClient) {
  }

  getEmployeeList(): Observable<any>{
    return this.httpClient
      .get(this.employeeApi);
  }

  addEmployee(body): Observable<any> {
    return this.httpClient
      .post(this.employeeApi, body);
  }

  editEmployee(id: string, body): Observable<any> {
    return this.httpClient
      .put(this.employeeApi + '/' + id, body);
  }

  deleteEmployee(employeeId: string): Observable<any>{
    return this.httpClient
      .delete(this.employeeApi + '/' + employeeId);
  }
}
