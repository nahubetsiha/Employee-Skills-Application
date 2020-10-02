package com.perficient.esa.service.impl;

import com.perficient.esa.exception.EntityNotFoundException;
import com.perficient.esa.model.Employee;
import com.perficient.esa.model.Skill;
import com.perficient.esa.repository.EmployeeRepository;
import com.perficient.esa.repository.SkillRepository;
import com.perficient.esa.service.EmployeeService;
import com.perficient.esa.service.SkillService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {

    SkillRepository skillRepository;
    EmployeeService employeeService;

    public SkillServiceImpl(SkillRepository skillRepository, EmployeeService employeeService){
        this.skillRepository = skillRepository;
        this.employeeService = employeeService;
    }

    @Override
    public List<Skill> getAllSkills(String employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return employee.getSkills();
    }

    @Override
    public Skill addSkill(@Valid Skill skill, String employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        List<Skill> skills = employee.getSkills();
        if(!skills.contains(skill)){
            skills.add(skill);
        }

        employee.setSkills(skills);

        employeeService.updateEmployee(employee, employeeId);

        return  skill;
    }

    @Override
    public Skill getSkillById(String skillId, String employeeId) {

        return getSkill(skillId, employeeId);
    }

    @Override
    public Skill updateSkill(String skillId, @Valid  Skill skill, String employeeId) {
//        Employee employee = employeeService.getEmployeeById(employeeId);
//        List<Skill> skills = employee.getSkills();
//        skills.add(skill);
//        Skill updateSkill = getSkill(skillId, employeeId);
//        skillRepository.save(updateSkill);
//        employeeService.updateEmployee(employee, employeeId);
        return skillRepository.findById(skillId)
                .map(skillToUpdate -> {
                    skillToUpdate.setExperience(skill.getExperience());
                    skillToUpdate.setField(skill.getField());
                    skillToUpdate.setSummary(skill.getSummary());

                    return skillRepository.save(skillToUpdate);
                }).orElseGet(() -> skillRepository.save(skill));
    }

    @Override
    public Skill deleteSkill(String skillId, String employeeId) {
        Skill skill = getSkill(skillId, employeeId);

        skillRepository.delete(skill);
        return skill;

    }

    private Skill getSkill(String skillId, String employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        List<Skill> skills = employee.getSkills();
        Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new EntityNotFoundException(Skill.class, "id", skillId));

        if (!skills.contains(skill)) throw new EntityNotFoundException(Skill.class, "id", skillId);
        return skill;
    }
}
