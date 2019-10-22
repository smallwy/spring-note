package com.timer.trigger;



import com.timer.Job;
import com.timer.Trigger;

import java.util.Date;


public class SimpleTrigger extends Trigger {
	private int repeatCount = REPEAT_INDEFINITELY;
	private int repeatInterval;
	private Date endTime;
	private static long offset = 60000L;

	public SimpleTrigger(String name, Date startTime, int repeatCount, int repeatInterval, Job task) {
		this(name, startTime, repeatCount, repeatInterval, null, task);
	}

	public SimpleTrigger(String name, Date startTime, int repeatInterval, Job task) {
		this(name, startTime, REPEAT_INDEFINITELY, repeatInterval, null, task);
	}

	public SimpleTrigger(String name, Date startTime, Date endStime, int repeatInterval, Job job) {
		this(name, startTime, 0, repeatInterval, endStime, job);
	}

	public SimpleTrigger(String name, Date startTime, int repeatCount, int repeatInterval, Date endTime, Job task) {
		setName(name);
		this.repeatCount = repeatCount;
		this.repeatInterval = repeatInterval;
		this.endTime = endTime;
		if (startTime.getTime() > System.currentTimeMillis() - offset) {
			setNextTime(startTime.getTime());
			setTask(task);
		} else {
			setCancel(true);
//			System.err.println("已取消一个过时1分钟的任务:" + name);
		}
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getRepeatCount() {
		return this.repeatCount;
	}

	public void setRepeatCount(int repeatCount) {
		this.repeatCount = repeatCount;
	}

	public int getRepeatInterval() {
		return this.repeatInterval;
	}

	public void setRepeatInterval(int repeatInterval) {
		this.repeatInterval = repeatInterval;
	}

	public void updateNextTime(long curr) {
		setNextTime(curr + getRepeatInterval());
		if (getRepeatCount() == Trigger.REPEAT_INDEFINITELY) {
			return;
		}
		if (getEndTime() != null) {
			if (getNextTime() > getEndTime().getTime()) {
				setComplete(true);
			}
		} else if (getTriggerCount() + 1 >= getRepeatCount()) {
			setComplete(true);
		}
	}
}
