package Model;

/**
 *
 * @author Satria
 */
public class user {
    private int id;
    private String nama;
    private String username;
    private String password;
    private String telepon;
    private String level;

    public user() {
    }

    public user(int id, String nama, String username, String password, String telepon, String level) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.telepon = telepon;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
    
}
