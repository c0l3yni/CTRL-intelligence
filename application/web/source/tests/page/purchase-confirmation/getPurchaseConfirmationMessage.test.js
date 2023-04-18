import { getPurchaseConfirmationMessage } from "../../../src/pages/payment-submission/payment.js";

test("convert total to cents when total is greater than 0", () => {
  expect(getPurchaseConfirmationMessage(true)).toBe(
    "Thank you for your purchase"
  );
});
