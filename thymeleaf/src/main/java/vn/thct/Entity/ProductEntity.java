package vn.thct.Entity;

public class ProductEntity {
	private Long categoryId;
	private String name;

	public ProductEntity() {
		super();
	}

	public ProductEntity(Long categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "ProductEntity [categoryId=" + categoryId + ", name=" + name + "]";
	}

}
