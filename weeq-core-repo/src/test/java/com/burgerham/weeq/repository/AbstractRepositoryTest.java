package com.burgerham.weeq.repository;

import com.burgerham.weeq.common.profile.WeeqProfiles;
import com.burgerham.weeq.model.common.BaseEntity;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@ExtendWith(SpringExtension.class)
@ActiveProfiles(WeeqProfiles.INTEGRATION_TEST)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractRepositoryTest {

  public static PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:13.2")
      .withDatabaseName("weeq-integration-tests")
      .withUsername("sa")
      .withPassword("sa");

  @Test
  void contextLoads() {
    System.out.println("Context loads!");
  }

  public static class InitializerWithSecondLevelCache extends Initializer {

    public InitializerWithSecondLevelCache() {
      super(true);
    }
  }

  public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private final boolean useSecondLevelCache;

    public Initializer() {
      useSecondLevelCache = false;
    }

    public Initializer(boolean useSecondLevelCache) {
      this.useSecondLevelCache = useSecondLevelCache;
    }

    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      System.out.println("jdbc url: " + container.getJdbcUrl());
      Stream<String> applicationProperties = Stream.of(
          "spring.jpa.show-sql=true",
          "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect",
          "spring.jpa.properties.hibernate.format_sql=true",
          "spring.datasource.driver-class-name=org.postgresql.Driver",
          "spring.jpa.hibernate.ddl-auto=none",
          "spring.jpa.open-in-view=false",
          "spring.datasource.hikari.maximum-pool-size=5",
          "spring.jpa.properties.hibernate.cache.use_second_level_cache=" + useSecondLevelCache,
          "spring.jpa.properties.hibernate.cache.use_query_cache=" + useSecondLevelCache,
          "spring.datasource.url=" + container.getJdbcUrl(),
          "spring.datasource.username=" + container.getUsername(),
          "spring.datasource.password=" + container.getPassword(),
          "spring.flyway.url=" + container.getJdbcUrl(),
          "spring.flyway.user=" + container.getUsername(),
          "spring.flyway.password=" + container.getPassword(),
          "spring.jpa.properties.hibernate.generate_statistics=true",
          "spring.jpa.properties.hibernate.resource.beans.container=org.springframework.orm.hibernate5.SpringBeanContainer"
      );
      if (useSecondLevelCache) {

        String configFile;
        try {
          configFile = new ClassPathResource("/ehcache3-test.xml").getURI().toString();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }

        applicationProperties = Stream.concat(applicationProperties, Stream.of(
            "spring.jpa.properties.hibernate.cache.factory_class=jcache",
            "spring.jpa.properties.hibernate.javax.cache.provider=org.ehcache.jsr107.EhcacheCachingProvider",
            "spring.jpa.properties.hibernate.javax.cache.uri=" + configFile
        ));
      }
      TestPropertyValues.of(applicationProperties).applyTo(configurableApplicationContext.getEnvironment());
    }
  }

  protected void thenVersionedEntityFieldsAreSet(BaseEntity entity) {
    Assertions.assertNotNull(entity.getCreatedAt());
    Assertions.assertNotNull(entity.getLastModifiedAt());
    Assertions.assertNotNull(entity.getCreatedBy());
    Assertions.assertNotNull(entity.getLastModifiedBy());
    Assertions.assertNotNull(entity.getVersion());
  }

}
