package com.synerzip.docker.training.user.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synerzip.docker.training.user.DTO.UserDTO;
import com.synerzip.docker.training.user.model.UserModel;
import com.synerzip.docker.training.user.repo.UserRepository;
import com.synerzip.docker.training.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO createUser(UserDTO userDTO) {

		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(userDTO, userModel);
		userRepository.save(userModel);
		userDTO.setUserId(userModel.getUserId());
		return userDTO;
	}

	@Override
	public UserDTO getUser(Long userId) {
		UserModel userModel = this.userRepository.getOne(userId);
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(userModel, userDTO);
		return userDTO;
	}
	
	

}
