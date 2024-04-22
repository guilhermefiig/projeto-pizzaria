package pizzaria;

import java.util.Date;

public class Conta {
    private Date data;

    public Conta(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
