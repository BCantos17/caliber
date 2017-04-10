/**
 * API for making vp related AJAX calls to the backend
 * @param $log
 * @param $http
 * @returns {{}}
 */
angular.module("api").factory("vpFactory", function ($log, $http) {
    $log.debug("Booted VP API Factory");
    var vp = {};

    // Get all batches
    vp.getAllBatches = function () {
        return $http({
            url: "/caliber/vp/batch/all",
            method: "GET"
        }).then(function (response) {
            $log.debug("Batches successfully retrieved.");
            $log.debug(response);
            return response.data;
        }, function (response) {
            $log.error("There was an error: " + response.status);
        });
    };

    // Get all current batches
    vp.getAllCurrentBatches = function () {
        return $http({
            url: "/caliber/vp/batch/current/all",
            method: "GET"
        }).then(function (response) {
            $log.debug("Batches successfully retrieved");
            $log.debug(response);
        }, function (response) {
            $log.error("There was an error: " + response.status);
        });
    };

    return vp;
});