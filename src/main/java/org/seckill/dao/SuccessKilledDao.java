package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 18:01 2020/5/27
 * @Modified By:
 */
public interface SuccessKilledDao {

    /**
     *
     * @Description: 插入购买明细
     *
     * @auther: vvshuai
     * @date: 18:01 2020/5/27
     * @param: [seckillId, userPhone]
     * @return:
     *
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     *
     * @Description: 查询并携带秒杀产品对象
     *
     * @auther: vvshuai
     * @date: 18:02 2020/5/27
     * @param: [seckillId]
     * @return: org.seckill.entity.SuccessKilled
     *
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
