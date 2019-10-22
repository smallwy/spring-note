package com.timer.trigger;


import com.timer.Job;
import com.timer.Trigger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class DailyTrigger extends Trigger {
	private List<Calendar> calList;
	private int index = 0;

	public DailyTrigger(String name, String expression, Job job) {
		setName(name);
		setTask(job);
		setCalList(passTimeExp(expression));
		setNextTime(this.calList.get(0).getTimeInMillis());
	}

	public DailyTrigger(String name, List<Calendar> calList, Job job) {
		setName(name);
		setTask(job);
		setCalList(passCalList(calList));
		setNextTime(calList.get(0).getTimeInMillis());
	}

	private List<Calendar> passCalList(List<Calendar> calList) {
		Calendar curr = Calendar.getInstance();
		for (Calendar cal : calList) {
			if (cal.compareTo(curr) < 0) {
				cal.add(5, 1);
			}
		}
		calSort(calList);
		return calList;
	}

	private List<Calendar> passTimeExp(String expression) {
		List<Calendar> calList = new ArrayList();
		String[] array = expression.trim().split(";");
		Calendar curr = Calendar.getInstance();
		for (String hourMin : array) {
			if (!hourMin.isEmpty()) {
				String[] time = hourMin.split(":");
				int hour = Integer.parseInt(time[0].trim());
				int minute = 0;
				if (time.length > 1) {
					minute = Integer.parseInt(time[1].trim());
				}
				int second = 0;
				if (time.length > 2) {
					second = Integer.parseInt(time[2].trim());
				}
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.HOUR_OF_DAY, hour);
				cal.set(Calendar.MINUTE, minute);
				cal.set(Calendar.SECOND, second);
				if (cal.compareTo(curr) < 0) {
					cal.add(5, 1);
				}
				calList.add(cal);
			}
		}
		calSort(calList);
		return calList;
	}

	private void calSort(List<Calendar> calList) {
		Collections.sort(calList, (Calendar o1, Calendar o2) -> {
			return o1.compareTo(o2);
		});
	}

	public void updateNextTime(long curr) {
		Calendar cal = this.calList.get(this.index);
		cal.add(5, 1);
		this.index = ((this.index + 1) % this.calList.size());
		setNextTime(this.calList.get(this.index).getTimeInMillis());
	}

	public List<Calendar> getCalList() {
		return this.calList;
	}

	public void setCalList(List<Calendar> calList) {
		this.calList = calList;
	}
}
