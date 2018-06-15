package net.serkanozaydin.hsmnzaydn.terminalcommands.EventBus;

import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Category;

/**
 * Created by hsmnzaydn on 6/15/18.
 */

public class CategoryEvent {
    private Category category;

    public CategoryEvent(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
