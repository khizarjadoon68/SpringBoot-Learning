package in.strikes.E_CommerceProductManagement.service;

import in.strikes.E_CommerceProductManagement.dto.CreateProductRequestDto;
import in.strikes.E_CommerceProductManagement.dto.ProductResponseDto;
import in.strikes.E_CommerceProductManagement.dto.UpdateProductRequestDto;
import in.strikes.E_CommerceProductManagement.entity.Category;
import in.strikes.E_CommerceProductManagement.entity.Product;
import in.strikes.E_CommerceProductManagement.repository.CategoryRepository;
import in.strikes.E_CommerceProductManagement.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private  ProductRepository productRepository ;
    private CategoryRepository categoryRepository ;
    public ProductService (ProductRepository productRepository ,
                           CategoryRepository categoryRepository){
        this.productRepository = productRepository ;
        this.categoryRepository = categoryRepository ;

    }

    public ProductResponseDto create(@Valid CreateProductRequestDto createProductRequestDto) {

        Category category = categoryRepository.findByIdAndIsDeletedFalse(
                createProductRequestDto.getCategoryId())
                .orElseThrow(()->
                        new RuntimeException("Category Not Found") ) ;

        Product product = new Product();

        product.setName(createProductRequestDto.getName());
        product.setDescription(createProductRequestDto.getDescription());
        product.setPrice(createProductRequestDto.getPrice());
        product.setQuantity(createProductRequestDto.getQuantity());
        product.setBrand(createProductRequestDto.getBrand());
        product.setAvailable(createProductRequestDto.getAvailable());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);

        ProductResponseDto responseDto = new ProductResponseDto();

        responseDto.setId(savedProduct.getId());
        responseDto.setName(savedProduct.getName());
        responseDto.setDescription(savedProduct.getDescription());
        responseDto.setPrice(savedProduct.getPrice());
        responseDto.setQuantity(savedProduct.getQuantity());
        responseDto.setBrand(savedProduct.getBrand());
        responseDto.setAvailable(savedProduct.getAvailable());
        responseDto.setCategoryName(savedProduct.getCategory().getName());
        responseDto.setCreatedAt(savedProduct.getCreatedAt());
        responseDto.setUpdatedAt(savedProduct.getUpdatedAt());

        return responseDto ;

    }

    public ProductResponseDto getById(Long id) {

       Product product =  productRepository.findByIdAndIsDeletedFalse(id)
               .orElseThrow(()->new RuntimeException("Product Not Found"));

       ProductResponseDto responseDto = new ProductResponseDto();

        responseDto.setId(product.getId());
        responseDto.setName(product.getName());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
        responseDto.setQuantity(product.getQuantity());
        responseDto.setBrand(product.getBrand());
        responseDto.setAvailable(product.getAvailable());
        responseDto.setCategoryName(product.getCategory().getName());
        responseDto.setCreatedAt(product.getCreatedAt());
        responseDto.setUpdatedAt(product.getUpdatedAt());

        return responseDto;

    }

    public List<ProductResponseDto> getAllProducts() {

        List<Product> products = productRepository.findByIsDeletedFalse();

        List<ProductResponseDto> responseDtoList = new ArrayList<>();

        for (Product product : products){

            ProductResponseDto responseDto = new ProductResponseDto();

            responseDto.setId(product.getId());
            responseDto.setName(product.getName());
            responseDto.setDescription(product.getDescription());
            responseDto.setPrice(product.getPrice());
            responseDto.setQuantity(product.getQuantity());
            responseDto.setBrand(product.getBrand());
            responseDto.setAvailable(product.getAvailable());
            responseDto.setCategoryName(product.getCategory().getName());
            responseDto.setCreatedAt(product.getCreatedAt());
            responseDto.setUpdatedAt(product.getUpdatedAt());

            responseDtoList.add(responseDto);

        }

        return responseDtoList ;
    }

    public ProductResponseDto updateProduct(
            Long id ,
            @Valid UpdateProductRequestDto updateProductRequestDto) {

        Product product = productRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(()->
                        new RuntimeException("Product Not Found ."));

        Category category = categoryRepository.findByIdAndIsDeletedFalse(updateProductRequestDto.getCategoryId())
                .orElseThrow(()->
                        new RuntimeException("Category Not Found ."));

        product.setName(updateProductRequestDto.getName());
        product.setDescription(updateProductRequestDto.getDescription());
        product.setPrice(updateProductRequestDto.getPrice());
        product.setQuantity(updateProductRequestDto.getQuantity());
        product.setBrand(updateProductRequestDto.getBrand());
        product.setAvailable(updateProductRequestDto.getAvailable());
        product.setCategory(category);
        product.setUpdatedAt(LocalDateTime.now());

        Product updatedProduct = productRepository.save(product);

        ProductResponseDto responseDto = new ProductResponseDto();

        responseDto.setId(updatedProduct.getId());
        responseDto.setName(updatedProduct.getName());
        responseDto.setDescription(updatedProduct.getDescription());
        responseDto.setPrice(updatedProduct.getPrice());
        responseDto.setQuantity(updatedProduct.getQuantity());
        responseDto.setBrand(updatedProduct.getBrand());
        responseDto.setAvailable(updatedProduct.getAvailable());
        responseDto.setCategoryName(updatedProduct.getCategory().getName());
        responseDto.setCreatedAt(updatedProduct.getCreatedAt());
        responseDto.setUpdatedAt(updatedProduct.getUpdatedAt());

        return  responseDto ;
    }

    public void deleteProduct(Long id) {

        Product product = productRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(()->
                        new RuntimeException("Product Not Found ."));

        productRepository.delete(product);

    }

    public void softDeleteProduct(Long id) {

        Product product = productRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(()->
                        new RuntimeException("Product Not Found ."));


        product.setIsDeleted(true);
        product.setUpdatedAt(LocalDateTime.now());

        productRepository.save(product);
    }
}
