package teste.residencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import teste.residencia.model.Skill;
import teste.residencia.repository.SkillRepository;

import java.util.List;


@Service
public class SkillService {

	@Autowired
	public SkillRepository skillRepository;

	public Skill findById(Integer id) {
		return skillRepository.findById(id).get();
	}

	public List<Skill> findAll() {
		List<Skill> skills = skillRepository.findAll();
		return skills;
	}

	public Skill save(Skill skill) {
		return skillRepository.save(skill);
	}

	public ResponseEntity<Skill> update(Integer id, Skill skill) {
		if (!skillRepository.existsById(id))
			return ResponseEntity.notFound().build();

		skill.setId(id);
		skill = skillRepository.save(skill);
		return ResponseEntity.ok(skill);
	}

	public boolean delete(Integer id) {
		if (id != null) {
			skillRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
	