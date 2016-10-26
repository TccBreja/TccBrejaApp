package app.youbeer.com.br.modelo;

import java.io.Serializable;

/**
 * Created by Ribolli on 12/10/2016.
 */
public class Estabelecimento implements Serializable {

    private String nome;

    private String telefone;

    private String endereco;

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

    /** @return Retorno o atributo endereco */
    public String getEndereco() {
        return endereco;
    }

    /** @param endereco Atribui o valor ao atributo endereco */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /** @return Retorno o atributo telefone */
    public String getTelefone() {
        return telefone;
    }

    /** @param telefone Atribui o valor ao atributo telefone */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
