//package com.qa.ims.persistence.dao;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.qa.ims.persistence.domain.ItemOrders;
//import com.qa.ims.utils.DBUtils;
//
//
//public class ItemOrdersDAOTest {
//
//	private final ItemOrdersDAO DAO = new ItemOrdersDAO();
//
//	@Before
//	public void setup() {
//		DBUtils.connect();
//		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
//	}
//
//	@Test
//	public void testCreate() {
//		final ItemOrders created = new ItemOrders(21L, 3L, 3L, 22L);
//		assertEquals(created, DAO.create(created));
//	}
//
//	@Test
//	public void testReadAll() {
//		List<ItemOrders> expected = new ArrayList<>();
//		expected.add(new ItemOrders(20L,2L, 4L, 12L));
//		assertEquals(expected, DAO.readAll());
//	}
//
//	@Test
//	public void testReadLatest() {
//		assertEquals(new ItemOrders(20L,2L, 4L, 12L), DAO.readLatest());
//	}
//
//	@Test
//	public void testRead() {
//		final long ID = 1L;
//		assertEquals(new ItemOrders(ID, 1L,2L,29L), DAO.read(ID));
//	}
//
//	@Test
//	public void testUpdate() {
//		final ItemOrders updated = new ItemOrders(1L, 2L,1L,92L);
//		assertEquals(updated, DAO.update(updated));
//
//	}
//
//	@Test
//	public void testDelete() {
//		assertEquals(1, DAO.delete(1));
//	}
//	
////	@Test
////	public void testRead2() {
////		
////	}
//
//	
//	
//}
