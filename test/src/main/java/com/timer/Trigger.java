package com.timer;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Trigger implements Delayed {
	public static int REPEAT_INDEFINITELY = -1;
	public static final AtomicLong sequencer = new AtomicLong(0L);
	private long createTime = System.currentTimeMillis();
	private String name;
	private long preTime;
	private long nextTime;
	private boolean complete = false;
	private boolean cancel = false;
	private int triggerCount = 0;
	private long seqNum;
	private Job task;
	private JobListener listener;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPreTime() {
		return this.preTime;
	}

	public void setPreTime(long preTime) {
		this.preTime = preTime;
	}

	public long getNextTime() {
		return this.nextTime;
	}

	public void setNextTime(long nextTime) {
		this.nextTime = nextTime;
	}

	public boolean isComplete() {
		return this.complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public boolean isCancel() {
		return this.cancel;
	}

	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}

	public int getTriggerCount() {
		return this.triggerCount;
	}

	public void setTriggerCount(int triggerCount) {
		this.triggerCount = triggerCount;
	}

	public Job getTask() {
		return this.task;
	}

	public void setTask(Job task) {
		this.task = task;
	}

	public JobListener getListener() {
		return this.listener;
	}

	public void setListener(JobListener listener) {
		this.listener = listener;
	}

	public void setSeqNum(long seqNum) {
		this.seqNum = seqNum;
	}

	public long getSeqNum() {
		return this.seqNum;
	}

	public int compareTo(Delayed o) {
		int ans = 0;
		if (o == this) {
			return ans;
		}
		if ((o instanceof Trigger)) {
			Trigger trg = (Trigger) o;
			if (getNextTime() == trg.getNextTime()) {
				if (getSeqNum() < trg.getSeqNum()) {
					ans = -1;
				} else {
					ans = 1;
				}
			} else if (getNextTime() < trg.getNextTime()) {
				ans = -1;
			} else {
				ans = 1;
			}
		} else if (getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
			ans = -1;
		} else if (getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
			ans = 1;
		}
		return ans;
	}

	public long getDelay(TimeUnit unit) {
		return unit.convert(this.nextTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

	public long getCreateTime() {
		return this.createTime;
	}

	public Date getEndTime() {
		return null;
	}

	public void setEndTime(Date endTime) {
	}

	public abstract void updateNextTime(long paramLong);

	public String toString() {
		return "Trigger [createTime=" + this.createTime + ", name=" + this.name + ", preTime=" + new Date(this.preTime) + ", nextTime=" + new Date(this.nextTime) + ", complete=" + this.complete + ", cancel=" + this.cancel + ", triggerCount=" + this.triggerCount + ", seqNum=" + this.seqNum + ", task=" + this.task + ", listener=" + this.listener + "]";
	}
}
