package com.fh.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPools {
    private static JedisPool jedisPool;
    private RedisPools(){}

    //静态块的代码只能执行一次
    static {
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);//最大连接数
        jedisPoolConfig.setMaxIdle(10);//最大空闲连接数
        jedisPoolConfig.setMinIdle(5);//最小空闲连接数
        //创建连接池对象
        jedisPool =new JedisPool(jedisPoolConfig,"192.168.110.134",6379);
    }

    public static Jedis getJedis(){
        Jedis resource = jedisPool.getResource();//从连接池中拿出一个
        return resource;
    }

    public static void returnjedis(Jedis jedis){
        if(jedis!=null){
            jedis.close();
        }
    }

}
