import { isOutOfStock } from "../../../src/pages/products/product";

test("Should check if item is out of stock and return out of stock message", () => {
  let quantity = 0;
  let actual = isOutOfStock(quantity);
  let expected = true;
  expect(actual).toBe(expected);
});
