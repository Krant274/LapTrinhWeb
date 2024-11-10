package vn.thct.Controller.admin;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.thct.Model.CategoryModel;
import vn.thct.Model.ProductModel;
import vn.thct.Service.ICategoryService;
import vn.thct.Service.IProductService;
import vn.thct.Service.IStorageService;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
	@Autowired
	ICategoryService categoryService;
	@Autowired
	IProductService productService;
	@Autowired
	IStorageService storageService;

	@ModelAttribute("categories")
	public List<CategoryModel> getCategories() {
		return categoryService.findAll().stream().map(item -> {
			CategoryModel cateModel = new CategoryModel();
			BeanUtils.copyProperties(item, cateModel);
			return cateModel;
		}).toList();
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		ProductModel proModel = new ProductModel();
		proModel.setIsEdit(false);
		// chuyển dữ liệu từ model vào biến product để đưa lên view
		model.addAttribute("product", proModel);
		return "admin/products/addOrEdit";
	}
}
