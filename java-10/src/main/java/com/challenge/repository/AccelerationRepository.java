package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {
    Optional<Acceleration> findByName(String name);

    @Query("from Acceleration a JOIN a.candidates ca WHERE ca.id.company.id = :companyId")
    List<Acceleration> findByCandidateIdCompanyId(@Param("companyId") Long companyId);

}
