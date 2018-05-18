package com.ts.controllers;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ts.models.User;
import com.ts.services.interfaces.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/ts/api/v1")
@Api(tags = { "Ticketing-System" })
public class TSController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users/{username}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get the user credentials for the username ", response = User.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "The user not found")
	})
	public @ResponseBody User getCredentials(@PathVariable String username,
			@ApiParam(value = "encoded password", required = true) 
			@RequestParam("password") String password) {
		User user = userService.findUser(username,password);

		if (user == null)
			throw new EntityNotFoundException("Nothing like that");
		return user;
	}

	@GetMapping("anonymously")
	@PermitAll
	public String anonymously() {
		return "Hello, World! anonymously";
	}

	@GetMapping("has-role")
	@RolesAllowed({ "TTTTT" })
	public String hasRole() {
		return "Hello, World! has-role";
	}
}
