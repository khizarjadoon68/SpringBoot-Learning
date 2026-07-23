package in.strikes.E_CommerceProductManagement.controller;

import in.strikes.E_CommerceProductManagement.dto.CreateProductRequestDto;
import in.strikes.E_CommerceProductManagement.dto.ProductResponseDto;
import in.strikes.E_CommerceProductManagement.dto.UpdateProductRequestDto;
import in.strikes.E_CommerceProductManagement.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/products")
public class ProductController {

    private ProductService productService ;

    public ProductController (ProductService productService){
        this.productService = productService ;
    }

    @PostMapping ("/create")
    public ResponseEntity<ProductResponseDto> create (
            @Valid
            @RequestBody CreateProductRequestDto createProductRequestDto){

       ProductResponseDto responseDto = productService.create(createProductRequestDto);
       return ResponseEntity.
               status(HttpStatus.CREATED)
               .body(responseDto);

    }

    @GetMapping ("/get/{id}")
    public ResponseEntity<ProductResponseDto> getById (@PathVariable Long id){
          ProductResponseDto responseDto = productService.getById(id);
        return ResponseEntity.ok(responseDto) ;

    }

    @GetMapping ("/getAll")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts (){
        List<ProductResponseDto> productResponseDto = productService.getAllProducts();
        return ResponseEntity.ok(productResponseDto) ;
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(
            @PathVariable Long id ,
            @Valid @RequestBody  UpdateProductRequestDto updateProductRequestDto ){

        ProductResponseDto responseDto = productService.updateProduct(id , updateProductRequestDto);

        return ResponseEntity.ok(responseDto);

    }

    @DeleteMapping ("hardDelete/{id}")
    public ResponseEntity<String> deleteProduct (@PathVariable Long id ){

        productService.deleteProduct(id);
        return ResponseEntity.ok("Product permanently deleted successfully.");
    }

    @PatchMapping ("softDelete/{id}")
    public ResponseEntity<String> softDeleteProduct (@PathVariable Long id ){

        productService.softDeleteProduct(id);
        return ResponseEntity.ok("Product soft deleted successfully.");
    }


}
