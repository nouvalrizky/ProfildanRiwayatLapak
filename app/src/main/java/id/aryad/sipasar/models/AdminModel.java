package id.aryad.sipasar.models;

public class AdminModel {
    private int id_admin;
    private int id_pegawai;
    private String username;
    private String password;
    private String role;
    private int status;

    public AdminModel(int id_admin, int id_pegawai, String username, String password, String role, int status) {
        this.id_admin = id_admin;
        this.id_pegawai = id_pegawai;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public int getId_admin() {
        return id_admin;
    }

    public int getId_pegawai() {
        return id_pegawai;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public int getStatus() {
        return status;
    }
}
