package ru.mulla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mulla.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleById(long id);
}
