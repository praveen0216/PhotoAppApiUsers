package com.scratchdeveloper.photoapp.api.users.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.scratchdeveloper.photoapp.api.users.data.UserEntity;
import com.scratchdeveloper.photoapp.api.users.data.UsersRepository;
import com.scratchdeveloper.photoapp.api.users.shared.UserDto;

@Service
public class UsersServiceImpl implements UsersService {
	
	UsersRepository usersRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
	public UsersServiceImpl(UsersRepository usersRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usersRepository=usersRepository;
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}
	

	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		
		ModelMapper modelMapper= new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserEntity userEntity=modelMapper.map(userDetails, UserEntity.class);
		//userEntity.setEncryptedPassword(UUID.randomUUID().toString());
		
		
		usersRepository.save(userEntity);
		return modelMapper.map(userEntity, UserDto.class);
		
	}

}
