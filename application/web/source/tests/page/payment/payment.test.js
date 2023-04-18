import { validateSource } from "../../../src/pages/payment-submission/payment";

const sourceScenarios = [["bogus"], ["tok_amex"]];

describe("validate input fields", () => {
  test.each(sourceScenarios)("payment source: %p", (scenario) => {
    let expected = scenario === "tok_amex" ? "" : "Source is in error";
    let actual = validateSource(scenario);
    expect(actual).toBe(expected);
  });
});
