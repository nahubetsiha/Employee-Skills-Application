import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {SkillService} from '../../../service/SkillService';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-edit-skill',
  templateUrl: './edit-skill.component.html',
  styleUrls: ['./edit-skill.component.css']
})
export class EditSkillComponent implements OnInit {

  skillForm: FormGroup;
  employeeId: string;
  skillId: string;
  // tslint:disable-next-line:max-line-length
  constructor(private formBuilder: FormBuilder, private skillService: SkillService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.data.subscribe(res => {
      this.route.params.subscribe(value => {
        this.employeeId = value.employeeId;
        this.skillId = value.skillId;
      });
    });
    this.skillForm = this.formBuilder.group({
      skill: this.formBuilder.group({
        id: [this.skillId],
        field: this.formBuilder.group({
          name: ['', Validators.required],
          type: ['', Validators.required],
        }),
        experience: ['', Validators.required],
        summary: ['', Validators.required]
      })
    });
  }

  editSkill(): void{
    this.skillService.editSkill(this.employeeId, this.skillId, this.skillForm.value.skill).subscribe(
      res => {
        console.log('res', res);
        this.skillForm.reset();
        this.router.navigate(['/employee']);
      }
    );
  }

}
