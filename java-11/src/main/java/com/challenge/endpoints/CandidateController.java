package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {

    @Autowired
    private CandidateService service;

    @Autowired
    private CandidateMapper mapper;

    @GetMapping(value = "/{userId}/{companyId}/{accelerationId}")
    @ResponseBody
    public CandidateDTO findById(@PathVariable("userId") Long userId,
                                 @PathVariable("companyId") Long companyId,
                                 @PathVariable("accelerationId") Long accelerationId) {
        return mapper.map(service.findById(userId, companyId, accelerationId).orElse(new Candidate()));
    }

    @GetMapping(params = "companyId")
    @ResponseBody
    public List<CandidateDTO> findByCompanyId(@PathParam("companyId") Long companyId) {
        return service.findByCompanyId(companyId).stream()
                .map(candidate -> mapper.map(candidate))
                .collect(Collectors.toList());
    }

    @GetMapping(params = "accelerationId")
    @ResponseBody
    public List<CandidateDTO> findByAccelerationId(@PathParam("accelerationId") Long accelerationId) {
        return service.findByAccelerationId(accelerationId).stream()
                .map(candidate -> mapper.map(candidate))
                .collect(Collectors.toList());
    }
}
