package in.strikes.E_CommerceProductManagement.repository;

import in.strikes.E_CommerceProductManagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product ,Long> {

    Optional<Product> findByIdAndIsDeletedFalse(Long id);

    List<Product> findByIsDeletedFalse();

}
