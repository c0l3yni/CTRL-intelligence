import {
  getCartTotalInDollars,
  getEmptyMessage,
} from "../../../src/pages/cart/cartPage.js";

describe("getCartTotalInDollars tests", () => {
  test("convert cart total to dollars", () => {
    let cart = {
      id: "2",
      items: [
        {
          prodId: 1,
          name: "Spy Pen",
          description: " A pen with hidden camera",
          price: 50,
          quantity: 1,
        },
        {
          prodId: 2,
          name: "Spy Pencil",
          description: " A pencil with hidden cameras",
          price: 50,
          quantity: 1,
        },
      ],
    };
    let actual = getCartTotalInDollars(cart.items);
    let expected = "1.00";
    expect(actual).toBe(expected);
  });
});

describe("getEmptyMessage tests", () => {
  test("should display 'Your cart is empty' message when cart itemCount is 0", () => {
    let itemCount = 0;
    let actual = getEmptyMessage(itemCount);
    let expected = "Your cart is empty";
    expect(actual).toBe(expected);
  });

  test("should display 'empty string' when cart itemCount is greater than 0", () => {
    let itemCount = 10;
    expect(getEmptyMessage(itemCount)).toBe("");
  });
});
