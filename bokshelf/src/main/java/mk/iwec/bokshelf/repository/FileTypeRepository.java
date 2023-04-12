package mk.iwec.bokshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mk.iwec.bokshelf.domain.FileType;

public interface FileTypeRepository extends JpaRepository<FileType, Integer> {

}
