const getProductPriceInDollars = (price) => {
  return price ? (price / 100).toFixed(2) : (0.0).toFixed(2);
};

export default getProductPriceInDollars;
