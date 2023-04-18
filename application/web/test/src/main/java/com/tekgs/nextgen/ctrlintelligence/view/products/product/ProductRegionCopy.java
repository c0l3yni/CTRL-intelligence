package com.tekgs.nextgen.ctrlintelligence.view.products.product;

import com.tekgs.nextgen.ctrlintelligence.view.copy.CtrlIntelligenceCopy;

public class ProductRegionCopy {
    private CtrlIntelligenceCopy copy;

    public static ProductRegionCopy getInstance() {
        return new ProductRegionCopy();
    }

    public String getOutOfStock() {
        return getCopy().getOutOfStock();
    }

    private CtrlIntelligenceCopy getCopy() {
        if(copy==null){
            copy= CtrlIntelligenceCopy.getInstance();
        }
        return copy;
    }
}
