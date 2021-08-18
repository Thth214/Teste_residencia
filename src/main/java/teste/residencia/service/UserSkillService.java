package teste.residencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import teste.residencia.model.User;
import teste.residencia.model.UserSkill;
import teste.residencia.repository.UserSkillRepository;

import java.util.List;
import java.util.Optional;


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
	public Optional<List<UserSkill>> findByUser(User user) {
		Optional<List<UserSkill>> userSkills = Optional.ofNullable(userSkillRepository.findByUser(user));
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
	