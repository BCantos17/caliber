package com.revature.caliber.gateway.services.impl;

import com.revature.caliber.beans.Batch;
import com.revature.caliber.beans.Trainee;
import com.revature.caliber.beans.Trainer;
import com.revature.caliber.beans.Week;
import com.revature.caliber.beans.exceptions.TrainingServiceTraineeOperationException;
import com.revature.caliber.gateway.services.TrainingService;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.Serializable;
import java.util.*;

public class TrainingServiceImpl implements TrainingService {

    private String localhost = "http://localhost:8080";
    private String hostname;
    private String portNumber;

    //path for week
    private String weekId, weekNumber, batch, topics;

    //paths for batch
    private String newBatch, allBatch, allBatchesForTrainer, allCurrentBatch, allCurrentBatchByTrainer,
            batchById, updateBatch, deleteBatch;
    //paths for trainee (look at beans.xml for the paths themselves)
    private String addTraineePath, updateTraineePath, deleteTraineePath, getTraineeByIdPath, getTraineeByNamePath,
            getTraineesByBatchPath, getTraineesByTrainerPath;
    private String addTrainerPath, updateTrainerPath, getAllTrainersPath, getTrainerByIdPath, getTrainerByEmailPath;
    private String getWeekByBatch;
    //paths for week
    private String addWeekPath, getAllWeekPath;
    private String addTraineesPath;

    /***********************************Batch**********************************/
    @Override
    public Long createBatch(Batch batch) {
        RestTemplate service = new RestTemplate();
        // Build Service URL
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(newBatch)
                .build().toUriString();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Batch> entity = new HttpEntity<>(batch, headers);

        ResponseEntity<Long> response = service.exchange(URI, HttpMethod.POST, entity, Long.class);
        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new RuntimeException("Batch could not be created");
        }

        return response.getBody();
    }

    @Override
    public Set<Batch> allBatch() {
        RestTemplate service = new RestTemplate();
        // Build Service URL
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(allBatch)
                .build().toUriString();
        // Invoke the service
        ResponseEntity<Batch[]> response = service.getForEntity(URI, Batch[].class);

        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new RuntimeException("Bad request.");
        } else if (response.getStatusCode() == HttpStatus.OK) {
            return  new HashSet(Arrays.asList(response.getBody()));
        } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return new HashSet<>();
        } else {
            // Includes 404 and other responses. Give back no data.
            return new HashSet<>();
        }
    }

    @Override
    public Set<Batch> getBatches(Integer id) {
        RestTemplate service = new RestTemplate();
        // Build Service URL
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname + allBatchesForTrainer)
                .path(id.toString()).build().toUriString();

        // Invoke the service
        ResponseEntity<Batch[]> response = service.getForEntity(URI, Batch[].class);

        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new RuntimeException("Trainer not found in batch.");
        } else if (response.getStatusCode() == HttpStatus.OK) {
            return new HashSet(Arrays.asList(response.getBody()));
        } else {
            // Includes 404 and other responses. Give back no data.
            return new HashSet<>();
        }
    }

    @Override
    public List<Batch> currentBatches() {
        RestTemplate service = new RestTemplate();
        // Build Service URL
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(allCurrentBatch)
                .build().toUriString();
        // Invoke the service
        ResponseEntity<Batch[]> response = service.getForEntity(URI, Batch[].class);

        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new RuntimeException("No Current batches.");
        } else if (response.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(response.getBody());
        } else {
            // Includes 404 and other responses. Give back no data.
            return new ArrayList<>();
        }
    }


    @Override
    public List<Batch> currentBatches(Integer id) {
        RestTemplate service = new RestTemplate();
        final String URI =
                UriComponentsBuilder.fromHttpUrl(hostname)
                        .path(allCurrentBatchByTrainer).path(String.valueOf(id))
                        .build().toUriString();
        // Invoke the service
        ResponseEntity<Batch[]> response = service.getForEntity(URI, Batch[].class);
        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new RuntimeException("Could not find batch");
        } else if (response.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(response.getBody());
        } else {
            // Includes 404 and other responses. Give back no data.
            return new ArrayList<>();
        }
    }

    @Override
    public Batch getBatch(Integer id) {
        RestTemplate service = new RestTemplate();
        String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(batchById).
                path(String.valueOf(id)).build().toUriString();
        // Invoke the service
        ResponseEntity<Batch> response = service.getForEntity(URI, Batch.class);
        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new RuntimeException("Could not find batch");
        } else if (response.getStatusCode() == HttpStatus.OK)
            return response.getBody();
        return null;
    }

    @Override
    public void updateBatch(Batch batch) {
        RestTemplate service = new RestTemplate();
        String URI = UriComponentsBuilder.fromHttpUrl(hostname).
                path(updateBatch).build().toUriString();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Batch> entity = new HttpEntity<>(batch, headers);
        ResponseEntity<Serializable> response = service.exchange(URI, HttpMethod.POST,
                entity, Serializable.class);
        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new RuntimeException("Batch could not be updated");
        }
    }

    @Override
    public void deleteBatch(Batch batch) {
        RestTemplate service = new RestTemplate();
        String URI = UriComponentsBuilder.fromHttpUrl(hostname).
                path(deleteBatch).build().toUriString();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity<>(batch, headers);
        //Invoke the service
        ResponseEntity<Serializable> response = service.exchange(URI, HttpMethod.DELETE,
                entity, Serializable.class);
        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new RuntimeException("Batch could not be updated");
        }
    }

    //Trainee------------------------------------------------------------
    @Override
    public long createTrainee(com.revature.caliber.training.beans.Trainee trainee) {
        RestTemplate service = new RestTemplate();
        //Build Parameters
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(addTraineePath)
                .build().toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<com.revature.caliber.training.beans.Trainee> entity = new HttpEntity<>(trainee, headers);

        //Invoke the service
        ResponseEntity<Long> response = service.exchange(URI, HttpMethod.PUT, entity, Long.class);
        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new TrainingServiceTraineeOperationException("Trainee could not be created");
        }
        return response.getBody();
    }
    @Override
    public long createTrainees(com.revature.caliber.training.beans.Trainee[] trainees) {
        RestTemplate service = new RestTemplate();
        //Build Parameters
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(addTraineesPath)
                .build().toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<com.revature.caliber.training.beans.Trainee[]> entity
                = new HttpEntity(trainees, headers);

        //Invoke the service
        ResponseEntity<Long> response = service.exchange(URI, HttpMethod.PUT, entity, Long.class);
        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new TrainingServiceTraineeOperationException("Trainees could not be created");
        }
        return response.getBody();
    }

    @Override
    public void updateTrainee(Trainee trainee) {
        RestTemplate service = new RestTemplate();
        //Build Parameters
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(updateTraineePath)
                .build().toUriString();

        //Invoke the service
        ResponseEntity<Serializable> response = service.postForEntity(URI, trainee, Serializable.class);
        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new TrainingServiceTraineeOperationException("Trainer could not be updated");
        }
    }

    @Override
    public Trainee getTrainee(Integer id) {
        RestTemplate service = new RestTemplate();
        //Build Parameters
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(getTraineeByIdPath)
                .path(id.toString())
                .build().toUriString();

        //Invoke the service
        ResponseEntity<Trainee> response = service.getForEntity(URI, Trainee.class);

        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new TrainingServiceTraineeOperationException("Failed to retrieve the trainee by id.");
        } else if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public Trainee getTrainee(String email) {
        email = email.replace("@", "%40").replace(".", "_dot_");
        RestTemplate service = new RestTemplate();
        //Build Parameters
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(getTraineeByNamePath)
                .path(email)
                .build().toUriString();

        //Invoke the service
        ResponseEntity<Trainee> response = service.getForEntity(URI, Trainee.class);

        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new TrainingServiceTraineeOperationException("Failed to retrieve the trainee by email.");
        } else if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public List<Trainee> getTraineesInBatch(Integer batchId) {
        RestTemplate service = new RestTemplate();
        //Build Parameters
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(getTraineesByBatchPath)
                .path(batchId.toString())
                .build().toUriString();

        //Invoke the service
        ResponseEntity<Trainee[]> response = service.getForEntity(URI, Trainee[].class);

        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new TrainingServiceTraineeOperationException("Failed to retrieve trainees by batch.");
        } else if (response.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(response.getBody());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Trainee> getTraineesByTrainer (Long trainerId) {
        RestTemplate service = new RestTemplate();
        //Build Parameters
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(getTraineesByTrainerPath)
                .path("/" + trainerId.toString())
                .build().toUriString();

        //Invoke the service
        ResponseEntity<Trainee[]> response = service.getForEntity(URI, Trainee[].class);

        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new TrainingServiceTraineeOperationException("Failed to retrieve trainees by trainer.");
        } else if (response.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(response.getBody());
        } else {
            return new ArrayList<>();
        }
    }


    @Override
    public void deleteTrainee(Trainee trainee) {
        RestTemplate service = new RestTemplate();
        //Build Parameters
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(deleteTraineePath)
                .build().toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Trainee> entity = new HttpEntity<>(trainee, headers);

        //Invoke the service
        ResponseEntity<Serializable> response = service.exchange(URI, HttpMethod.DELETE, entity, Serializable.class);
        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new TrainingServiceTraineeOperationException("Trainee could not be deleted");
        }
    }
    //End of Trainee -------------------------------------------------------------------------------

    //Trainer --------------------------------------------------------------------------------------
    @Override
    public void createTrainer(Trainer trainer) {
        RestTemplate service = new RestTemplate();
        //Build Parameters
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(addTrainerPath)
                .build().toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Trainer> entity = new HttpEntity<>(trainer, headers);

        //Invoke the service
        ResponseEntity<Serializable> response = service.exchange(URI, HttpMethod.PUT, entity, Serializable.class);
        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new RuntimeException("Trainee could not be created");
        }
    }


    @Override
    public Trainer getTrainer(Integer id) {
        RestTemplate service = new RestTemplate();
        //Build Parameters
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(getTrainerByIdPath)
                .path(id.toString())
                .build().toUriString();
        //Invoke the service
        ResponseEntity<Trainer> response = service.getForEntity(URI, Trainer.class);

        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new RuntimeException("Failed to retrieve the trainer by id.");
        } else if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }


    @Override
    public void updateTrainer(Trainer trainer) {
        RestTemplate service = new RestTemplate();
        //Build Parameters
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(updateTrainerPath)
                .build().toUriString();

        //Invoke the service
        ResponseEntity<Serializable> response = service.postForEntity(URI, trainer, Serializable.class);
        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new RuntimeException("Trainer could not be updated");
        }
    }



    //End of Trainer ----------------------------------------------------------------------------



    // Week
    @Override
    public List<Week> getAllWeek() {

        RestTemplate service = new RestTemplate();
        // Build Service URL
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path("training/week/all").build().toUriString();

        System.out.println(URI);
        // Invoke the service
        ResponseEntity<Week[]> response = service.getForEntity(URI, Week[].class);

        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new RuntimeException("Bad request.");
        } else if (response.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(response.getBody());
        } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            System.out.println("Not found");
            return new ArrayList<>();
        } else {
            // Includes 404 and other responses. Give back no data.
            return new ArrayList<>();
        }
    }

    @Override
    public Long createWeek(Week week) {
        RestTemplate service = new RestTemplate();
        // Build Parameters
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path("training/week/new").build()
                .toUriString();

        System.out.println(URI);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Week> entity = new HttpEntity<>(week, headers);

        // Invoke the service
        ResponseEntity<Long> response = service.exchange(URI, HttpMethod.POST, entity, Long.class);
        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new RuntimeException("Trainee could not be created");
        }

        return response.getBody();
    }




    @Override
    public Trainer getTrainer(String email) {
        RestTemplate service = new RestTemplate();
        //Build Parameters
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(getTrainerByEmailPath)
                .path(email)
                .build().toUriString();

        //Invoke the service
        ResponseEntity<Trainer> response = service.getForEntity(URI, Trainer.class);

        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new RuntimeException("Failed to retrieve the trainer by email.");
        } else if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public List<Trainer> getAllTrainers() {
        RestTemplate service = new RestTemplate();
        //Build Parameters
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(getAllTrainersPath)
                .build().toUriString();

        //Invoke the service
        ResponseEntity<Trainer[]> response = service.getForEntity(URI, Trainer[].class);

        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new RuntimeException("Failed to retrieve all trainers.");
        } else if (response.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(response.getBody());
        } else {
            return new ArrayList<>();
        }
    }


    //End of Trainer ----------------------------------------------------------------------------


    //Week --------------------------------------------------------------------------------------

    @Override
    public List<Week> getWeekByBatch(int batchId) {
        RestTemplate service = new RestTemplate();
        final String URI = UriComponentsBuilder.fromHttpUrl(hostname).path(getWeekByBatch).path(String.valueOf(batchId))
                .build().toUriString();
        //Invoke the service
        ResponseEntity<Week[]> response = service.getForEntity(URI, Week[].class);

        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new RuntimeException("Failed to retrieve Week by Batch.");
        } else if (response.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(response.getBody());
        } else {
            return new ArrayList<>();
        }
    }


    //End of Week     ----------------------------------------------------------------------------

    /////////// SETTERS ////////////////
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    //Batch
    public void setNewBatch(String newBatch) {
        this.newBatch = newBatch;
    }

    public void setAllBatch(String allBatch) {
        this.allBatch = allBatch;
    }

    public void setAllBatchesForTrainer(String allBatchesForTrainer) {
        this.allBatchesForTrainer = allBatchesForTrainer;
    }

    public void setAllCurrentBatch(String allCurrentBatch) {
        this.allCurrentBatch = allCurrentBatch;
    }

    public void setAllCurrentBatchByTrainer(String allCurrentBatchByTrainer) {
        this.allCurrentBatchByTrainer = allCurrentBatchByTrainer;
    }

    public void setBatchById(String batchById) {
        this.batchById = batchById;
    }

    public void setUpdateBatch(String updateBatch) {
        this.updateBatch = updateBatch;
    }

    public void setDeleteBatch(String deleteBatch) {
        this.deleteBatch = deleteBatch;
    }
    //end of batch

    //Trainee
    public void setAddTraineePath(String addTraineePath) {
        this.addTraineePath = addTraineePath;
    }

    public void setUpdateTraineePath(String updateTraineePath) {
        this.updateTraineePath = updateTraineePath;
    }

    public void setDeleteTraineePath(String deleteTraineePath) {
        this.deleteTraineePath = deleteTraineePath;
    }

    public void setGetTraineeByIdPath(String getTraineeByIdPath) {
        this.getTraineeByIdPath = getTraineeByIdPath;
    }

    public void setGetTraineeByNamePath(String getTraineeByNamePath) {
        this.getTraineeByNamePath = getTraineeByNamePath;
    }

    public void setGetTraineesByBatchPath(String getTraineesByBatchPath) {
        this.getTraineesByBatchPath = getTraineesByBatchPath;
    }

    public void setGetTraineesByTrainerPath(String getTraineesByTrainerPath) {
        this.getTraineesByTrainerPath = getTraineesByTrainerPath;
    }

    //end of Trainee

    //Trainer
    public void setAddTrainerPath(String addTrainerPath) {
        this.addTrainerPath = addTrainerPath;
    }

    public void setUpdateTrainerPath(String updateTrainerPath) {
        this.updateTrainerPath = updateTrainerPath;
    }

    public void setGetAllTrainersPath(String getAllTrainersPath) {
        this.getAllTrainersPath = getAllTrainersPath;
    }

    public void setGetTrainerByIdPath(String getTrainerByIdPath) {
        this.getTrainerByIdPath = getTrainerByIdPath;
    }

    public void setGetTrainerByEmailPath(String getTrainerByEmailPath) {
        this.getTrainerByEmailPath = getTrainerByEmailPath;
    }
    //End of Trainer

    //Week
    public void setGetWeekByBatch(String getWeekByBatch) {
        this.getWeekByBatch = getWeekByBatch;
    }

    public void setAddWeekPath(String addWeekPath) {
        this.addWeekPath = addWeekPath;
    }

    public void setGetAllWeekPath(String getAllWeekPath) {
        this.getAllWeekPath = getAllWeekPath;
    }

    public void setAddTraineesPath(String addTraineesPath) {
        this.addTraineesPath = addTraineesPath;
    }

    public String getAddTraineesPath() {
        return addTraineesPath;
    }
    //End of Week

}

