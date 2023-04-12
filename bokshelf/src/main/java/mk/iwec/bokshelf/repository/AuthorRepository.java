package mk.iwec.bokshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.Entity;
import mk.iwec.bokshelf.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
