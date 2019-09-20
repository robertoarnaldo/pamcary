package br.com.pamcary.desafio.aluno.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorController> handle(MethodArgumentNotValidException exception) {
		List<ErrorController> error = new ArrayList<>();

		exception.getBindingResult().getFieldErrors().forEach(e -> {
			error.add(new ErrorController(e.getField(),
					messageSource.getMessage(e, LocaleContextHolder.getLocale())));
		});

		return error;
	}

}
