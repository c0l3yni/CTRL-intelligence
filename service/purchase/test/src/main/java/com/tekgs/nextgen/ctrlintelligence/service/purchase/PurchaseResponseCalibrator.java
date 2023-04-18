package com.tekgs.nextgen.ctrlintelligence.service.purchase;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class PurchaseResponseCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Purchase' response";
    private final PurchaseResponseExpected expected;
    private final PurchaseResponse actual;

    private PurchaseResponseCalibrator(PurchaseResponseExpected expected, PurchaseResponse actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }

    public static PurchaseResponseCalibrator getInstance(PurchaseResponseExpected expected, PurchaseResponse actual) {
        return new PurchaseResponseCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'Response' Message", expected.getMessage(), actual.getMessage());
        verify("'Purchase Response' code", expected.getResponseCode().name(), actual.getResponseCode().name());
    }
}
