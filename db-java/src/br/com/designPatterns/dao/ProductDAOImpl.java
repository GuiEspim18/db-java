package br.com.designPatterns.dao;

import br.com.designPatterns.DbManeger;
import br.com.designPatterns.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO{
    private Connection connection;
    PreparedStatement preparedStatement = null;

    @Override
    public void save (Product product) {
        try {
            this.connection = DbManeger.getConnection();
            this.preparedStatement = this.connection.prepareStatement("INSERT INTO public.\"PRODUCTS\" (NAME, PRICE, QUANTITY) VALUES (?, ?, ?)");
            this.preparedStatement.setString(1, product.getName());
            this.preparedStatement.setString(2, product.getPrice());
            this.preparedStatement.setInt(3, product.getQuantity());
            this.preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                this.preparedStatement.close();
                this.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<Product>();
        ResultSet rs = null;
        try {
            this.connection = DbManeger.getConnection();
            this.preparedStatement = this.connection.prepareStatement("SELECT * FROM public.\"PRODUCTS\"");
            rs = this.preparedStatement.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("price"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                this.preparedStatement.close();
                this.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return products;
    }


    @Override
    public Product getById (int id) {
        Product product = new Product();
        ResultSet rs;
        try {
            this.connection = DbManeger.getConnection();
            this.preparedStatement = this.connection.prepareStatement("SELECT * FROM public.\"PRODUCTS\" WHERE ID = ?");
            this.preparedStatement.setInt(1, id);
            rs = this.preparedStatement.executeQuery();
            product = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("price"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                this.preparedStatement.close();
                this.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    @Override
    public void update(Product product, int id) {
        try {
            this.connection = DbManeger.getConnection();
            this.preparedStatement = this.connection.prepareStatement("UPDATE public.\"PRODUCTS\" SET PRICE = ?, QUANTITY = ?, NAME = ? WHERE ID = ?;");
            this.preparedStatement.setString(1, product.getPrice());
            this.preparedStatement.setInt(2, product.getQuantity());
            this.preparedStatement.setString(3, product.getName());
            this.preparedStatement.setInt(4, id);
            this.preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                this.preparedStatement.close();
                this.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        try {
            this.connection = DbManeger.getConnection();
            this.preparedStatement = this.connection.prepareStatement("DELETE FROM public.\"PRODUCTS\" WHERE ID = ?");
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                this.preparedStatement.close();
                this.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
