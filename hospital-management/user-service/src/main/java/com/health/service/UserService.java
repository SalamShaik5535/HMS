package com.health.service;

import com.health.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByKeycloakId(String keycloakId);
    public List<User> getAllUsers();
    public Optional<User> getUserByKeycloakId(String keycloakId);
    public User saveUser(User user);
    public void deleteUser(Long id);
}
