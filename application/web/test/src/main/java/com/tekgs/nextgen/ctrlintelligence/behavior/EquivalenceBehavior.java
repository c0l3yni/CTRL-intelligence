package com.tekgs.nextgen.ctrlintelligence.behavior;

public class EquivalenceBehavior {
    private final Object comparatorValue;
    private final Object thisValue;

    public EquivalenceBehavior(Object comparatorValue, Object thisValue) {
        this.comparatorValue = comparatorValue;
        this.thisValue = thisValue;
    }

    public static EquivalenceBehavior getInstance(Object comparatorValue, Object thisValue) {
        return new EquivalenceBehavior(comparatorValue, thisValue);
    }

    public boolean execute() {
        return comparatorValue == null || thisValue.equals(comparatorValue);
    }
}
