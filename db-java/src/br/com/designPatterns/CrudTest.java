package br.com.designPatterns;

import br.com.designPatterns.dao.ProductDAO;
import br.com.designPatterns.dao.ProductDAOImpl;

import java.util.List;

public class CrudTest {

    public static void main(String[] args) {
        try {
            // chamando o nosso dao implementando
            final ProductDAO productDAO = new ProductDAOImpl();

            // chamando a classe produto
            Product product = new Product();
            product.setName("Limão");
            product.setPrice("10.00");
            product.setQuantity(12);


            // salvando
            // productDAO.save(product);

            // product.setQuantity(18);
            // productDAO.update(product, 1);

            List<Product> products = productDAO.getAll();

            // for com variável item dentro de product ele pega cada um deles e transforma em string
            for (Product item : products) {
                System.out.println(item.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
