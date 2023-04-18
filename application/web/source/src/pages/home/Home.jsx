import React from "react";
import { Container } from "react-bootstrap";
import "./home.css";

export default function home() {
  return (
    <Container>
      <div className="home-container">
        <h1 className="hero-title">Welcome to Ctrl Intelligence</h1>
      </div>
    </Container>
  );
}
