import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {SkillService} from '../../service/SkillService';
import {Skill} from '../../model/Skill';

@Component({
  selector: 'app-skill',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css']
})
export class SkillComponent implements OnInit {

  employeeId: string;
  allSkills: Skill[];
  skillLength: number;
  constructor(private route: ActivatedRoute, private skillService: SkillService, private router: Router) { }

  ngOnInit(): void {
    this.route.data.subscribe(res => {
      this.route.params.subscribe(value => {
        this.employeeId = value.employeeId;
      });
    });
    this.listAllSkills();
  }
  listAllSkills(): void{
    this.skillService.getSkillList(this.employeeId).subscribe(
      res => {
        this.allSkills = res;
        this.skillService = res.length;
      }
    );
  }
  addSkill(): void{
      this.router.navigate(['addSkill', this.employeeId]);
  }
  editSkill(skillId: string): void{
    if (skillId){
      this.router.navigate(['editSkill', this.employeeId, skillId]);
    }
  }
  deleteSkill(skillId: string): void{
    this.skillService.deleteSkill(this.employeeId, skillId).subscribe(res => {
      this.router.navigate(['/home']);
    });
  }
}
