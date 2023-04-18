import axios from "axios";

export const postPayment = async (amount, currency, source) => {
  let response;
  try {
    response = await axios.post("http://localhost:8080/purchase", {
      amount,
      currency,
      source,
    });
  } catch (error) {
    response = error;
  }

  return response;
};

export const getPurchaseConfirmationMessage = (isPaymentSuccessful) => {
  return isPaymentSuccessful ? "Thank you for your purchase" : "";
};

export const getPurchaseFailureMessage = () => {
  return "Credit card declined or rejected. Please try again";
};

export const validateSource = (source) => {
  return source === "tok_amex" || source === "tok_bogus"
    ? ""
    : "Source is in error";
};
