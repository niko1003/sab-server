package org.sab.bsm.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.sab.bsm.model.Role;
import org.sab.bsm.model.RoleEnum;
import org.sab.bsm.model.User;
import org.sab.bsm.payload.request.LoginRequest;
import org.sab.bsm.payload.request.SignupRequest;
import org.sab.bsm.payload.response.JwtResponse;
import org.sab.bsm.payload.response.MessageResponse;
import org.sab.bsm.repository.RoleRepository;
import org.sab.bsm.repository.UserRepository;
import org.sab.bsm.security.UserDetailsImpl;
import org.sab.bsm.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String jwt = jwtUtils.generateJwtToken(authentication);

		final UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		final List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		final User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		final Set<String> strRoles = signUpRequest.getRole();
		final Set<Role> roles = new HashSet<>();

		if (strRoles == null) {

			final Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER);

			if (userRole == null) {
				throw new RuntimeException("Error: Role is not found");
			}

			roles.add(userRole);

		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					final Role adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN);
					if (adminRole == null) {
						throw new RuntimeException("Error: Role is not found");
					}
					roles.add(adminRole);

					break;
				case "mod":
					final Role modRole = roleRepository.findByName(RoleEnum.ROLE_MODERATOR);
					if (modRole == null) {
						throw new RuntimeException("Error: Role is not found");
					}
					roles.add(modRole);

					break;
				default:
					final Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER);
					if (userRole == null) {
						throw new RuntimeException("Error: Role is not found");
					}
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

}