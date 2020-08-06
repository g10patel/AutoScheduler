package com.company;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;

public class Settings {

    Boolean autoSchedule;
    Double timeInBetweenTasks;
    Double timeWorkingChunk;
    LocalTime startTime;
    LocalTime endTime;
    ArrayList<LocalTime> restrictedTimes;

    public Settings()
    {
        this.autoSchedule = false;
    }

    public Double getTimeInBetweenTasks() {
        return timeInBetweenTasks;
    }

    public void setTimeInBetweenTasks(Double timeInBetweenTasks) {
        this.timeInBetweenTasks = timeInBetweenTasks;
    }

    public Double getTimeWorkingChunk() {
        return timeWorkingChunk;
    }

    public void setTimeWorkingChunk(Double timeWorkingChunk) {
        this.timeWorkingChunk = timeWorkingChunk;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public ArrayList<LocalTime> getRestrictedTimes() {
        return restrictedTimes;
    }

    public void setRestrictedTimes(ArrayList<LocalTime> restrictedTimes) {
        this.restrictedTimes = restrictedTimes;
    }
    public void addRestricedTimes(LocalTime restrictedTime)
    {
        this.restrictedTimes.add(restrictedTime);
    }

    public void addRestricedTimes(ArrayList<LocalTime> restrictedTimes)
    {
        for (LocalTime i : restrictedTimes)
        {
            this.restrictedTimes.add(i);

        }
    }


    public void toggleAutoSchedule()
    {
        this.autoSchedule = !this.autoSchedule;
    }


}
