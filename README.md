# jsoup-annotations
Jsoup Annotations POJO

[![](https://jitpack.io/v/fcannizzaro/jsoup-annotations.svg)](https://jitpack.io/#fcannizzaro/jsoup-annotations)
[![Build Status](https://travis-ci.org/fcannizzaro/jsoup-annotations.svg?branch=master)](https://travis-ci.org/fcannizzaro/jsoup-annotations)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-jsoup--annotations-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/5713)

![](https://raw.githubusercontent.com/fcannizzaro/jsoup-annotations/master/icon.png)


# Gradle Dependency

## Step 1.
Add the JitPack repository to your build file
```gradle
  allprojects {
    repositories {
      ...
      maven { url 'https://jitpack.io' }
    }
  }
```
## Step 2.
Add the dependency
```gradle
  dependencies {
    compile 'com.github.fcannizzaro:jsoup-annotations:1.0.3'
  }
```

# Usage

```java

Element html = Jsoup.connect("https://www.npmjs.com/").get();

/*
*  Scrape!
*  Use JsoupProcessor or JP
*/

NPM npm = JP.from(html, NPM.class);

// or

List<Package> packages = JP.fromList(html, Package.class);

```

See [Sample Code](https://github.com/fcannizzaro/jsoup-annotations/tree/master/app/src/main/java/com/fcannizzaro/jsoup/sample)

# Annotations

## @Selector(String: query)
Can be used for class or field.

```java
@Selector("#content")
class Content {
  
  // internal elements

}
```

## @Text(String: query)
```java
@Text("h3")
String title;
```

## @Html(String: query)
```java
@Html("div.inner")
String html;
```

## @Attr(String: query, String: attr)
```java
@Attr(query="a", attr="href")
String href;
```

### `Text`, `Html`, `Attr` can be also attached to methods like:

```java
@Text("head > title")
void title(String title){
  // do something with result
}
```

## @ForEach(String: query)
```java
@ForEach("li")
void iterate(Element element, int index){
  // [required] element
  // [optional] index 
  // do something
}
```

## @AfterBind
```java
@AfterBind
void attached(){
  // called after object binding is completed.
}
```

## @Child
Denote **Field** as child element (POJO).

## @Items
Denote **Field** as List of Elements (POJO).

# License
```
Copyright 2017 Francesco Saverio Cannizzaro

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
