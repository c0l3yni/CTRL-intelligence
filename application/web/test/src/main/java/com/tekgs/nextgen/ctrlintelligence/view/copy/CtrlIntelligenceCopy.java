package com.tekgs.nextgen.ctrlintelligence.view.copy;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class CtrlIntelligenceCopy {
    private final Properties properties = new Properties();

    public CtrlIntelligenceCopy() {
        String copyFilepath = String.format("../source/src/copy/%s.properties", "en-us");
        try (Reader reader = new FileReader(copyFilepath)) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CtrlIntelligenceCopy getInstance() {
        return new CtrlIntelligenceCopy();
    }

    public String getFailureReportTitle() {
        return get("failure-report-title");
    }

    private String get(String key) {
        return properties.getProperty(key);
    }

    public String getAmountLabel() {
        return get("amount-label");
    }

    public String getSourceErrorMessage() {
        return get("source-error-message");
    }

    public String getCurrencyErrorMessage() {
        return get("currency-error-message");
    }

    public String getLoginFileNotFound() {
        return get("login-file-not-found-message");
    }

    public String getOutOfStock() {
        return get("out-of-stock");
    }
}
