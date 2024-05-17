package br.com.treinaweb.hyperprof.core.models;


import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "professores")
/*
 * Gerar o equals() e hashCode() apenas com os atributos que forem informados de
 * forma explícita.
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false) /*EqualsAndHashCode da 
classe Professor não vai chamar EqualsAndHashCode da classe Auditable.*/
@ToString(onlyExplicitlyIncluded = true)
public class Professor extends Auditable{
    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ToString.Include
    @Column(name = "email")
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor_hora")
    private BigDecimal valorHora;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @Column(name = "password")
    private String password;

    

    /*
     * Biblioteca Lombok serve para evitar a escrita de código boiler plate e gerar
     * o código abaixo de forma automática e no tempo de compilação do projeto.
     */

    /*
     * Boa prática: dentro de modelos da JPA, deve-se levar em consideração apenas o
     * id para gerar os métodos equals and hashCcode().
     */
    // @Override
    // public int hashCode() {
    // final int prime = 31;
    // int result = 1;
    // result = prime * result + ((id == null) ? 0 : id.hashCode());
    // return result;
    // }

    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj)
    // return true;
    // if (obj == null)
    // return false;
    // if (getClass() != obj.getClass())
    // return false;
    // Professor other = (Professor) obj;
    // if (id == null) {
    // if (other.id != null)
    // return false;
    // } else if (!id.equals(other.id))
    // return false;
    // return true;
    // }

    // @Override
    // public String toString() {
    // return "Professor [id=" + id + ", email=" + email + "]";
    // }

}
