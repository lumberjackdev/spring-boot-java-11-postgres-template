package com.lumberjackdev.template;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.ContainerState;

import static com.lumberjackdev.template.ContainerInitializer.getContainers;
import static com.lumberjackdev.template.ContainerInitializer.getPostgres;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(initializers = ContainerInitializer.class)
class ContainerInitializerTest {

	@Autowired
	private DataSourceProperties dataSourceProperties;

	@Test
	void appStartup_shouldStartDockerContainers() {
		assertThat(getContainers()).allMatch(ContainerState::isRunning);
	}

	@Test
	void appStartup_shouldInitializeJdbcDatasourceFromContainer() {
		assertThat(dataSourceProperties.getUrl()).isEqualTo(getPostgres().getJdbcUrl());
		assertThat(dataSourceProperties.getUsername()).isEqualTo(getPostgres().getUsername());
	}

}
