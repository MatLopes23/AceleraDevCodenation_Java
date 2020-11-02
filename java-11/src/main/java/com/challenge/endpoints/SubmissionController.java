package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService service;

    @Autowired
    private SubmissionMapper mapper;

    @GetMapping(params = {"challengeId","accelerationId"})
    @ResponseBody
    public List<SubmissionDTO> findByChallengeIdAndAccelerationId(@RequestParam("challengeId") Long challengeId,
                                                                  @RequestParam("accelerationId") Long accelerationId) {

        return service.findByChallengeIdAndAccelerationId(challengeId, accelerationId).stream()
                .map(submission -> mapper.map(submission))
                .collect(Collectors.toList());
    }
}
