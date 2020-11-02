package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
    @Query("SELECT DISTINCT co from Company co JOIN co.candidates ca JOIN ca.id.acceleration acc " +
            "WHERE acc.id = ?1")
    List<Company> findByCandidateIdAccelerationId(Long accelerationId);

    @Query("SELECT co from Company co JOIN co.candidates ca JOIN ca.id.user u " +
            "WHERE u.id = ?1")
    List<Company> findByCandidateIdUserId(Long userId);
}
