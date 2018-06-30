
import java.util.ArrayList;
import java.util.List;


public class PessoaDao {

    private static PessoaDao instance;
    
    private final List<Pessoa> pessoas = new ArrayList<>();

    public PessoaDao() {
    }
    
    public static PessoaDao getInstance(){
        if(instance == null){
            instance = new PessoaDao();
        }
        return instance;
    }

    public void adicionar(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }
    
public boolean atualizar(Pessoa pessoa) {
        for (int i = 0; i < this.pessoas.size(); i++) {
            if (this.pessoas.get(i).nome == pessoa.nome) {
                this.pessoas.set(i, pessoa);
                return true;
            }
        }
        return false;
    }

     public String consutar(String nome){
         String a = "";
        for(Pessoa pessoa : this.pessoas){
           a = "Nome: "+ pessoa.nome + " / Idade: " +  pessoa.idade;
        }
        return a;
     }
     
    public boolean remover(Pessoa pessoa){
        this.pessoas.remove(pessoa);
        return true;
    }
    
    public List<Pessoa> recuperandoPessoas() {
        return this.pessoas;
    }
}