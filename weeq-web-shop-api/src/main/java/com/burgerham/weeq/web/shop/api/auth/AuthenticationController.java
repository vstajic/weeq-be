package com.burgerham.weeq.web.shop.api.auth;

import com.burgerham.weeq.security.util.JwtUtil;
import com.burgerham.weeq.web.shop.dto.auth.AuthenticationRequestDto;
import com.burgerham.weeq.web.shop.dto.auth.AuthenticationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthenticationController {

  private final AuthenticationManager authenticationManager;
  private final UserDetailsService userDetailsService;

  @GetMapping(path = "/hello")
  public String helloWorld() {
    return "HELLO WORLD";
  }

  @PostMapping(path = "/authenticate")
  public ResponseEntity<AuthenticationResponseDto> authenticate(
      @RequestBody final AuthenticationRequestDto authenticationRequest) throws Exception {

    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
    } catch (BadCredentialsException e) {
      throw new Exception("Incorrect username or password");
    }
    final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    final String jwt = JwtUtil.generateToken(userDetails);
    return ResponseEntity.ok(new AuthenticationResponseDto(jwt));
  }

}
