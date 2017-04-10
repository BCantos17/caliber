angular.module("auth").factory("authFactory", function ($log, $http, $cookies, $state, $location) {
    $log.debug("Booted Authentication Factory");

    var auth = {};

    // Roles
    var vpRole = "ROLE_VP";
    var qcRole = "ROLE_QC";
    var trainerRole = "ROLE_TRAINER";

    // home states
    var vpState = "vp.home";
    var qcState = "qc.home";
    var trainerState = "trainer.home";

    // home
    var vpHome = "/vp/home";
    var qcHome = "/qc/home";
    var trainerHome = "/trainer/home";

    //
    /**
     * Retrieves role from cookie
     * @returns A cookie that contains the role
     */
    function getCookie() {
        return $cookies.get("role");
    }

    //

    /**
     * Moves user to home page when entering root
     */
    auth.auth = function () {
        var role = getCookie();
        if (role === trainerRole)
            $state.go(trainerState);
        else if (role === qcRole)
            $state.go(qcState);
        else $state.go(vpState);
    };

    /**
     *  Moves user to home page if user is not of role qc
     */
    auth.authQC = function () {
        var role = getCookie();
        if (role === qcRole)
            $log.debug("Authenticated user as QC");
        else if (role === trainerRole)
            $location.path(trainerHome);
        else $location.path(vpHome);
    };

    //

    /**
     * moves user to home page if user is not of role vp
     */
    auth.authVP = function () {
        var role = getCookie();
        if (role === vpRole)
            $log.debug("Authenticate user as VP");
        else if (role === trainerRole)
            $location.path(trainerHome);
        else $location.path(qcHome);
    };

    /**
     * Moves user to home page if user is not of role trainer
     */
    auth.authTrainer = function () {
        var role = getCookie();
        if (role === trainerRole)
            $log.debug("Authenticated user as Trainer");
        else if (role === qcRole)
            $location.path(qcHome);
        else $location.path(vpHome);
    };

    return auth;
});