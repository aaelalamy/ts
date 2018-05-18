package com.ts.services.interfaces.hc;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public interface HCService {

	public List<JsonNode> getDropCall(LocalDateTime startDateTime, LocalDateTime endDateTime);
	
	public List<JsonNode> getBadfetchCalls(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
