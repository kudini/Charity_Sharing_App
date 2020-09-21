package pl.coderslab.charity.category.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.category.entity.Category;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> findAllCategories();
}
