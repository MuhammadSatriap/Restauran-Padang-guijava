package Controller;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;//Mengimport class untuk mengkoneksikan java dengan SQL.
import java.sql.ResultSet;//Mengimport class sql untuk mendapatkan return value ketika menjalankan statement ke database
import java.sql.SQLException;//Mengimport class sql untuk mendreskripsikan error
import java.sql.Statement;//Mengimport class sql untuk membuat statement
import java.util.logging.Level;//Mengimport class untuk membuat type data yang lebih tinggi/ BigDecimal
import java.util.logging.Logger;//Mengimport class untuk membuat type data yang lebih tinggi/ BigDecimal
import javax.swing.JOptionPane;
import Connection.ConnectionManager;
import View.Form_Admin;
import View.Form_Login;
import View.Form_User;

/**
 *
 * @author Satria
 */
public class Controller {
    PreparedStatement pst;//Inisialisasi library.
    ResultSet rs;//Inisialisasi library.
    Statement st;//Inisialisasi library.
    public Form_User user;
    public Form_Admin admin;
    public Form_Login login;
    
    
    public ResultSet selectDB() {//method untuk memilih syntax dari tabel Mhs.
        ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
        Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
        
        try {
            String sql = "Select * from user";//Syntax sql.
            st = conn.createStatement();//Untuk membuat statement sql.
            rs = st.executeQuery(sql);//Untuk menjalankan statement sql dan mengembalikan values.
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet selectDB2() {//method untuk memilih syntax dari tabel Mhs.
        ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
        Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
        
        try {
            String sql = "Select * from pesanan";//Syntax sql.
            st = conn.createStatement();//Untuk membuat statement sql.
            rs = st.executeQuery(sql);//Untuk menjalankan statement sql dan mengembalikan values.
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet selectDB3() {//method untuk memilih syntax dari tabel Mhs.
        ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
        Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
        
        try {
            String sql = "Select * from transaksi";//Syntax sql.
            st = conn.createStatement();//Untuk membuat statement sql.
            rs = st.executeQuery(sql);//Untuk menjalankan statement sql dan mengembalikan values.
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void login(String username, String password){
        ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
        Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
        String sql = "select * from user where username= '"+username+"' and password = '"+password+"'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()){
                String level = rs.getString("level");
                if(level.equals("admin")){
                    admin = new Form_Admin();
                    login = new Form_Login();
                    admin.setVisible(true);
                    login.setVisible(false);
                }else if(level.equals("user")){
                    user = new Form_User();
                    login = new Form_Login();
                    user.setVisible(true);                    
                    user.pack();
                    user.setLocationRelativeTo(null);
                    user.lbl_nama.setText("Selamat Datang, " + rs.getString(2));
                    user.nama.setText(rs.getString(2));
                    user.telp.setText(rs.getString(5));
                    login.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Gagal");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Gagal");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "salah prosedur");
            e.printStackTrace();
        }
        
    }
    
    public void tambahUsr(String id, String nama, String username, String password, String telepon, String level){
        ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
        Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
        
        try {
            String sql = "insert into user VALUES (?, ?, ?, ?, ?, ?)";
            pst = (PreparedStatement) conn.prepareStatement(sql);//Object baru.
            pst.setString(1, id);
            pst.setString(2, nama);
            pst.setString(3, username);
            pst.setString(4, password);
            pst.setString(5, telepon);
            pst.setString(6, level);
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null, "Berhasil tambah akun.");
        } catch (Exception e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void updateUsr(String id, String nama, String username, String telepon, String level) {//Method menambah Mahasiswa.
        ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
        Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
        
        try {
            String sql = "UPDATE user set nama=?, username=?, telepon=?, level=? where id=?";//Syntax sql.
            pst = (PreparedStatement) conn.prepareStatement(sql);//Object baru.
            pst.setString(5, id);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(1, nama);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(2, username);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(3, telepon);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(4, level);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.executeUpdate();//Menjalankan syntax sql.
            pst.close();
            JOptionPane.showMessageDialog(null, "Update Berhasil.");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
    public void hapusUsr(String id){
        ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
        Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
        
        try {
            String sql = "DELETE from user where id =?";//Syntax sql.
            pst = (PreparedStatement) conn.prepareStatement(sql);//Object baru.
            pst.setString(1, id);//Mengambil data dari FrameMhs menggunakan PrepareStatement.
            pst.executeUpdate();//Menjalankan syntax sql.
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tambahPsn(String id, String username, String detail, String harga, String alamat, String telepon, String pembayaran) {//Method menambah Mahasiswa.
        ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
        Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
        try {
            String sql = "Insert into pesanan values (?,?,?,?,?,?,?)";//Syntax sql.
            pst = (PreparedStatement) conn.prepareStatement(sql);//Object baru.
            pst.setString(1, id);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(2, username);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(3, detail);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(4, harga);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(5, alamat);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(6, telepon);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(7, pembayaran);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.executeUpdate();//Menjalankan syntax sql.
            pst.close();
            JOptionPane.showMessageDialog(null, "Pesanan Telah dibuat.");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void updatePsn(String id, String username, String detail, String harga, String alamat, String telepon) {//Method menambah Mahasiswa.
        ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
        Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
        try {
            String sql = "UPDATE ignore pesanan set username=?, detail=?, harga=?, alamat=?, telepon=? where id=?";//Syntax sql.
            pst = (PreparedStatement) conn.prepareStatement(sql);//Object baru.
            pst.setString(6, id);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(1, username);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(2, detail);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(3, harga);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(4, alamat);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(5, telepon);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.executeUpdate();//Menjalankan syntax sql.
            pst.close();
            JOptionPane.showMessageDialog(null, "Update Berhasil.");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
    public void konfirPsn(String id, String nama, String harga, String alamat, String telepon) {//Method menambah Mahasiswa. 
        ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
        Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
        try {
            String status = "Dikirim";
            String sql = "Insert into transaksi values (?,?,?,?,?,?)";//Syntax sql.
            pst = (PreparedStatement) conn.prepareStatement(sql);//Object baru.
            pst.setString(1, id);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(2, nama);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(3, harga);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(4, alamat);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(5, telepon);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(6, status);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.executeUpdate();//Menjalankan syntax sql.
            hapus(id);
            pst.close();
            JOptionPane.showMessageDialog(null, "Pesanan Telah dikirim.");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hapus(String id){
        ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
        Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
        
        try {
            String sql = "DELETE from pesanan where id =?";//Syntax sql.
            pst = (PreparedStatement) conn.prepareStatement(sql);//Object baru.
            pst.setString(1, id);//Mengambil data dari FrameMhs menggunakan PrepareStatement.
            pst.executeUpdate();//Menjalankan syntax sql.
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void batalPsn(String id, String nama, String harga, String alamat, String telepon) {//Method menambah Mahasiswa.
        ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
        Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
        
        try {
            String status = "Batal";
            String sql = "Insert into transaksi values (?,?,?,?,?,?)";//Syntax sql.
            pst = (PreparedStatement) conn.prepareStatement(sql);//Object baru.
            pst.setString(1, id);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(2, nama);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(3, harga);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(4, alamat);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(5, telepon);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.setString(6, status);//Memasukan data yang diambil dari Frame ke dalam syntax sql.
            pst.executeUpdate();//Menjalankan syntax sql.
            hapus(id);
            pst.close();
            JOptionPane.showMessageDialog(null, "Pesanan Telah dikirim.");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hapusTrk(String id){
        ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
        Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
        try {
            String sql = "DELETE from transaksi where id =?";//Syntax sql.
            pst = (PreparedStatement) conn.prepareStatement(sql);//Object baru.
            pst.setString(1, id);//Mengambil data dari FrameMhs menggunakan PrepareStatement.
            pst.executeUpdate();//Menjalankan syntax sql.
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void dtrma(String id){
        ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
        Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
        try {
            String sql = "UPDATE transaksi set status=? where id =?";//Syntax sql.
            pst = (PreparedStatement) conn.prepareStatement(sql);//Object baru.
            String status = "Diterima";
            pst.setString(1, status);//Mengambil data dari FrameMhs menggunakan PrepareStatement.
            pst.setString(2, id);//Mengambil data dari FrameMhs menggunakan PrepareStatement.
            pst.executeUpdate();//Menjalankan syntax sql.
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
