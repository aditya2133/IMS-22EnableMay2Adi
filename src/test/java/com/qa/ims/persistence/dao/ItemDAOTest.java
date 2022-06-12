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
//import com.qa.ims.persistence.domain.Item;
//import com.qa.ims.utils.DBUtils;
//
//public class ItemDAOTest {
//	
//	private final ItemDAO DAO = new ItemDAO();
//
//	@Before
//	public void setup() {
//		DBUtils.connect();
//		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
//	}
//
//	@Test
//	public void testCreate() {
//		final Item created = new Item(5L, "Gloves", 20L);
//		assertEquals("ItemDAO create test failed",created, DAO.create(created));
//	}
//
//	@Test
//	public void testReadAll() {
//		List<Item> expected = new ArrayList<>();
//		expected.add(new Item(4L, "helmet", 40L));
//		assertEquals("ItemDAO readall test failed",expected, DAO.readAll());
//	}
//
//	@Test
//	public void testReadLatest() {
//		assertEquals("ItemDAO readlatest test failed",new Item(4L, "helmet", 40L), DAO.readLatest());
//	}
//
//	@Test
//	public void testRead() {
//		final long ID = 1L;
//		assertEquals("ItemDAO read test failed",new Item(ID, "Bat", 40L), DAO.read(ID));
//	}
//
//	@Test
//	public void testUpdate() {
//		final Item updated = new Item(1L, "Guard", 100L);
//		assertEquals("ItemDAO update test failed",updated, DAO.update(updated));
//
//	}
//
//	@Test
//	public void testDelete() {
//		assertEquals(1, DAO.delete(1));
//	}
//
//}
