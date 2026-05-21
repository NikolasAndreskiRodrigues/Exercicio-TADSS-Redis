package exercicio.exercicio9;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Map;

import redis.clients.jedis.RedisClient;

public class RedisPessoa {
    RedisClient redis = RedisClient.create("redis://localhost:6379");

    public void CreatePessoa(Pessoa pessoa) 
    {
        try {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(pessoa);
        redis.hset("contatos:".getBytes(), pessoa.getApelido().getBytes(), baos.toByteArray());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pessoa ReadPessoa(String apelido) 
    {
        Pessoa p = null;
    try {
        byte[] data = redis.hget("contatos:".getBytes(), apelido.getBytes());
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bis);
        p = (Pessoa) ois.readObject();
        } 
    catch (Exception e) {
        e.printStackTrace();
    }
        return p;
    }

    public void UpdatePessoa(Pessoa pessoa) {
        CreatePessoa(pessoa);
    }

    public void DeletePessoa(String apelido) {
        redis.hdel("contatos:".getBytes(), apelido.getBytes());
    }
}