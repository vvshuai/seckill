package org.seckill.enums;

/**
 * @Author: vvshuai
 * @Description: 使用枚举表述常量数据字典
 * @Date: Created in 16:35 2020/5/28
 * @Modified By:
 */
public enum SeckillStateEnum {
    /**
     * @Description: 系统状态码
     * @return:
     */
    SUCCESS(1, "秒杀成功"),
    END(0, "秒杀结束"),
    REPEAT_KILL(-1, "重复秒杀"),
    INNER_ERROR(-2, "系统异常"),
    DATA_REWRITE(-3, "数据篡改");

    private int state;

    private String stateInfo;

    SeckillStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillStateEnum stateOf(int index){
        for(SeckillStateEnum stateEnum : values()){
            if(stateEnum.getState() == index){
                return stateEnum;
            }
        }
        return null;
    }
}
