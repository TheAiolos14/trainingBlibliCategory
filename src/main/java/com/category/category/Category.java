package com.category.category;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //Constructor yang ada isinya
@NoArgsConstructor
public class Category {

    private String categoryId;
    private String categoryName;
}
