package se.lexicon.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.sequencer.Sequencers;
import se.lexicon.model.entity.Skill;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Component
public class SkillDAOImpl implements  SkillDAO{

    private final Collection<Skill> skills;
    private final Sequencers sequencers;

    @Autowired
    public SkillDAOImpl(Sequencers sequencers) {
        this.sequencers = sequencers;
        skills = new HashSet<>();
    }

    @Override
    public Skill save(Skill entity) {
        if(entity == null) throw new IllegalArgumentException("Entity was null");
        if(entity.getId() == null){
            return internalCreate(entity);
        }
        return entity;
    }

    public Skill internalCreate(Skill entity) {
        entity.setId(sequencers.getSkillId());
        skills.add(entity);
        return entity;
    }

    @Override
    public Optional<Skill> findById(Integer id) {
        return skills.stream()
                .filter(skill -> skill.getId().equals(id))
                .findFirst();
    }

    @Override
    public Collection<Skill> findAll() {
        return new ArrayList<>(skills);
    }

    @Override
    public void delete(Skill entity) {
        skills.remove(entity);
    }
}
