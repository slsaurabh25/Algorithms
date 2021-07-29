package Sorting;

import java.util.List;

public class Store {
    private String menuItemId;
    private String displayName;
    private String description;
    private String ingredientDeclaration;
    private String imageURL;
    private String packOptions;
    private List<String> tags;
    private List<Integer> storeId;
    private Integer displayOrder;
    private String parentCategory;
    private Boolean requireBottleDeposit;


    public String getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(final String menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getIngredientDeclaration() {
        return ingredientDeclaration;
    }

    public void setIngredientDeclaration(final String ingredientDeclaration) {
        this.ingredientDeclaration = ingredientDeclaration;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(final String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPackOptions() {
        return packOptions;
    }

    public void setPackOptions(final String packOptions) {
        this.packOptions = packOptions;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(final List<String> tags) {
        this.tags = tags;
    }

    public List<Integer> getStoreId() {
        return storeId;
    }

    public void setStoreId(final List<Integer> storeId) {
        this.storeId = storeId;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(final Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(final String parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Boolean getRequireBottleDeposit() {
        return requireBottleDeposit;
    }

    public void setRequireBottleDeposit(final Boolean requireBottleDeposit) {
        this.requireBottleDeposit = requireBottleDeposit;
    }
}
