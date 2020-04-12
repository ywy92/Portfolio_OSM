package com.spring.repository;

import java.util.List;

public interface RepositoryInterface {
	public abstract Integer create(Object dto) throws Exception;
	public abstract Integer update(Object dto) throws Exception;
	public abstract Integer delete(Object dto) throws Exception;
	public abstract Object read(Object dto) throws Exception;
	public abstract List<Object> list() throws Exception;
}
