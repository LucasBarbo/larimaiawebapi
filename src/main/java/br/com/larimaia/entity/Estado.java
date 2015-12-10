package br.com.larimaia.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Usuario on 07/12/2015.
 */

@Entity
@Table(name = "estado")
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String uf;

    public void setNome(String nome){this.nome = nome;}
    public void setId(Integer id){this.id = id;}
    public void setUf(String uf){this.uf = uf;}

    public Integer getId(){return this.id;}
    public String getNome(){return this.nome;}
    public String getUf(){return this.uf;}

}
