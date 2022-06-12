package com.qa.ims;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//import com.qa.ims.controllers.CustomerControllerTest;
//import com.qa.ims.controllers.ItemControllerTest;
//import com.qa.ims.controllers.ItemOrdersControllerTest;
//import com.qa.ims.controllers.OrderControllerTest;
import com.qa.ims.persistence.dao.CustomerDAOTest;
//import com.qa.ims.persistence.dao.ItemDAOTest;
//import com.qa.ims.persistence.dao.ItemOrdersDAOTest;
//import com.qa.ims.persistence.dao.OrderDAOTest;
//import com.qa.ims.persistence.domain.CustomerTest;
//import com.qa.ims.persistence.domain.ItemOrdersTest;
//import com.qa.ims.persistence.domain.ItemTest;
//import com.qa.ims.persistence.domain.OrderTest;

@RunWith(Suite.class)
@SuiteClasses({
//	CustomerTest.class,
//	ItemTest.class,
//	OrderTest.class,
//	ItemOrdersTest.class,
//	
	CustomerDAOTest.class,
//	ItemDAOTest.class,
//	OrderDAOTest.class,
//	ItemOrdersDAOTest.class,
//	
//	CustomerControllerTest.class,
//	ItemControllerTest.class,
//	OrderControllerTest.class,
//	ItemOrdersControllerTest.class,
	
})

public class TestHolder {

}

//Help from
//https://www.guru99.com/create-junit-test-suite.html#:~:text=Steps%20to%20create%20Test%20Suite%20and%20Test%20Runner,MySecondClassTest%29%20and%20create%20a%20method%20annotated%20with%20%40test.
