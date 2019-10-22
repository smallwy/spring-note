package com.timer;



import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;

public class ScheduledManager{
	private Map<String, Trigger> runJobMap = new ConcurrentHashMap();
	private DelayQueue<Trigger> taskQueue = new DelayQueue();
	private WorldScene worldScene = WorldScene.getInstance();
	private static ScheduledManager instance = new ScheduledManager();

	public static ScheduledManager getInstance() {
		return instance;
	}


	public void execute() {
		while (true) {
			Trigger trigger = taskQueue.poll();
			if (trigger != null) {
				worldScene.executeWorker(new JobRunService(trigger, runJobMap, taskQueue));
			}
		}
	}

	public Map<String, Trigger> getRunJobMap() {
		return this.runJobMap;
	}

	public DelayQueue<Trigger> getTaskQueue() {
		return this.taskQueue;
	}

	public void schedule(Trigger trigger) {
		if ((trigger == null) || (trigger.getName() == null)) {
			throw new IllegalArgumentException("任务为空or任务参数不完整");
		}
		if (this.runJobMap.containsKey(trigger.getName())) {
			throw new RuntimeException("已存在同名任务:" + trigger.getName());
		}
		trigger.setSeqNum(Trigger.sequencer.getAndIncrement());
		boolean ans = this.taskQueue.offer(trigger);
		if (ans) {
			this.runJobMap.put(trigger.getName(), trigger);
		} else {
			throw new RuntimeException("添加任务失败:" + trigger.getName());
		}
	}

	public Trigger getTrigger(String name) {
		return this.runJobMap.get(name);
	}

	public boolean contains(String name) {
		return this.runJobMap.containsKey(name);
	}

	public boolean cancel(String jobName) {
		boolean ans = false;
		Trigger trigger = this.runJobMap.get(jobName);
		if (trigger != null) {
			trigger.setCancel(true);
			trigger.setTask(null);
			trigger.setListener(null);
			this.runJobMap.remove(trigger.getName());
			ans = true;
		}
		return ans;
	}

	public String schInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("当前正在执行的任务列表(总计" + this.runJobMap.size() + "个) \n");
		for (Trigger trg : this.runJobMap.values()) {
			sb.append(trg.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}
