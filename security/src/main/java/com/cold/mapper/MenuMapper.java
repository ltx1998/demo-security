package com.cold.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cold.entity.Menu;

import java.util.List;

/**
 * @Author: LTX
 * @create: 2022-06-12 10:39
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * @param userId
     * @return
     */
    List<String> selectPermsByUserId(Long userId);
}
