import ru.popovash.api.PopovashAPI;
import ru.popovash.api.configuration.yaml.YamlConfiguration;
import ru.popovash.api.scheduler.Task;
import ru.popovash.api.scheduler.impl.PRunnable;
import ru.popovash.api.scheduler.impl.PTask;
import ru.popovash.api.utils.FileUtils;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Task task = new PRunnable() {
            @Override
            public void run() {
                System.out.println("Я пидор");
            }
        }.runTaskTimer(1000, 1000);
        PopovashAPI.getScheduler().runTaskLater(task::cancel, 5000);
    }
}
