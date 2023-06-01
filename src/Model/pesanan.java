package Model;

/**
 *
 * @author Satria
 */
public class pesanan {
    private int id;
    private String username;
    private String detail;
    private String harga;
    private String alamat;
    private String telepon;
    private String pembayaran;

    public pesanan() {
    }

    public pesanan(int id, String username, String detail, String harga, String alamat, String telepon, String pembayaran) {
        this.id = id;
        this.username = username;
        this.detail = detail;
        this.harga = harga;
        this.alamat = alamat;
        this.telepon = telepon;
        this.pembayaran = pembayaran;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public String getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    }
    
    
}
