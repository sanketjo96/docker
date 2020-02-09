package com.synerzip.docker.training.user.service;

import com.synerzip.docker.training.user.DTO.UserDTO;

public interface UserService {

	public UserDTO createUser(UserDTO userDTO);
	
	public UserDTO getUser(Long userId);
}
