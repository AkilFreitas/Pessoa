
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Root resource (exposed at "myresource" path)
 */

@Path("meuwebservice")
public class MyApplicationController {

    private PessoaDao pessoaDao;

    public MyApplicationController() {
        pessoaDao = PessoaDao.getInstance();
    }
   //http://localhost:8080/WebService/meuwebservice/ola
    @GET
    @Path("ola")
    @Produces(MediaType.TEXT_PLAIN)
    public String olaMundo() {
        return "Olá mundo!";
    }

  //http://localhost:8080/WebService/meuwebservice/adicionar?nome=Akil&idade=18
    @GET
    @Path("adicionar")
    public Response adicionar(@QueryParam("nome") String nome,
                            @QueryParam("idade") String idade){
        Pessoa pessoa = new Pessoa(nome,Integer.parseInt(idade));
        this.pessoaDao.adicionar(pessoa);     
        return Response.status(Status.OK).build();
    }

   //http://localhost:8080/WebService/meuwebservice/consultar
    @GET
    @Path("consultar")
    @Produces(MediaType.APPLICATION_JSON)
    public String consultar() {
         return new Gson().toJson(pessoaDao.recuperandoPessoas());

    }

    //http://localhost:8080/WebService/meuwebservice/remover?nome=Akil&idade=18
    @DELETE
    @Path("remover")
    public Response remover(@QueryParam("nome") String nome,
                            @QueryParam("idade") int idade) {
        Pessoa pessoa = new Pessoa(nome,idade);
        this.pessoaDao.remover(pessoa);
        return Response.status(Status.OK).build();
    }
    
    
    @GET
    @Path("atualizar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@QueryParam("nome") String nome, @QueryParam("novoNome") String novoNome,
                            @QueryParam("idade") int idade, @QueryParam("novaIdade") int novaIdade){
        Pessoa p = new Pessoa(nome, idade);
        Pessoa novaPessoa = new Pessoa(novoNome,novaIdade);
        pessoaDao.getInstance().atualizar(novaPessoa);
        return Response.status(Status.OK).build();
  }
}