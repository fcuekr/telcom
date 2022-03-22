package test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

public class MyRedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.getClient().getPort());
        System.out.println("连接本地的Redis服务器成功");
        //查看服务是否运行
        System.out.println("服务正在运行：" + jedis.ping());

        test();
    }

    public static void test() {
        // 连接池
        JedisPool jedisPool = new JedisPool("localhost", 6379);

        /* 操作Redis */
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.flushAll();
            jedis.set("ww","123");
            Pipeline p = jedis.pipelined();
            for (Integer i = 0; i < 10; i++) {
                p.set(i.toString(), i.toString());
            }
            p.del("4");
            p.incr("ww");
            p.sync();
            System.out.println("操作后，全部Key值：" + jedis.keys("*"));
            System.out.println(jedis.get("ww"));
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
