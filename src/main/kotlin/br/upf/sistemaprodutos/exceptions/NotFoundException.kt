package br.upf.sistemaprodutos.exceptions

import br.upf.sistemaprodutos.dtos.ErrorResponseDTO
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.RuntimeException

class NotFoundException (override val message: String)
    : RuntimeException ()

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(
        exception: NotFoundException,
        request: HttpServletRequest
    ): ErrorResponseDTO {
        return ErrorResponseDTO(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            massage = exception.message,
            path = request.servletPath
        )
    }
}