// package com.Sewin.Sewin3.Service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.ui.Model;

// import com.Sewin.Sewin3.Model.user;
// import com.Sewin.Sewin3.Repository.UserRepository;

// @Service
// public class UserService {

//     @Autowired
//     private UserRepository userRepository;

//     public void createUser(Model model) {
//         userRepository.save(model);
//     }

//     public user findByUsername(String username) {
//         return userRepository.findByUsername(username);
//     }

//     public boolean authenticateUser(String username, String password) {
//         user existingUser = userRepository.findByUsername(username);
//         if (existingUser != null && existingUser.getPassword().equals(password)) {
//             return true;
//         } else {
//             return false;
//         }
//     }
// }
