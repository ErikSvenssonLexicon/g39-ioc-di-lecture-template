package se.lexicon.dao;

import se.lexicon.dao.sequencer.Sequencers;
import se.lexicon.model.entity.LearnedSkill;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class LearnedSkillDAOImpl implements LearnedSkillDAO {

    private final Collection<LearnedSkill> learnedSkills;
    private final Sequencers sequencers;

    public LearnedSkillDAOImpl(Sequencers sequencers) {
        this.sequencers = sequencers;
        learnedSkills = new HashSet<>();
    }

    @Override
    public LearnedSkill save(LearnedSkill entity) {
        if(entity == null) throw new IllegalArgumentException("Entity was null");
        if(entity.getId() == null){
            return internalCreate(entity);
        }
        return entity;
    }

    public LearnedSkill internalCreate(LearnedSkill entity) {
        entity.setId(sequencers.getLearnedSkillId());
        learnedSkills.add(entity);
        return entity;
    }

    @Override
    public Optional<LearnedSkill> findById(Integer id) {
        return learnedSkills.stream()
                .filter(learnedSkill -> learnedSkill.getId().equals(id))
                .findFirst();
    }

    @Override
    public Collection<LearnedSkill> findAll() {
        return new ArrayList<>(learnedSkills);
    }

    @Override
    public void delete(LearnedSkill entity) {
        learnedSkills.remove(entity);
    }
}
