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
 * AtualizarItemCardapioRequestDto
 */

@JsonTypeName("AtualizarItemCardapioRequest")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-05T11:02:19.156837-03:00[America/Sao_Paulo]")
public class AtualizarItemCardapioRequestDto {

  private String nome;

  @Valid
  private List<String> codigoTags;

  private String descricao;

  private Float preco;

  private Boolean disponivelLocal;

  private String fotoPath;

  public AtualizarItemCardapioRequestDto nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
  */
  
  @Schema(name = "nome", example = "Feijoada Light", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public AtualizarItemCardapioRequestDto codigoTags(List<String> codigoTags) {
    this.codigoTags = codigoTags;
    return this;
  }

  public AtualizarItemCardapioRequestDto addCodigoTagsItem(String codigoTagsItem) {
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
  @Size(max = 5) 
  @Schema(name = "codigoTags", example = "[\"01\"]", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("codigoTags")
  public List<String> getCodigoTags() {
    return codigoTags;
  }

  public void setCodigoTags(List<String> codigoTags) {
    this.codigoTags = codigoTags;
  }

  public AtualizarItemCardapioRequestDto descricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

  /**
   * Get descricao
   * @return descricao
  */
  
  @Schema(name = "descricao", example = "Menos gordura, acompanha arroz integral", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("descricao")
  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public AtualizarItemCardapioRequestDto preco(Float preco) {
    this.preco = preco;
    return this;
  }

  /**
   * Get preco
   * @return preco
  */
  
  @Schema(name = "preco", example = "39.9", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("preco")
  public Float getPreco() {
    return preco;
  }

  public void setPreco(Float preco) {
    this.preco = preco;
  }

  public AtualizarItemCardapioRequestDto disponivelLocal(Boolean disponivelLocal) {
    this.disponivelLocal = disponivelLocal;
    return this;
  }

  /**
   * Get disponivelLocal
   * @return disponivelLocal
  */
  
  @Schema(name = "disponivelLocal", example = "false", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("disponivelLocal")
  public Boolean getDisponivelLocal() {
    return disponivelLocal;
  }

  public void setDisponivelLocal(Boolean disponivelLocal) {
    this.disponivelLocal = disponivelLocal;
  }

  public AtualizarItemCardapioRequestDto fotoPath(String fotoPath) {
    this.fotoPath = fotoPath;
    return this;
  }

  /**
   * Get fotoPath
   * @return fotoPath
  */
  
  @Schema(name = "fotoPath", example = "/imagens/feijoada-light.jpg", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    AtualizarItemCardapioRequestDto atualizarItemCardapioRequest = (AtualizarItemCardapioRequestDto) o;
    return Objects.equals(this.nome, atualizarItemCardapioRequest.nome) &&
        Objects.equals(this.codigoTags, atualizarItemCardapioRequest.codigoTags) &&
        Objects.equals(this.descricao, atualizarItemCardapioRequest.descricao) &&
        Objects.equals(this.preco, atualizarItemCardapioRequest.preco) &&
        Objects.equals(this.disponivelLocal, atualizarItemCardapioRequest.disponivelLocal) &&
        Objects.equals(this.fotoPath, atualizarItemCardapioRequest.fotoPath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, codigoTags, descricao, preco, disponivelLocal, fotoPath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AtualizarItemCardapioRequestDto {\n");
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

