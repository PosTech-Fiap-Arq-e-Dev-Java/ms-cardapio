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
 * ItemCardapioDto
 */

@JsonTypeName("ItemCardapio")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-03T22:46:04.803020-03:00[America/Sao_Paulo]")
public class ItemCardapioDto {

  private Integer idItemCardapio;

  private String usuario;

  private String nome;

  private String descricao;

  private Float preco;

  private Boolean disponivelLocal;

  private String fotoPath;

  @Valid
  private List<String> codigoTags = new ArrayList<>();

  public ItemCardapioDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ItemCardapioDto(Integer idItemCardapio, String usuario, String nome, Float preco, Boolean disponivelLocal, List<String> codigoTags) {
    this.idItemCardapio = idItemCardapio;
    this.usuario = usuario;
    this.nome = nome;
    this.preco = preco;
    this.disponivelLocal = disponivelLocal;
    this.codigoTags = codigoTags;
  }

  public ItemCardapioDto idItemCardapio(Integer idItemCardapio) {
    this.idItemCardapio = idItemCardapio;
    return this;
  }

  /**
   * Get idItemCardapio
   * @return idItemCardapio
  */
  @NotNull 
  @Schema(name = "idItemCardapio", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idItemCardapio")
  public Integer getIdItemCardapio() {
    return idItemCardapio;
  }

  public void setIdItemCardapio(Integer idItemCardapio) {
    this.idItemCardapio = idItemCardapio;
  }

  public ItemCardapioDto usuario(String usuario) {
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

  public ItemCardapioDto nome(String nome) {
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

  public ItemCardapioDto descricao(String descricao) {
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

  public ItemCardapioDto preco(Float preco) {
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

  public ItemCardapioDto disponivelLocal(Boolean disponivelLocal) {
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

  public ItemCardapioDto fotoPath(String fotoPath) {
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

  public ItemCardapioDto codigoTags(List<String> codigoTags) {
    this.codigoTags = codigoTags;
    return this;
  }

  public ItemCardapioDto addCodigoTagsItem(String codigoTagsItem) {
    if (this.codigoTags == null) {
      this.codigoTags = new ArrayList<>();
    }
    this.codigoTags.add(codigoTagsItem);
    return this;
  }

  /**
   * Lista de IDs das tags (máximo 5)
   * @return codigoTags
  */
  @NotNull @Size(max = 5) 
  @Schema(name = "codigoTags", description = "Lista de IDs das tags (máximo 5)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("codigoTags")
  public List<String> getCodigoTags() {
    return codigoTags;
  }

  public void setCodigoTags(List<String> codigoTags) {
    this.codigoTags = codigoTags;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemCardapioDto itemCardapio = (ItemCardapioDto) o;
    return Objects.equals(this.idItemCardapio, itemCardapio.idItemCardapio) &&
        Objects.equals(this.usuario, itemCardapio.usuario) &&
        Objects.equals(this.nome, itemCardapio.nome) &&
        Objects.equals(this.descricao, itemCardapio.descricao) &&
        Objects.equals(this.preco, itemCardapio.preco) &&
        Objects.equals(this.disponivelLocal, itemCardapio.disponivelLocal) &&
        Objects.equals(this.fotoPath, itemCardapio.fotoPath) &&
        Objects.equals(this.codigoTags, itemCardapio.codigoTags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idItemCardapio, usuario, nome, descricao, preco, disponivelLocal, fotoPath, codigoTags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemCardapioDto {\n");
    sb.append("    idItemCardapio: ").append(toIndentedString(idItemCardapio)).append("\n");
    sb.append("    usuario: ").append(toIndentedString(usuario)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
    sb.append("    preco: ").append(toIndentedString(preco)).append("\n");
    sb.append("    disponivelLocal: ").append(toIndentedString(disponivelLocal)).append("\n");
    sb.append("    fotoPath: ").append(toIndentedString(fotoPath)).append("\n");
    sb.append("    codigoTags: ").append(toIndentedString(codigoTags)).append("\n");
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

