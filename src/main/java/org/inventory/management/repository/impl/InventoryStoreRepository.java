package org.inventory.management.repository.impl;

import org.inventory.management.helpers.DBHelper;
import org.inventory.management.models.BaseModel;
import org.inventory.management.models.InventoryStore;
import org.inventory.management.repository.interfaces.IRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class InventoryStoreRepository implements IRepository {
    private static final Logger logger = LoggerFactory.getLogger(InventoryStoreRepository.class);

    // SQL statements
    private static final String SELECT_QUERY = "SELECT * FROM inventory_store WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO inventory_store ( inventory_id, store_id, manager_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE inventory_store SET inventory_id = ?, store_id = ?, manager_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM inventory_store WHERE id = ?";


    @Override
    public BaseModel get(String id) {
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_QUERY)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                InventoryStore inventoryStore = InventoryStore.builder().build();
                inventoryStore.setId(rs.getString("id"));
                inventoryStore.setInventoryId(rs.getString("inventory_id"));
                inventoryStore.setStoreId(rs.getString("store_id"));
                inventoryStore.setManagerId(rs.getString("manager_id"));
                return inventoryStore;
            }
        } catch (SQLException e) {
            logger.error("Error occurred while retrieving InventoryStore with ID: {}", id, e);
        }
        return null;
    }

    @Override
    public BaseModel add(BaseModel model) {
        InventoryStore inventoryStore = (InventoryStore) model;
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY)) {
            stmt.setString(1, inventoryStore.getInventoryId());
            stmt.setString(2, inventoryStore.getStoreId());
            stmt.setString(3, inventoryStore.getManagerId());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                return model;
            }
        } catch (SQLException e) {
            logger.error("Error occurred while adding InventoryStore with model: {}", inventoryStore, e);
        }
        return null;
    }

    @Override
    public BaseModel update(BaseModel model) {
        InventoryStore inventoryStore = (InventoryStore) model;
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY)) {
            stmt.setString(1, inventoryStore.getInventoryId());
            stmt.setString(2, inventoryStore.getStoreId());
            stmt.setString(3, inventoryStore.getManagerId());
            stmt.setString(4, model.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                return model;
            }
        } catch (SQLException e) {
            logger.error("Error occurred while updating InventoryStore with model: {}", inventoryStore, e);
        }
        return null;
    }

    @Override
    public void remove(String id) {
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_QUERY)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error occurred while deleting InventoryStore with id: {}", id, e);
        }
    }

}

