package in.strikes.E_CommerceProductManagement.dto;

import jakarta.validation.constraints.NotBlank;

public class UpdateCategoryRequestDto {

    @NotBlank(message = "Category name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    public UpdateCategoryRequestDto(){}
    public UpdateCategoryRequestDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
