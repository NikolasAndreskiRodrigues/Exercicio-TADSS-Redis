package exercicio.exercicio8;

import java.io.ByteArrayOutputStream;
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
        byte[] bytes = baos.toByteArray();
        System.out.println(Arrays.toString(bytes));
        redis.set(("contatos:" +pessoa.getApelido()).getBytes(), bytes);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pessoa ReadPessoa(String apelido) 
    {
    Map<String, String> data = redis.hgetAll("contatos:" +apelido);

    if (data.isEmpty()) {
        return null;
    }
    Pessoa p = new Pessoa();
    p.setApelido(apelido);
    p.setNome(data.get("nome"));
    p.setSobrenome(data.get("sobrenome"));
    p.setTelefone(data.get("telefone"));
    p.setIdade(Integer.parseInt(data.get("idade")));
    return p;
    }

    public void UpdatePessoa(Pessoa pessoa) {
        CreatePessoa(pessoa);
    }

    public void DeletePessoa(String apelido) {
        redis.del("contatos:" + apelido);
    }
}