package com.yppcat.community.result;

import com.yppcat.community.constant.ResultCode;

public class ResultUtil {
    public static Result<Object> success(Object object) {
        Result<Object> result = new Result<>();
        result.setCode(ResultCode.CODE_SUCCESS);
        result.setMsg(ResultCode.MSG_SUCCESS);
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
