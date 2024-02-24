package ru.popovash.api.scheduler;

public interface Task {
    int getTaskId();

    boolean isCancelled();

    void cancel();
}
