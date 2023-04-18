import "./App.css";
import { Route, Routes, Navigate } from "react-router-dom";
import PaymentSubmission from "./pages/payment-submission/PaymentSubmission";
import Cart from "./pages/cart/Cart";
import SiteAdmin from "./pages/site-admin/SiteAdmin";
import ErrorPage from "./pages/error-page/ErrorPage";
import MainNavbar from "./components/navbar/Navbar";
import Home from "./pages/home/Home";
import { Container } from "react-bootstrap";
import Products from "./pages/products/Products";
import ErrorBoundary from "./ErrorBoundary";
import SimulateError from "./pages/simulate-error/SimulateError";

function App() {
	return (
		<ErrorBoundary>
			<MainNavbar />
			<Container>
				<Routes>
					<Route path="/" element={<Home />} />
					<Route path="/payment-submission" element={<PaymentSubmission />} />
					<Route path="/cart" element={<Cart />} />
					<Route path="/site-admin" element={<SiteAdmin />} />
					<Route path="/products" element={<Products />} />
					<Route path="/error-page" element={<ErrorPage />} />
					<Route path="/simulate-error" element={<SimulateError />} />
					<Route path="*" element={<Navigate to="/error-page" replace />} />
				</Routes>
			</Container>
		</ErrorBoundary>
	);
}

export default App;
