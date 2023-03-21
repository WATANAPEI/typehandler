CREATE TABLE typehandler.store (
  id INT NOT NULL AUTO_INCREMENT,
  request_id INT NOT NULL,
  store_name VARCHAR(100),
  brand_name VARCHAR(200),
  representative JSON,
  PRIMARY KEY (id)
);

