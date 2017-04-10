/**
 * API for making trainer related AJAX calls caliber endpoints
 * @param $log
 * @param $http
 * @returns {{}}
 */
angular.module("api").factory("trainerFactory", function ($log, $http) {
    $log.debug("Booted Trainer API");
    var trainer = {};

    /*************************** Batch ************************/
	// grab all batches
	trainer.getAllBatches = function() {
		return $http({
			url : "/caliber/trainer/batch/all",
			method : "GET"
		}).then(function(response) {
		    $log.debug("Batches successfully retrieved")
			$log.debug(response);
			return response.data;
		}, function(response) {
			$log.error("There was an error: " + response.status);
		});
	};
    // grab all batches
    trainer.getAllBatches = function () {
        return $http({
            url: "/caliber/trainer/batch/all",
            method: "GET"
        }).then(function (response) {
            $log.debug(response);
            return response.data;
        }, function (response) {
            $log.error("There was an error: " + response.status);
            return null;
        });
    };
    // grab all batches
    trainer.getAllBatches = function () {
        return $http({
            url: "/caliber/trainer/batch/all",
            method: "GET"
        }).then(function (response) {
            $log.debug("Batches successfully retrieved")
            $log.debug(response);
            return response.data;
        }, function (response) {
            $log.error("There was an error: " + response.status);
        });
    };
    // grab all batches
    trainer.getAllBatches = function () {
        return $http({
            url: "/caliber/trainer/batch/all",
            method: "GET"
        }).then(function (response) {
            $log.debug("Batches successfully retrieved");
            $log.debug(response);
            return response.data;
        }, function (response) {
            $log.error("There was an error: " + response.status);
        });
    };

    /*************************** Week ************************/
    // create a new week
    trainer.createWeek = function (weekObj) {
        return $http({
            url: "/caliber/trainer/week/new",
            method: "POST",
            data: weekObj
        }).then(function (response) {
            $log.debug("Week successfully created.");
            $log.debug(response);
            // return id
            return response.data;
        },function (response) {
            $log.error("There was an error: " + response.status);
        });
    };

    /*************************** Grade ************************/
    // add a new grade
    trainer.addGrade = function (gradeObj) {
        return $http({
            url: "/caliber/trainer/grade/create",
            method: "POST",
            data: gradeObj
        }).then(function (response) {
            $log.debug("Grade successfully created.");
            $log.debug(response);
        }, function (response) {
            $log.error("There was an error: " + response.status);
        });
    };

    // update trainer grade
    trainer.updateGrade = function (gradeObj) {
        return $http({
            url: "/caliber/trainer/grade/update",
            method: "PUT",
            data: gradeObj
        }).then(function (response) {
            $log.debug("Grade successfully updated");
            $log.debug(response);
        }, function(response) {
            $log.error("There was an error: " + response.status);
        });
    };

    /************************* Assessment ***********************/
    // create assessment
    trainer.createAssessment = function (assessmentObj) {
        return $http({
            url: "/caliber/trainer/assessment/create",
            method: "PUT",
            data: assessmentObj
        }).then(function (response) {
            $log.debug("Assessment successfully created.");
            $log.debug(response);
            // return id
            return response.data;
        }, function(response) {
            $log.error("There was an error: " + response.status);
        });
    };

    // get all assessments
    trainer.getAllAssessments = function (weekId) {
        return $http({
            url: "/caliber/trainer/assessment/week/" + weekId,
            method: "GET"
        }).then(function(response) {
            $log.debug("Assessments successfully retrieved");
            $log.debug(response);
            return response.data;
        }, function (response) {
            $log.error("There was an error: " + response.status);
        });
    };

    // update assessment
    trainer.updateAssessment = function (assessmentObj) {
        return $http({
            url: "/caliber/trainer/assessment/update/",
            method: "PUT",
            data: assessmentObj
        }).then(function (response) {
            $log.debug("Assessments successfully updated");
            $log.debug(response);
        }, function (response) {
            $log.error("There was an error: " + response.status);
        });
    };

    // delete assessment
    trainer.deleteAssessment = function (assessmentId) {
        return $http({
            url: "/caliber/trainer/assessment/delete/" + assessmentId,
            method: "DELETE"
        }).then(function(response) {
            $log.debug("Assessment successfully deleted");
            $log.debug(response);
        }, function (response) {
            $log.error("There was an error: " + response.status);
        });
    };

    /************************** Notes *************************/
    trainer.createNote = function (noteObj) {
        return $http({
            url: "/caliber/trainer/assessment/note/create",
            method: "POST",
            data: noteObj
        }).then(function(response) {
            $log.debug("Notes successfully created");
            $log.debug(response);
            // return id
            return response.data;
        }, function (response) {
            $log.error("There was an error: " + response.status);
        });
    };

    trainer.updateNote = function (noteObj) {
        return $http({
            url: "/caliber/trainer/assessment/note/update",
            method: "PUT",
            data: noteObj
        }).then(function (response) {
            $log.debug("Assessments successfully updated");
            $log.debug(response);
        }, function (response) {
            $log.error("There was an error: " + response.status);
        });
    };
    return trainer;
});