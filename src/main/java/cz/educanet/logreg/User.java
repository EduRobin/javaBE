package cz.educanet.logreg;

public class User {
    public String jmeno, heslo;
    public int id, code;

    public String getJmeno() { return jmeno; }
    public String getHeslo() { return heslo; }
    public int getID() { return id; }
    public int getCode() { return code; }

    public String setUser(String jmeno) { return this.jmeno = jmeno; }
    public String setHeslo(String heslo){ return this.heslo = heslo;}
    public int setId(int id) { return this.id = id; }
    public int setCode(int code) { return this.code = code; }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public int getId() {
        return id;
    }
}
