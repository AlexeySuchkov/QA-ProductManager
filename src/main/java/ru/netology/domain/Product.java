package ru.netology.domain;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int id;
    private int price;
    private String name;

    public boolean matches(String search) {
        return this.getName().matches(search);
    }
}

