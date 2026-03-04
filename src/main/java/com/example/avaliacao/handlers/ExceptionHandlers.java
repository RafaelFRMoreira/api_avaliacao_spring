package com.example.avaliacao.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.avaliacao.exceptions.EmailJaExisteException;
import com.example.avaliacao.exceptions.NaoEncontradoException;

@ControllerAdvice
public class ExceptionHandlers {
	
    // 1. Trata o erro 404 (Tanto para Cliente não encontrado quanto para Produto)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(NaoEncontradoException.class)
    public String recursoNaoEncontrado(NaoEncontradoException ex) {
        return ex.getMessage();
    }
	
    // 2. Trata o erro 409 (Quando tenta cadastrar um Cliente com e-mail repetido)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    @ExceptionHandler(EmailJaExisteException.class)
    public String emailJaExiste(EmailJaExisteException ex) {
        return ex.getMessage();
    }
	
    // 3. Trata qualquer outro erro inesperado do sistema (Erro 500)
   // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   // @ResponseBody
    //@ExceptionHandler(Exception.class)
    //public String excecaoGeral(Exception ex) {
       // return "Ocorreu um erro interno no servidor: " + ex.getMessage();
    //}
}