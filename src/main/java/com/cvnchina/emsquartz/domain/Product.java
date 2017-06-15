/********************** 版权声明 *************************
 * 文件名: Product.java
 * 包名: com.cvnchina.emsquartz.domain
 * 版权:	杭州华量软件  EMSQuartz
 * 职责: 
 ********************************************************
 *
 * 创建者：Primo  创建时间：2017/6/15
 * 文件版本：V1.0
 *
 *******************************************************/
package com.cvnchina.emsquartz.domain;

import org.apache.ibatis.type.Alias;

@Alias("Product")
public class Product {
    private Integer id;
    private String name;
    private String description;
    private String ingredient_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }
}
