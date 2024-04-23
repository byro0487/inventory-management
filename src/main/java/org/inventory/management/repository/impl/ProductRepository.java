package org.inventory.management.repository.impl;

import org.inventory.management.constants.ProductCategory;
import org.inventory.management.helpers.DBHelper;
import org.inventory.management.models.BaseModel;
import org.inventory.management.models.InventoryStore;
import org.inventory.management.models.Product;
import org.inventory.management.repository.interfaces.IRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.inventory.management.helpers.DBHelper.getConnection;


public class ProductRepository implements IRepository {
    private static final Logger logger = LoggerFactory.getLogger(InventoryStoreRepository.class);
    private static final String SELECT_QUERY = "SELECT * FROM PRODUCT WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO PRODUCT ( id,name, description, category, unit_price, supplier_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE PRODUCT SET name = ?, description = ?, category = ?, unit_price = ?, supplier_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM PRODUCT WHERE id = ?";

    @Override
    public BaseModel get(String id) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_QUERY)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Product product = Product.builder().build();
                product.setId(rs.getString("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setCategory(ProductCategory.valueOf(rs.getString("category")));
                product.setUnitPrice(rs.getDouble("unit_price"));
                product.setSupplierId(rs.getString("supplier_id"));
                return product;
            }
        } catch (SQLException e) {
            logger.error("Error occurred while retrieving Product with ID: {}", id, e);
        }
        return null;
    }

    @Override
    public BaseModel add(BaseModel model) {
        Product product =(Product) model;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY)) {
            stmt.setString(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setString(3, product.getDescription());
            stmt.setString(4, product.getCategory().toString());
            stmt.setDouble(5, product.getUnitPrice());
            stmt.setString(6, product.getSupplierId());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                return product;
            }
        } catch (SQLException e) {
            logger.error("Error occurred while adding Product: {}", model, e);
        }
        return null;
    }

    @Override
    public BaseModel update(BaseModel model) {
        Product product =(Product) model;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getCategory().toString());
            stmt.setDouble(4, product.getUnitPrice());
            stmt.setString(5, product.getSupplierId());
            stmt.setString(6, product.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                return model;
            }
        } catch (SQLException e) {
            logger.error("Error occurred while updating Product: {}", model, e);
        }
        return null;
    }

    @Override
    public void remove(String id) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_QUERY)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error occurred while removing Product with ID: {}", id, e);
        }
    }
}
