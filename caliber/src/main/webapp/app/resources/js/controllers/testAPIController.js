angular.module("app").controller("testAPIController", function ($scope, $log, caliberDelegate) {
        $log.debug("Launched REST API");

        $scope.all = {};
        $scope.vp = {};
        $scope.qc = {};
        $scope.trainer = {};

        /************************ Test All ***********************/
        // create batch
        // $scope.createdBatch = caliberDelegate.all.createBatch(batchObj);

        // update batch
        // $scope.all.updatedBatch = caliberDelegate.all.updateBatch(batchObj);

        // delete batch
        // $scope.all.deletedBatch = caliberDelegate.all.deleteBatch(batchId);

        // create trainee
        // $scope.all.createdTrainee = caliberDelegate.all.createTrainee(traineeObj);

        // update trainee
        // $scope.all.updatedTrainee = caliberDelegate.all.updateTrainee(traineeObj);

        // delete trainee
        // $scope.all.deletedTrainee = caliberDelegate.all.deleteTrainee(traineeId);

        // get grades for assessments
        // $scope.all.grades = caliberDelegate.all.getGrades(assessmentId);

        // all trainers
        $scope.all.allTrainers = caliberDelegate.all.getAllTrainers();

        /************************* Trainer *************************/
        // all batches
        $scope.trainer.allBatches = caliberDelegate.trainer.getAllBatches();

        // create week
        // $scope.trainer.createdWeek = caliberDelegate.trainer.createWeek(weekObj);

        // add grade
        // $scope.trainer.newGrade = caliberDelegate.trainer.addGrade(gradeObj);

        // update grade
        // $scope.trainer.updatedGrade = caliberDelegate.trainer.updateGrade(gradeObj);

        // create assessment
        // $scope.trainer.createdAssessment = caliberDelegate.trainer.createAssessment(assessmentObj);

        // get all assessments
        // $scope.trainer.allAssessments = caliberDelegate.trainer.getAllAssessments(weekId);

        // update assessment
        // $scope.trainer.updatedAssessment = caliberDelegate.trainer.updateAssessment(assessmentObj);

        // delete assessment
        // $scope.trainer.deletedAssessment = caliberDelegate.trainer.deleteAssessment(assessmentId);

        // create note
        // $scope.trainer.createdNote = caliberDelegate.trainer.createNote(noteObj);

        // update note
        // $scope.trainer.updatedNote = caliberDelegate.trainer.updateNote(noteObj);

        /**************************** VP *****************************/
        // all batches
        $scope.vp.allBatches = caliberDelegate.vp.getAllBatches();

        // get all current batches
        $scope.vp.allCurrentBatches = caliberDelegate.vp.getAllCurrentBatches();

        /************************** Test QC *************************/
        // get all batches
        $scope.qc.allBatches = caliberDelegate.qc.getAllBatches();

        // add grade
        // $scope.qc.newGrade = caliberDelegate.qc.addGrade(gradeObj);

        // update grad
        // $scope.qc.updatedGrade = caliberDelegate.qc.updateGrade(gradeObj);

        // create assessment
        // $scope.qc.createdAssessment = caliberDelegate.qc.createAssessment(assessmentObj);

        // get all assessments
        // $scope.qc.allAssessments = caliberDelegate.qc.getAllAssessments(weekId);

        // delete assessment
        // $scope.qc.deletedAssessment = caliberDelegate.qc.deleteAssessment(assessmentId);

        // create note
        // $scope.qc.createdNote = caliberDelegate.qc.createNote(noteObj);

        // update note
        // $scope.qc.updatedNote = caliberDelegate.qc.updateNote(noteObj);

    });