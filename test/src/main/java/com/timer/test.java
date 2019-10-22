package com.timer;

import com.timer.trigger.DailyTrigger;

public class test {
	public static void main(String[] args) throws InterruptedException {


		ScheduledManager scheduledManager=ScheduledManager.getInstance();
		ScheduledManager.getInstance().schedule(new DailyTrigger("player-Daily-Reset", "11:31:00", (Trigger trigger) -> {
			System.out.println("11点执行任务");
		}));

		scheduledManager.execute();

		Thread.sleep(200000);
	}
}