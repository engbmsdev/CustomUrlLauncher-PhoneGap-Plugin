function CustomUrlLauncher() {}

CustomUrlLauncher.prototype.launch = function(url, successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, "CustomUrlLauncher", "launch", [url]);
};

CustomUrlLauncher.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.customurllauncher = new CustomUrlLauncher();
  return window.plugins.customurllauncher;
};
cordova.addConstructor(CustomUrlLauncher.install);
