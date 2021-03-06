package com.poicom.basic.plugin.quartz;

/**
 * 
 * @author ice on 14-11-28.
 *
 */
public class QuartzKey {
	long id;
	String name;
	String group;

	public QuartzKey(long id, String name) {
		this(id, name, "default");
	}

	public QuartzKey(long id, String name, String group) {
		this.id = id;
		this.name = name;
		this.group = group;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String toString() {
		return "id:" + id + ",name:" + name + ",group:" + group;
	}

	public boolean equals(Object o) {
		if (o != null && o instanceof QuartzKey) {
			QuartzKey quartzKey = (QuartzKey) o;
			return this.id == quartzKey.getId()
					&& this.name.equals(quartzKey.getName())
					&& this.group.equals(quartzKey.getGroup());
		}
		return super.equals(o);
	}

}
