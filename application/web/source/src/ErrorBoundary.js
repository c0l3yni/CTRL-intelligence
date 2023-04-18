import React from "react";
import { Navigate } from "react-router-dom";

class ErrorBoundary extends React.Component {
  state = { hasError: false };

  componentDidCatch() {
    this.setState({ hasError: true });
  }

  componentDidUpdate() {
    if (this.state.hasError) {
      this.setState({ hasError: false });
    }
  }

  render() {
    return this.state.hasError ? (
      <Navigate
        state={{ isUnhandledException: true }}
        to="error-page"
        replace
      />
    ) : (
      this.props.children
    );
  }
}

export default ErrorBoundary;
