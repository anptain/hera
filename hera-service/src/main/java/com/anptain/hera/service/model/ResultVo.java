package com.anptain.hera.service.model;

import java.io.Serializable;

public class ResultVo implements Serializable {

	private static final long serialVersionUID = -773058344437465211L;

	private final static int CODE_SUCCESS = 0;

	private final static int CODE_EXCEPTION = 1;

	private final static int CODE_ERROR = -1;

	public static ResultVo createSuccessResp() {
		return createSuccessResp(null);
	}

	public static ResultVo createSuccessResp(Object content) {
		return new ResultVo(CODE_SUCCESS, content);
	}

	public static ResultVo createExceptionResp() {
		return createExceptionResp(null);
	}

	public static ResultVo createExceptionResp(String content) {
		return new ResultVo(CODE_EXCEPTION, content);
	}

	public static ResultVo createErrorResp() {
		return new ResultVo(CODE_ERROR, null);
	}

	private int code;
	private Object content;

	public ResultVo(int code, Object content) {
		super();
		this.code = code;
		this.content = content;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

}
