package net.restapp.repository;

import net.restapp.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDocument  extends JpaRepository<Document, Long> {
}
