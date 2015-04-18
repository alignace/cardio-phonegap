/**
 * CardIOPlugin.js
 * card.io phonegap plugin
 * @Copyright 2015 Alignace LLC. http://www.alignace.com
 * @author Ayajahmed Shaikh <ayaj.shaikh@alignace.com>
 * @Since 18 April, 2015
 */

// Response array contain these fields
// redacted_card_number, card_number, expiry_month,expiry_year, cvv, zip

var CardIOPlugin = function() {

};


//set your configurations here
var cardIOConfig = {
	'expiry': false,
	'cvv': false,
	'zip': false,
    'confirm': true,
    'hideLogo': true,
    'suppressManual': true
};
 
CardIOPlugin.prototype.requireExpiry = function(b) {
    cardIOConfig.expiry = b;
};

CardIOPlugin.prototype.requireCVV = function(b) {
    cardIOConfig.cvv = b;
};

CardIOPlugin.prototype.requireZip = function(b) {
    cardIOConfig.zip = b;
};

CardIOPlugin.prototype.requireConfirmation = function(b) {
    cardIOConfig.confirm = b;
};

CardIOPlugin.prototype.showLogo = function(b) {
    cardIOConfig.hideLogo = b;
};

CardIOPlugin.prototype.suppressManual = function(b) {
    cardIOConfig.suppressManual = b;
};

CardIOPlugin.prototype.scan = function(successCallback, errorCallback) {

    if (errorCallback == null) { errorCallback = function() {}}

    if (typeof errorCallback != "function")  {
        console.log("Scan failure: failure parameter not a function");
        return
    }

    if (typeof successCallback != "function") {
        console.log("Scan failure failure: success callback parameter must be a function");
        return
    }
    cordova.exec(successCallback, errorCallback, "CardIOPlugin", "scan", [cardIOConfig]);
};

//-------------------------------------------------------------------
if(!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.CardIOPlugin) {
    window.plugins.CardIOPlugin = new CardIOPlugin();
}

if (typeof module != 'undefined' && module.exports) {
  module.exports = CardIOPlugin;
}


//EOF