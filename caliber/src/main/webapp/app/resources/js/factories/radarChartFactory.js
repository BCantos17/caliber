/**
 *
 * @param $log
 * @returns {{}}
 */
angular.module("charts").factory("radarChartFactory", function ($log) {
    $log.debug("Booted Radar Chart Factory");

    var radarChart = {};

    radarChart.getBatchRankComparisonChart = function (data) {
        var chartData = {};

        // series
        chartData.series = ["Batch"];

        // labels and data
        chartData.labels = [];
        chartData.data = [];

        // push empty arrays for data
        chartData.data.push([]);

        // loop through batch data
        angular.forEach(data, function (value, key) {
            chartData.labels.push(key);
            chartData.data[0].push(value[0]);
        });

        // set radar options
        chartData.options = {
            legend: {
                display: true,
                position: 'bottom'
            }
        };
        return chartData;
    };

    radarChart.getTraineeTechProgressChart = function (data) {
        var chartData = {};

        // series
        chartData.series = ["Technology"];

        // labels and data
        chartData.labels = [];
        chartData.data = [];

        // push empty arrays for data
        chartData.data.push([]);

        // loop through batch data
        angular.forEach(data, function (value, key) {
            chartData.labels.push(key);
            chartData.data[0].push(value[0]);
        });
        // set radar options
        chartData.options = {
            legend: {
                display: true,
                position: 'bottom'
            }
        };
        return chartData;
    };

    radarChart.getAllBatchRankComparisonChart = function (data) {
        var chartData = {};

        // series
        chartData.series = [];

        // labels and data
        chartData.labels = [];
        chartData.data = [];

        var firstPass = true;

        // loop through batch data
        angular.forEach(data, function (value, key) {
            chartData.series.push(key);
            var temp = [];
            angular.forEach(value, function(value2, key2){
                temp.push(value2[0]);
                if(firstPass)
                chartData.labels.push(key2);
            });
            firstPass = false;
            chartData.data.push(temp);
        });

        // set radar options
        chartData.options = {
            legend: {
                display: true,
                position: 'bottom'
            }
        };
        return chartData;
    };

    return radarChart;
});
