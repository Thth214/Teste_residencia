package teste.residencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import teste.residencia.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
