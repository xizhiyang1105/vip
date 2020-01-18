package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.model.Vip;

public interface VipDao extends BaseMapper<Vip> {
    Vip queryByName(String name);
}