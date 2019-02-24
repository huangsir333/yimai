package cn.alibaba.yimai.util;

public class AjaxResult {
    private boolean success=true;
    private String  msg="操作成功";
    private Object object;

    public static  AjaxResult get(){
        return new AjaxResult();
    }

    public AjaxResult() {
    }

    public AjaxResult(String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public boolean isSuccess() {
        return success;
    }

    public AjaxResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public AjaxResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", object=" + object +
                '}';
    }

}
