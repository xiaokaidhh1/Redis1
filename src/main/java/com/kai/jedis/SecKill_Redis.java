package com.kai.jedis;

import redis.clients.jedis.Jedis;

public class SecKill_Redis {

    //秒杀
    public static boolean doSeckill(String uid, String proid) {
        //判断uid和proid不为空
        if (uid == null || proid == null) {
            return false;
        }
        //连接Redis
        Jedis jedis = new Jedis("192.168.174.132", 6379);

        //拼接key
        //秒杀成功用户userkey
        String userkey = "sk:" + proid + ":user";
        //库存key
        String kckey = "sk:" + proid + ":qt";


        //判断库存是否为空，为空就未开始
        String kc = jedis.get(kckey);
        if (kc == null) {
            System.out.println("未开始Q！");
            jedis.close();
            return false;
        }

        //秒杀过程
        //获取库存，小于1，秒杀结束
        if (Integer.valueOf(jedis.get(kckey)) <= 0) {
            System.out.println("秒杀已经结束");
            jedis.close();
            return false;
        }
        //判断用户是否秒杀重复
        if (jedis.sismember(userkey, uid)) {
            System.out.println("已经成功不能重复");
            jedis.close();
            return false;
        }
        //库存-1
        jedis.decr(kckey);
        //添加秒杀成功的用户
        jedis.sadd(userkey,uid);
        System.out.println("秒杀成功！");
        return true;
    }

}
