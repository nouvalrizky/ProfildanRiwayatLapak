package id.aryad.sipasar.data;

import java.util.ArrayList;

import id.aryad.sipasar.models.AdminModel;

public class AdminData {
    public ArrayList<AdminModel> akunAdmin;

    public AdminData() {
        akunAdmin = new ArrayList<>();
        akunAdmin.add(new AdminModel(1, 1, "admin", "admin", "pegawai", 1));
        akunAdmin.add(new AdminModel(2, 2, "aryapegawai", "pass123", "pegawai", 1));
        akunAdmin.add(new AdminModel(3, 3, "aryaadmin", "pass123", "admin", 1));
        akunAdmin.add(new AdminModel(4, 4, "aryamanager", "pass123", "manager", 1));
    }


    public void setAkunAdmin(ArrayList<AdminModel> akunAdmin) {
        this.akunAdmin = akunAdmin;
    }

    public ArrayList<AdminModel> getAkunAdmin() {
        return akunAdmin;
    }
}
