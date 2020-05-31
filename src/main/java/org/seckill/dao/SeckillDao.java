package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 17:58 2020/5/27
 * @Modified By:
 */
public interface SeckillDao {

    /**
     *
     * @Description: 减库存
     *
     * @auther: vvshuai
     * @date: 17:58 2020/5/27
     * @param: [seckillId, killTime]
     * @return: 如果影响行数大于1 表示更新行数
     *
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     *
     * @Description: 根据id查询秒杀对象
     *
     * @auther: vvshuai
     * @date: 17:59 2020/5/27
     * @param: [seckillId]
     * @return: org.seckill.entity.Seckill
     *
     */
    Seckill queryById(long seckillId);

    /**
     *
     * @Description: 根据偏移量查询秒杀商品列表
     *
     * @auther: vvshuai
     * @date: 18:00 2020/5/27
     * @param: [offet, limit]
     * @return: java.util.List<org.seckill.entity.Seckill>
     *
     */
    List<Seckill> queryAll(@Param("offset") int offet, @Param("limit") int limit);
}
