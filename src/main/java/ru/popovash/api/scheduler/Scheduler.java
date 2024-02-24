package ru.popovash.api.scheduler;

public interface Scheduler {
    void cancelTask(int taskId);

    void cancelAllTasks();

    Task runTask(Runnable runnable);

    Task runTaskLater(Runnable runnable, long delay);

    Task runTaskTimer(Runnable runnable, long delay, long period);
}
