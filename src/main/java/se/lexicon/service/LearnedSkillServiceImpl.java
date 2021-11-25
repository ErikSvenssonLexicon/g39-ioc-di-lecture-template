package se.lexicon.service;

import se.lexicon.dao.LearnedSkillDAO;
import se.lexicon.model.dto.LearnedSkillFormDTO;
import se.lexicon.model.entity.LearnedSkill;

import java.util.Collection;

public class LearnedSkillServiceImpl implements LearnedSkillService{

    private final LearnedSkillDAO learnedSkillDAO;
    private final SkillService skillService;

    public LearnedSkillServiceImpl(LearnedSkillDAO learnedSkillDAO, SkillService skillService) {
        this.learnedSkillDAO = learnedSkillDAO;
        this.skillService = skillService;
    }

    @Override
    public LearnedSkill create(LearnedSkillFormDTO learnedSkillFormDTO) {
        if(learnedSkillFormDTO == null) throw new IllegalArgumentException("Dto was null");
        LearnedSkill learnedSkill = new LearnedSkill(
                learnedSkillFormDTO.getGrade(),
                learnedSkillFormDTO.getStudentNote(),
                skillService.findById(learnedSkillFormDTO.getSkillId())
        );
        return learnedSkillDAO.save(learnedSkill);
    }

    @Override
    public Collection<LearnedSkill> findAll() {
        return learnedSkillDAO.findAll();
    }

    @Override
    public LearnedSkill findById(Integer id) {
        return learnedSkillDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find learned skill with id " + id));
    }

    @Override
    public LearnedSkill update(Integer id, LearnedSkillFormDTO learnedSkillFormDTO) {
        if(id == null || learnedSkillFormDTO == null) throw new IllegalArgumentException("id or dto was null");
        LearnedSkill learnedSkill = findById(id);
        learnedSkill.setGrade(learnedSkillFormDTO.getGrade());
        learnedSkill.setStudentNote(learnedSkillFormDTO.getStudentNote());
        return learnedSkillDAO.save(learnedSkill);
    }

    @Override
    public void delete(Integer id) {
        learnedSkillDAO.delete(findById(id));
    }
}
