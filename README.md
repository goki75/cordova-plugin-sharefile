cordova-plugin-share
====================

Cordova Plugin to open native "share" popup in Android for Sharing Files

This is completely derived from Mark Marijissen's simple cordova share plugin

### Install

In your phonegap/cordova project, type:

`cordova plugins add https://github.com/goki75/cordova-plugin-share.git`

### Usage

`navigator.share(URItoFile,title,mimetype)`

* URItoFile: URI of the File/Image to be shared
* title: Title of popup, i.e. "Share this quote" (android only, default: "Share")
* mimetype: Mimetype, i.e. "image/jpeg" (android only, default: "plain/text")

### More info


* Android share code from [here](http://developer.android.com/training/sharing/send.html). Read if you want to understand *mimetype* options.


### License

MIT license

