package se.lexicon.dao.sequencer;

public interface Sequencers {
    Integer nextStudentId();
    Integer nextSkillId();
    Integer nextLearnedSkillId();

    Integer getStudentId();
    Integer getSkillId();
    Integer getLearnedSkillId();

    void setStudentId(Integer id);
    void setSkillId(Integer id);
    void setLearnedSkillId(Integer id);
}
