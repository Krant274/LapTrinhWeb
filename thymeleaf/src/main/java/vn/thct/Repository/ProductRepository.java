package vn.thct.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.thct.Entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByNameContaining(String name);
    Page<ProductEntity> findByNameContaining(String name, Pageable pageable);
}
