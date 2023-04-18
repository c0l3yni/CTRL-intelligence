package com.tekgs.nextgen.ctrlintelligence.data.inventory;

import com.google.gson.Gson;
import com.tekgs.nextgen.ctrlintelligence.data.inventory.product.CiProduct;

import java.util.ArrayList;
import java.util.List;

public class CiInventory {
    private final List<CiProduct> products;

     public CiInventory(List<CiProduct> products) {
      this.products = products;
     }

     public static CiInventory getInstance() {
            return new CiInventory(null);
        }

     public static CiInventory getInstance(List<CiProduct> products) {
      return new CiInventory(products);
     }

     public List<CiProduct> getProducts() {
            return new ArrayList<>(this.products);
     }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }


}
