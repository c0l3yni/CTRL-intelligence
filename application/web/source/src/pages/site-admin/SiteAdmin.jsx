import React, {useEffect, useState} from "react";
import {useSearchParams} from "react-router-dom";
import LoginFailureReport from "./LoginFailureReport";
import {getFileNotFoundMessage} from "./loginFailureFile";

export default function SiteAdmin() {
    const [urlParam] = useSearchParams();
    const loginFailureLogFile = urlParam.get("fileName") ? urlParam.get("fileName") : "LoginErrorLog";
    const [fileContentData, setFailContent] = useState([]);
    useEffect(() => {
        let logfilePathname = `${process.env.PUBLIC_URL}/logs/${loginFailureLogFile}.log`;
        fetch(logfilePathname)
            .then((response) => {
                return response.text();
            })
            .then((response) => {
                setFailContent(response.trim().split("\n"));
            });
    }, [loginFailureLogFile]);
    return (
        <div id="site-admin">
            <h1>SiteAdmin</h1>
            <div id="failure-report">
                <h3 id="login-report-title">Login Failure Report</h3>
                <h2 id="not-found-message">{getFileNotFoundMessage(fileContentData)}</h2>
                <LoginFailureReport report={fileContentData} data={loginFailureLogFile}
                />
            </div>
        </div>
    );
}
