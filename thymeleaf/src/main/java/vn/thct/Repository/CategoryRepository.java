package vn.thct.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.thct.Entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
//Tàm Kiếm theo nội dung tên
	List<CategoryEntity> findByNameContaining(String name);

//Tàm kiếm và Phân trang
	Page<CategoryEntity> findByNameContaining(String name, Pageable pageable);
	
}