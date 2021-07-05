package com.agkw.studentHub.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.agkw.studentHub.models.User;
import com.agkw.studentHub.repositories.RoleRepository;
import com.agkw.studentHub.repositories.UserRepository;

 
@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    public void validateRegistration(User user, BindingResult result) {
    	if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if(!user.getPassword().equals(user.getPasswordConfirmation())) {
            result.rejectValue("passwordConfirmation", "Matches", "The Confirm Password must match Password!");
        }
        if (userRepository.findByName(user.getName()) != null) {
        	result.rejectValue("name", "Unique", "This username is already taken!");
        }
        
        if (user.getBirthday() != null) {
	        LocalDate currentDate = LocalDate.now();
	        LocalDate currentDateMinus18Years = currentDate.minusYears(18);
	        LocalDate birthDay =  user.getBirthday().toInstant()
	        	      .atZone(ZoneId.systemDefault())
	        	      .toLocalDate(); 
	        if (birthDay.isAfter(currentDateMinus18Years)) {
	        	result.rejectValue("birthday", "Young", "You must be older than 18");
	        }
        }
        else {
        	result.rejectValue("birthday", "nullDate", "Date must not be null");
        }
    }
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    // 3
    public User findByUsername(String username) {
        return userRepository.findByName(username);
    }
    
    //4
    public void saveUser(User u) {
        userRepository.save(u);
    }

	public User findById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
}