# jsoup-annotations
Jsoup Annotations POJO

![](https://raw.githubusercontent.com/fcannizzaro/jsoup-annotations/master/icon.png)

# Usage

```java

Element html = Jsoup.connect("https://www.npmjs.com/").get();

/*
*  Scrape!
*  Use JsoupProcessor or JP
*/

NPM npm = JP.from(body, NPM.class);

// or

List<Packege> packages = JP.fromList(body, Package.class);

```

See [Sample Code]()

# Annotations

## Selector(query)
Can be used for class or field.

```java
@Selector("#content")
class Content {
  
  // internal elements

}
```

## Text(query)
```java
@Text("h3")
String title;
```

## Attr(query,attr)
```java
@Text(value="a", attr="href")
String href;
```

## ForEach(query)
```java
@ForEach("li")
void iterate(Element el, [, int index]){
  // do something
}
```

## Child
Denote Field as child element (POJO).

## Items
Denote Field as List of Elements (POJO).

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
