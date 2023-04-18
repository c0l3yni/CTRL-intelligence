package com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure;

import com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure.line.LoginFailureLineRegionCalibratable;
import com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure.line.LoginFailureLineRegionExpected;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LoginFailureReportExpected implements LoginFailureReportCalibratable {
    private static final String FAILURE_FILES_PATH = "../source/public/logs/%s.log";
    private static final int DATE_INDEX = 0;
    private final List<LoginFailureLineRegionExpected> failures = new ArrayList<>();
    SortedMap<String, Integer> aggregatedDates = new TreeMap<>();
    private LoginFailureReportCopy copy;
    private boolean isLogFileFound = true;

    private LoginFailureReportExpected(String failureFilename) {
        aggregateFailuresByDate(failureFilename);
        addFailuresByDate();
    }

    public static LoginFailureReportExpected getInstance(String failureFile) {
        return new LoginFailureReportExpected(failureFile);
    }

    private void aggregateFailuresByDate(String failureFilename) {
        if (failureFilename != null) {
            File failureFile = new File(String.format(FAILURE_FILES_PATH, failureFilename));
            try (BufferedReader failureFileReader = new BufferedReader(new FileReader(failureFile))) {
                String failureLine = failureFileReader.readLine();
                while (failureLine != null) {
                    addFailureToReport(failureLine);
                    failureLine = failureFileReader.readLine();
                }
            } catch (IOException e) {
                isLogFileFound = false;
                throw new RuntimeException(e);
            }
        }
    }

    private void addFailureToReport(String failureLine) {
        String date = failureLine.split(" ")[DATE_INDEX];
        int failureCount = aggregatedDates.containsKey(date) ? aggregatedDates.get(date) + 1 : 1;
        aggregatedDates.put(date, failureCount);
    }

    private void addFailuresByDate() {
        for (Map.Entry<String, Integer> entry : aggregatedDates.entrySet()) {
            String failureDate = entry.getKey();
            Integer failureCount = entry.getValue();
            failures.add(LoginFailureLineRegionExpected.getInstance(failureDate, failureCount));
        }
    }

    @Override
    public String getTitle() {
        return getCopy().getFailureReportTitle();
    }

    private LoginFailureReportCopy getCopy() {
        if (copy == null) {
            copy = LoginFailureReportCopy.getInstance();
        }
        return copy;
    }

    @Override
    public List<LoginFailureLineRegionCalibratable> getFailureLines() {
        return new ArrayList<>(failures);
    }

    @Override
    public String getLogNotFound() {
        return isLogFileFound ? "" : getCopy().getLoginFileNotFound();
    }
}
