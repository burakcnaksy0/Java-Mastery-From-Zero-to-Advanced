package L5_OOP;

public class D3_Encapsulation_Students {
    private String name;
    private String surname;
    private int no;
    private byte sınıf;
    private boolean status;

    D3_Encapsulation_Students(String name, String surname, int no, byte sınıf, boolean status) {
        this.name = name;
        this.surname = surname;
        this.no = no;
        this.sınıf = sınıf;
        this.status = status;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public byte getSınıf() {
        return sınıf;
    }

    public void setSınıf(byte sınıf) {
        this.sınıf = sınıf;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
