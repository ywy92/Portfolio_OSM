package com.spring.repository;

public interface RepositoryInterface {
	public abstract Object create(Object dto) throws Exception;
	public abstract Object update(Object dto) throws Exception;
	public abstract Object delete(Object dto) throws Exception;
	public abstract Object read(Object dto) throws Exception;
	public abstract Object list() throws Exception;
}
