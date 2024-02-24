package ru.popovash.api.scheduler.impl;

import lombok.Getter;
import ru.popovash.api.scheduler.Task;

import java.util.concurrent.RunnableFuture;

@Getter
public class PTask implements Task {
    private final int taskId;
    private boolean cancelled;
    private RunnableFuture<Void> runnableFuture;

    public PTask(int taskId, RunnableFuture<Void> runnableFuture) {
        this.taskId = taskId;
        this.runnableFuture = runnableFuture;
    }

    public void cancel() {
        cancelled = true;
        runnableFuture.cancel(true);
    }
}
