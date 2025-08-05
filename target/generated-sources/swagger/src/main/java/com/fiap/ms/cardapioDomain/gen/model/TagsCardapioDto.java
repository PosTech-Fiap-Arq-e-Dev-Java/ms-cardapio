package com.fiap.ms.cardapioDomain.gen.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TagsCardapioDto
 */

@JsonTypeName("TagsCardapio")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-05T11:02:19.156837-03:00[America/Sao_Paulo]")
public class TagsCardapioDto {

  private String codigoTags;

  private String nome;

  public TagsCardapioDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TagsCardapioDto(String codigoTags, String nome) {
    this.codigoTags = codigoTags;
    this.nome = nome;
  }

  public TagsCardapioDto codigoTags(String codigoTags) {
    this.codigoTags = codigoTags;
    return this;
  }

  /**
   * Get codigoTags
   * @return codigoTags
  */
  @NotNull 
  @Schema(name = "codigoTags", example = "01", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("codigoTags")
  public String getCodigoTags() {
    return codigoTags;
  }

  public void setCodigoTags(String codigoTags) {
    this.codigoTags = codigoTags;
  }

  public TagsCardapioDto nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
  */
  @NotNull 
  @Schema(name = "nome", example = "Sobremesas", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TagsCardapioDto tagsCardapio = (TagsCardapioDto) o;
    return Objects.equals(this.codigoTags, tagsCardapio.codigoTags) &&
        Objects.equals(this.nome, tagsCardapio.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigoTags, nome);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TagsCardapioDto {\n");
    sb.append("    codigoTags: ").append(toIndentedString(codigoTags)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
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

