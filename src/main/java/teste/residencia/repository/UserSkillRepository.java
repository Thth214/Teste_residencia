package teste.residencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import teste.residencia.model.User;
import teste.residencia.model.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Integer> {

	List<UserSkill> findByUser(User user);
}
