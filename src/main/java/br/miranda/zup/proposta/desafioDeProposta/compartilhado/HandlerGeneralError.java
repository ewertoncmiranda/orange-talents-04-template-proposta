package br.miranda.zup.proposta.desafioDeProposta.compartilhado;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class HandlerGeneralError {
    @Autowired
    MessageSource messageSource ;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ErrorResponse> handlerMethodArgumentNotValid(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<ErrorResponse>listaDeErros = new ArrayList<>();

        fieldErrors.forEach( error ->{
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            ErrorResponse errorResponse = new ErrorResponse(error.getField() ,mensagem);
            listaDeErros.add(errorResponse);
        });
        return listaDeErros;
    }

    @ExceptionHandler(FeignException.FeignServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handlerFeignServerException(FeignException.FeignServerException exception){
      return  new ErrorResponse(exception.getMessage(),exception.getCause().toString());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FeignException.FeignClientException.class)
    public ErrorResponse handlerFeignClienteException(FeignException.FeignClientException exception){
      return  new ErrorResponse(exception.getMessage(),exception.getCause().toString());
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(FeignException.UnprocessableEntity.class)
    public ErrorResponse handlerFeignClienteRException(FeignException.UnprocessableEntity exception) {
       return  new ErrorResponse(exception.getMessage(),exception.getCause().toString());
    }
}
