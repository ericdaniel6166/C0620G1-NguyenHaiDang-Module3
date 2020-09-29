package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "chair", 320000, "abc def", "ABC"));
        products.put(2, new Product(2, "bhair", 420000, "bbc def", "BBC"));
        products.put(3, new Product(3, "dhair", 520000, "cbc def", "CBC"));
        products.put(4, new Product(4, "ehair", 620000, "dbc def", "DBC"));
        products.put(5, new Product(5, "fhair", 720000, "ebc def", "EBC"));
        products.put(6, new Product(6, "ghair", 820000, "fbc def", "FBC"));
        products.put(7, new Product(7, "chair", 9120000, "fbc def", "FBC"));
        products.put(8, new Product(8, "chair", 8340000, "fbc def", "FBC"));
        products.put(9, new Product(9, "bhair", 82333000, "fbc def", "FBC"));
        products.put(10, new Product(9, null, 82333000, "fbc def", "FBC"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();

//        Tìm kiếm chính xác tên dùng .equals()
//        *********
//        for (Integer key : products.keySet()) {
//            if (name.equals(products.get(key).getName())) {
//                productList.add(products.get(key));
//            }
//        }
//        *********

//        Tìm kiếm tên chứa dùng .contains()
//        ***********
        for (Integer key : products.keySet()) {
            if (products.get(key).getName() == null) {
                continue;
            }
            if (products.get(key).getName().contains(name)) {
                productList.add(products.get(key));
            }
        }
//        ********

        return productList;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
