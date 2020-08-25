# HCL_UseCase
Order Management System ..


Implement an order management system that has two microservices: Order Service and Order Item Service. The Order Service is responsible for creating new orders, retrieving existing order info. Similarly, Order Item Service is responsible for creating order items, retrieving order items.

Order Item has below data:
- Product code
- Product name
- Quantity



Order has below data:
- Customer name
- Order date
- Shipping address
- Order items
- Total ($)
Tech requirements:
- Use FeignClient for inter-service communication
- Use H2 DB to store order & order item data
- Need to have global exception handler to handle exceptions like OrderNotFound
- APIs should be exposed as REST APIs


