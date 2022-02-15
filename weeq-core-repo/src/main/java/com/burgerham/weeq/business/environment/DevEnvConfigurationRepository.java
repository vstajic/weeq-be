package com.burgerham.weeq.business.environment;

import com.burgerham.weeq.model.environment.DevEnvConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
@Repository
public interface DevEnvConfigurationRepository extends JpaRepository<DevEnvConfiguration, Long> {

  DevEnvConfiguration findByEnvironmentId(String environmentId);

}