package com.timer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.DelayQueue;

public class JobRunService implements ISpokesmanOfGod {
	private Logger log = LoggerFactory.getLogger(getClass());
	private Trigger trigger;
	private Map<String, Trigger> runJobMap;
	private DelayQueue<Trigger> taskQueue;

	public JobRunService(Trigger trigger, Map<String, Trigger> runJobMap, DelayQueue<Trigger> taskQueue) {
		this.trigger = trigger;
		this.runJobMap = runJobMap;
		this.taskQueue = taskQueue;
	}


	public JobRunService(Trigger trigger) {
		this.trigger = trigger;
	}

	public void run() {
		if (this.trigger.isCancel()) {
			return;
		}
		try {
			if (this.log.isDebugEnabled()) {
				this.log.debug("Trigger job [" + this.trigger.getName() + "]");
			}
			long start = System.currentTimeMillis();
			beforeFire(this.trigger, this.trigger.getNextTime());
			fire();
			afterFire(this.trigger, this.trigger.getNextTime());
			long cost = System.currentTimeMillis() - start;
			if (cost >= 100L) {
				String notice = String.format("%s 任务执行时间大于100ms时间 cost= %s ms", new Object[]{this.trigger.getName(), Long.valueOf(cost)});
				this.log.warn(notice);
			}
			if (this.trigger.isComplete()) {
				this.runJobMap.remove(this.trigger.getName());
				return;
			}
			this.taskQueue.offer(this.trigger);
		} catch (Exception e) {
			this.log.error("Trigger Error, Trigger=" + this.trigger.getName(), e);
			if (!this.taskQueue.offer(this.trigger)) {
				this.log.warn("重新加入任务队列失败: Trigger=" + this.trigger.getName());
			}
		}
	}

	private void fire() {
		if ((this.trigger.getTriggerCount() == 0) && (this.trigger.getListener() != null)) {
			try {
				this.trigger.getListener().startJob();
			} catch (Exception e) {
				this.log.error("Listener.startJob() error!", e);
			}
		}
		try {
			this.trigger.getTask().execute(this.trigger);
		} catch (Exception e) {
			this.log.error("Job.execute() error!", e);
		}
		if ((this.trigger.getListener() != null) && (this.trigger.isComplete())) {
			try {
				this.trigger.getListener().endJob();
			} catch (Exception e) {
				this.log.error("Listener.endJob() error!", e);
			}
		}
	}

	private void beforeFire(Trigger trigger, long curr) {
		trigger.setPreTime(curr);
		trigger.updateNextTime(curr);
	}

	private void afterFire(Trigger trigger, long curr) {
		trigger.setTriggerCount(trigger.getTriggerCount() + 1);
		trigger.setSeqNum(Trigger.sequencer.getAndIncrement());
	}

	@Override
	public void stop() {

	}

	@Override
	public boolean isRunning() {
		return false;
	}

	@Override
	public boolean isService() {
		return false;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public void init() {

	}
}
