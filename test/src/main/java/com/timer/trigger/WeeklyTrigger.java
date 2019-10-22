package com.timer.trigger;


import com.timer.Job;
import com.timer.Trigger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class WeeklyTrigger extends Trigger {
	private List<Calendar> calList;
	private int index = 0;

	public WeeklyTrigger(String name, List<Calendar> calList, Job job) {
		setName(name);
		setTask(job);
		setCalList(passCalList(calList));
		setNextTime(calList.get(0).getTimeInMillis());
	}

	private List<Calendar> passCalList(List<Calendar> calList) {
		Calendar curr = Calendar.getInstance();
		for (Calendar cal : calList) {
			if (cal.compareTo(curr) < 0) {
				cal.add(3, 1);
			}
		}
		calSort(calList);
		return calList;
	}

	public WeeklyTrigger(String name, int hour, int minute, int[] dayOfWeek, Job job) {
		if ((dayOfWeek == null) || (dayOfWeek.length == 0)) {
			throw new IllegalArgumentException("day of week must be set!");
		}
		List<Calendar> calList = new ArrayList();
		Calendar curr = Calendar.getInstance();
		for (int day : dayOfWeek) {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DAY_OF_WEEK, day);
			cal.set(Calendar.HOUR_OF_DAY, hour);
			cal.set(Calendar.MINUTE, minute);
			cal.set(Calendar.SECOND, 0);
			calList.add(cal);
			if (cal.compareTo(curr) < 0) {
				cal.add(3, 1);
			}
		}
		setName(name);
		setTask(job);
		calSort(calList);
		setCalList(calList);
		setNextTime(calList.get(0).getTimeInMillis());
	}

	private void calSort(List<Calendar> calList) {
		Collections.sort(calList, (Calendar o1, Calendar o2) -> {
			return o1.compareTo(o2);
		});
	}

	public List<Calendar> getCalList() {
		return this.calList;
	}

	public void setCalList(List<Calendar> calList) {
		this.calList = calList;
	}

	public void updateNextTime(long curr) {
		Calendar cal = this.calList.get(this.index);
		cal.add(3, 1);
		this.index = ((this.index + 1) % this.calList.size());
		setNextTime(this.calList.get(this.index).getTimeInMillis());
	}
}
