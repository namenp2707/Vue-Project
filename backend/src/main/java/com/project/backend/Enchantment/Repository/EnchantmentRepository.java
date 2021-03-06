package com.project.backend.Enchantment.Repository;

import com.project.backend.Enchantment.Entity.Enchantment;
import java.util.Collection;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
public interface EnchantmentRepository extends JpaRepository<Enchantment, Long> {
    Enchantment findById(long id);
}