package com.ts.configs.actuator;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class InfoDataContributor implements InfoContributor {

	@Autowired
	private ApplicationContext ctx;

	@Override
	public void contribute(Info.Builder builder) {
		Map<String, Object> details = new HashMap<>();
		details.put("bean-definition-count", ctx.getBeanDefinitionCount());
		LocalDateTime datetime = LocalDateTime.ofInstant(
				Instant.ofEpochMilli(ctx.getStartupDate()), ZoneId.systemDefault());
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter
				.ofPattern("dd-MM-yyyy hh:mm:ss");

		details.put("startup-date", datetime.format(dateTimeFormatter));
		builder.withDetail("context", details);
	}
}
