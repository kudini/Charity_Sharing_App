package pl.coderslab.charity.category.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.category.entity.Category;
import pl.coderslab.charity.category.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }

}
