export const getCartTotalInDollars = (items) => {
  let total = getCartTotal(items);
  return items ? (total / 100).toFixed(2) : (0.0).toFixed(2);
};

export const getCartTotal = (items) => {
  let total = 0;
  for (let i = 0; i < items.length; i++) {
    total = total + items[i].price * items[i].quantity;
  }
  return total;
};

export function getEmptyMessage(itemCount) {
  return itemCount < 1 ? "Your cart is empty" : "";
}
