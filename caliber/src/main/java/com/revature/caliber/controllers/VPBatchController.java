package com.revature.caliber.controllers;

import com.revature.caliber.beans.Batch;
import com.revature.caliber.gateway.ApiGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

/**
 * The type Vp batch controller.
 */
@RestController
@RequestMapping("/vp")
public class VPBatchController {

    private ApiGateway apiGateway;

    /**
     * Sets api gateway.
     *
     * @param apiGateway the api gateway
     */
    @Autowired
    public void setApiGateway(ApiGateway apiGateway) {
        this.apiGateway = apiGateway;
    }

    /**
     * getAllBatches - REST API method, retrieves all the batches
     *
     * @return in JSON, a set of batch objects
     */
    @RequestMapping(value = "/batch/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Batch>> getAllBatches() {
        return new ResponseEntity<>(apiGateway.getAllBatches(), HttpStatus.OK);
    }

    @RequestMapping(value = "/agg/tech/batch/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, HashMap<String, Double[]>>> aggregateTechForAllBatches() {
        return new ResponseEntity<>(apiGateway.getTechGradeAllBatch(), HttpStatus.OK);
    }
}
