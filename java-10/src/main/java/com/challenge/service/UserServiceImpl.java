package com.challenge.service;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Long userId) {
        return this.userRepository.findById(userId);
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        return this.userRepository.findByCanditeIdAccelerationName(name);
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return this.userRepository.findByCanditeIdCompanyId(companyId);
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }
}
