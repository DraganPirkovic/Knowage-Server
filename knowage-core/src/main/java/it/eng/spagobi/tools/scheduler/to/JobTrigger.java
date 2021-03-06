/*
 * Knowage, Open Source Business Intelligence suite
 * Copyright (C) 2016 Engineering Ingegneria Informatica S.p.A.
 * 
 * Knowage is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Knowage is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package it.eng.spagobi.tools.scheduler.to;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class JobTrigger implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String TRIGGER_NAME = "triggerName";
	public static final String TRIGGER_GROUP = "triggerGroup";
	public static final String TRIGGER_DESCRIPTION = "triggerDescription";
	public static final String START_DATE = "startDate";
	public static final String START_TIME = "startTime";
	public static final String END_DATE = "endDate";
	public static final String END_TIME = "endTime";
	public static final String JOB_NAME = "jobName";
	public static final String JOB_GROUP = "jobGroup";
	public static final String CHRONO = "chrono";
	public static final String CHRONO_TYPE = "type";
	public static final String CHRONO_PARAMETER = "parameter";
	public static final String DOCUMENTS = "documents";

	// obj.get(CHRONO_TYPE) == ( "minute" || "hour" || "day" || "week" || "month" )
	// obj.get(CHRONO_TYPE) == "month" and day choice type IS simple
	public static final String CHRONO_PARAMETER_NUMREPETITION = "numRepetition";

	// obj.get(CHRONO_TYPE) == "month" and day choice type IS simple
	public static final String CHRONO_PARAMETER_DAYREPETITION = "dayRepetition";

	// obj.get(CHRONO_TYPE) == "week"
	// obj.get(CHRONO_TYPE) == "month" and month choice type IS NOT simple
	public static final String CHRONO_PARAMETER_DAYS = "days";

	// obj.get(CHRONO_TYPE) == "month" and day choice type IS NOT simple
	public static final String CHRONO_PARAMETER_WEEKS = "weeks";

	// obj.get(CHRONO_TYPE) == "month" and month choice type IS NOT simple
	public static final String CHRONO_PARAMETER_MONTHS = "months";

	private String triggerName = "";
	private String triggerDescription = "";
	private String startDate = "";
	private String startTime = "";
	private String endDate = "";
	private String endTime = "";
	private JobInfo jobInfo;
	private Integer chronoParameterNumRepetition = null;
	private Integer chronoParameterDayRepetition = null;
	private String[] chronoParameterDayS = null;
	private String[] chronoParameterWeeks = null;
	private String[] chronoParameterMonths = null;

	// "single", "minute", "hour", "day", "week", "month", "event"
	private String chronoType = "";
	private String chrono = "";
	private String repeatInterval = "";
	private Map<String, DispatchContext> saveOptions = null;

	public String getChronoType() {
		return chronoType;
	}

	public void setChronoType(String chronoType) {
		this.chronoType = chronoType;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate
	 *            the new end date
	 */
	public void setEndDate(String endDate) {
		if (endDate.matches("\\d+")) {
			// millisec
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(Long.parseLong(endDate));
			String z = calendar.get(Calendar.DAY_OF_MONTH) < 10 ? "0" : "";
			this.endDate = z + "" + calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
			return;
		}

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		SimpleDateFormat formatterF = new SimpleDateFormat("dd/MM/yyyy");
		if (endDate != null && endDate.trim().compareTo("") != 0) {
			try {
				// if formatter is correct
				formatterF.parse(endDate);
				this.endDate = endDate;
			} catch (java.text.ParseException e) {
				try {
					Date date = formatter.parse(endDate);
					this.endDate = formatterF.format(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

	}

	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * Sets the end time.
	 *
	 * @param endTime
	 *            the new end time
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * Gets the repeat interval.
	 *
	 * @return the repeat interval
	 */
	public String getRepeatInterval() {
		return repeatInterval;
	}

	/**
	 * Sets the repeat interval.
	 *
	 * @param repeatInterval
	 *            the new repeat interval
	 */
	public void setRepeatInterval(String repeatInterval) {
		this.repeatInterval = repeatInterval;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate
	 *            the new start date
	 */
	public void setStartDate(String startDate) {
		if (startDate.matches("\\d+")) {
			// millisec
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(Long.parseLong(startDate));
			String z = calendar.get(Calendar.DAY_OF_MONTH) < 10 ? "0" : "";
			this.startDate = z + "" + calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
			return;
		}

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		SimpleDateFormat formatterF = new SimpleDateFormat("dd/MM/yyyy");
		if (startDate != null && startDate.trim().compareTo("") != 0) {
			try {
				// if formatter is correct
				formatterF.parse(startDate);
				this.startDate = startDate;
			} catch (java.text.ParseException e) {
				try {
					Date date = formatter.parse(startDate);
					this.startDate = formatterF.format(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}
	}

	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * Sets the start time.
	 *
	 * @param startTime
	 *            the new start time
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the trigger description.
	 *
	 * @return the trigger description
	 */
	public String getTriggerDescription() {
		return triggerDescription;
	}

	/**
	 * Sets the trigger description.
	 *
	 * @param triggerDescription
	 *            the new trigger description
	 */
	public void setTriggerDescription(String triggerDescription) {
		this.triggerDescription = triggerDescription;
	}

	/**
	 * Gets the trigger name.
	 *
	 * @return the trigger name
	 */
	public String getTriggerName() {
		return triggerName;
	}

	/**
	 * Sets the trigger name.
	 *
	 * @param triggerName
	 *            the new trigger name
	 */
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	/**
	 * Gets the chron string.
	 *
	 * @return the chron string
	 */
	public String getChrono() {
		if ("single{}".compareTo(this.chrono) == 0) {
			return "{'type': 'single' }";
		}
		return chrono;
	}

	/**
	 * Sets the chron string.
	 *
	 * @param chrono
	 *            the new chron string
	 */
	public void setChrono(String chrono) {
		this.chrono = chrono;
	}

	/**
	 * @return the jobInfo
	 */
	public JobInfo getJobInfo() {
		return jobInfo;
	}

	/**
	 * @param jobInfo
	 *            the jobInfo to set
	 */
	public void setJobInfo(JobInfo jobInfo) {
		this.jobInfo = jobInfo;
	}

	/**
	 * Gets the save options.
	 *
	 * @return the save options
	 */
	public Map<String, DispatchContext> getSaveOptions() {
		return saveOptions;
	}

	/**
	 * Sets the save options.
	 *
	 * @param saveOptions
	 *            the new save options
	 */
	public void setSaveOptions(Map<String, DispatchContext> saveOptions) {
		this.saveOptions = saveOptions;
	}

	/**
	 * Gets the start date rf c3339.
	 *
	 * @return the start date rf c3339
	 */
	public String getStartDateRFC3339() {
		String startDRFC = "";
		String startD = this.getStartDate();
		if ((startD != null) && !startD.trim().equals("")) {
			String[] dateParts = startD.split("/");
			startDRFC = dateParts[2] + "-" + dateParts[1] + "-" + dateParts[0];
		}
		return startDRFC;
	}

	/**
	 * Gets the end date rf c3339.
	 *
	 * @return the end date rf c3339
	 */
	public String getEndDateRFC3339() {
		String endDRFC = "";
		String endD = this.getEndDate();
		if ((endD != null) && !endD.trim().equals("")) {
			if (endD.indexOf("/") > 0) {
				String[] dateParts = endD.split("/");
				endDRFC = dateParts[2] + "-" + dateParts[1] + "-" + dateParts[0];
			} else {
				endDRFC = endD;
			}
		}
		return endDRFC;
	}

	@Override
	public String toString() {
		return "{ triggerName = \"" + triggerName + "\"; triggerDescription = \"" + triggerDescription + "\"; startDate = \"" + startDate
				+ "\"; startTime = \"" + startTime + "\"; endDate = \"" + endDate + "\"; endTime = \"" + endTime + "\"; chrono = \"" + chrono
				+ "\"; jobInfo = {" + " jobName = \"" + jobInfo.getJobName() + "; jobGroupName = \"" + jobInfo.getJobGroupName() + "} }";
	}
}
