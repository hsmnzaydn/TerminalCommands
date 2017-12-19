package hsmnzaydn.serkanozaydin.net.EventBus;

import hsmnzaydn.serkanozaydin.net.model.Category;

import java.util.List;

/**
 * Created by hsmnzaydn on 18.12.2017.
 */

public class CategoryListEvent {
    private List<Category> listOfCategory=null;

    public CategoryListEvent(List<Category> listOfCategory) {
        this.listOfCategory = listOfCategory;
    }

    public List<Category> getListOfCategory() {
        return listOfCategory;
    }

    public void setListOfCategory(List<Category> listOfCategory) {
        this.listOfCategory = listOfCategory;
    }
}
