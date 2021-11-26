package se.lexicon.dao.sequencer;

import org.springframework.stereotype.Component;

@Component
public class SequencersImpl implements Sequencers{

    private Integer studentId = 0;
    private Integer skillId = 0;
    private Integer learnedSkillId = 0;

    @Override
    public Integer nextStudentId() {
        return ++studentId;
    }

    @Override
    public Integer nextSkillId() {
        return ++skillId;
    }

    @Override
    public Integer nextLearnedSkillId() {
        return ++learnedSkillId;
    }

    @Override
    public Integer getStudentId() {
        return studentId;
    }

    @Override
    public Integer getSkillId() {
        return skillId;
    }

    @Override
    public Integer getLearnedSkillId() {
        return learnedSkillId;
    }

    @Override
    public void setStudentId(Integer id) {
        studentId = id;
    }

    @Override
    public void setSkillId(Integer id) {
        skillId = id;
    }

    @Override
    public void setLearnedSkillId(Integer id) {
        learnedSkillId = id;
    }
}
