/* SpagoBI, the Open Source Business Intelligence suite

 * Copyright (C) 2012 Engineering Ingegneria Informatica S.p.A. - SpagoBI Competency Center
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0, without the "Incompatible With Secondary Licenses" notice.
 * If a copy of the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package it.eng.spagobi.tools.scheduler.bo;

import java.util.Date;

/**
 *
 * Triggers are the 'mechanism' by which <code>Jobs</code> are scheduled. Many <code>Triggers</code> can point to the same <code>Job</code>, but a single
 * <code>Trigger</code> can only point to one <code>Job</code>.
 *
 * @author Andrea Gioia (andrea.gioia@eng.it)
 *
 */
public class Trigger {
	String name;
	String groupName;
	String description;
	String originalTriggerName;
	String chronType;
	boolean runImmediately;

	Date startTime;
	Date endTime;

	CronExpression cronExpression;

	Job job;

	public Trigger() {
		cronExpression = new CronExpression();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the originalTriggerName
	 */
	public String getOriginalTriggerName() {
		return originalTriggerName;
	}

	/**
	 * @param originalTriggerName
	 *            the originalTriggerName to set
	 */
	public void setOriginalTriggerName(String originalTriggerName) {
		this.originalTriggerName = originalTriggerName;
	}

	public CronExpression getChronExpression() {
		return cronExpression;
	}

	public void setCronExpression(CronExpression cronExpression) {
		this.cronExpression = cronExpression;
	}

	public boolean isSimpleTrigger() {
		return this.cronExpression.isSimpleExpression();
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public boolean isRunImmediately() {
		return runImmediately;
	}

	public void setRunImmediately(boolean runImmediately) {
		this.runImmediately = runImmediately;
	}

	/**
	 * @return the chronType
	 */
	public String getChronType() {
		return chronType;
	}

	/**
	 * @param chronType
	 *            the chronType to set
	 */
	public void setChronType(String chronType) {
		this.chronType = chronType;
	}

	/**
	 * @return the triggerType
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trigger other = (Trigger) obj;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trigger [name=" + name + ", groupName=" + groupName + "]";
	}

}
