package com.ts.services.impl.hc;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.ts.repositories.hc.ICMRepository;
import com.ts.services.interfaces.hc.HCService;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class HCServiceImpl implements HCService {

	@Autowired
	private ICMRepository icmRepository;

	@Override
	public List<JsonNode> getDropCall(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		return icmRepository.getDropCall(startDateTime, endDateTime);
	}

	@Override
	public List<JsonNode> getBadfetchCalls(LocalDateTime startDateTime,
			LocalDateTime endDateTime) {
		return icmRepository.getBadFetchCalls(startDateTime, endDateTime);
	}

}
