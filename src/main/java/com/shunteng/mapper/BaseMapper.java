package com.shunteng.mapper;

/**
 * DAO公共基类，由MybatisGenerator自动生成请勿修改
 * @param <T> The Model Class 这里是泛型是Model类
 */
public interface BaseMapper<T> {
    int deleteByPrimaryKey(Long id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);
}