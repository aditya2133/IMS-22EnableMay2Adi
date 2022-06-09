use `ims`;
-- additional query codes


-- SELECT orders.customer_id, first_name, order_items.order_id,items.item_id,item_name,item_quantity,price, sum(price*item_quantity) AS total FROM order_items
-- Join orders on orders.order_id = order_items.order_id
-- Join customers ON customers.customer_id = orders.customer_id
-- Join items on order_items.item_id = items.item_id
-- 	Group By order_id;
--     

-- selecting using customer id
 SELECT orders.customer_id, first_name, order_items.order_id,items.item_id,item_name,item_quantity,price, (price*item_quantity) AS total FROM order_items
 Join orders on orders.order_id = order_items.order_id
 Join customers ON customers.customer_id = orders.customer_id
 Join items on order_items.item_id = items.item_id
 	-- Group By order_id; 
     -- WHERE order_items.order_id = 2;
      WHERE customers.customer_id = 2;
    ;
    
-- selecting using order id, sum using each order id
SELECT orders.customer_id, first_name,orderitems_id, order_items.order_id,items.item_id, item_name, item_quantity,price, sum(price*item_quantity) AS total FROM order_items
Join orders on orders.order_id = order_items.order_id
Join customers ON customers.customer_id = orders.customer_id
Join items on order_items.item_id = items.item_id
	    WHERE order_items.order_id = 6
	
	-- Group By order_id 
    -- ORDER BY order_id; 
;


-- without sum, 
SELECT orders.customer_id, first_name,orderitems_id, order_items.order_id,items.item_id, item_name, item_quantity,price, (price*item_quantity) AS total FROM order_items
Join orders on orders.order_id = order_items.order_id
Join customers ON customers.customer_id = orders.customer_id
Join items on order_items.item_id = items.item_id
	   -- WHERE order_items.order_id = 6
	
	 Group By order_id 
     ORDER BY order_id; 
;