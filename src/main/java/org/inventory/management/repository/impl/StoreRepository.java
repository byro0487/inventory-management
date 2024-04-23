package org.inventory.management.repository.impl;

import org.inventory.management.constants.EntityStatus;
import org.inventory.management.models.BaseModel;
import org.inventory.management.models.Store;
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

public class StoreRepository implements IRepository {
    private static final Logger logger = LoggerFactory.getLogger(StoreRepository.class);

    // SQL statements
    private static final String SELECT_QUERY = "SELECT * FROM store WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO store ( name, area, status, location_id, manager_id, inventory_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE store SET name = ?, area = ?, status = ?, location_id = ?, manager_id = ?, inventory_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM store WHERE id = ?";
    @Override
    public Store get(String id) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_QUERY)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Store store = Store.builder().build();
                store.setId(rs.getString("id"));
                store.setName(rs.getString("name"));
                store.setArea(rs.getDouble("area"));
                store.setStatus(EntityStatus.valueOf(rs.getString("status")));
                store.setLocationId(rs.getString("location_id"));
                store.setManagerId(rs.getString("manager_id"));
                store.setInventoryId(rs.getString("inventory_id"));
                return store;
            }
        } catch (SQLException e) {
            logger.error("Error occurred while retrieving Store with ID: {}", id, e);
        }
        return null;
    }

    @Override
    public BaseModel add(BaseModel model) {
        Store store = (Store) model;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY)) {
            stmt.setString(1, store.getId());
            stmt.setString(2, store.getName());
            stmt.setDouble(3, store.getArea());
            stmt.setString(4, store.getStatus().toString());
            stmt.setString(5, store.getLocationId());
            stmt.setString(6, store.getManagerId());
            stmt.setString(7, store.getInventoryId());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                return model;
            }
        } catch (SQLException e) {
            logger.error("Error occurred while adding Store: {}", store, e);
        }
        return null;
    }

    @Override
    public BaseModel update(BaseModel model) {
        Store store = (Store) model;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY)) {
            stmt.setString(1, store.getName());
            stmt.setDouble(2, store.getArea());
            stmt.setString(3, store.getStatus().toString());
            stmt.setString(4, store.getLocationId());
            stmt.setString(5, store.getManagerId());
            stmt.setString(6, store.getInventoryId());
            stmt.setString(7, store.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                return model;
            }
        } catch (SQLException e) {
            logger.error("Error occurred while updating Store: {}", store, e);
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
            logger.error("Error occurred while removing Store with ID: {}", id, e);
        }
    }
}
