package com.project.backend.Rune.Repository;

import com.project.backend.Rune.Entity.TypeRune;
import java.util.Collection;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
public interface TypeRuneRepository extends JpaRepository<TypeRune, Long> {
    TypeRune findById(long id);
}