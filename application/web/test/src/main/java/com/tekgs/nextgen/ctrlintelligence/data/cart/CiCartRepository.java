package com.tekgs.nextgen.ctrlintelligence.data.cart;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CiCartRepository {
    private static final String PATH_TO_CART_DATA = "../source/src/data/cart/cartData.json";
    List<CiCart> carts = new ArrayList<>();

    public static CiCartRepository getInstance() {
        return new CiCartRepository();
    }

    private void getLatestCartData() {
        try (Reader reader = Files.newBufferedReader(Paths.get(PATH_TO_CART_DATA))) {
            carts = new Gson().fromJson(reader, new TypeToken<List<CiCart>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CiCart query(CiCartDefinition definition) {
        getLatestCartData();
        if (carts == null) return null;
        for (CiCart candidate : carts) {
            if (candidate.equivalent(definition)) {
                return candidate;
            }
        }
        return null;
    }

    public List<CiCart> query() {
        getLatestCartData();
        return carts;
    }
}
