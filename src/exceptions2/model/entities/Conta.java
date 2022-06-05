package exceptions2.model.entities;

import exceptions2.model.exceptions.BusinessException;

public class Conta {

  private Integer numero;
  private String titular;
  private Double saldo;
  private Double limiteSaque;
  
  
  public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
    super();
    this.numero = numero;
    this.titular = titular;
    this.saldo = saldo;
    this.limiteSaque = limiteSaque;
  }


  public Integer getNumero() {
    return numero;
  }


  public void setNumero(Integer numero) {
    this.numero = numero;
  }


  public String getTitular() {
    return titular;
  }


  public void setTitular(String titular) {
    this.titular = titular;
  }


  public Double getSaldo() {
    return saldo;
  }


  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }


  public Double getLimiteSaque() {
    return limiteSaque;
  }


  public void setLimiteSaque(Double limiteSaque) {
    this.limiteSaque = limiteSaque;
  }
  
  public void deposito(double valor) {
    saldo += valor;
}

public void saque(double valor) {
    validateSaque(valor);
    saldo -= valor;
}

private void validateSaque(double valor) {
    if (valor > getLimiteSaque()) {
        throw new BusinessException("Erro de saque: A quantia excede o limite de saque");
    } 
    if (valor > getSaldo()) {
        throw new BusinessException("Erro de saque: Saldo insuficiente");
    }
}
  
}
