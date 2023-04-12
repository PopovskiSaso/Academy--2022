package mk.iwec.bokshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mk.iwec.bokshelf.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
