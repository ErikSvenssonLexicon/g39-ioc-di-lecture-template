package se.lexicon.service;

import se.lexicon.dao.SkillDAO;
import se.lexicon.model.dto.SkillFormDTO;
import se.lexicon.model.entity.Skill;

import java.util.Collection;

public class SkillServiceImpl implements SkillService{

    private final SkillDAO skillDAO;

    public SkillServiceImpl(SkillDAO skillDAO) {
        this.skillDAO = skillDAO;
    }

    @Override
    public Skill create(SkillFormDTO skillFormDTO) {
        if(skillFormDTO == null) throw new IllegalArgumentException("DTO was null");
        Skill skill = new Skill(skillFormDTO.getSkillName().trim(), skillFormDTO.getDescription().trim());
        return skillDAO.save(skill);
    }

    @Override
    public Collection<Skill> findAll() {
        return skillDAO.findAll();
    }

    @Override
    public Skill findById(Integer id) {
        return skillDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill with id " + id + " could not be found"));
    }

    @Override
    public Skill update(Integer id, SkillFormDTO skillFormDTO) {
        if(id == null || skillFormDTO == null) throw new IllegalArgumentException("Id or Dto was null");
        Skill skill = findById(id);
        skill.setSkillName(skillFormDTO.getSkillName().trim());
        skill.setDescription(skillFormDTO.getDescription().trim());
        return skillDAO.save(skill);
    }

    @Override
    public void delete(Integer id) {
        skillDAO.delete(findById(id));
    }
}
