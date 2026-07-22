package in.strikes.E_CommerceProductManagement.service;

import in.strikes.E_CommerceProductManagement.dto.CategoryResponseDto;
import in.strikes.E_CommerceProductManagement.dto.CreateCategoryRequestDto;
import in.strikes.E_CommerceProductManagement.entity.Category;
import in.strikes.E_CommerceProductManagement.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponseDto create(CreateCategoryRequestDto categoryRequestDto) {

        Category category = new Category();

        category.setName(categoryRequestDto.getName());
        category.setDescription(categoryRequestDto.getDescription());
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());


        Category savedCategory = categoryRepository.save(category);

        CategoryResponseDto responseDto = new CategoryResponseDto();

        responseDto.setId(savedCategory.getId());
        responseDto.setName(savedCategory.getName());
        responseDto.setDescription(savedCategory.getDescription());

        return responseDto;
    }

    public CategoryResponseDto getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new  RuntimeException ("Category Not Fond"));

        CategoryResponseDto responseDto = new CategoryResponseDto() ;
        responseDto.setId(category.getId());
        responseDto.setName(category.getName());
        responseDto.setDescription(category.getDescription());
        responseDto.setCreatedAt(category.getCreatedAt());
        responseDto.setUpdatedAt(category.getUpdatedAt());

        return responseDto;

    }

    public List<CategoryResponseDto> getAllCategories() {

        List<Category> categories = categoryRepository.findAll() ;

        List<CategoryResponseDto> responseDtoList = new ArrayList<>();

        for (Category category : categories ){

            CategoryResponseDto responseDto = new CategoryResponseDto() ;

            responseDto.setId(category.getId());
            responseDto.setName(category.getName());
            responseDto.setDescription(category.getDescription());
            responseDto.setCreatedAt(category.getCreatedAt());
            responseDto.setUpdatedAt(category.getUpdatedAt());

            responseDtoList.add(responseDto);

        }

        return responseDtoList ;
    }
}