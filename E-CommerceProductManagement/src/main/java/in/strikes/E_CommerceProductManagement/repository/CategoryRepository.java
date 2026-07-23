package in.strikes.E_CommerceProductManagement.repository;

import in.strikes.E_CommerceProductManagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Long> {

    Optional<Category> findByIdAndIsDeletedFalse(Long id);

    List<Category> findByIsDeletedFalse();

}
