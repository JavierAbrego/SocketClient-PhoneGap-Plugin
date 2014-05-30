# PhoneGap Socket Client plugin

for Android  by [Javier Abrego Lorente]

## 0. Index

1. [Description](#1-description)
2. [Screenshots](#2-screenshots)
3. [Installation](#3-installation)
	3. [Automatically (CLI / Plugman)](#automatically-cli--plugman)
	3. [Manually](#manually)
	3. [PhoneGap Build](#phonegap-build)
4. [Usage](#4-usage)
5. [Credits](#5-credits)
6. [Changelog](#6-changelog)
7. [License](#7-license)

## 1. Description

This plugin allows you to communicate with a server through sockets
* Compatible with [Cordova Plugman](https://github.com/apache/cordova-plugman).


## 2. Screenshots

Android

![ScreenShot](screenshots/screenshot-android-SocketClient.png)



## 3. Installation

### Automatically (CLI / Plugman)
SocketClient is compatible with [Cordova Plugman](https://github.com/apache/cordova-plugman), compatible with [PhoneGap 3.0 CLI](http://docs.phonegap.com/en/3.0.0/guide_cli_index.md.html#The%20Command-line%20Interface_add_features), here's how it works with the CLI (backup your project first!):

```
$ phonegap local plugin add https://github.com/JavierAbrego/SocketClient-PhoneGap-Plugin.git
```
or
```
$ cordova plugin add https://github.com/JavierAbrego/SocketClient-PhoneGap-Plugin.git
$ cordova prepare
```

SocketClient.js is brought in automatically. There is no need to change or add anything in your html.

### Manually

1\. Add the following xml to your `config.xml` in the root directory of your `www` folder:

```xml
<!-- for Android -->
<feature name="SocketClient">
  <param name="android-package" value="es.abrego.plugins.SocketClient" />
</feature>
```


2\. Grab a copy of SocketClient.js, add it to your project and reference it in `index.html`:
```html
<script type="text/javascript" src="js/SocketClient.js"></script>
```

3\. Download the source files and copy them to your project.

Android: Copy `SocketClient.java` to `platforms/android/src/es/abrego/plugins` (create the folders)



## 4. Usage
window.plugins.socketClient.sendSocket(address, //example "127.0.0.1"
										port,   //example "8080"
										message, //example "message sended"
										successCallback,
										errorCallback);

window.plugins.socketClient.sendSocket("127.0.0.1", "80", "test", function(e){console.log("success: "+e);}, function(e){console.log("error: "+e);});

## 5. CREDITS

This plugin was  entirely created by [Javier Abrego].


## 6. CHANGELOG

1.0: initial version supporting Android

## 7. License

[The MIT License (MIT)](http://www.opensource.org/licenses/mit-license.html)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
