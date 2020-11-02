package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends CrudRepository<Challenge, Long> {
    @Query("select c from Challenge c JOIN c.accelerations ac JOIN ac.candidates ca JOIN ca.id.user u " +
            "WHERE ac.id = ?1 AND u.id = ?2")
    List<Challenge> findByIdAccelerationIdAndUserId(Long accelerationId, Long userId);
}
