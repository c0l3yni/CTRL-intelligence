import cartData from "./cartData.json";

export const getCartById = (id) => {
  let cart = {};

  cart = cartData.find((c) => c.id === id);
  cart = cart === undefined ? { items: [] } : cart;

  return cart;
};
