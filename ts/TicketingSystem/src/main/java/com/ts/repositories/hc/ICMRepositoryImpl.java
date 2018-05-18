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

package com.ts.repositories.hc;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.JsonNode;

@Repository("ICMRepository")
@Profile("Production")
public class ICMRepositoryImpl implements ICMRepository {

	private static final String SELECT_SQL = "select top 10 Variable1, Variable4, Variable5, Variable8 from ipcc_hds..t_Termination_Call_Detail where Variable1 is not null;";
	@Autowired
	@Qualifier("icmJdbcTemplate")
	JdbcTemplate icmJdbcTemplate;
	@Override
	public List<JsonNode> getDropCall(LocalDateTime startDateTime,
			LocalDateTime endDateTime) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<JsonNode> getBadFetchCalls(LocalDateTime startDateTime,
			LocalDateTime endDateTime) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
