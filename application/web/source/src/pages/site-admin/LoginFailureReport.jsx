import React from "react";
import getLoginFailureFileContent from "./loginFailureFile";
import "../../App.css";

export default function LoginFailureReport({ report, data }) {
  let loginFailureData = getLoginFailureFileContent(report);
  return (
    <div>
      {data ? (
        <table className="login-failure-report-table">
          <thead>
            <tr>
              <th
                className="login-failure-report-table"
                id="failure-date-label"
              >
                Login Failure Date
              </th>
              <th className="login-failure-report-table">
                Login Failure Count
              </th>
            </tr>
          </thead>
          <tbody>
            {Object.keys(loginFailureData).map((key, index) => {
              return (
                <tr className="failure-aggregation" key={index}>
                  <td className="failure-date login-failure-report-table">
                    {key}
                  </td>
                  <td className="number-failures login-failure-report-table">
                    {loginFailureData[key]}
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      ) : (
        ""
      )}
    </div>
  );
}
