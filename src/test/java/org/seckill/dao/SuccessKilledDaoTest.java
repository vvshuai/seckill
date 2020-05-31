package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 14:41 2020/5/28
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void test1(){
        long id = 1000L;
        long phone = 13502181181L;
        int insertCount = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println(insertCount);
    }

    @Test
    public void test2(){

    }
}