package com.ex.prep.service.Impl;

import com.ex.prep.model.entities.UserEntity;
import com.ex.prep.model.service.UserServiceModel;
import com.ex.prep.repository.UserRepository;
import com.ex.prep.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        userRepository.save(modelMapper.map(userServiceModel, UserEntity.class));
    }
}
