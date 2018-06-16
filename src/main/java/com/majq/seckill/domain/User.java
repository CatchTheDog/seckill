package com.majq.seckill.domain;

import java.sql.Timestamp;

/**
 * user bean
 */
public class User {
	private Integer id;
	private String name;
	private Integer age;
	private String job;
	private Timestamp registeTime;
	private Timestamp lastUpdateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Timestamp getRegisteTime() {
		return registeTime;
	}

	public void setRegisteTime(Timestamp registeTime) {
		this.registeTime = registeTime;
	}

	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", job='" + job + '\'' +
				", registeTime=" + registeTime +
				", lastUpdateTime=" + lastUpdateTime +
				'}';
	}
}
