package com.uniyaz.sistem.dao;


import java.io.Serializable;

import com.uniyaz.sistem.service.GenericRestClientService;

public class GenericRestDao<T> extends GenericRestClientService<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	public GenericRestDao(Class<T> entityClass) {
		super(entityClass);
	}
}