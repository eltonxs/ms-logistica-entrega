package br.com.mslogisticaentrega.exception;

public class DuplicidadeException extends RuntimeException {
    public DuplicidadeException(String mensagem) {
        super(mensagem);
    }
}