package practice;

import java.util.Date;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

/**
 * Spring @Scheduled定时任务动态修改cron参数
 *
 * @author Philip
 * @version v0.1
 * @date 2019年9月6日
 */
@Component
@EnableScheduling
public class TaskCronChange implements SchedulingConfigurer {

    private static String cron;

    TaskCronChange() {
        //默认情况是：每5秒执行一次
        cron = "0/5 * * * * *";
        // 开启新线程模拟外部更改了任务执行周期.
        new Thread(() -> {
            try {
                // 让线程睡眠15秒
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //修改为：每10秒执行一次
            cron = "0/10 * * * * *";
            System.out.println("Thread id : " + Thread.currentThread().getId());
            System.out.println("cron change to:" + cron);
        }).start();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        Runnable task = () -> {
            // 任务逻辑代码部分
            System.out.println("TaskCronChange task is running ... " + new Date());
        };

        Trigger trigger = triggerContext -> {
            // 任务触发，可修改任务的执行周期.
            CronTrigger trigger1 = new CronTrigger(cron);
            Date nextExec = trigger1.nextExecutionTime(triggerContext);
            return nextExec;
        };
        taskRegistrar.addTriggerTask(task, trigger);
    }
}