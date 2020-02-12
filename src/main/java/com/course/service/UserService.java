package com.course.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.course.entities.User;
import com.course.repository.UserRepository;
import com.course.service.exception.DataBaseException;
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
		try {
			User userSalvo = findById(id);
			userRepository.deleteById(userSalvo.getId());
		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFound(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public User update(Long id, User user) {
		try {
			User userSalvo = userRepository.getOne(id);
			updateData(userSalvo, user);
			return userRepository.save(userSalvo);
		} catch (EntityNotFoundException e) {
			throw new ObjectNotFound(id);
		}

	}

	private void updateData(User userSalvo, User user) {
		userSalvo.setName(user.getName());
		userSalvo.setEmail(user.getEmail());
		userSalvo.setPhone(user.getPhone());
		
	}
}
