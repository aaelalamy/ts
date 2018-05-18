/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ts.repositories.hc.test;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.ts.repositories.hc.ICMRepository;
import com.ts.repositories.hc.JsonNodeRowMapper;

@Repository("ICMRepository")
@Profile("Test")
public class ICMRepositoryİmpl implements ICMRepository {

	private static final String SELECT_SQL = String.join("\n",
			"select  Variable1 as ani , Variable4 as skill, Variable5 as language, Variable8 as sessionId from Termination_Call_Detail");

	private static final String SELECT_SQL_2 = "select  ani, sessionId, sourceIp  from DropCall";

	@Autowired
	@Qualifier("icmJdbcTemplate")
	private JdbcTemplate icmJdbcTemplate;

	public List<JsonNode> getDropCall(LocalDateTime startDateTime,
			LocalDateTime endDateTime) {
		JsonNodeRowMapper json = new JsonNodeRowMapper();
		List<JsonNode> dropCalls = icmJdbcTemplate.query(SELECT_SQL,
				json);
		return dropCalls;
	}

	@Override
	public List<JsonNode> getBadFetchCalls(LocalDateTime startDateTime,
			LocalDateTime endDateTime) {
		JsonNodeRowMapper json = new JsonNodeRowMapper();
		List<JsonNode> dropCalls = icmJdbcTemplate.query(SELECT_SQL,
				json);
		return dropCalls;
	}

}
