package com.etiya.ecommercedemopair6;

import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.ErrorDataResult;
import com.etiya.ecommercedemopair6.core.util.result.ErrorResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Bean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@SpringBootApplication
@RestControllerAdvice
public class EcommerceDemoPair6Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemoPair6Application.class, args);
	}

	@Bean
	public ModelMapper getModelMapper (){
		return new ModelMapper();

	}

	@ExceptionHandler //400
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public DataResult handleValidationException(MethodArgumentNotValidException exception) {
		//TODO: ErrorDataResult olarak ilgili hataları döndür.
		Map<String, String> errors = new HashMap<>();
		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ErrorDataResult(errors,Message.Exception.validationExcepiton);
	}
	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDataResult<Object> handleBusinessException(BusinessException exception) {
		return  new ErrorDataResult<>(exception.getMessage(),exception.getLocalizedMessage());
	}

	@ExceptionHandler  //400
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result HttpMessageNotReadableException(HttpMessageNotReadableException exception){
		return new ErrorResult(Message.Exception.badRequest);
	}

	@ExceptionHandler //500
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result HttpMessageNotReadableException(NoSuchElementException exception){
		return new ErrorResult(Message.Exception.badRequest);
	}

	@ExceptionHandler //500
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Result NotFoundException(ChangeSetPersister.NotFoundException exception){
		return new ErrorResult(Message.Exception.noSuchException);
	}

}
