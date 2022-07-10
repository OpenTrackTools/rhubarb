package org.rhubarb.domain.models.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.rhubarb.domain.models.commons.BaseEntity;

import java.io.Serial;

/**
 * @author Arpan Mukhopadhyay
 */
@Entity
@Table(name = "app_database", indexes = {@Index(name = "index_name_on_database", columnList = "name", unique = true)})
@Getter
@Setter
public class DataBase extends BaseEntity {
  
  @Serial
  private static final long serialVersionUID = 5302495299890073160L;
  
  @NaturalId
  @Column(name = "object_id", nullable = false, unique = true)
  private String objectId;
  
  @Column(name = "name", nullable = false)
  private String name;
  
  @Column(name = "visibility", nullable = false)
  private Visibility visibility = Visibility.PUBLIC;
  
  @Column(name = "description")
  private String description;
  
  @Column(name = "note")
  private String note;
  
  @Column(name = "short_code")
  private String shortCode;
}
