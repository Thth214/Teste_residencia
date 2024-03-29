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

import teste.residencia.model.Skill;
import teste.residencia.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	private SkillService skillService;

	@GetMapping("/{id}")
	public ResponseEntity<Skill> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(skillService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Skill>> getAll() {
		List<Skill> skills = skillService.findAll();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(skills, headers, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Skill> post(@Valid @RequestBody Skill skill) {
		Skill l = skillService.save(skill);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(l.getId()).toUri();
		return ResponseEntity.created(uri).body(l);
	}

	@PutMapping("/{id}")

	public ResponseEntity<Skill> update(@PathVariable Integer id, @RequestBody Skill skill) {
		return skillService.update(id, skill);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Skill> delete(@PathVariable Integer id) {
		try {
			skillService.delete(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
}
