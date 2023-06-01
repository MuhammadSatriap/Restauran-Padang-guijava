package Model;

/**
 *
 * @author Satria
 */
public class transaksi {
    private String id;
    private String nama;
    private String harga;
    private String alamat;
    private String telepon;
    private String status;

    public transaksi() {
    }

    public transaksi(String id, String nama, String harga, String alamat, String telepon, String status) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.alamat = alamat;
        this.telepon = telepon;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
