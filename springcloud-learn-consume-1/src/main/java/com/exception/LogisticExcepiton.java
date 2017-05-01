package com.exception;

/**
 * 业务异常类
 */
public class LogisticExcepiton extends RuntimeException {

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  private Integer code;

  public LogisticExcepiton() {
    super();
  }

  public LogisticExcepiton(String message) {
    super(message);
  }

  public LogisticExcepiton(Integer code , String message) {
    super(message);
    this.code = code ;
  }

  public LogisticExcepiton(String message, Throwable cause) {
    super(message, cause);
  }

  public LogisticExcepiton(Throwable cause) {
    super(cause);
  }


}
