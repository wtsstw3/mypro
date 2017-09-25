package simple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {
    private static final long FUTURE_EXECUTION_WAIT_DELAY = 10000L; // in ms

    public void runThreadTest () throws Exception{

        ExecutorService service = Executors.newFixedThreadPool(20);
        List<String> availableParts = new ArrayList();
        availableParts.add("p0");
        availableParts.add("p1");

        final List<Future<String>> tasks = new ArrayList(availableParts.size());
        for (final String part : availableParts) {
            final Future<String> submit = service.submit(
                    new Callable<String>()
                    {
                        @Override
                        public String call() throws Exception {
                            try {
                                return processPart(part);
                            }
                            catch (final Exception e) {
                                System.out.println("ААаААААаааАААаа");
                                throw new Exception(e);
                            }
                        }
                    });
            tasks.add(submit);
        }
        System.out.println("Submitted" + tasks.size() + "tasks");

        while (tasks.size() > 0) {
            Future<String> readyTask = null;
            for (Future<String> task : tasks) {
                if (task.isDone()) {
                    readyTask = task;
                    break;
                }
            }
            if (readyTask == null) {
                Thread.sleep(FUTURE_EXECUTION_WAIT_DELAY);
            } else {
                String taskResult = readyTask.get(); // throws exception if any
                System.out.println(taskResult);
                tasks.remove(readyTask);
            }
        }
        service.shutdownNow();
    }

    public String processPart(String part){
        return "1";
    }
}
