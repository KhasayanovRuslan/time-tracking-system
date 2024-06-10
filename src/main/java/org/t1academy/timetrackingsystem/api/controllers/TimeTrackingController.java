package org.t1academy.timetrackingsystem.api.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.t1academy.timetrackingsystem.api.TimeTrackingApi;
import org.t1academy.timetrackingsystem.dto.AllMethodResult;
import org.t1academy.timetrackingsystem.dto.AllTimeTrackingResult;
import org.t1academy.timetrackingsystem.dto.TimeTrackingResult;
import org.t1academy.timetrackingsystem.services.TimeTrackingService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TimeTrackingController implements TimeTrackingApi {
    private final TimeTrackingService timeTracking;


    @Override
    public ResponseEntity<AllTimeTrackingResult> getAllTimeTrackingResult() {
        return ResponseEntity.ok(timeTracking.getLastMeasurements());
    }

    @Override
    public ResponseEntity<TimeTrackingResult> getMeasurements(final String methodName) {
        return ResponseEntity.ok(timeTracking.getTimeTracking(methodName));
    }

    @Override
    public ResponseEntity<AllMethodResult> getAllMethods() {
        return ResponseEntity.ok(timeTracking.getAllMethods());
    }

}
