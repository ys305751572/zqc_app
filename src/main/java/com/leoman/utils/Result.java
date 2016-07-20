package com.leoman.utils;

import com.leoman.enums.ErrorType;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yesong
 *
 */
public final class Result {

	private int status;                                           // 状态 0:成功 1:失败（异常）
	private String msg;                                               // 错误信息
	private Object data;  // 数据内容

	private static final int SUCCESS = 0;                             // 成功
	private static final int ERROR = 1;                               // 失败(异常)

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Result(){}

	public Result(ErrorType errorType){
		this.status= errorType.getCode();
		this.msg= errorType.getName();
	}

	public static Result success(String... errorMessage) {
		Result result = new Result();
		result.status = SUCCESS;
		if(errorMessage == null || errorMessage.length == 0) {
			result.msg = "操作成功";
		}
		else {
			result.msg = errorMessage[0];
		}
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Result success(Object data) {
		Result result = new Result();
		result.status = SUCCESS;
		result.msg = "";
		result.data = data;
		return result;
	}

	public static Result failure(String... errorMessage) {
		Result result = new Result();
		result.status = ERROR;
		if(errorMessage == null || errorMessage.length == 0) {
			result.msg = "操作失败";
		} 
		else {
			result.msg = errorMessage[0];
		}
		return result;
	}

}
