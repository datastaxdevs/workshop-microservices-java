CREATE TABLE IF NOT EXISTS products (name text, id uuid, description text, price decimal, created timestamp, PRIMARY KEY ((name), id));
CREATE TABLE IF NOT EXISTS products_log (name text, id uuid, created timestamp, PRIMARY KEY ((id), created));
CREATE TABLE IF NOT EXISTS orders (order_id uuid, product_id uuid, product_name text, product_quantity int, product_price decimal, added_to_order_at timestamp, PRIMARY KEY ((order_id), product_id));
CREATE TABLE IF NOT EXISTS orders_by_customer_email (customer_email text, order_id uuid, executed_at timestamp, PRIMARY KEY ((customer_email), order_id));