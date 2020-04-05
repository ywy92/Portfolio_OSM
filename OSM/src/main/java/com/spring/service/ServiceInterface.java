package com.spring.service;

public interface ServiceInterface {
	public abstract Object register(Object dto) throws Exception;
	public abstract Object modify(Object dto) throws Exception;
	public abstract Object remove(Object dto) throws Exception;
	public abstract Object getOne(Object dto) throws Exception;
	public abstract Object listAll() throws Exception;
}
