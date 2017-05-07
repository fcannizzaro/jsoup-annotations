package com.fcannizzaro.jsoup.sample.model;

import com.fcannizzaro.jsoup.annotations.interfaces.AfterBind;
import com.fcannizzaro.jsoup.annotations.interfaces.Items;

import java.util.List;

/**
 * Created by Francesco Cannizzaro (fcannizzaro)
 */

public class NPM {

    @Items
    public List<Package> packages;

    @AfterBind
    void attached() {
        System.out.println("[attached] " + packages);
    }

}
