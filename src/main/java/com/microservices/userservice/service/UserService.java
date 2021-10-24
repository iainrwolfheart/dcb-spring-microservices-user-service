package com.microservices.userservice.service;

import com.microservices.userservice.ValueObjects.Department;
import com.microservices.userservice.ValueObjects.ResponseTemplateVO;
import com.microservices.userservice.entity.User;
import com.microservices.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO findUserWithDepartment(String userId) {
        ResponseTemplateVO response = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                Department.class);

        response.setUser(user);
        response.setDepartment(department);
        return response;
    }
}
