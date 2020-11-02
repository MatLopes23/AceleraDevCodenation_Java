package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public User findById(@PathVariable Long id) throws BadHttpRequest{
        return service.findById(id).orElseThrow(BadHttpRequest::new);
    }

    @GetMapping(params = "accelerationName")
    @ResponseBody
    public List<User> findByAccelerationName(@RequestParam("accelerationName") String accelerationName) {
        return service.findByAccelerationName(accelerationName);
    }

    @GetMapping(params = "companyId")
    @ResponseBody
    public List<User> findByCompanyId(@RequestParam("companyId") Long companyId){
        return service.findByCompanyId(companyId);
    }
}
