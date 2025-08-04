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
 * MsCardapioV1ItensUsuarioTagsPostRequestDto
 */

@JsonTypeName("_ms_cardapio_v1_itens__usuario__tags_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-03T22:46:04.803020-03:00[America/Sao_Paulo]")
public class MsCardapioV1ItensUsuarioTagsPostRequestDto {

  private String codigoTags;

  public MsCardapioV1ItensUsuarioTagsPostRequestDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MsCardapioV1ItensUsuarioTagsPostRequestDto(String codigoTags) {
    this.codigoTags = codigoTags;
  }

  public MsCardapioV1ItensUsuarioTagsPostRequestDto codigoTags(String codigoTags) {
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
    MsCardapioV1ItensUsuarioTagsPostRequestDto msCardapioV1ItensUsuarioTagsPostRequest = (MsCardapioV1ItensUsuarioTagsPostRequestDto) o;
    return Objects.equals(this.codigoTags, msCardapioV1ItensUsuarioTagsPostRequest.codigoTags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigoTags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MsCardapioV1ItensUsuarioTagsPostRequestDto {\n");
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

