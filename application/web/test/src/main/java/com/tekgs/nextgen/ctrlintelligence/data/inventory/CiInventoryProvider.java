package com.tekgs.nextgen.ctrlintelligence.data.inventory;

public class CiInventoryProvider {
    private final CiInventoryRepository repository = CiInventoryRepository.getInstance();

    public static CiInventoryProvider getInstance() {
        return new CiInventoryProvider();
    }

    public CiInventory get() {
        return CiInventory.getInstance(repository.get());
    }
}
