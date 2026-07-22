package in.strikes.E_CommerceProductManagement.repository;

import in.strikes.E_CommerceProductManagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Long> {

}
