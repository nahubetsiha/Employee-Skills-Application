package com.perficient.esa.service;

import com.perficient.esa.model.Skill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillService {
    List<Skill> getAllSkills(String employeeId);
    Skill addSkill(Skill skill, String employeeId);
    Skill getSkillById(String skillId, String employeeId);
    Skill updateSkill(String skillId, Skill skill, String employeeId);
    Skill deleteSkill(String skillId, String employeeId);
}
