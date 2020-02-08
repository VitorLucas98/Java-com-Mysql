
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Peca;

public class PecaDAO {
private static Connection connection;
private static PreparedStatement st;
private static ResultSet rs;

public static List<Peca> leTodos() throws Exception{
List<Peca> listPeca = new ArrayList<Peca>();
try {
String sql = "SELECT * FROM peca";
connection = GerenteDeConexao.getConnection();
st = connection.prepareStatement(sql);
rs = st.executeQuery();
while (rs.next()) {
 Peca pe = new Peca();
 pe.setNumeracao(rs.getInt("numeracao"));
 pe.setPreco(rs.getDouble("preco"));
 pe.setDescricao(rs.getString("descricao"));
 listPeca.add(pe);
 }
st.close();
} catch (Exception e) {
 System.out.println(e.getMessage());
 }
 return listPeca;
 }

public static Peca leUm1(int numeracao) throws Exception {
 Peca peca = new Peca();
 try {
 String sql = "SELECT * FROM peca WHERE numeracao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, numeracao);
 rs = st.executeQuery();
 if (rs.next()) {
 peca.setNumeracao(rs.getInt("numeracao"));
 peca.setPreco(rs.getDouble("preco"));
 peca.setDescricao(rs.getString("descricao"));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return peca;
 }
public static Peca leUm2(String descricao) throws Exception {
 Peca peca = new Peca();
 try {
 String sql = "SELECT * FROM peca WHERE descricao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, descricao);
 rs = st.executeQuery();
 if (rs.next()) {
 peca.setDescricao(rs.getString("descricao"));
 peca.setNumeracao(rs.getInt("numeracao"));
 peca.setPreco(rs.getDouble("preco"));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return peca;
 }
public static Peca leUm3(int numeracao,String descricao) throws Exception {
 Peca peca = new Peca();
 try {
 String sql = "SELECT * FROM peca WHERE numeracao = ? AND descricao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, numeracao);
 st.setString(2, descricao);
 rs = st.executeQuery();
 if (rs.next()) {
 peca.setNumeracao(rs.getInt("numeracao"));
 peca.setDescricao(rs.getString("descricao"));
 peca.setPreco(rs.getDouble("preco"));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return peca;
 }
public static List<Peca>  leUm4(int numeracao,String descricao) throws Exception {
 List<Peca> listPeca = new ArrayList<Peca>();
 try {
 String sql = "SELECT * FROM peca WHERE numeracao = ? OR descricao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, numeracao);
 st.setString(2, descricao);
 rs = st.executeQuery();
 while (rs.next()) {
 Peca peca = new Peca();
 peca.setNumeracao(rs.getInt("numeracao"));
 peca.setDescricao(rs.getString("descricao"));
 peca.setPreco(rs.getDouble("preco"));
 listPeca.add(peca);
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return listPeca;
 }
public static int grava(Peca peca) throws Exception {
 int ret = 0;
 try {
 String sql = "INSERT INTO peca (numeracao,preco,descricao) VALUES (?, ?, ?)";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, peca.getNumeracao());
 st.setDouble(2, peca.getPreco());
 st.setString(3, peca.getDescricao());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera1(Double preco, String descricao,int numeracao ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE peca SET preco = ?, descricao = ? WHERE numeracao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setDouble(1, preco);
 st.setString(2,descricao);
  st.setInt(3,numeracao);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera2(Double preco, int numeracao,String descricao ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE peca SET preco = ?, numeracao = ?  WHERE descricao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setDouble(1, preco);
 st.setInt(2,numeracao);
 st.setString(3,descricao);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera3(Double preco, int numeracao,String descricao ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE peca SET preco = ? WHERE numeracao = ? AND descricao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setDouble(1, preco);
 st.setInt(2,numeracao);
 st.setString(3,descricao);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera4(Double preco, int numeracao,String descricao ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE peca SET preco = ? WHERE numeracao = ? OR descricao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setDouble(1, preco);
 st.setInt(2,numeracao);
 st.setString(3,descricao);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int exclui1(int numeracao) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM peca WHERE numeracao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, numeracao);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int exclui2(String descricao) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM peca WHERE descricao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, descricao);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int exclui3(int numeracao,String descricao) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM peca WHERE numeracao = ? AND descricao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, numeracao);
 st.setString(2, descricao);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int exclui4(String descricao,int numeracao) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM peca WHERE descricao = ? OR numeracao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, descricao);
 st.setInt(2, numeracao);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
}
