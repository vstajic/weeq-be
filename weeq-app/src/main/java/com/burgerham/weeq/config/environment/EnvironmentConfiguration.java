package com.burgerham.weeq.config.environment;

import com.burgerham.weeq.business.environment.DevEnvConfigurationRepository;
import com.burgerham.weeq.model.environment.DevEnvironmentConfigurationState;
import com.burgerham.weeq.model.environment.DevEnvConfiguration;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

@Slf4j
public abstract class EnvironmentConfiguration {

  @Autowired
  private DevEnvConfigurationRepository devEnvConfigurationRepository;

  @Autowired
  private TransactionTemplate transactionTemplate;

  @PostConstruct
  public void initStartup() {
    transactionTemplate.executeWithoutResult(transactionStatus -> createCoreDataInOneTransaction());
  }

  private void createCoreDataInOneTransaction() {
    DevEnvConfiguration devEnvConfiguration = devEnvConfigurationRepository.findByEnvironmentId(getIdentifier());
    if (devEnvConfiguration == null) {
      devEnvConfiguration = new DevEnvConfiguration();
      devEnvConfiguration.setEnvironmentId(getIdentifier());
    }

    if (devEnvConfiguration.getState() != null) {
      log.warn("===================== SKIPPING AS ALREADY ATTEMPTED: " + getIdentifier());
    } else {
      Throwable error = null;
      try {
        log.info("===================== STARTING CREATION PROCESS: " + getIdentifier());
        createCoreData();
        log.info("===================== CREATION PROCESS FINISHED =====================");
      } catch (final Exception e) {
        error = e;
        throw new IllegalStateException(e);
      } finally {
        if (error != null) {
          devEnvConfiguration.setState(DevEnvironmentConfigurationState.FAILED);
          devEnvConfiguration.setDetails(error.getMessage());
        } else {
          devEnvConfiguration.setState(DevEnvironmentConfigurationState.FINISHED);
          devEnvConfiguration.setDetails(null);
        }
        devEnvConfigurationRepository.save(devEnvConfiguration);
      }
    }
  }

  /**
   * Creates core data.
   */
  protected abstract void createCoreData();

  private String getIdentifier() {
    return getClass().getSimpleName();
  }

}