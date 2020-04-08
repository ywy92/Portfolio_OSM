package com.spring.common.model;

import java.io.Serializable;

public abstract class TargetAndValueDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Object target;
	private Object value;

	public TargetAndValueDTO(Object target, Object value) {
		this.target = target;
		this.value = value;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
