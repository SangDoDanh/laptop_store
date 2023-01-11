package com.codegym.controller.auth;

import com.codegym.dto.request.SignInForm;
import com.codegym.dto.request.SignupForm;
import com.codegym.dto.response.JwtResponse;
import com.codegym.model.user.Account;
import com.codegym.model.user.AccountRole;
import com.codegym.model.user.Role;
import com.codegym.model.user.RoleName;
import com.codegym.security.jwt.JwtProvider;
import com.codegym.security.userprincal.USerPrinciple;
import com.codegym.service.account.IAccountRoleService;
import com.codegym.service.account.IAccountService;
import com.codegym.service.account.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin("*")
@RequestMapping("api/auth")
@RestController
public class AuthController {

    @Autowired
    IAccountService userService;

    @Autowired
    IRoleService roleService;

    @Autowired
    IAccountRoleService userRoleService;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignupForm signupForm) {
        if(userService.existsByUsername(signupForm.getUsername())) {
            return new ResponseEntity<>("user name exits", HttpStatus.OK);
        }
        Account user = new Account(signupForm.getName(), signupForm.getUsername(), passwordEncoder.encode(signupForm.getPassword()));
        Set<String> strRoles = signupForm.getRoles();
        Set<AccountRole> userRoles = new HashSet<>();

        strRoles.forEach(role  -> {
            Role roletest = roleService.findByName(RoleName.ADMIN).get();
            switch (role) {
                case "ADMIN":
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow(
                            () -> new RuntimeException("Role not found")
                    );
                    AccountRole aRole = new AccountRole();
                    aRole.setAccount(user);
                    aRole.setRole(adminRole);
                    userRoles.add(aRole);
                    userService.save(user);
                    userRoleService.save(aRole);
                    break;
                case "user":
                case "USER":
                    Role userRole = roleService.findByName(RoleName.USER).orElseThrow(
                            () -> new RuntimeException("Role not found")
                    );
                    AccountRole uRole = new AccountRole();
                    uRole.setAccount(user);
                    uRole.setRole(userRole);
                    userRoles.add(uRole);
                    userService.save(user);
                    userRoleService.save(uRole);
                    break;
                case "PM":
                case "pm":
                    Role pmRole = roleService.findByName(RoleName.PM).orElseThrow(
                            () -> new RuntimeException("Role not found")
                    );
                    AccountRole pRole = new AccountRole();
                    pRole.setAccount(user);
                    pRole.setRole(pmRole);
                    userRoles.add(pRole);
                    userService.save(user);
                    userRoleService.save(pRole);
                    break;
            }
        });

        user.setAccountRoles(userRoles);
        userService.save(user);
        return  new ResponseEntity<>("Create new user success!", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getRoleByName(@RequestParam String roleName) {
        Role role = roleService.findByName(RoleName.ADMIN).get();
        return  new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        USerPrinciple uSerPrinciple = (USerPrinciple) authentication.getPrincipal();
        return  ResponseEntity.ok(new JwtResponse(token,
                uSerPrinciple.getName(),
                uSerPrinciple.getAuthorities()));

    }
}
