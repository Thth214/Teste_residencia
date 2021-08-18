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

import teste.residencia.model.User;
import teste.residencia.service.UserService;
import teste.residencia.shared.LoginRequest;
import teste.residencia.shared.LoginResponse;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(userService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		List<User> users = userService.findAll();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(users, headers, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> post(@Valid @RequestBody User user) {
		User l = userService.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(l.getId()).toUri();
		return ResponseEntity.created(uri).body(l);
	}
	@PostMapping("/login")
	public LoginResponse login (@RequestBody LoginRequest request) throws Exception {
        return userService.login(request.getLogin(), request.getPassword());
    }

	@PutMapping("/{id}")

	public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user) {
		return userService.update(id, user);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> delete(@PathVariable Integer id) {
		try {
			userService.delete(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
}
