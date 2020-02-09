package com.synerzip.docker.training.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synerzip.docker.training.user.DTO.UserDTO;
import com.synerzip.docker.training.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class UserController.
 */
@RestController
@RequestMapping("/api/v1/users")
@Api(value = "User APIs", tags = "Users")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Creates the User.
	 *
	 * @param userDTO the user DTO
	 * @return the response entity
	 */
	@ApiOperation(nickname = "createUser", value = "Create User Profile", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User created successfully") })
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<UserDTO> createUSer(UserDTO userDTO) {
		userDTO = this.userService.createUser(userDTO);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "getUser/{Id}", value = "Fetch User Profile", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User fetched successfully") })
	@RequestMapping(value = "/{Id}",method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUser( @ApiParam(name = "Id", value = "Unique Id of User", required = true)@PathVariable(name = "Id")Long userId) {
		UserDTO userDTO = this.userService.getUser(userId);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}
	
	
}
