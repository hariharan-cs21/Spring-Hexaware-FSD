package com.springboot.lms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.jsonwebtoken.security.SignatureException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(exception = RuntimeException.class)

	public ResponseEntity<?> handleRuntime(RuntimeException e) {
		Map<String, String> map = new HashMap<>();
		map.put("message", e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

	@ExceptionHandler(exception = SignatureException.class)
	public ResponseEntity<?> handleSignatureException(Exception e) {
		Map<String, String> map = new HashMap<>();
		map.put("msg", e.getMessage());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
	}

	@ExceptionHandler(exception = Exception.class)

	public ResponseEntity<?> handleException(Exception e) {
		Map<String, String> map = new HashMap<>();
		map.put("message", e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

}
