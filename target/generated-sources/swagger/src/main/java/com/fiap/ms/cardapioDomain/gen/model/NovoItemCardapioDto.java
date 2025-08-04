package com.fiap.ms.cardapioDomain.gen.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * NovoItemCardapioDto
 */

@JsonTypeName("NovoItemCardapio")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-03T22:46:04.803020-03:00[America/Sao_Paulo]")
public class NovoItemCardapioDto {

  private String usuario;

  private String nome;

  @Valid
  private List<String> codigoTags = new ArrayList<>();

  private String descricao;

  private Float preco;

  private Boolean disponivelLocal;

  private String fotoPath;

  public NovoItemCardapioDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public NovoItemCardapioDto(String usuario, String nome, List<String> codigoTags, Float preco, Boolean disponivelLocal) {
    this.usuario = usuario;
    this.nome = nome;
    this.codigoTags = codigoTags;
    this.preco = preco;
    this.disponivelLocal = disponivelLocal;
  }

  public NovoItemCardapioDto usuario(String usuario) {
    this.usuario = usuario;
    return this;
  }

  /**
   * Get usuario
   * @return usuario
  */
  @NotNull 
  @Schema(name = "usuario", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("usuario")
  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public NovoItemCardapioDto nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
  */
  @NotNull 
  @Schema(name = "nome", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public NovoItemCardapioDto codigoTags(List<String> codigoTags) {
    this.codigoTags = codigoTags;
    return this;
  }

  public NovoItemCardapioDto addCodigoTagsItem(String codigoTagsItem) {
    if (this.codigoTags == null) {
      this.codigoTags = new ArrayList<>();
    }
    this.codigoTags.add(codigoTagsItem);
    return this;
  }

  /**
   * Get codigoTags
   * @return codigoTags
  */
  @NotNull @Size(max = 5) 
  @Schema(name = "codigoTags", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("codigoTags")
  public List<String> getCodigoTags() {
    return codigoTags;
  }

  public void setCodigoTags(List<String> codigoTags) {
    this.codigoTags = codigoTags;
  }

  public NovoItemCardapioDto descricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

  /**
   * Get descricao
   * @return descricao
  */
  
  @Schema(name = "descricao", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("descricao")
  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public NovoItemCardapioDto preco(Float preco) {
    this.preco = preco;
    return this;
  }

  /**
   * Get preco
   * @return preco
  */
  @NotNull 
  @Schema(name = "preco", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("preco")
  public Float getPreco() {
    return preco;
  }

  public void setPreco(Float preco) {
    this.preco = preco;
  }

  public NovoItemCardapioDto disponivelLocal(Boolean disponivelLocal) {
    this.disponivelLocal = disponivelLocal;
    return this;
  }

  /**
   * Get disponivelLocal
   * @return disponivelLocal
  */
  @NotNull 
  @Schema(name = "disponivelLocal", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("disponivelLocal")
  public Boolean getDisponivelLocal() {
    return disponivelLocal;
  }

  public void setDisponivelLocal(Boolean disponivelLocal) {
    this.disponivelLocal = disponivelLocal;
  }

  public NovoItemCardapioDto fotoPath(String fotoPath) {
    this.fotoPath = fotoPath;
    return this;
  }

  /**
   * Get fotoPath
   * @return fotoPath
  */
  
  @Schema(name = "fotoPath", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fotoPath")
  public String getFotoPath() {
    return fotoPath;
  }

  public void setFotoPath(String fotoPath) {
    this.fotoPath = fotoPath;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NovoItemCardapioDto novoItemCardapio = (NovoItemCardapioDto) o;
    return Objects.equals(this.usuario, novoItemCardapio.usuario) &&
        Objects.equals(this.nome, novoItemCardapio.nome) &&
        Objects.equals(this.codigoTags, novoItemCardapio.codigoTags) &&
        Objects.equals(this.descricao, novoItemCardapio.descricao) &&
        Objects.equals(this.preco, novoItemCardapio.preco) &&
        Objects.equals(this.disponivelLocal, novoItemCardapio.disponivelLocal) &&
        Objects.equals(this.fotoPath, novoItemCardapio.fotoPath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(usuario, nome, codigoTags, descricao, preco, disponivelLocal, fotoPath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NovoItemCardapioDto {\n");
    sb.append("    usuario: ").append(toIndentedString(usuario)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    codigoTags: ").append(toIndentedString(codigoTags)).append("\n");
    sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
    sb.append("    preco: ").append(toIndentedString(preco)).append("\n");
    sb.append("    disponivelLocal: ").append(toIndentedString(disponivelLocal)).append("\n");
    sb.append("    fotoPath: ").append(toIndentedString(fotoPath)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

