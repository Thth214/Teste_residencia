package teste.residencia.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import teste.residencia.model.UserSkill;
import teste.residencia.service.UserSkillService;

@RestController
@RequestMapping("/userSkill")
public class UserSkillController {

	@Autowired
	private UserSkillService userSkillService;

	@GetMapping("/{id}")
	public ResponseEntity<UserSkill> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(userSkillService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<UserSkill>> getAll() {
		List<UserSkill> userSkills = userSkillService.findAll();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(userSkills, headers, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserSkill> post(@Valid @RequestBody UserSkill userSkill) {
		UserSkill l = userSkillService.save(userSkill);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(l.getId()).toUri();
		return ResponseEntity.created(uri).body(l);
	}

	@PutMapping("/{id}")

	public ResponseEntity<UserSkill> update(@PathVariable Integer id, @RequestBody UserSkill userSkill) {
		return userSkillService.update(id, userSkill);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<UserSkill> delete(@PathVariable Integer id) {
		try {
			userSkillService.delete(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
}
