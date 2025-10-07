# Diseño de base de datos y API REST para una tienda online simple

##  Base de datos: 
Relacional - MySQL o Postgres

**users**   
*clientes o usuarios del sistema. informacion basica para autenticacion y vincular sus compras*  
-id: integer  
-name: varchar  
-email: varchar  
-password: varchar  

**products**  
*productos disponibles para la venta. informacion que se muestra al usuario e inventario*  
-id: integer  
-name: varchar  
-description: varchar  
-price: double  
-stock: integer  

**carts**  
*carrito de compras de un usuario. puede verse como una sesión temporal antes de generar una orden*  
-id: integer  
-user_id: integer (Foreign Key)  
-created_at: datetime  

**cartItems**  
*productos agregados a un carrito. intermedia entre carts & products*  
-id: integer  
-cart_id: integer (Foreign Key)  
-product_id: integer (Foreign Key)  
-quantity: integer  

**orders**  
*orden finalizada o compra confirmada. se crea a partir de un carrito cuando el usuario realiza el checkout*  
-id: integer   
-user_id: integer (Foreign Key)   
-total_amount: double  
-created_at: datetime  

**orderItems**  
*productos incluidos en una orden. copia del estado del producto al momento de la compra*  
-id: integer  
-order_id: integer (Foreign Key)  
-product_id: integer (Foreign Key)  
-quantity: integer  
-unit_price: double  

### Relaciones entre tablas:  
users(1) -> (N) carts  
user(1) -> (N) orders  
carts(1) -> (N) cartItems  
orders(1) -> (N) orderItems  
products(1) -> (N) cartItems  
products(1) -> (N) orderItems  

## API Endpoints 
**endpoints de usuarios /users**  
/users/register - POST - create new usar  
/users/login - POST - authenticate user and return token  
/users/:id - GET - get user profile  

**endpoints de productos /products**  
/product - GET - list all products  
/products/:id - GET - get details of a product  
/products - POST - create new product   
/products/:id - PUT - update product  
/products/:id - DELETE - delete product  

**endpoints de carritos /cart**  
/cart - POST - create a new cart - if one doesn't exist  
/cart - DELETE - empty cart  
/cart/:cartId - GET - view cart details  
/cart/:cartId/items - POST - add item to cart  
/cart/items/:itemId - PUT - change quantity  
/cart/items/:itemId - DELETE - delete cart item  

**endpoints de ordenes /orders**  
/orders - POST - place an order from a cart  
/orders - GET - list user orders  
/orders/:id - GET - view order details  


*The API follow REST principles with clear separation of resources. Each main entity has a clean set of CRUD endpoints. Each endpoint focuses on a single resposibility. The typical flow start when a user logs in, browses products, builds a cart, and places an order.*