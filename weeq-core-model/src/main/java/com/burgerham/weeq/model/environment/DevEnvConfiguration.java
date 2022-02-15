package com.burgerham.weeq.model.environment;

import com.burgerham.weeq.model.common.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "dev_env_configuration")
public class DevEnvConfiguration extends BaseEntity {

  @Column(name = "env_id")
  private String environmentId;

  @Enumerated(EnumType.STRING)
  @Column(name = "state")
  private DevEnvironmentConfigurationState state;

  @Column(name = "details")
  private String details;

}
