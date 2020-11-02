package com.challenge.service;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyServiceInterface {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        return companyRepository.findByCandidateIdAccelerationId(accelerationId);
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return companyRepository.findByCandidateIdUserId(userId);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }
}
