angular.module("api")
    .factory("aggFactory", function ($http, $log) {
        $log.debug("Booted Aggregate Factory");

        var agg = {};
        /**
         *
         * @param traineeId
         * @returns {*}
         */
        agg.techTrainee = function(traineeId) {
            return $http({
                url: "/caliber/all/agg/tech/trainee/" + traineeId,
                method: "GET"
            }).then(function(response) {
                $log.debug("Agg - Tech - trainee -- success");
                $log.debug(response);
                return response.data;
            }, function(response) {
                $log.error("There was an error: " + response.status);
            });

        };
        /**
         *
         * @param traineeId
         * @returns {*}
         */
        agg.weekTrainee = function(traineeId) {
            return $http({
                url: "/caliber/all/agg/week/trainee/" + traineeId,
                method: "GET"
            }).then(function(response) {
                $log.debug("Agg - Week - trainee -- success");
                $log.debug(response);
                return response.data;
            }, function(response) {
                $log.error("There was an error: " + response.status);
            });
        };

        /**
         *
         * @param batchId
         * @returns {*}
         */
        agg.techBatch = function(batchId) {
            return $http({
                url: "/caliber/all/agg/tech/batch/" + batchId,
                method: "GET"
            }).then(function(response) {
                $log.debug("Agg - Tech - Batch -- success");
                $log.debug(response);
                return response.data;
            }, function(response) {
                $log.error("There was an error: " + response.status);
            });
        };

        /**
         *
         * @param batchId
         * @returns {*}
         */
        agg.weekBatch = function(batchId) {
            return $http({
                url: "/caliber/all/agg/week/batch/" + batchId,
                method: "GET"
            }).then(function(response) {
                $log.debug("Agg - Week - Batch -- success");
                $log.debug(response);
                return response.data;
            }, function(response) {
                $log.error("There was an error: " + response.status);
            });
        };

        /**
         *
         * @returns {*}
         */
        agg.techAllBatch = function() {
            return $http({
                url: "/caliber/vp/agg/tech/batch/all",
                method: "GET"
            }).then(function (response) {
                $log.debug("Agg - Tech - Batch - All -- success");
                $log.debug(response);
                return response.data;
            }, function (response) {
                $log.error("There was an error: " + response.status);
            });
        };

        /**
         *
         * @param trainerId
         * @returns {*}
         */
        agg.batchTrainer = function(trainerId) {
            return $http({
                url: "/caliber/all/agg/batch/trainer/" + trainerId,
                method: "GET"
            }).then(function(response) {
                $log.debug("Agg - Batch - Trainer -- success");
                $log.debug(response);
                return response.data;
            }, function(response) {
                $log.error("There was an error: " + response.status);
            });
        };

        return agg;
    });