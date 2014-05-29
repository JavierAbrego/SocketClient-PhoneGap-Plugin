function SocketClient() {
}

SocketClient.prototype.sendSocket= function (address, port, message, successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, "SocketClient", "sendSocket", [address, port, message]);
};

SocketClient.install = function () {
  if (!window.plugins) {
    window.plugins = {};
  }

  window.plugins.socketClient = new SocketClient();
  return window.plugins.socketClient;
};

cordova.addConstructor(SocketClient.install);