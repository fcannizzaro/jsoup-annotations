package com.fcannizzaro.jsoup.sample.model;

import com.fcannizzaro.jsoup.annotations.interfaces.AfterBind;
import com.fcannizzaro.jsoup.annotations.interfaces.Items;
import com.fcannizzaro.jsoup.annotations.interfaces.Text;

import java.util.List;

/**
 * Created by Francesco Cannizzaro (fcannizzaro)
 */

public class NPM {

    @Items
    public List<Package> packages;

    @Text("head > title")
    private void title(String title) {
        System.out.println("[title] " + title);
    }

    @AfterBind
    void attached() {
        System.out.println("[attached] " + packages);
    }

}
