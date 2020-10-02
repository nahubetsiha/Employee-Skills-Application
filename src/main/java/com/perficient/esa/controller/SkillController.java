package com.perficient.esa.controller;

import com.perficient.esa.exception.EntityNotFoundException;
import com.perficient.esa.model.Skill;
import com.perficient.esa.service.EmployeeService;
import com.perficient.esa.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("employees")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SkillController {
    EmployeeService employeeService;
    SkillService skillService;

    public SkillController(EmployeeService employeeService, SkillService skillService){
        this.employeeService = employeeService;
        this.skillService = skillService;
    }

    @GetMapping("/{employeeId}/skills")
    public ResponseEntity<List<Skill>> getAllEmployeeSkillById(@PathVariable String employeeId) {

        List<Skill> skills = skillService.getAllSkills(employeeId);
        if (skills.isEmpty()) {
            return new ResponseEntity<>(skills, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @GetMapping("/{employeeId}/skills/{skillId}")
    public ResponseEntity<?> getEmployeeSkillById(@PathVariable String employeeId, @PathVariable String skillId) {
        Skill skill = skillService.getSkillById(skillId, employeeId);

        if (skill.equals(null)) {
            throw new EntityNotFoundException(Skill.class, "id", skillId);

        }

        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PostMapping(value="/{employeeId}/skills" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addSkill(@PathVariable String employeeId, @RequestBody @Valid Skill skill) {

        Skill addSkill= skillService.addSkill(skill, employeeId);

        return new ResponseEntity<>(addSkill, HttpStatus.OK);
    }

    @PutMapping(value="/{employeeId}/skills/{skillId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> putEmployeeById(@PathVariable String employeeId, @PathVariable String skillId, @RequestBody @Valid Skill skill) {

        Skill updateSkill = skillService.updateSkill(skillId, skill, employeeId);


        if (updateSkill.equals(null)) {
            throw new EntityNotFoundException(Skill.class, "id", skillId);
        }

        return new ResponseEntity<>(updateSkill, HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}/skills/{skillId}")
    public ResponseEntity<Skill> deleteEmployeeById(@PathVariable String employeeId, @PathVariable String skillId) {

        Skill skill = skillService.deleteSkill(employeeId, skillId);
        if (skill.equals(null)) {
            throw new EntityNotFoundException(Skill.class, "id", skillId);
        }

        return new ResponseEntity<>(skill, HttpStatus.OK);
    }
}

