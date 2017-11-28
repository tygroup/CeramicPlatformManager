package com.cpf.dao;


import java.util.List;
import java.util.Map;

import com.cpf.resources.PageListData;

public interface BaseDAO<T, PK> {
	/**
	 * 生成并返回表主键
	 * 
	 * @return String
	 */
	public String getPrimaryKey(Class<T> entityClass);


	public T save(T entity);

	public void update(T entity);

	public void delete(T entity);

	/**
	 * 通过主键批量删除
	 * 
	 * @param entityClass
	 * @param ids
	 */
	public void deleteByIds(String[] ids);

	public T findById(PK id);

	/**
	 * 自定义参数查询所有符合条件的记录
	 * 
	 * @param entityClass
	 *            entityClass
	 * @param params
	 *            Map<String, Object> 自定义查询参数集合
	 * @return List<T>
	 */
	public List<T> findAll(Map<String, Object> params);

	/**
	 * 实体属性参数查询所有符合条件的记录
	 * 
	 * @param entityClass
	 *            entityClass
	 * @param entity
	 *            实体bean
	 * @return List<T>
	 */
	public List<T> findAllByProperty(T entity);

	/**
	 * 分页查询符合查询条件的记录
	 * 
	 * @param entityClass
	 *            entityClass
	 * @param params
	 *            Map<String, Object> 查询参数
	 * @param currentPage
	 *            当前页码
	 * @param pageSize
	 *            页面容量
	 * @return PageListData
	 */
	public List<T> queryPage(Map<String, Object> params);
}
