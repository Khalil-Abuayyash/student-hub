package com.agkw.studentHub.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.agkw.studentHub.models.Course;
import com.agkw.studentHub.models.User;

@Service
public class AjaxService {
	private List<User> users;

    // Love Java 8
    public List<User> findByUserNameOrEmail(String username) {

        List<User> result = users.stream()
            .filter(x -> x.getName().equalsIgnoreCase(username))
            .collect(Collectors.toList());

        return result;
    }
    @PostConstruct
    private void iniDataForTesting() {

        users = new ArrayList<User>();

        Course course = new Course();
        




    }

}
