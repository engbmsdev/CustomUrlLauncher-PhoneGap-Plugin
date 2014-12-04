CustomUrlLauncher-PhoneGap-Plugin
=================================

Cordova plugin for Android to launch another application via custom url in a new task.



# Installation (automatically)

You can install the plugin via CLI:

`$ phonegap local plugin add https://github.com/engbmsdev/CustomUrlLauncher-PhoneGap-Plugin.git`

or

`$ cordova plugin add https://github.com/engbmsdev/CustomUrlLauncher-PhoneGap-Plugin.git`

# Usage

```
window.plugins.customurllauncher.launch("anotherapp://foobar?foo=123&bar=321", function(){
  console.log("success!");
}, function(e){
  console.log("error: " + e);
});

window.plugins.customurllauncher.canLaunch("anotherapp://foobar?foo=123&bar=321", function(){
  console.log("success!");
}, function(e){
  console.log("error: " + e);
});
```

# Credits

Inspired by [nchutchind's App-Launcher-Cordova-Plugin](https://github.com/nchutchind/App-Launcher-Cordova-Plugin)
