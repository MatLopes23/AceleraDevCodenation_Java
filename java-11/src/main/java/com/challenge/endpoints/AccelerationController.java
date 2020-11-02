package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationService service;

    @GetMapping(value = "/{id}")
    public Acceleration findById(@PathVariable Long id){
        return service.findById(id).orElse(new Acceleration());
    }

    @GetMapping(params = "companyId")
    public List<Acceleration> findByCompanyId(@PathParam("companyId") Long companyId){
        return service.findByCompanyId(companyId);
    }
}
