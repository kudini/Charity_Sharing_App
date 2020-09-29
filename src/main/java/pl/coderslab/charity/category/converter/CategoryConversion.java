package pl.coderslab.charity.category.converter;

import pl.coderslab.charity.category.dto.CategoryDto;
import pl.coderslab.charity.category.entity.Category;

public class CategoryConversion {
    public static Category convertCategoryDtoToCategory(CategoryDto categoryDto){
        return new Category(categoryDto);
    }  
    public static CategoryDto convertCategoryToCategoryDto(Category category){
        return new CategoryDto(category);
    }
}
