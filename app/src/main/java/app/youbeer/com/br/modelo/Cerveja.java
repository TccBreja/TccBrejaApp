package app.youbeer.com.br.modelo;

import java.io.Serializable;

/**
 * Created by Ribolli on 12/10/2016.
 */
public class Cerveja implements Serializable {

    private String nome;

    private Long id;


    /** @return Retorno o atributo Id */
    public Long getId() {
        return id;
    }

    /** @param id Atribui o valor ao atributo nome */
    public void setId(Long id) {
        this.id = id;
    }

    /** @return Retorno o atributo nome */
    public String getNome() {
        return nome;
    }

    /** @param nome Atribui o valor ao atributo nome */
    public void setNome(String nome) {
        this.nome = nome;
    }


}
