package vn.thct.Controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.thct.Entity.CategoryEntity;
import vn.thct.Model.CategoryModel;
import vn.thct.Service.ICategoryService;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {
	@Autowired
	ICategoryService categoryService;

	@GetMapping("add")
	public String add(ModelMap model) {
		CategoryModel cateModel = new CategoryModel();
		cateModel.setIsEdit(false);
//chuyển dữ liệu từ model vào biến category để đưa lên view
		model.addAttribute("category", cateModel);
		return "admin/categories/addOrEdit";

	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("category") CategoryModel cateModel,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin/categories/addOrEdit");
		}

		CategoryEntity entity = new CategoryEntity();
		// Copy properties from Model to Entity
		BeanUtils.copyProperties(cateModel, entity);

		// Call save method in service
		categoryService.save(entity);

		// Prepare success message
		String message;
		if (cateModel.getIsEdit()) {
			message = "Category is Edited !!!!!!!! ";
		} else {
			message = "Category is saved !!!!!!!! ";
		}

		model.addAttribute("message", message);

		// Redirect to searchpaginated page
		return new ModelAndView("forward:/admin/categories/searchpaginated", model);
	}

	@RequestMapping("")
	public String list(ModelMap model) {
		// goi hàm findAll() trong service
		List<CategoryEntity> list = categoryService.findAll();
		// chuyển dữ liệu từ list lên bien categories
		model.addAttribute("categories", list);
		return "admin/categories/list";
	}

	@GetMapping("edit/{categoryId}")
	public ModelAndView edit(ModelMap model, @PathVariable("categoryId") Long categoryId) {
		Optional<CategoryEntity> optCategory = categoryService.findById(categoryId);
		CategoryModel cateModel = new CategoryModel();

		// Check if the category exists
		if (optCategory.isPresent()) {
			CategoryEntity entity = optCategory.get();
			// Copy properties from entity to cateModel
			BeanUtils.copyProperties(entity, cateModel);
			cateModel.setIsEdit(true);
			// Add the category to the model for the view
			model.addAttribute("category", cateModel);
			return new ModelAndView("admin/categories/addOrEdit", model);
		} else {
			model.addAttribute("message", "Category does not exist !!!! ");
			return new ModelAndView("forward:/admin/categories", model); // Redirect if the category does not exist
		}
	}

	@GetMapping("delete/{categoryId}")
	public ModelAndView delet(ModelMap model, @PathVariable("categoryId") Long categoryId) {
		categoryService.deleteById(categoryId);
		model.addAttribute("message", "Category is deleted !!!! ");
		return new ModelAndView("forward:/admin/categories/searchpaginated", model);
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
		List<CategoryEntity> list = null;
		// có nội dung truyền ve không, name là tuy chon khi required=false
		if (StringUtils.hasText(name)) {
			list = categoryService.findByNameContaining(name);
		} else {
			list = categoryService.findAll();
		}
		model.addAttribute("categories", list);
		return "admin/categories/search";
	}

	@RequestMapping("searchpaginated")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		int count = (int) categoryService.count();
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(3);
		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("name"));
		Page<CategoryEntity> resultPage;

		if (StringUtils.hasText(name)) {
			resultPage = categoryService.findByNameContaining(name, pageable);
			model.addAttribute("name", name);
		} else {
			resultPage = categoryService.findAll(pageable);
		}

		int totalPages = resultPage.getTotalPages();
		if (totalPages > 0) {
			int start = Math.max(1, currentPage - 2);
			int end = Math.min(currentPage + 2, totalPages);
			if (totalPages > count) {
				if (end == totalPages) {
					start = end - count;
				} else if (start == 1) {
					end = start + count;
				}
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
			model.addAttribute("categoryPage", resultPage);
		}

		// Ensure that you return a String for this method
		return "admin/categories/searchpaginated"; // Return the view name
	}

}
