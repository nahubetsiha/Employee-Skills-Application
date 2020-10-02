import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class SkillService {
  private skillApi: any = 'http://localhost:8080/employees';
  constructor(private httpClient: HttpClient) {
  }

  getSkillList(employeeId: string): Observable<any>{
    return this.httpClient
      .get(this.skillApi + '/' + employeeId + '/skills');
  }

  addSkill(id: string, body): Observable<any> {
    return this.httpClient
      .post(this.skillApi + '/' + id + '/' + 'skills', body);
  }

  editSkill(employeeId: string, skillId: string, body): Observable<any> {
    return this.httpClient
      .put(this.skillApi + '/' + employeeId + '/skills/' + skillId , body);
  }
  deleteSkill(employeeId: string, skillId: string): Observable<any>{
    return this.httpClient
      .delete(this.skillApi + '/' + employeeId + '/skills/' + skillId );
  }
}
