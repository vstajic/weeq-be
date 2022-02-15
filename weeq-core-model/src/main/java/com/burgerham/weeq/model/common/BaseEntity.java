package com.burgerham.weeq.model.common;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;

@Getter
@Setter

@MappedSuperclass
public abstract class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Version
  private Integer version;

  @Column(name = "created_at")
  private Instant createdAt;

  @Column(name = "last_modified_at")
  private Instant lastModifiedAt;

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "last_modified_by")
  private String lastModifiedBy;

  @PrePersist
  protected void prePersist() {
    if (this.createdAt == null) createdAt = Instant.now();
    if (this.lastModifiedAt == null) lastModifiedAt = Instant.now();
    if (this.createdBy == null) createdBy = getPerformer();
    if (this.lastModifiedBy == null) lastModifiedBy = getPerformer();
  }

  @PreUpdate
  protected void preUpdate() {
    this.lastModifiedAt = Instant.now();
    this.lastModifiedBy = getPerformer();
  }

  @PreRemove
  protected void preRemove() {
    this.lastModifiedBy = getPerformer();
  }

  private static String getPerformer() {
    String creator;
    if (SecurityContextHolder.getContext().getAuthentication() == null) {
      creator = "SYSTEM";
    } else {
      creator = SecurityContextHolder.getContext().getAuthentication().getName();
    }
    return creator;
  }

}
