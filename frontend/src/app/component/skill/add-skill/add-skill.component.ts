import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../../../service/EmployeeService';
import {ActivatedRoute, Router} from '@angular/router';
import {SkillService} from '../../../service/SkillService';

@Component({
  selector: 'app-add-skill',
  templateUrl: './add-skill.component.html',
  styleUrls: ['./add-skill.component.css']
})
export class AddSkillComponent implements OnInit {

  skillForm: FormGroup;
  id: string;

  // tslint:disable-next-line:max-line-length
  constructor(private formBuilder: FormBuilder, private skillService: SkillService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.data.subscribe(res => {
      this.route.params.subscribe(value => {
        this.id = value.id;
      });
    });
    this.skillForm = this.formBuilder.group({
      skill: this.formBuilder.group({
        field: this.formBuilder.group({
          name: ['', Validators.required],
          type: ['', Validators.required],
        }),
        experience: ['', Validators.required],
        summary: ['', Validators.required]
      })
    });
  }

  // tslint:disable-next-line:typedef
  addSkill() {
    this.skillService.addSkill(this.id, this.skillForm.value.skill).subscribe(
      res => {
        console.log('res', res);
        this.skillForm.reset();
        this.router.navigate(['/employee']);
      }
    );
  }
}
