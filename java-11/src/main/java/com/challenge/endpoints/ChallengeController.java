package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeService service;

    @GetMapping(params = {"accelerationId","userId"})
    @ResponseBody
    public List<Challenge> findByAccelerationIdAndUserId(@RequestParam("accelerationId") Long accelerationId,
                                                         @RequestParam("userId") Long userId) {
        return service.findByAccelerationIdAndUserId(accelerationId, userId);
    }

}
