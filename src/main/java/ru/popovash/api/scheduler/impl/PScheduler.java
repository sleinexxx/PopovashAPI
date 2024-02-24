package ru.popovash.api.scheduler.impl;

import ru.popovash.api.scheduler.Scheduler;
import ru.popovash.api.scheduler.Task;

import java.util.Map;
import java.util.concurrent.*;

public class PScheduler implements Scheduler {
    private final ExecutorService executorService;
    private final Map<Integer, Task> tasks;

    public PScheduler() {
        tasks = new ConcurrentHashMap<>();
        executorService = new ThreadPoolExecutor(5, Integer.MAX_VALUE, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
    }

    @Override
    public void cancelTask(int taskId) {
        tasks.get(taskId).cancel();
        tasks.remove(taskId);
    }

    @Override
    public void cancelAllTasks() {
        tasks.clear();
        executorService.shutdownNow();
    }

    @Override
    public Task runTask(Runnable runnable) {
        int taskId = tasks.size() + 1;
        Task task;
        tasks.put(taskId, task = new PTask(taskId, (RunnableFuture<Void>) executorService.submit(() -> {
            runnable.run();
            tasks.remove(taskId);
        })));
        return task;
    }

    @Override
    public Task runTaskLater(Runnable runnable, long delay) {
        return runTask(() -> {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                return;
            }
            runnable.run();
        });
    }

    @Override
    public Task runTaskTimer(Runnable runnable, long delay, long period) {
        return runTaskLater(() -> {
            while (true) {
                runnable.run();
                try {
                    Thread.sleep(period);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, delay);
    }
}
