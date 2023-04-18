import React, { useState, useEffect } from "react";
import { useLocation } from "react-router-dom";

function ErrorMessage() {
  const [errorMessage, setErrorMessage] = useState(
    "You attempted to enter a high-security URL, and were caught. Please try a different URL!"
  );
  const location = useLocation();
  let isUnhandledException = location.state?.isUnhandledException;

  useEffect(() => {
    if (isUnhandledException) {
      setErrorMessage("Sorry, something went wrong. :(");
    }
  }, []);

  return (
    <>
      <h4 id="error-message">{errorMessage}</h4>
    </>
  );
}

export default ErrorMessage;
