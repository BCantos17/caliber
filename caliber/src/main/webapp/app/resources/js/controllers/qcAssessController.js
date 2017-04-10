angular.module("qc")
    .controller("qcAssessController", function ($log, $scope, chartsDelegate, caliberDelegate, qcFactory) {
        $log.debug("Booted Trainer Assess Controller");

        /******************************** Sample Data *******************************/
        $scope.batches = [
            {
                batchId: 451, trainingName: 'Batch123', trainer: 'Patrick', coTrainer: '',
                skillType: 'Java', trainingType: 'CUNY', startDate: new Date(), endDate: new Date(),
                location: 'Queens, NY', goodGradeThreshold: 75, borderlineGradeThreshold: 40,
                trainees: [{traineeId: 53, name: "Charles", email: "charles@gmail.com", trainingStatus: "Active"},
                    {traineeId: 65, name: "Mike", email: "Mike@gmail.com", trainingStatus: "Active"},
                    {traineeId: 78, name: "Rebecca", email: "Rebecca@gmail.com", trainingStatus: "Active"}],
                weeks: [{weekId: 421, weekNumber: 1, topics: [{categoryId: 13, skillCategory: "Java Core"}]},
                    {weekId: 476, weekNumber: 2, topics: [{categoryId: 13, skillCategory: "SQL"}]},
                    {weekId: 486, weekNumber: 3, topics: [{categoryId: 13, skillCategory: "Design Patterns"}]},
                    {weekId: 495, weekNumber: 4, topics: [{categoryId: 13, skillCategory: "Hibernate"}]}]
            },
            {
                trainingName: 'Batch456', trainingType: 'Corporate', skillType: 'Java', location: 'Reston, VA',
                trainer: 'Ryan', coTrainer: 'Brian', startDate: new Date(), endDate: new Date()
            }
        ];

        var assessments = [
            [{
                assessmentId: 51, title: "Java Core Test I", rawScore: 50, type: "Mul Choice",
                categories: [{categoryId: 13, skillCategory: "Java"}]
            },
                {
                    assessmentId: 58, title: "Java Core Verbal", rawScore: 60, type: "Verbal",
                    categories: [{categoryId: 13, skillCategory: "Java"},
                        {categoryId: 15, skillCategory: "SQL"}]
                }],
            [{
                assessmentId: 78, title: "Java Core Test II", rawScore: 50, type: "Mul Choice",
                categories: [{categoryId: 13, skillCategory: "Java"}]
            },
                {
                    assessmentId: 89, title: "Java Core Verbal I", rawScore: 60, type: "Verbal",
                    categories: [{categoryId: 13, skillCategory: "Java"}]
                }]
        ];

        var grades = [
            {gradeId: 14, assessment: 51, trainee: 53, dateReceived: new Date(), score: 94},
            {gradeId: 15, assessment: 51, trainee: 65, dateReceived: new Date(), score: 84},
            {gradeId: 16, assessment: 51, trainee: 78, dateReceived: new Date(), score: 74}
        ];

        $scope.skill_categories = [
            {"categoryId": 5, "skillCategory": "HIBERNATE", "weeks": []},
            {"categoryId": 4, "skillCategory": "SPRING", "weeks": []},
            {"categoryId": 2, "skillCategory": "REST", "weeks": []},
            {"categoryId": 3, "skillCategory": "SOAP", "weeks": [1, 2, 3]},
            {"categoryId": 1, "skillCategory": "Core Java", "weeks": []}
        ];

        $scope.trainers = [
            {
                "trainerId": 1,
                "name": "Name",
                "title": "title",
                "email": "email3",
                "salesforceAccount": "account",
                "salesforceAuthenticationToken": "token",
                "salesforceRefreshToken": "token",
                "tier": {
                    "tierId": 1,
                    "tier": "ROLE_VP",
                    "ranking": 1
                }
            },
            {
                "trainerId": 7,
                "name": "Martino",
                "title": "title",
                "email": "nikolovski23@gmail.com",
                "salesforceAccount": "nikolovski23@gmail.com",
                "salesforceAuthenticationToken": "auth_token",
                "salesforceRefreshToken": "refr_token",
                "tier": {
                    "tierId": 1,
                    "tier": "ROLE_VP",
                    "ranking": 1
                }
            },
            {
                "trainerId": 5,
                "name": "Test trainee (TraineeDAO Test)",
                "title": "title",
                "email": "email5",
                "salesforceAccount": "sf_account",
                "salesforceAuthenticationToken": "sf_auth_token",
                "salesforceRefreshToken": "sf_refr_token",
                "tier": {
                    "tierId": 3,
                    "tier": "ROLE_TRAINER",
                    "ranking": 999
                }
            },
            {
                "trainerId": 29100,
                "name": "Kristy Kim",
                "title": "Trainer at Hunter",
                "email": "kkim@revature.com",
                "salesforceAccount": "sfaccountex",
                "salesforceAuthenticationToken": "sfauthenticationtoken",
                "salesforceRefreshToken": "sfrefreshtoken",
                "tier": {
                    "tierId": 3,
                    "tier": "ROLE_TRAINER",
                    "ranking": 999
                }
            }
        ];

        // END TEST DATA *********************

        /******************************************* UI ***********************************************/
        // starting scope vars
        $scope.currentBatch = $scope.batches[0];
        $scope.currentWeek = $scope.currentBatch.weeks[0];
        $scope.currentAssessments = getAssessments(0);

        // default -- view assessments table
        $scope.currentView = true;

        // back button
        $scope.back = function () {
            $scope.currentView = true;
        };

        // batch drop down select
        $scope.selectCurrentBatch = function (index) {
            $scope.currentBatch = $scope.batches[index];
            // set week
            $scope.currentWeek = $scope.currentBatch.weeks[0];

            /** replace with ajax call to get assessments by weekId **/
            // test function to grab assessments
            $scope.currentAssessments = getAssessments(index);
        };

        // select week
        $scope.selectWeek = function (index) {
            $scope.currentWeek = $scope.currentBatch.weeks[index];
            /** ajax call to get assessments by weekId **/
        };

        // active week
        $scope.showActiveWeek = function (index) {
            if ($scope.currentWeek === $scope.currentBatch.weeks[index])
                return "active";
        };

        // select assessment from list
        $scope.selectAssessment = function (index) {
            $scope.currentAssessment = $scope.currentAssessments[index];
            $scope.currentView = false;
            /** replace with ajax call to get grades by assessmentId **/
        };

        // find grade for trainee
        $scope.findGrade = function (traineeId) {
            var grade = grades.find(function (element) {
                return element.trainee === traineeId;
            });

            return grade.score;
        };

        /* Save Assessment */
        $scope.addAssessment = function () {
            assessments.push({
                trainingName: $scope.trainingName,
                trainingType: $scope.trainingType,
                skillType: $scope.skillType,
                weekId: $scope.weekId,
                rawScore: $scope.rawScore
            });
            qcFactory.createAssessment()
        };

        // test function - get assessment
        function getAssessments(index) {
            return assessments[index];
        }

    });
