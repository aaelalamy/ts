package com.ts.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.ts.models.User;
import com.ts.services.interfaces.hc.HCService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/ts/api/hc")
@Api(tags = { "Healthy-Check" })
public class HCController {

	@Autowired
	private HCService hcSerice;

	@RequestMapping(value = "/dropcalls", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get the drop calls during spscified period", response = User.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "There is no drop calls")
	})
	public @ResponseBody List<JsonNode> getDropCalls(
			@ApiParam(value = "The Start Date Time in format dd-MM-yyyy HH:mm:ss", required = true) @RequestParam("startDateTime") @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") LocalDateTime startDateTime,
			@ApiParam(value = "The End Date Time in format dd-MM-yyyy HH:mm:ss", required = true) @RequestParam("endDateTime") @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") LocalDateTime endDateTime) {
		return hcSerice.getDropCall(startDateTime, endDateTime);
	}
	
	@RequestMapping(value = "/badfetchcalls", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get the Bad fetch calls during spscified period", response = User.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "There is no badfetch calls")
	})
	public @ResponseBody List<JsonNode> getBadfetchCalls(
			@ApiParam(value = "The Start Date Time in format dd-MM-yyyy HH:mm:ss", required = true) @RequestParam("startDateTime") @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") LocalDateTime startDateTime,
			@ApiParam(value = "The End Date Time in format dd-MM-yyyy HH:mm:ss", required = true) @RequestParam("endDateTime") @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") LocalDateTime endDateTime) {
		return hcSerice.getBadfetchCalls(startDateTime, endDateTime);
	}
}
