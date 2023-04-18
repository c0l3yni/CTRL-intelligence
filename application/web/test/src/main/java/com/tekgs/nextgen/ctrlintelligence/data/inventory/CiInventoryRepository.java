package com.tekgs.nextgen.ctrlintelligence.data.inventory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tekgs.nextgen.ctrlintelligence.data.inventory.product.CiProduct;

import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CiInventoryRepository {
    private static final String PATH_TO_INVENTORY_DATA = "../source/src/data/product/products.json";
    private List<CiProduct> inventory = new ArrayList<>();

    public static CiInventoryRepository getInstance() {
        return new CiInventoryRepository();
    }

    private void getLatestInventoryData() {
        try(Reader reader = Files.newBufferedReader(Paths.get(PATH_TO_INVENTORY_DATA))) {
            inventory = new Gson().fromJson(reader, new TypeToken<List<CiProduct>>() {}.getType());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public List<CiProduct> get() {
        getLatestInventoryData();
        return inventory;
    }
}
