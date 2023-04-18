import React from "react";
import { getProducts, isOutOfStock, truncateProductName } from "./product";
import { Card, Button, Row, Col } from "react-bootstrap";

export default function Products() {
  return (
    <div id="products">
      <Row id="products-region">
        {getProducts().map((product) => (
          <Col md={3}>
            <Card key={product.id} className="product product-container">
              <Card.Body>
                <Card.Title className="product-name">
                  {truncateProductName(product.name)}
                </Card.Title>
                <Card.Text className="out-of-stock text-warning fw-bold">
                  {isOutOfStock(product.quantity) ? "Out of stock" : ""}
                </Card.Text>
                <Button className="add-to-cart" disabled={isOutOfStock(product.quantity)}>
                  Add to Cart
                </Button>
              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>
    </div>
  );
}
