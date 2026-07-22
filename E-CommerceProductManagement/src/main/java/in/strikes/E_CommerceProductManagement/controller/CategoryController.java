package in.strikes.E_CommerceProductManagement.controller;

import in.strikes.E_CommerceProductManagement.dto.CategoryResponseDto;
import in.strikes.E_CommerceProductManagement.dto.CreateCategoryRequestDto;
import in.strikes.E_CommerceProductManagement.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/categories")
public class CategoryController {

    private CategoryService categoryService ;

    public CategoryController (CategoryService categoryService){
        this.categoryService = categoryService ;
    }

    @PostMapping ("/create")
    public ResponseEntity<CategoryResponseDto> create (
            @Valid @RequestBody CreateCategoryRequestDto categoryRequestDto){

        CategoryResponseDto responseDto =
                categoryService.create(categoryRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto) ;
    }

    @GetMapping ("/get/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById (@PathVariable long id ){

       CategoryResponseDto responseDto = categoryService.getById(id);
       return ResponseEntity.ok(responseDto);
    }

    @GetMapping ("/getAll")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories (){
        List<CategoryResponseDto> responseDtoList = categoryService.getAllCategories();
        return ResponseEntity.ok(responseDtoList);
    }

}
