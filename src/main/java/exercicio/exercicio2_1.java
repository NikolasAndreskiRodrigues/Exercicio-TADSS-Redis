package exercicio;

import java.util.Set;
import java.util.UUID;

import redis.clients.jedis.RedisClient;

public class exercicio2_1 {

    private static Iterable<String> keys;
    public static void main(String[] args) {
        RedisClient redis = RedisClient.create("redis://localhost:6379");
        String chave = UUID.randomUUID().toString();
        String string = UUID.randomUUID().toString();
        for (int i = 0; i < 10; i++) {
            redis.setex(chave,30, string);
        // Ou redis.set(chave, string, SetParams.SetParams().ex(30))
        }
        Set<String> keys = redis.keys("*");

        for (String key : keys) {
            System.out.println(key + " : " + redis.get(key));
        }
        redis.close();
    }
}
