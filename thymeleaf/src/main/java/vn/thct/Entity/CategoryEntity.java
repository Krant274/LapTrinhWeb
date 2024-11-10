package vn.thct.Entity;

import java.io.Serializable;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "Categories")
public class CategoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name = "category_name", length = 200, columnDefinition = "nvarchar(200) not null")
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<ProductEntity> products;

    // No-argument constructor
    public CategoryEntity() {
    }

    // All-argument constructor
    public CategoryEntity(Long categoryId, String name, Set<ProductEntity> products) {
        this.categoryId = categoryId;
        this.name = name;
        this.products = products;
    }

    // Getters and Setters
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }

    // Optional: Override toString, equals, and hashCode methods if needed
}
