package kz.iitu.intercitybustransportation.service.impl;

import kz.iitu.intercitybustransportation.dto.UserDTO;
import kz.iitu.intercitybustransportation.exceptions.ResourceNotFoundException;
import kz.iitu.intercitybustransportation.mapper.UserMapper;
import kz.iitu.intercitybustransportation.model.User;
import kz.iitu.intercitybustransportation.repository.UserRepository;
import kz.iitu.intercitybustransportation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO getUser(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDto) {
        User user = userMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDto) {
        return userRepository.findById(id)
                .map(user -> {
                    // Update the fields of the user as per your requirements
                    User updatedUser = userRepository.save(user);
                    return userMapper.toDto(updatedUser);
                })
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id)
                .ifPresentOrElse(userRepository::delete, () -> {
                    throw new ResourceNotFoundException("User not found with id " + id);
                });
    }
}
