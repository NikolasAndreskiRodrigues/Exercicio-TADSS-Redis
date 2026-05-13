package exercicio;

import redis.clients.jedis.RedisClient;

public class exercicio3 {
     public static void main(String[] args) {
        RedisClient redis = RedisClient.create("redis://localhost:6379");
        redis.incr("programa:aula:teste:execucoes");
        redis.close();
    }
}

