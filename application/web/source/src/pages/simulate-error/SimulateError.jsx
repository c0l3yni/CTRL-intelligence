import React from "react";

const SimulateError = () => {
	const throwError = () => {
		throw "Major Error";
	};
	return <div>{throwError()}</div>;
};

export default SimulateError;
