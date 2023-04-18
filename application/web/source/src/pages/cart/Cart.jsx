import React from "react";
import { Link, useSearchParams } from "react-router-dom";
import Products from "./CartProducts";
import { getCartById } from "../../data/cart/cart";
import { getCartTotalInDollars, getEmptyMessage } from "./cartPage.js";
import { Button } from "react-bootstrap";
import "./cart.css";

export default function Cart() {
  const [id] = useSearchParams();
  const cartId = id.get("cart_id");

  let items = getCartById(cartId).items;
  let total = cartId ? getCartTotalInDollars(items) : (0.0).toFixed(2);
  let itemCount = items == null ? 0 : items.length;
  let emptyMessage = getEmptyMessage(itemCount);

  const renderCheckoutButton = () => {
    if (itemCount !== 0) {
      return (
        <Button>
          <Link to={`/payment-submission/?cart_id=${cartId}`} className="checkout-button">
            Checkout
          </Link>
        </Button>
      );
    }
  }

  return (
    <div id="cart">
      <p id="cart-empty-message">{emptyMessage}</p>
      <div id="items">{cartId && <Products cartItemData={items} />}</div>
      <h4 className="total-amount">
        Total $<span id="cart-total">{total}</span>
      </h4>
      {renderCheckoutButton()}
    </div>
  );
}
