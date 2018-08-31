package Test.Enum;

/**
 * 枚举类型错误码
 */
public enum ErrorCode {
    FAILURE(0,"操作失败"),
    SUCCESS(1,"操作成功");

    private int code;
    private  String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public static void main(String[] args){
        System.out.println(ErrorCode.SUCCESS.getCode()+" , "+ErrorCode.SUCCESS.getMsg());
        System.out.println(ErrorCode.FAILURE.getCode()+" , "+ErrorCode.FAILURE.getMsg());
    }
}
