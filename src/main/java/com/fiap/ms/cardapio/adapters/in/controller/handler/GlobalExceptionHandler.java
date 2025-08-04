package com.fiap.ms.cardapio.adapters.in.controller.handler;

import com.fiap.ms.cardapio.application.core.domain.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", OffsetDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Bad Request");
        body.put("message", "Endpoint inválido. Verifique a URL.");
        body.put("path", request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handleMissingParams(MissingServletRequestParameterException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", OffsetDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Bad Request");
        body.put("message", "O parâmetro '" + ex.getParameterName() + "' é obrigatório.");
        body.put("path", request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CampoObrigatorioException.class)
    public ResponseEntity<Object> handleCampoObrigatorio(CampoObrigatorioException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", OffsetDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Bad Request");
        body.put("message", ex.getReason());
        body.put("path", request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemCardapioNaoEncontradoException.class)
    public ResponseEntity<Object> handleItemCardapioNaoEncontrado(ItemCardapioNaoEncontradoException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", OffsetDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Not Found");
        body.put("message", ex.getReason());
        body.put("path", request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AtualizarDadosIguaisException.class)
    public ResponseEntity<Object> handleAtualizarDadosIguais(AtualizarDadosIguaisException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", OffsetDateTime.now());
        body.put("status", HttpStatus.CONFLICT.value());
        body.put("error", "Conflict");
        body.put("message", ex.getReason());
        body.put("path", request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(TagNaoEncontradaException.class)
    public ResponseEntity<Object> handleTagNaoEncontrada(TagNaoEncontradaException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", OffsetDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Not Found");
        body.put("message", ex.getReason());
        body.put("path", request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NomeItemCardapioDuplicadoException.class)
    public ResponseEntity<Object> handleNomeItemCardapioDuplicado(NomeItemCardapioDuplicadoException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", OffsetDateTime.now());
        body.put("status", HttpStatus.CONFLICT.value());
        body.put("error", "Conflict");
        body.put("message", ex.getReason());
        body.put("path", request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }
}
