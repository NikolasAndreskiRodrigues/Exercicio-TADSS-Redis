package exercicio.exercicio7;

import java.util.Map;

import redis.clients.jedis.RedisClient;

public class RedisPessoa {
    RedisClient redis = RedisClient.create("redis://localhost:6379");

    public void CreatePessoa(Pessoa pessoa) 
    {

        String chave = "contatos:" + pessoa.getApelido();
        redis.hset(chave, "nome", pessoa.getNome());
        redis.hset(chave, "sobrenome", pessoa.getSobrenome());
        redis.hset(chave, "telefone", pessoa.getTelefone());
        redis.hset(chave, "idade", String.valueOf(pessoa.getIdade()));
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