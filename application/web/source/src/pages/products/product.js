import productData from "../../data/product/products.json";

export function getProducts() {
  return productData;
}

export function isOutOfStock(quantity) {
  return quantity <= 0;
}

export function truncateProductName(productName) {
  if (productName.length > 256) {
    return productName.slice(0, 253) + "...".trim();
  } else {
    return productName.trim();
  }
}
