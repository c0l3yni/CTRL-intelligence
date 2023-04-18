import React, { useState } from "react";
import { useSearchParams } from "react-router-dom";
import {
  getPurchaseConfirmationMessage,
  validateSource,
  postPayment,
  getPurchaseFailureMessage,
} from "./payment";
import { Button, Form } from "react-bootstrap";
import "./paymentSubmission.css";
import { getCartTotalInDollars } from "../cart/cartPage.js";
import { getCartById } from "../../data/cart/cart";

export default function PaymentSubmission() {
  const [searchParams] = useSearchParams();
  const cartId = searchParams.get("cart_id");
  const [message, setMessage] = useState("");
  const [currency, setCurrency] = useState("usd");
  const [source, setSource] = useState("");
  const [sourceError, setSourceError] = useState("");
  const [purchaseFailureMessage, setPurchaseFailureMessage] = useState("");

  const setCurrencyInput = (e) => {
    setCurrency(e.target.value);
  };

  const setSourceInput = (e) => {
    setSource(e.target.value);
  };

  let items = getCartById(cartId).items;
  let cartTotal = cartId ? getCartTotalInDollars(items) : (0.0).toFixed(2);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage("");

    setSourceError(validateSource(source));

    let isPaymentSuccessful;
    if (validateSource(source) === "") {
      const response = await postPayment(cartTotal * 100, currency, source);
      isPaymentSuccessful = response.data.responseCode === "SUCCESS";

      if (isPaymentSuccessful) {
        e.target.style.display = "none";
      } else {
        setPurchaseFailureMessage(getPurchaseFailureMessage());
      }
      setMessage(getPurchaseConfirmationMessage(isPaymentSuccessful));
    }
  };

  return (
    <>
      <div id="payment-submission">
        <p id="result-message">{message}</p>
        <Form
          id="payment-form"
          onSubmit={handleSubmit}
          style={{ display: "block" }}
        >
          <p id="purchase-error" className="field-error">
            {purchaseFailureMessage}
          </p>
          <h4>
            Total $<span id="total">{cartTotal}</span>
          </h4>
          <Form.Group>
            <Form.Label>Currency</Form.Label>
            <select
              name="currency-dropdown"
              id="currency-dropdown"
              onChange={setCurrencyInput}
            >
              <option name="currency" value="usd">
                USD
              </option>
              <option name="currency" value="bogus">
                Bogus
              </option>
              <option name="currency" value="bogus2.0">
                Bogus2.0
              </option>
            </select>
          </Form.Group>
          <Form.Group>
            <Form.Label>
              Source
              <Form.Control
                name="source"
                value={source}
                type="text"
                onChange={setSourceInput}
              />
            </Form.Label>
            <p id="source-error" className="field-error">
              {sourceError}
            </p>
          </Form.Group>
          <Button id="submit-button" type="submit">
            Submit
          </Button>
        </Form>
      </div>
    </>
  );
}
