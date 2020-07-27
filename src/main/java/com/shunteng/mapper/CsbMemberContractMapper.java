package com.shunteng.mapper;

import com.shunteng.entity.CsbMemberContract;

public interface CsbMemberContractMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CsbMemberContract record);

    int insertSelective(CsbMemberContract record);

    CsbMemberContract selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CsbMemberContract record);

    int updateByPrimaryKey(CsbMemberContract record);
}