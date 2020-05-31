package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseExcaption;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * @Author: vvshuai
 * @Description: 实现使用者设计接口
 *               三个方面：方法定义粒度 参数 返回类型
 * @Date: Created in 14:52 2020/5/28
 * @Modified By:
 */
public interface SeckillService {

    /**
     * @Description: 查询所有的秒杀记录
     * @return:
     */
    List<Seckill> getSeckillList();

    /**
     * @Description: 查询单个秒杀记录
     * @return:
     */
    Seckill getById(long seckillId);

    /**
     * @Description: 输出秒杀接口地址
     * @return: void
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * @Description: 执行秒杀操作
     * @return:
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
        throws SeckillException, RepeatKillException, SeckillCloseExcaption;
}
