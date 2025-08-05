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
 * ItensUsuarioTagsPostRequestDto
 */

@JsonTypeName("_itens__usuario__tags_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-05T17:50:26.073910-03:00[America/Sao_Paulo]")
public class ItensUsuarioTagsPostRequestDto {

  private String codigoTags;

  public ItensUsuarioTagsPostRequestDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ItensUsuarioTagsPostRequestDto(String codigoTags) {
    this.codigoTags = codigoTags;
  }

  public ItensUsuarioTagsPostRequestDto codigoTags(String codigoTags) {
    this.codigoTags = codigoTags;
    return this;
  }

  /**
   * Codigo da tag a ser adicionada
   * @return codigoTags
  */
  @NotNull 
  @Schema(name = "codigoTags", description = "Codigo da tag a ser adicionada", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("codigoTags")
  public String getCodigoTags() {
    return codigoTags;
  }

  public void setCodigoTags(String codigoTags) {
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
    ItensUsuarioTagsPostRequestDto itensUsuarioTagsPostRequest = (ItensUsuarioTagsPostRequestDto) o;
    return Objects.equals(this.codigoTags, itensUsuarioTagsPostRequest.codigoTags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigoTags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItensUsuarioTagsPostRequestDto {\n");
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

