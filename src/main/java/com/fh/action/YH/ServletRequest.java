package com.fh.action.YH;
public class ServletRequest {
    private int status;
    private String message;
    private Object data;


    public static ServletRequest success(){
        return new ServletRequest(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg());
    }

    public static ServletRequest error(){
        return new ServletRequest(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getMsg());
    }

    public static ServletRequest success(Object data){
        return new ServletRequest(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(),data);
    }
    public static ServletRequest error(Object data){
        return new ServletRequest(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getMsg(),data);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ServletRequest(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public ServletRequest(int status, String message) {
        this.status = status;
        this.message = message;
    }
    public ServletRequest() {
    }
}
