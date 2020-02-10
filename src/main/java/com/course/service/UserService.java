package com.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entities.User;
import com.course.repository.UserRepository;
import com.course.service.exception.ObjectNotFound;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFound(id));
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}

	public void deleteById(Long id) {
		User userSalvo = findById(id);
		userRepository.deleteById(userSalvo.getId());
	}

	public User update(Long id, User user) {
		User userSalvo = userRepository.getOne(id);
		BeanUtils.copyProperties(user, userSalvo, "id", "password");
		return userRepository.save(userSalvo);
		
	}
}
