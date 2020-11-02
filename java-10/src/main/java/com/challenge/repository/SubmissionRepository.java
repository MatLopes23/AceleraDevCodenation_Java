package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

    @Query(" SELECT MAX(s.score) FROM Submission s JOIN s.id.challenge ch WHERE ch.id = ?1 ")
    Optional<BigDecimal> findHigherScoreByChallengeId(Long challengeId);

    @Query("select s from Submission s JOIN s.id.challenge ch JOIN ch.accelerations acc " +
            "WHERE ch.id = ?1 AND acc.id = ?2")
    List<Submission> findByIdChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);

}
