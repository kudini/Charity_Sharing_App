package pl.coderslab.charity.category.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.category.dto.CategoryDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category() {
    }

    public Category(CategoryDto categoryDto) {
        this.id = categoryDto.getId();
        this.name = categoryDto.getName();
    }
}
