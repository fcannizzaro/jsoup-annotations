package com.fcannizzaro.jsoup.sample.model;

import com.fcannizzaro.jsoup.annotations.interfaces.Attr;
import com.fcannizzaro.jsoup.annotations.interfaces.Child;
import com.fcannizzaro.jsoup.annotations.interfaces.Selector;
import com.fcannizzaro.jsoup.annotations.interfaces.Text;

/**
 * Created by Francesco Cannizzaro (fcannizzaro)
 */


@Selector(".marginalia-container:has(img)")
public class Package {

    @Selector(".type-sm")
    public static class Info {

        @Text("a[href*='package']")
        public String version;

        @Text("a[href*='~']")
        public String author;

    }

    @Attr(value = "h3 a", attr = "href")
    public String link;

    @Text("h3")
    public String name;

    @Text("p.type-ellipsis")
    public String description;

    @Attr(value = "img.mts", attr = "src")
    public String icon;

    @Child
    public Info info;

}
