package pe.edu.ulima.ulpokemonapi.ulpokemonapi.dto.usuario;

public class Status {
    private int code;
    private String msg;

    public Status(int code, String msg) {
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
    
    
}
