package org.t1academy.timetrackingsystem.services.impl;

import org.springframework.stereotype.Service;
import org.t1academy.timetrackingsystem.aspects.annotations.TrackAsyncTime;
import org.t1academy.timetrackingsystem.aspects.annotations.TrackTime;
import org.t1academy.timetrackingsystem.services.TestService;

@Service
public class TestServiceImpl implements TestService {

    @TrackTime
    @Override
    public void testTime() {
        int random = (int) (Math.random() * 10);
        for (int i = 0; i < random; i++) {
            System.out.println(i);
        }
    }

    @TrackAsyncTime
    @Override
    public void testAsyncTime() {
        int random = (int) (Math.random() * 10);
        for (int i = 0; i < random; i++) {
            System.out.println(i);
        }

    }
}
