angular.module("app").config(
    function ($stateProvider, $locationProvider, $urlRouterProvider,
              ChartJsProvider, $logProvider) {

        // Turn on/off debug messages
        $logProvider.debugEnabled(true);

        // chart options
        ChartJsProvider.setOptions({

            chartColors: ['#803690', '#00ADF9', '#ffff66', '#FDB45C', '#949FB1', '#4D5360', '#66ff33', '#ff5050']

        });

        // go to home on startup
        $urlRouterProvider.otherwise('/routing');

        // app states
        $stateProvider
            .state("routing", {
                url: "/routing",
                templateUrl: "app/partials/routing.html"
                // uncomment when dev is complete
                // onEnter:
                //     function(authFactory){
                //         authFactory.auth();
                //     }
            })
            .state("testPage", {
                url: "/testpage",
                templateUrl: "app/partials/testPage.html",
                controller: "testAPIController"
            })

            // qc
            .state("qc", {
                abstract: true,
                url: "/qc",
                templateUrl: "app/partials/abstracts/qc.html",
                resolve: {
                    allBatches: function(caliberDelegate){
                        return caliberDelegate.qc.getAllBatches();
                    }
                }
                // uncomment when dev is complete
                // onEnter:
                //     function(authFactory){
                //         authFactory.authQC();
                //     }

            })
            .state("qc.home", {
                url: "/home",
                templateUrl: "app/partials/home/qc-home.html",
                controller: "qcHomeController"
            })
            .state("qc.manage", {
                url: "/manage",
                templateUrl: "app/partials/qc-manage.html",
                controller: "qcManageController"
            })
            .state("qc.assess", {
                url: "/assess",
                templateUrl: "app/partials/assess/qc-assess.html",
                controller: "qcAssessController"
            })
            // trainer
            .state("trainer", {
                abstract: true,
                url: "/trainer",
                templateUrl: "app/partials/abstracts/trainer.html",
                resolve: {
                    allBatches: function(caliberDelegate){
                        return caliberDelegate.trainer.getAllBatches();
                    }
                }
                // uncomment when dev is complete
                // onEnter:
                //     function(authFactory){
                //         authFactory.authTrainer();
                //     }
            })
            .state("trainer.home", {
                templateUrl: "app/partials/home/trainer-home.html",
                url: "/home",
                controller: "trainerHomeController"
            })
            .state("trainer.manage", {
                templateUrl: "app/partials/manage-batch.html",
                url: "/manage",
                controller: "trainerManageController"
            })
            .state("trainer.assess", {
                templateUrl: "app/partials/assess/trainer-assess.html",
                url: "/assess",
                controller: "trainerAssessController"
            })

            // vp
            .state("vp", {
                abstract: true,
                url: "/vp",
                templateUrl: "app/partials/abstracts/vp.html",
                resolve: {
                    allBatches: function(caliberDelegate){
                        return caliberDelegate.vp.getAllBatches();
                    }
                }
                // uncomment when dev is complete
                // onEnter:
                //     function(authFactory){
                //         authFactory.authVP();
                //     }

            })
            .state("vp.home", {
                templateUrl: "app/partials/home/vp-home.html",
                url: "/home",
                controller: "vpHomeController"
            })
            .state("vp.manage", {
                templateUrl: "app/partials/manage-batch.html",
                url: "/manage"
            });
    });