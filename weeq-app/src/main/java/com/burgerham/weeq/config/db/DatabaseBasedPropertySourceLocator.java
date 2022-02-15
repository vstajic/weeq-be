package com.burgerham.weeq.config.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Import(FlywayAutoConfiguration.class)
public class DatabaseBasedPropertySourceLocator implements PropertySourceLocator {

  @Override
  public PropertySource<?> locate(Environment environment) {

    try (HikariDataSource dataSource = new HikariDataSource(createHikariConfig(environment))) {
      List<DatabasePropertyEntity> entries = readAllEntriesFromDatabase(environment, dataSource);
      Map<String, Object> propertyMap = createPropertyMapRespectingProfileOrder(environment, entries);
      return new MapPropertySource("database-properties", propertyMap);
    }
  }

  private Map<String, Object> createPropertyMapRespectingProfileOrder(
      Environment environment, List<DatabasePropertyEntity> entries) {

    Map<String, Object> propertyMap = new HashMap<>();
    usePropertiesOfProfiles(new String[] { null }, entries, propertyMap);
    usePropertiesOfProfiles(environment.getDefaultProfiles(), entries, propertyMap);
    usePropertiesOfProfiles(environment.getActiveProfiles(), entries, propertyMap);
    return propertyMap;
  }

  private List<DatabasePropertyEntity> readAllEntriesFromDatabase(Environment environment, HikariDataSource dataSource) {

    JdbcTemplate t = new JdbcTemplate(dataSource);
    String appName = environment.getProperty("spring.application.name");
    String query = "select * from spring_property where application = '" + appName + "'";
    return t.query(query, new DatabasePropertyRowMapper());
  }

  private HikariConfig createHikariConfig(Environment environment) {

    HikariConfig cfg = new HikariConfig();
    cfg.setJdbcUrl(environment.getProperty("spring.datasource.url"));
    cfg.setUsername(environment.getProperty("spring.datasource.username"));
    cfg.setPassword(environment.getProperty("spring.datasource.password"));
    cfg.setMaximumPoolSize(1);
    cfg.setPoolName("spring-properties");
    cfg.setRegisterMbeans(true);
    return cfg;
  }

  private void usePropertiesOfProfiles(String[] profiles,
      List<DatabasePropertyEntity> entries, Map<String, Object> propertyMap) {

    if (profiles == null) {
      return;
    }
    for (String profile : profiles) {
      entries.stream()
          .filter(e -> Objects.equals(profile, e.getProfile()))
          .forEach(entry -> propertyMap.put(entry.getKey(), entry.getValue()));
    }
  }

  @Getter
  @Setter
  private static class DatabasePropertyEntity {

    private long id;
    private String application;
    private String key;
    private String value;
    private String profile;
  }

  private static class DatabasePropertyRowMapper implements RowMapper<DatabasePropertyEntity> {

    @Override
    public DatabasePropertyEntity mapRow(ResultSet rs, int i) throws SQLException {

      DatabasePropertyEntity entity = new DatabasePropertyEntity();
      entity.setId(rs.getLong("id"));
      entity.setApplication(rs.getString("application"));
      entity.setKey(rs.getString("key"));
      entity.setValue(rs.getString("value"));
      entity.setProfile(rs.getString("profile"));
      return entity;
    }
  }

}