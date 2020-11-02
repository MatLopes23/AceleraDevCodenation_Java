package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Company findById(@PathVariable("id") Long id) {
        return service.findById(id).orElse(new Company());
    }

    @GetMapping(params = "accelerationId")
    @ResponseBody
    public List<Company> findByAccelerationId(@PathParam("accelerationId") Long accelerationId) {
        return service.findByAccelerationId(accelerationId);
    }

    @GetMapping(params = "userId")
    @ResponseBody
    public List<Company> findByUserId(@PathParam("userId") Long userId) {
        return service.findByUserId(userId);
    }
}