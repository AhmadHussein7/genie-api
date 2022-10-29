package com.technova.genie.services;

import java.util.List;

import com.technova.genie.modelsDtos.UserDto;

public interface IUserService {
	/**
	 * User service interface.
	 * @return
	 */

	public List<UserDto> getAll();

	public UserDto getById(Long id);

	public UserDto create(UserDto userDto);

	public UserDto update(UserDto userDto);

	public void delete(Long id);

}
