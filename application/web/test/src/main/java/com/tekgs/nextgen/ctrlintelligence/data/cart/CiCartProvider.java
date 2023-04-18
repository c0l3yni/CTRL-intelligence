package com.tekgs.nextgen.ctrlintelligence.data.cart;

import java.util.Comparator;
import java.util.List;

public class CiCartProvider {
    private final CiCartRepository repository = CiCartRepository.getInstance();

    public static CiCartProvider getInstance() {
        return new CiCartProvider();
    }

    public CiCart get(CiCartDefinition definition) {
        return repository.query(definition);
    }

    public CiCart getLowestTotalAvailable(CiCartDefinition cartDefinition) {
        Integer minimumTotal = cartDefinition.getTotal();
        cartDefinition.withTotal(null);
        List<CiCart> sortedList =
                repository.query().stream().sorted(Comparator.comparingInt(CiCart::getTotal)).toList();
        for (CiCart candidate : sortedList) {
            if (candidate.getTotal() >= minimumTotal && candidate.equivalent(cartDefinition)) {
                return candidate;
            }
        }
        return null;
    }

    public CiCart get() {
        return get(CiCartDefinition.getInstance());
    }
}
