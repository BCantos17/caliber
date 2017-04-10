angular.module("trainer")
    .controller("trainerAssessController", function($log, $scope, chartsDelegate, caliberDelegate, allBatches){

        $log.debug("Booted Trainer Aesess Controller");

        /******************************TEST DATA***********************/
        $scope.skill_categories = [
            {categoryId: 1, skillCategory:"Java"},
            {categoryId: 2, skillCategory:"SQL"},
            {categoryId: 3, skillCategory:"Servlet"},
            {categoryId: 4, skillCategory:"JSP"},
            {categoryId: 5, skillCategory:"XML"},
            {categoryId: 6, skillCategory:"Git"},
            {categoryId: 7, skillCategory:"JUnit"},
            {categoryId: 8, skillCategory:"Maven"},
            {categoryId: 9, skillCategory:"JDBC"},
            {categoryId: 10, skillCategory:"HTML"},
            {categoryId: 11, skillCategory:"CSS"},
            {categoryId: 12, skillCategory:"Javascript"},
            {categoryId: 13, skillCategory:"JQuery"},
            {categoryId: 14, skillCategory:"AJAX"},
            {categoryId: 15, skillCategory:"UNIX"},
            {categoryId: 16, skillCategory:"AWS"},
            {categoryId: 17, skillCategory:"Jenkins"},
            {categoryId: 18, skillCategory:"Hibernate"},
            {categoryId: 19, skillCategory:"Spring"},
            {categoryId: 20, skillCategory:"SOAP"},
            {categoryId: 21, skillCategory:"REST"},
            {categoryId: 22, skillCategory:"AngularJS"},
            {categoryId: 23, skillCategory:"Selenium"},
            {categoryId: 24, skillCategory:"Cucumber"},
            {categoryId: 25, skillCategory:"UFT"},
            {categoryId: 26, skillCategory:"Python"},
            {categoryId: 27, skillCategory:"Robot Framework"},
            {categoryId: 28, skillCategory:"ALM"},
            {categoryId: 29, skillCategory:"SDLC"},
            {categoryId: 30, skillCategory:"Agile"},
            {categoryId: 31, skillCategory:"Testing"},
            {categoryId: 32, skillCategory:"VBScript"},
            {categoryId: 33, skillCategory:"SOAP UI"},
            {categoryId: 34, skillCategory:"TestNG"},
            {categoryId: 35, skillCategory:"Chef"},
            {categoryId: 36, skillCategory:"Docker"},
            {categoryId: 37, skillCategory:"Kafka"},
            {categoryId: 38, skillCategory:"Microservices"},
            {categoryId: 39, skillCategory:"NoSQL"},
            {categoryId: 40, skillCategory:"C#"},
            {categoryId: 41, skillCategory:"ASP.NET"},
            {categoryId: 42, skillCategory:"ADO.NET"},
            {categoryId: 43, skillCategory:"Entity Framework"},
            {categoryId: 44, skillCategory:"MSBuild"},
            {categoryId: 45, skillCategory:"WPF"},
            {categoryId: 46, skillCategory:"WCF"}
        ];




        /******************************************* UI ***********************************************/

        $log.debug("Batches " + allBatches);
        $log.debug(allBatches);

        (function start(allBatches){
            $scope.batches = allBatches;
           if(allBatches.length > 0){
               $scope.currentBatch = allBatches[0];
               if(allBatches[0].weeks.length > 0){
                   allBatches[0].weeks.sort(weekComparator);
                   $scope.currentWeek = allBatches[0].weeks[0];
                   getAllAssessmentsForWeek();
               }

               else $scope.currentWeek = null;
           }else{
               $scope.currentBatch = null;
               $scope.currentWeek = null;
           }
           $log.debug("Starting Values: currentBatch and currentWeek");
           $log.debug($scope.currentBatch);
           $log.debug($scope.currentWeek);
        })(allBatches);

        $scope.grades = [];

        // default -- view assessments table
        $scope.currentView = true;

        // back button
        $scope.back = function () {
            $scope.currentView = true;
        };

        // batch drop down select
        $scope.selectCurrentBatch = function(index){
            $scope.currentBatch = $scope.batches[index];

            if($scope.currentBatch.weeks.length > 0){
                $scope.currentBatch.weeks.sort(weekComparator);
                $scope.currentWeek = $scope.currentBatch.weeks[0];
            }
            else $scope.currentWeek = null;

            /** replace with ajax call to get assessments by weekId **/
            getAllAssessmentsForWeek()
        };


        // select week
        $scope.selectWeek = function (index) {
            $scope.currentWeek = $scope.currentBatch.weeks[index];
            $log.debug($scope.currentWeek);
            /** ajax call to get assessments by weekId **/
            getAllAssessmentsForWeek();
        };

        // active week
        $scope.showActiveWeek = function (index) {
            if ($scope.currentWeek === $scope.currentBatch.weeks[index])
                return "active";
        };

        //create week
        $scope.createWeek = function () {
            var weekNumber;
            if(!$scope.currentBatch.weeks)
                weekNumber  = 1;
            else weekNumber = $scope.currentBatch.weeks.length+1;
            $log.debug(weekNumber);
            var weekObj = {
                weekId:1,
                weekNumber: weekNumber,
                batch: $scope.currentBatch,
                topics:null
            };
            caliberDelegate.trainer.createWeek(weekObj).then(function (response) {
                $scope.currentBatch.weeks.push({
                    weekId:response,
                    weekNumber: weekNumber,
                    batch: null,
                    topics:null
                });
                $log.debug($scope.currentBatch.weeks);
            });

        };

        // select assessment from list
        $scope.selectAssessment = function (index) {
            $scope.currentAssessment = $scope.currentAssessment[index];
            $scope.currentView = false;
            /** replace with ajax call to get grades by assessmentId **/
        };
        
        $scope.addAssessment = function () {
            var assessment = {
                assessmentId: 1,
                title: $scope.trainingName,
                batch: $scope.currentBatch.batchId,
                type: $scope.trainingType,
                categories:  $scope.selectedCategories,
                week: $scope.currentWeek.weekId,
                weeklyStatus: null,
                rawScore: $scope.rawScore
            };
            $log.debug(assessment);
            caliberDelegate.trainer.createAssessment(assessment).then(function (response) {
              $log.debug(response);
              if($scope.currentAssessments > 0)
                    $scope.currentAssessments.push(assessment);
              else $scope.currentAssessments = assessment;
                getAllAssessmentsForWeek();
                $("#createAssessmentModal").modal('toggle');

            });
        };
        $scope.selectedCategories = [];

        $scope.toggleSelection = function (category) {
            var index = $scope.selectedCategories.indexOf(category);
            if(index > -1) $scope.selectedCategories.splice(index,1);
            else $scope.selectedCategories.push(category);
        };

        $scope.updateGrade = function (traineeId, assessment) {
            $log.debug(traineeId);
            var grade = {
                gradeId: 1,
                assessment: assessment,
                trainee: traineeId,
                dateReceived: new Date(),
                score: document.getElementById((traineeId+""+assessment.assessmentId)).value,

            };

            caliberDelegate.trainer.addGrade(grade).then(function (response) {
                $log.debug("======= ADD GRADE =======");
                $log.debug(response);
            })
        }

        function weekComparator(w1,w2) {
            return (w1.weekNumber>w2.weekNumber)? 1:
                (w2.weekNumber>w1.weekNumber)?-1 : 0;
        }

        function getAllAssessmentsForWeek(){
            caliberDelegate.trainer.getAllAssessments($scope.currentWeek.weekId)
                .then(function(data){
                    $scope.currentAssessments = data;
                    $log.debug($scope.currentAssessments);
                    $scope.currentAssessments.forEach(function (assessment) {
                        caliberDelegate.all.getGrades(assessment.assessmentId).then(function (response) {
                            $scope.grades.push(response.data);
                            $log.debug("====== GRADES ======");
                            $log.debug($scope.grades);
                        });
                    });

                });
        }

    });
