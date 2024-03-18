package chap05.common;

import java.io.Serializable;

public class MenuAndCategoryDTO implements Serializable {
    private int code;
    private String name;
    private int price;
    private String orderableStatus;
    private CategoryDTO category;

    public MenuAndCategoryDTO(){}
    public MenuAndCategoryDTO(int code, String name, int price, String orderableStatus, CategoryDTO category) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.orderableStatus = orderableStatus;
        this.category = category;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "MenuAndCategoryDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", orderableStatus='" + orderableStatus + '\'' +
                ", category=" + category +
                '}';
    }
}
