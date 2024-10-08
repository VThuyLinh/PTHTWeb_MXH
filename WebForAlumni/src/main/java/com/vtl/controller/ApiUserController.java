/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.controller;

import com.vtl.component.JwtService;
import com.vtl.pojo.User;
import com.vtl.service.UserService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thuy Linh
 */

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiUserController {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody User user) {
        if (this.userService.authUser(user.getUsername(), user.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(user.getUsername());

            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/Users",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<User> addUser(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar,@RequestPart MultipartFile cover) {
        User user = this.userService.addUser(params, avatar,cover);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @GetMapping(path = "/current-user", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    @PreAuthorize("isAuthenticated()") // Ensure authenticated user access
    public ResponseEntity<User>details(Principal user) {
        
        User currentUser = userService.getUserByUsername(user.getName());
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    @GetMapping("/Users")
    public ResponseEntity<List<User>> list(@RequestParam Map<String, String> params) {
        List<User> user = this.us.getInfoAllUser(params);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    
    @GetMapping("/Student")
    public ResponseEntity<List<User>> listStudent() {
        List<User> user = this.us.getUserWithRoleStudent();

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @GetMapping("/Lecturer")
    public ResponseEntity<List<User>> listLecturer() {
        List<User> user = this.us.getUserWithRoleLecturer();

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    
  

    @Autowired
    private UserService us;

    @DeleteMapping("/Users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "userId") int id) {
        this.us.deleteUser(id);
    }

}
