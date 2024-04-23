package org.inventory.management.repository.impl;

import org.inventory.management.models.BaseModel;
import org.inventory.management.models.StoreProduct;
import org.inventory.management.repository.interfaces.IRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.inventory.management.helpers.DBHelper.getConnection;

public class StoreProductRepository implements IRepository {
    private static final Logger logger = LoggerFactory.getLogger(StoreProductRepository.class);

    // SQL statements
    private static final String SELECT_QUERY = "SELECT * FROM store_product WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO store_product ( store_id, product_id, quantity) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE store_product SET store_id = ?, product_id = ?, quantity = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM store_product WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM store_product";

    @Override
    public StoreProduct get(String id) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_QUERY)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                StoreProduct storeProduct = StoreProduct.builder().build();
                storeProduct.setId(rs.getString("id"));
                storeProduct.setStoreId(rs.getString("store_id"));
                storeProduct.setProductId(rs.getString("product_id"));
                storeProduct.setQuantity(rs.getInt("quantity"));
                return storeProduct;
            }
        } catch (SQLException e) {
            logger.error("Error occurred while retrieving StoreProduct with ID: {}", id, e);
        }
        return null;
    }

    @Override
    public BaseModel add(BaseModel model) {
        StoreProduct storeProduct = (StoreProduct) model;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY)) {
            stmt.setString(1, storeProduct.getStoreId());
            stmt.setString(2, storeProduct.getProductId());
            stmt.setInt(3, storeProduct.getQuantity());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                return model;
            }
        } catch (SQLException e) {
            logger.error("Error occurred while adding StoreProduct: {}", storeProduct, e);
        }
        return null;
    }

    @Override
    public BaseModel update(BaseModel model) {
        StoreProduct storeProduct = (StoreProduct) model;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY)) {
            stmt.setString(1, storeProduct.getStoreId());
            stmt.setString(2, storeProduct.getProductId());
            stmt.setInt(3, storeProduct.getQuantity());
            stmt.setString(4, model.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                return model;
            }
        } catch (SQLException e) {
            logger.error("Error occurred while updating StoreProduct: {}", storeProduct, e);
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
            logger.error("Error occurred while removing StoreProduct with ID: {}", id, e);
        }
    }

    public List<StoreProduct> getAll() {
        List<StoreProduct> storeProducts = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                StoreProduct storeProduct = StoreProduct.builder().build();
                storeProduct.setId(rs.getString("id"));
                storeProduct.setStoreId(rs.getString("store_id"));
                storeProduct.setProductId(rs.getString("product_id"));
                storeProduct.setQuantity(rs.getInt("quantity"));
                storeProducts.add(storeProduct);
            }
        } catch (SQLException e) {
            logger.error("Error occurred while retrieving all StoreProducts", e);
        }
        return storeProducts;
    }

}
