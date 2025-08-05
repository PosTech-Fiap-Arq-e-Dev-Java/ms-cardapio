package com.fiap.ms.cardapio.adapters.in.controller.handler;

import com.fiap.ms.cardapio.application.core.domain.exception.*;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.http.converter.HttpMessageNotReadableException;


import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler;
    private WebRequest webRequest;

    @BeforeEach
    void setup() {
        handler = new GlobalExceptionHandler();
        webRequest = Mockito.mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("uri=/test-path");
    }

    @SuppressWarnings("unchecked")
    @Test
    void testHandleNoHandlerFoundException() {
        NoHandlerFoundException ex = new NoHandlerFoundException("GET", "/path", null);
        ResponseEntity<Object> response = handler.handleNoHandlerFoundException(ex, webRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        var body = (java.util.Map<String, Object>) response.getBody();
        assert body != null;
        assertEquals("Endpoint inválido. Verifique a URL.", body.get("message"));
        assertEquals("/test-path", body.get("path"));
    }

    @SuppressWarnings("unchecked")
    @Test
    void testHandleMissingParams() {
        MissingServletRequestParameterException ex = new MissingServletRequestParameterException("param", "String");
        ResponseEntity<Object> response = handler.handleMissingParams(ex, webRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        var body = (java.util.Map<String, Object>) response.getBody();
        assert body != null;
        assertTrue(body.get("message").toString().contains("param"));
        assertEquals("/test-path", body.get("path"));
    }

    @SuppressWarnings("unchecked")
    @Test
    void testHandleCampoObrigatorio() {
        CampoObrigatorioException ex = new CampoObrigatorioException();
        ResponseEntity<Object> response = handler.handleCampoObrigatorio(ex, webRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        var body = (java.util.Map<String, Object>) response.getBody();
        assert body != null;
        assertEquals("Parâmetro obrigatório não informado.", body.get("message"));
    }

    @SuppressWarnings("unchecked")
    @Test
    void testHandleMaxTagsExcedidas() {
        MaxTagsExcedidasException ex = new MaxTagsExcedidasException();
        ResponseEntity<Object> response = handler.handleMaxTagsExcedidas(ex, webRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        var body = (java.util.Map<String, Object>) response.getBody();
        assert body != null;
        assertEquals("Não é permitido adicionar mais de 5 tags para um item do cardápio", body.get("message"));
    }

    @SuppressWarnings("unchecked")
    @Test
    void testHandleItemCardapioNaoEncontrado() {
        ItemCardapioNaoEncontradoException ex = new ItemCardapioNaoEncontradoException("Item não encontrado");
        ResponseEntity<Object> response = handler.handleItemCardapioNaoEncontrado(ex, webRequest);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        var body = (java.util.Map<String, Object>) response.getBody();
        assert body != null;
        assertEquals("Nenhum item de Cardapio encontrado para usuário Item não encontrado", body.get("message"));
    }

    @SuppressWarnings("unchecked")
    @Test
    void testHandleAtualizarDadosIguais() {
        AtualizarDadosIguaisException ex = new AtualizarDadosIguaisException();
        ResponseEntity<Object> response = handler.handleAtualizarDadosIguais(ex, webRequest);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        var body = (java.util.Map<String, Object>) response.getBody();
        assertEquals("Dados de entrada já cadastrados para esse usuário.", body.get("message"));
    }

    @SuppressWarnings("unchecked")
    @Test
    void testHandleTagNaoEncontrada() {
        String codigoTag = "Tag123";
        TagNaoEncontradaException ex = new TagNaoEncontradaException(codigoTag);
        ResponseEntity<Object> response = handler.handleTagNaoEncontrada(ex, webRequest);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        var body = (java.util.Map<String, Object>) response.getBody();
        assert body != null;
        assertEquals("Tag com código " + codigoTag + " não encontrada.", body.get("message"));
    }


    @SuppressWarnings("unchecked")
    @Test
    void testHandleNomeItemCardapioDuplicado() {
        NomeItemCardapioDuplicadoException ex = new NomeItemCardapioDuplicadoException("usuario1", "Nome duplicado");

        ResponseEntity<Object> response = handler.handleNomeItemCardapioDuplicado(ex, webRequest);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        var body = (java.util.Map<String, Object>) response.getBody();
        assertEquals("Já existe um item de cardápio com o nome 'Nome duplicado' para o usuário 'usuario1'.", body.get("message"));
    }


    @SuppressWarnings("unchecked")
    @Test
    void testHandleValidationExceptions() {
        FieldError fieldError = new FieldError("object", "field", "Campo inválido");
        MethodArgumentNotValidException ex = mock(MethodArgumentNotValidException.class);
        when(ex.getBindingResult()).thenReturn(new org.springframework.validation.BeanPropertyBindingResult(new Object(), "object") {{
            addError(fieldError);
        }});

        ResponseEntity<Object> response = handler.handleValidationExceptions(ex, webRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        var body = (java.util.Map<String, Object>) response.getBody();
        assertTrue(body.get("message").toString().contains("Campo inválido"));
    }

    @SuppressWarnings("unchecked")
    @Test
    void testHandleConstraintViolation() {
        ConstraintViolation<?> violation = mock(ConstraintViolation.class);
        Path path = mock(Path.class);

        when(path.toString()).thenReturn("campo");
        when(violation.getPropertyPath()).thenReturn(path);
        when(violation.getMessage()).thenReturn("não pode ser nulo");

        ConstraintViolationException ex = new ConstraintViolationException(Set.of(violation));

        ResponseEntity<Object> response = handler.handleConstraintViolation(ex, webRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        var body = (java.util.Map<String, Object>) response.getBody();
        assert body != null;
        assertTrue(body.get("message").toString().contains("campo: não pode ser nulo"));
    }


    @SuppressWarnings("unchecked")
    @Test
    void testHandleHttpMessageNotReadable() {
        HttpMessageNotReadableException ex = new HttpMessageNotReadableException("JSON inválido");
        ResponseEntity<Object> response = handler.handleHttpMessageNotReadable(ex, webRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        var body = (java.util.Map<String, Object>) response.getBody();
        assertEquals("JSON mal formatado ou campo com tipo inválido.", body.get("message"));
    }
}

