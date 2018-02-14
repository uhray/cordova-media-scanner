/**
 * @file MediaScanner PhoneGap/Cordova plugin
 * @license MIT
 */

var exec = require('cordova/exec');

// Consts
var SERVICE  = 'MediaScanner';
var ACTION   = 'MediaScanner';

/**
 * Runs media scanner
 * @public
 * @param  {string}   data
 * @param  {string}   [prefix]
 * @param  {function} [success]
 * @param  {function} [fail]
 * @return {undefined}
 */
module.exports = function(file, success, fail) {
  return exec(ok(success), error(fail), SERVICE, ACTION, [file]);
};

/**
 * Gets success callback if it is defined and not null.
 * Otherwise returns a simple console.log.
 * @private
 * @param  {[function|undefined|null]} success
 * @return {function}
 */
function ok(success) {
  if (typeof success !== 'function') {
    return console.log;
  }

  return success;
}

/**
 * Gets fail callback if it is defined and not null.
 * Otherwise returns a simple console.error.
 * @private
 * @param  {[function|undefined|null]} fail
 * @return {function}
 */
function error(fail) {
  if (typeof fail !== 'function') {
    return console.error;
  }

  return fail;
}
