package net.restapp.repository;

import net.restapp.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryContract  extends JpaRepository<Contract, Long> {
}
