package exercicio;

import java.util.Set;
import java.util.UUID;

import redis.clients.jedis.RedisClient;

public class exercicio2 {

    private static Iterable<String> keys;
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        RedisClient redis = RedisClient.create("redis://localhost:6379");
        String chave = UUID.randomUUID().toString();
        String string = UUID.randomUUID().toString();
        for (int i = 0; i < 10; i++) {
            redis.set(chave, string);
        }
        Set<String> keys = redis.keys("*");

        for (String key : keys) {
            System.out.println(key + " : " + redis.get(key));
        }
        redis.close();
    }
}
