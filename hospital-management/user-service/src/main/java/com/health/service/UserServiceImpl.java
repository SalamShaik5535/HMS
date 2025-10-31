package com.health.service;

import com.health.entity.User;
import com.health.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository  userRepository;

    @Override
    public Optional<User> findByKeycloakId(String keycloakId) {
        return Optional.empty();
    }
    public List<User> getAllUsers() {
            return userRepository.findAll();
        }
    @Override
    public Optional<User> getUserByKeycloakId(String keycloakId) {
        return userRepository.findByKeycloakId(keycloakId);
    }
    public User saveUser(User user) {
            return userRepository.save(user);
        }
        public void deleteUser(Long id) {
            userRepository.deleteById(id);
        }


}
