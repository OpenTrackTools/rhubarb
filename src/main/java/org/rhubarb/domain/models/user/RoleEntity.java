package org.rhubarb.domain.models.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.annotations.NaturalId;
import org.rhubarb.domain.models.commons.BaseEntity;

import java.io.Serial;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

/**
 * @author Arpan Mukhopadhyay
 */
@Entity
@Table(name = "roles", indexes = {
    @Index(name = "name_on_role", columnList = "name", unique = true)
})
@Getter
@Setter
@NoArgsConstructor
public class RoleEntity extends BaseEntity {
  
  @Serial
  private static final long serialVersionUID = -3802764072875827008L;
  
  @NaturalId
  @Column(name = "object_id", nullable = false, unique = true)
  private String objectId;
  
  @Column(name = "name", nullable = false)
  private String name;
  
  @Column(name = "description")
  private String description;
  
  @Column(name = "key", length = 8, unique = true)
  private String key;
  
  @ManyToMany(mappedBy = "roles")
  private Collection<UserEntity> users;
  
  public RoleEntity(@NotBlank String name, String description, String key) {
    this.objectId = RandomStringUtils.randomAlphanumeric(6);
    this.name = name;
    this.description = description;
    this.key = key;
    this.setCreatedAt(new Date());
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    RoleEntity that = (RoleEntity) o;
    
    if (!key.equals(that.getKey())) return false;
    return name.equals(that.name);
  }
  
  /**
   * Returns the count of total users with this role.
   * @return the count
   */
  public int totalUsers() {
    return users.size();
  }
  
  @Override
  public String toString() {
    return String.format("Role<name=%s>", this.name);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(name, key);
  }
}
