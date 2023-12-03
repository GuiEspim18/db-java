package br.com.designPatterns.dao;

import br.com.designPatterns.Product;

import java.util.List;

public interface ProductDAO {
    void save (Product product);

    List<Product> getAll();

    Product getById(int id);

    void update (Product product, int id);

    void delete(int id);
}
