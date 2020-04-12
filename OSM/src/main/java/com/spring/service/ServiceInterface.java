package com.spring.service;

import java.util.List;

public interface ServiceInterface {
	public abstract Integer register(Object dto) throws Exception;
	public abstract Integer modify(Object dto) throws Exception;
	public abstract Integer remove(Object dto) throws Exception;
	public abstract Object getOne(Object dto) throws Exception;
	public abstract List<Object> listAll() throws Exception;
}
