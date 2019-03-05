package cn.alibaba.yimai.util;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
    static JedisPool jedisPool=null;
    static{
        GenericObjectPoolConfig poolConfig= new JedisPoolConfig();
//        设置连接池的一些参数
        poolConfig.setMaxTotal(10);
        poolConfig.setMaxIdle(10);//最大空闲数
        poolConfig.setMaxWaitMillis(3*1000);//超时时间
        poolConfig.setTestOnBorrow(true);//借的时候进行测试
        String host="127.0.0.1";
        int port=6379;
        int timeout=1*1000;
        String password="root";

//        public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password)
        jedisPool =new JedisPool( poolConfig,  host,  port,  timeout,  password);
    }
     public static  void set(String key,String value){

         Jedis jedis = jedisPool.getResource();

         try {
             jedis.set(key, value);
         } catch (Exception e) {
             e.printStackTrace();
         }finally {
             jedis.close();

         }
     }

     public static  String  get(String key){

         Jedis jedis = jedisPool.getResource();

         try {
             return jedis.get(key);
         } catch (Exception e) {
             e.printStackTrace();
             return  null;
         }finally {
             jedis.close();
         }

     }
}
