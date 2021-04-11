package com.scratchdeveloper.photoapp.api.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.scratchdeveloper.photoapp.api.users.shared.UserDto;

public interface UsersService extends UserDetailsService{

	UserDto	createUser(UserDto userDetails);
}
