package pl.coderslab.charity.category.dto;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.category.entity.Category;

@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String name;

    public CategoryDto() {
    }

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
