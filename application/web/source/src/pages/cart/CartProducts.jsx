import React from "react";
import { Button, Table } from "react-bootstrap";
import getProductPrice from "./product";

function Products({ cartItemData }) {
  return (
    <>
      <Table>
        <thead>
          <tr>
            <th>Product</th>
            <th>Price</th>
            <th>QTY</th>
            <th>Price x QTY</th>
          </tr>
        </thead>
        <tbody className="product-container">
          {cartItemData.map((item, i) => (
            <tr key={i} className="item">
              <td className="item-name">{item.name}</td>
              <td className="item-price">$ {getProductPrice(item.price)}</td>
              <td className="item-quantity">{item.quantity}</td>
              <td className="item-subtotal">
                ${getProductPrice(item.price * item.quantity)}
              </td>
              <td className="remove-button-container">
                <Button className="remove-button" variant="primary">
                  Remove
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </>
  );
}

export default Products;
