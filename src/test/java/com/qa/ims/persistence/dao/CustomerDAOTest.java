//package com.qa.ims.persistence.dao;
//
//import static org.junit.Assert.assertEquals;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
////import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.qa.ims.persistence.domain.Customer;
//import com.qa.ims.utils.DBUtils;
//
//public class CustomerDAOTest {
//
//	private final CustomerDAO DAO = new CustomerDAO();
//	
	// NOT WORKING here either
//	@BeforeClass
//	public void connsetup throws Exceptions {
//    Connection conn = DriverManager.
//            getConnection("jdbc:h2:~/test", "sa", "");
//    
//}
//	@Before
//	public void setup() {
//		  try {conn = DBUtils.connect();
//			DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql"); 
//	            if(conn!=null) conn.close(); 
//	         } catch(SQLException se){ 
//	            se.printStackTrace(); 
//		
//		DBUtils.connect();
//		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
//		
//	}
//
//	@Test
//	public void testCreate() {
//		
		// doesnt work
//		try (Connection conn = DBUtils.connect(); DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");){
//			final Customer created = new Customer(5L, "chris", "perrins");
//			assertEquals(created, DAO.create(created));
//			}
//			return conn;
//		} catch (SQLException e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		
//		final Customer created = new Customer(5L, "chris", "perrins");
//		assertEquals(created, DAO.create(created));
//	}
//
//	
//	
//	@Test
//	public void testReadAll() {
//		List<Customer> expected = new ArrayList<>();
//		expected.add(new Customer(4L, "Chris", "Hem"));
//		assertEquals(expected, DAO.readAll());
//		
//		
//	}
//
//	@Test
//	public void testReadLatest() {
//		assertEquals(new Customer(4L, "Chris", "Hem"), DAO.readLatest());
//	}
//
//	@Test
//	public void testRead() {
//		final long ID = 1L;
//		assertEquals(new Customer(ID, "adi", "pan"), DAO.read(ID));
//	}
//
//	@Test
//	public void testUpdate() {
//		final Customer updated = new Customer(1L, "chris", "perrins");
//		assertEquals(updated, DAO.update(updated));
//
//	}
//
//	@Test
//	public void testDelete() {
//		assertEquals(1, DAO.delete(1));
//	}
//}
