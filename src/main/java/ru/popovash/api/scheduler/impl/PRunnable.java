package ru.popovash.api.scheduler.impl;

import lombok.NonNull;
import ru.popovash.api.PopovashAPI;
import ru.popovash.api.scheduler.Task;

public abstract class PRunnable implements Runnable {
    private Task task;

    public synchronized boolean isCancelled() {
        checkScheduled();
        return task.isCancelled();
    }

    public synchronized void cancel() {
        PopovashAPI.getScheduler().cancelTask(getTaskId());
    }

    public synchronized @NonNull Task runTask() {
        checkNotYetScheduled();
        return setupTask(PopovashAPI.getScheduler().runTask(this));
    }

    public synchronized @NonNull Task runTaskLater(long delay) {
        checkNotYetScheduled();
        return setupTask(PopovashAPI.getScheduler().runTaskLater(this, delay));
    }

    public synchronized @NonNull Task runTaskTimer(long delay, long perid) {
        checkNotYetScheduled();
        return setupTask(PopovashAPI.getScheduler().runTaskTimer(this, delay, perid));
    }

    public synchronized int getTaskId() {
        checkScheduled();
        return task.getTaskId();
    }

    private void checkScheduled() {
        if (task == null) throw new IllegalStateException("Not scheduled yet");
    }

    private void checkNotYetScheduled() {
        if (task != null) throw new IllegalStateException("Already scheduled as " + task.getTaskId());
    }

    private Task setupTask(Task task) {
        this.task = task;
        return task;
    }
}
