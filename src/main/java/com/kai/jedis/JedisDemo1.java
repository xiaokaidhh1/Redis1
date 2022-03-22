package com.kai.jedis;



import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.Set;

public class JedisDemo1 {
    public static void main(String[] args) {
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.174.132", 6379);
        jedis.auth("xiaokai316");
        //测试
        System.out.println(jedis.ping());
    }

    //操作key
    @Test
    public void  demo1(){
        Jedis jedis = new Jedis("192.168.174.132", 6379);
        //添加
        jedis.set("name", "xiaokai");

        //获取
        String name = jedis.get("name");
        System.out.println(name);

        //设置多个key-value
        jedis.mset("k1", "v1", "k2", "v2");
        List<String> mget = jedis.mget("k1", "k2");

        System.out.println(mget);
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }

    }

    //操作list
    @Test
    public void demo2(){
        Jedis jedis = new Jedis("192.168.174.132", 6379);
        jedis.lpush("key1", "lucy", "mary", "jack");
        List<String> lget=  jedis.lrange("key1", 0, -1);
        for (String s : lget) {
            System.out.println(s);
        }
    }

    //set
    @Test
    public void demo3(){
        Jedis jedis = new Jedis("192.168.174.132", 6379);
        jedis.sadd("names", "lucy", "jack");
        Set<String> sget= jedis.smembers("names");
        for (String s : sget) {
            System.out.println(s);
        }
    }

    //hash
    @Test
    public void demo4() {
        Jedis jedis = new Jedis("192.168.174.132", 6379);
        jedis.hset("users", "id", "1");
        String s = jedis.hget("users", "id");
        System.out.println(s);
    }
    //Zset
    @Test
    public void demo5() {
        Jedis jedis = new Jedis("192.168.174.132", 6379);
        jedis.zadd("china", 100, "shanghai");
        Set<String> stringSet = jedis.zrange("china", 0, -1);
        for (String s : stringSet) {
            System.out.println(s);
            System.out.println("3");
            System.out.println("4");
            System.out.println("5");
            System.out.println("6");
            System.out.println("push test");
        }}

}
