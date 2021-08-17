package teste.residencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import teste.residencia.model.UserSkill;
import teste.residencia.repository.UserSkillRepository;

import java.util.List;


@Service
public class UserSkillService {

	@Autowired
	public UserSkillRepository userSkillRepository;

	public UserSkill findById(Integer id) {
		return userSkillRepository.findById(id).get();
	}

	public List<UserSkill> findAll() {
		List<UserSkill> userSkills = userSkillRepository.findAll();
		return userSkills;
	}

	public UserSkill save(UserSkill userSkill) {
		return userSkillRepository.save(userSkill);
	}

	public ResponseEntity<UserSkill> update(Integer id, UserSkill userSkill) {
		if (!userSkillRepository.existsById(id))
			return ResponseEntity.notFound().build();

		userSkill.setId(id);
		userSkill = userSkillRepository.save(userSkill);
		return ResponseEntity.ok(userSkill);
	}

	public boolean delete(Integer id) {
		if (id != null) {
			userSkillRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
	