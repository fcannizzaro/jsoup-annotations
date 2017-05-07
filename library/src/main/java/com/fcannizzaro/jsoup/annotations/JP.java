package com.fcannizzaro.jsoup.annotations;

import org.jsoup.nodes.Element;

import java.util.List;

/**
 * Created by Francesco Cannizzaro (fcannizzaro)
 */

public class JP {


    public static <T> T from(Element container, Class<T> clazz) {
        return JsoupProcessor.from(container, clazz);
    }

    public static <T> List<T> fromList(Element container, Class<T> clazz) {
        return JsoupProcessor.fromList(container, clazz);

    }

}
