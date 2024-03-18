package chap05.common;

import java.io.Serializable;
import java.util.List;

public class CategoryAndMenuDTO implements Serializable {
    private int category_code;
    private String category_name;
    private int ref_category_code;
    private List<MenuDTO> menuList;

    public CategoryAndMenuDTO(){}

    public CategoryAndMenuDTO(int category_code, String category_name, int refCategoryCode, List<MenuDTO> menuList) {
        this.category_code = category_code;
        this.category_name = category_name;
        this.ref_category_code = refCategoryCode;
        this.menuList = menuList;
    }

    public int getCategory_code() {
        return category_code;
    }

    public void setCategory_code(int category_code) {
        this.category_code = category_code;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getRefCategoryCode() {
        return ref_category_code;
    }

    public void setRefCategoryCode(int refCategoryCode) {
        this.ref_category_code = refCategoryCode;
    }

    public List<MenuDTO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuDTO> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "CategoryAndMenuDTO{" +
                "category_code=" + category_code +
                ", category_name='" + category_name + '\'' +
                ", refCategoryCode=" + ref_category_code +
                ", menuList=" + menuList +
                '}';
    }
}
