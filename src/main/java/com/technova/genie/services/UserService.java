package com.technova.genie.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technova.genie.repositories.*;
import com.technova.genie.models.User;
import com.technova.genie.modelsDtos.UserDto;

@Service
public class UserService implements IUserService {
	/**
	 * User service implementation.
	 */
	@Autowired
	private UserRepository userRepository;
	private ModelMapper mapper;

	public UserService(UserRepository userRepository, ModelMapper mapper) {
		/**
		 * Inject user repository and model mapper.
		 */
		this.userRepository = userRepository;
		this.mapper = mapper;
	}

	@Override
	public UserDto create(UserDto userDto) {
		/**
		 * Map usrDto to user Save the new user in DB Re-map and return the usrDto
		 */
		User user = dtoToUser(userDto);
		User newUser = userRepository.save(user);
		return userToDto(newUser);
	}

	@Override
	public List<UserDto> getAll() {
		/**
		 * Get the users from DB Map users list to userDtos cash the results in memory
		 */
		List<User> users = userRepository.findAll();
		List<UserDto> userDtos = users.stream().map(user -> userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public UserDto getById(Long id) {
		/**
		 * Get the user from DB by id Map user to userDtos
		 */
		try {

			User user = userRepository.getReferenceById(id);
			return userToDto(user);

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public UserDto update(UserDto userDto) {
		/**
		 * Get the user from DB by id Update the properties Save the updated user
		 */
		User user = userRepository.getReferenceById(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAddress(userDto.getAddress());
		user.setPhone(userDto.getPhone());
		User newUser = userRepository.save(user);
		return userToDto(newUser);
	}

	@Override
	public void delete(Long id) {
		/**
		 * Delete user from DB
		 */
		userRepository.deleteById(id);
	}

	public boolean login(UserDto userDto){
		User _user = dtoToUser(userDto);
		try {
			User user = userRepository.findByEmail(_user.getEmail());
			if(user.getPassword().equals(_user.getPassword()))
				return true;
			return false;
		}catch (Exception e){
			return false;
		}

	}

	private UserDto userToDto(User user) {
		/**
		 * Map from user to userDto
		 */
		return mapper.map(user, UserDto.class);
	}

	private User dtoToUser(UserDto dto) {
		/**
		 * Map from userDto to user
		 */
		return mapper.map(dto, User.class);
	}



}
