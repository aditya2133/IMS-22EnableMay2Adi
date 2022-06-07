package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.ItemOrders;
import com.qa.ims.utils.DBUtils;

public class ItemOrdersDAO implements Dao<ItemOrders>{

	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public ItemOrders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderItemId = resultSet.getLong("orderitems_id");
		Long orderId = resultSet.getLong("order_id");
		Long itemId = resultSet.getLong("item_id");
		Long itemQuantity = (long) resultSet.getInt("item_quantity");
		return new ItemOrders(orderItemId, orderId, itemId, itemQuantity);
	
	}
	
	
	@Override
	public List<ItemOrders> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items");) {
			List<ItemOrders> itemorders = new ArrayList<>();
			while (resultSet.next()) {
				itemorders.add(modelFromResultSet(resultSet));
			}
			return itemorders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public ItemOrders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	@Override
	public ItemOrders read(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_items WHERE order_id = ?");) {
			statement.setLong(2, orderId);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public ItemOrders create(ItemOrders itemorders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_items(order_id, item_id, item_quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, itemorders.getOrderId());
			statement.setLong(2, itemorders.getItemId());
			statement.setLong(3, itemorders.getItemQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public ItemOrders update(ItemOrders itemorders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE order_items SET item_quantity = ? WHERE orderitems_id = ?");) {
			statement.setLong(1, itemorders.getItemQuantity());
			statement.executeUpdate();
			return read(itemorders.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long orderItemid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE orderitems_id = ?");) {
			statement.setLong(1, orderItemid);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	

	
}
