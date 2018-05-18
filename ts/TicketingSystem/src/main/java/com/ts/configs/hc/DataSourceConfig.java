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

package com.ts.configs.hc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@PropertySource({ "classpath:hc-datasources.properties" })
@EnableJpaRepositories(basePackages = "com.ts.repositories.hc")
public class DataSourceConfig {

	@Bean
	@Qualifier("icmDataSource")
	@ConfigurationProperties(prefix = "icm.datasource")
	@Profile("Production")
	DataSource icmDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Qualifier("icmDataSource")
	@ConfigurationProperties(prefix = "test.icm.datasource")
	@Profile("Test")
	DataSource testICMDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Qualifier("icmJdbcTemplate")
	JdbcTemplate customerJdbcTemplate(
			@Qualifier("icmDataSource") DataSource icmDataSource) {
		return new JdbcTemplate(icmDataSource);
	}

}
