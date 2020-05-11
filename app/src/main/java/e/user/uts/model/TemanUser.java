package e.user.uts.model;
/*
    tgl pengerjaan  : 11-Mei-2020
    Nim             : 10117104
    Nama            : Aditya Suheryana
    Kelas           : IF-3 / AKB-3
 */

public class TemanUser {
    private String Id,Nim,Nama,Kelas,Telp,Email,Instagram;

    public TemanUser() {

    }
    public TemanUser(String Id, String Nim, String Nama, String Kelas, String Telp, String Email, String Instagram) {
            this.setNim(Id);
            this.setNim(Nim);
            this.setNama(Nama);
            this.setKelas(Kelas);
            this.setTelp(Telp);
            this.setEmail(Email);
            this.setInstagram(Instagram);

        }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNim() {
        return Nim;
    }

    public void setNim(String nim) {
        Nim = nim;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getKelas() {
        return Kelas;
    }

    public void setKelas(String kelas) {
        Kelas = kelas;
    }

    public String getTelp() {
        return Telp;
    }

    public void setTelp(String telp) {
        Telp = telp;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getInstagram() {
        return Instagram;
    }

    public void setInstagram(String instagram) {
        Instagram = instagram;
    }
}
