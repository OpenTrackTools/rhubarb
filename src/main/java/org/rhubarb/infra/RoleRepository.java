package org.rhubarb.infra;

import org.rhubarb.domain.models.user.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Arpan Mukhopadhyay
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
