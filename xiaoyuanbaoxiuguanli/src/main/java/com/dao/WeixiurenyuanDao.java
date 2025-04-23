package com.dao;

import com.entity.WeixiurenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WeixiurenyuanView;

/**
 * 维修人员 Dao 接口
 *
 * @author 
 */
public interface WeixiurenyuanDao extends BaseMapper<WeixiurenyuanEntity> {

   List<WeixiurenyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
