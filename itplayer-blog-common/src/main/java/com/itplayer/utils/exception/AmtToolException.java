package com.itplayer.utils.exception;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class AmtToolException extends RuntimeException {
	private static final long serialVersionUID = 8434871710814278861L;
	private String name;
	private Integer code = 0;

	public AmtToolException() {
		super();
	}

	public AmtToolException(Integer code) {
		this.code = code;
	}

	public AmtToolException(String message) {
		super(message);
	}

	public AmtToolException(String message, Integer code) {
		super(message);
		this.code = code;
	}

	public AmtToolException(String name, String message, Integer code) {
		super(message);
		this.name = name;
		this.code = code;
	}

	public AmtToolException(String name, String message) {
		super(message);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
