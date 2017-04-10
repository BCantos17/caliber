angular.module("qc").controller("qcHomeController",
    function ($scope, $log, caliberDelegate, chartsDelegate, allBatches) {
        $log.log("All Batches: ");
        $log.debug(allBatches);
        /********************************************* On Start ************************************************/

        (function start(){
            createDefaultChart();
        })();

        function createDefaultChart(){
            //Finishes any left over ajax animation from another page
            NProgress.done();

            $scope.batches = allBatches;
            $scope.currentBatch = allBatches[0];
            NProgress.start();
            caliberDelegate.agg.getAggTechBatch($scope.currentBatch.batchId)
                .then(function(data){
                    var radarChartObject = chartsDelegate.radar.getBatchRankComparisonChart(data);
                    $scope.radarData = radarChartObject.data;
                    $scope.radarLabels = radarChartObject.labels;
                    $scope.radarSeries = radarChartObject.series;
                    $scope.radarOptions = radarChartObject.options;
                }, function(){
                    NProgress.done();
                });

            caliberDelegate.agg.getAggWeekBatch($scope.currentBatch.batchId)
                .then(function(data){
                    NProgress.done();
                    var lineChartObject = chartsDelegate.line.getBatchProgressChart(data);
                    $scope.batchProgressLabels = lineChartObject.labels;
                    $scope.batchProgressData = lineChartObject.data;
                    $scope.batchProgressSeries = lineChartObject.series;
                    $scope.batchProgressOptions = lineChartObject.options;
                    $scope.batchProgressDatasetOverride = lineChartObject.datasetOverride;
                }, function(){
                    NProgress.done();
                });
        }

        /*********************************************** UI ***************************************************/
        var viewCharts = 1;
        $scope.currentTrainee = {name: "Trainee"};

        // on batch selection
        $scope.selectCurrentBatch = function (index) {
            $scope.currentTrainee = {name: "Trainee"};
            $scope.currentBatch = $scope.batches[index];
            viewCharts = 1;
            createBatchCharts();
        };

        // on trainee selection
        $scope.selectCurrentTrainee = function (index) {
            if (index === -1) {
                $scope.currentTrainee = {name: "Trainee"};
                viewCharts = 1;
                createBatchCharts();
            }
            else {
                $scope.currentTrainee = $scope.currentBatch.trainees[index];
                viewCharts = 3;
                createTraineeCharts();
            }
        };

        // hide filter tabs
        $scope.hideOtherTabs = function () {
            return $scope.currentBatch.trainingName !== "Batch";
        };

        // show charts
        $scope.showCharts = function (charts) {
            return charts === viewCharts;
        };

        // create charts on batch selection
        function createBatchCharts() {
            NProgress.start();
            caliberDelegate.agg.getAggTechBatch($scope.currentBatch.batchId)
                .then(function(data){
                    var radarChartObject = chartsDelegate.radar.getBatchRankComparisonChart(data);
                    $scope.radarData = radarChartObject.data;
                    $scope.radarLabels = radarChartObject.labels;
                    $scope.radarSeries = radarChartObject.series;
                    $scope.radarOptions = radarChartObject.options;
                }, function(){
                    NProgress.done();
                });

            caliberDelegate.agg.getAggWeekBatch($scope.currentBatch.batchId)
                .then(function(data){
                    NProgress.done();
                    var lineChartObject = chartsDelegate.line.getBatchProgressChart(data);
                    $scope.batchProgressLabels = lineChartObject.labels;
                    $scope.batchProgressData = lineChartObject.data;
                    $scope.batchProgressSeries = lineChartObject.series;
                    $scope.batchProgressOptions = lineChartObject.options;
                    $scope.batchProgressDatasetOverride = lineChartObject.datasetOverride;
                }, function(){
                    NProgress.done();
                });
        }

        // create charts on trainee selection
        function createTraineeCharts() {

            NProgress.start();
            caliberDelegate.agg.getAggWeekTrainee($scope.currentTrainee.traineeId)
                .then(function (data) {
                    $log.debug(data);
                    NProgress.done();
                    var lineChartObject = chartsDelegate.line.getTraineeProgressChart(data);
                    $scope.lineLabels = lineChartObject.labels;
                    $scope.lineSeries = lineChartObject.series;
                    $scope.lineData = lineChartObject.data;
                    $scope.lineDatasetOverride = lineChartObject.datasetOverride;
                    $scope.lineOptions = lineChartObject.options;
                }, function(){
                    NProgress.done();
                });

            caliberDelegate.agg.getAggTechTrainee($scope.currentTrainee.traineeId)
                .then(function (data) {
                    $log.debug(data);
                    var radarChartObject = chartsDelegate.radar.getTraineeTechProgressChart(data);
                    $scope.radarData = radarChartObject.data;
                    $scope.radarLabels = radarChartObject.labels;
                    $scope.radarSeries = radarChartObject.series;
                    $scope.radarOptions = radarChartObject.options;
                }, function() {
                    NProgress.done();
                }
            );
        }

    });