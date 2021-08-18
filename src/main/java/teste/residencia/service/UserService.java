package teste.residencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import teste.residencia.model.User;
import teste.residencia.repository.UserRepository;
import teste.residencia.shared.LoginResponse;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;

	public LoginResponse login(String login,String password) throws Exception {
		Optional<User> user = userRepository.findByLogin(login);
	if(user.get().getPassword().equals(password)){
        return new LoginResponse(user.get());
    } else {
     throw new Exception("Senha ou Login inválidos");
     }
	}
	public User findById(Integer id) {
		return userRepository.findById(id).get();
	}

	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users;
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public ResponseEntity<User> update(Integer id, User user) {
		if (!userRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
			}else {
		user.setId(id);
		user = userRepository.save(user);
		return ResponseEntity.ok(user);
		}
		
	}

	public boolean delete(Integer id) {
		if (id != null) {
			userRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
}
