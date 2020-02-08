
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Celular;

public class CelularDAO {
    private static Connection connection;
private static PreparedStatement st;
private static ResultSet rs;

public static List<Celular> leTodos() throws Exception{
List<Celular> listCelular = new ArrayList<Celular>();
try {
String sql = "SELECT * FROM Celular";
connection = GerenteDeConexao.getConnection();
st = connection.prepareStatement(sql);
rs = st.executeQuery();
while (rs.next()) {
 Celular ce = new Celular();
 ce.setCodPlaca(rs.getString("codPlaca"));
 ce.setModelo(rs.getString("modelo"));
 ce.setAcessorio(AcessorioDAO.leUm1(rs.getString("Acessorio_codBarra")));
 listCelular.add(ce);
 }
st.close();
} catch (Exception e) {
 System.out.println(e.getMessage());
 }
 return listCelular;
 }
public static Celular leUm1(String codPlaca) throws Exception {
 Celular ce = new Celular();
 try {
 String sql = "SELECT * FROM celular WHERE codPlaca = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, codPlaca);
 rs = st.executeQuery();
 if (rs.next()) {
 ce.setCodPlaca(rs.getString("codPlaca"));
 ce.setModelo(rs.getString("modelo"));
 ce.setAcessorio(AcessorioDAO.leUm1(rs.getString("Acessorio_codBarra")));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ce;
 }
public static Celular leUm2(String modelo) throws Exception {
 Celular ce = new Celular();
 try {
 String sql = "SELECT * FROM celular WHERE modelo = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, modelo);
 rs = st.executeQuery();
 if (rs.next()) {
 ce.setModelo(rs.getString("modelo"));
 ce.setCodPlaca(rs.getString("codPlaca"));
 ce.setAcessorio(AcessorioDAO.leUm1(rs.getString("Acessorio_codBarra")));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ce;
 }
public static Celular leUm3(String codPlaca, String modelo) throws Exception {
 Celular ce = new Celular();
 try {
 String sql = "SELECT * FROM celular WHERE codPlaca = ? and modelo = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, codPlaca);
 st.setString(2, modelo);
 rs = st.executeQuery();
 if (rs.next()) {
 ce.setCodPlaca(rs.getString("codPlaca"));
  ce.setModelo(rs.getString("modelo"));
 ce.setAcessorio(AcessorioDAO.leUm1(rs.getString("Acessorio_codBarra")));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ce;
 }
public static List<Celular>  leUm4(String modelo,String acessorio_codBarra) throws Exception {
 List<Celular> listCelular = new ArrayList<Celular>();
 try {
 String sql = "SELECT * FROM Celular WHERE modelo = ? or acessorio_codBarra = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, modelo);
 st.setString(2, acessorio_codBarra);
 rs = st.executeQuery();
 while (rs.next()) {
 Celular ce = new Celular();
ce.setModelo(rs.getString("modelo"));
ce.setAcessorio(AcessorioDAO.leUm1(rs.getString("Acessorio_codBarra")));
ce.setCodPlaca(rs.getString("codPlaca"));
 listCelular.add(ce);
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return listCelular;
 }
public static int grava(Celular celular) throws Exception {
 int ret = 0;
 try {
 String sql = "INSERT INTO celular (codPlaca,modelo,Acessorio_codBarra) VALUES (?, ?, ?)";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, celular.getCodPlaca());
 st.setString(2, celular.getModelo());
 st.setString(3, celular.getAcessorio().getCodBarra());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera1(Celular ce) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE Celular SET modelo = ?, Acessorio_codBarra = ? WHERE codPlaca = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
  st.setString(1, ce.getModelo());
 st.setString(2, ce.getAcessorio().getCodBarra());
  st.setString(3, ce.getCodPlaca());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera2(String codPlaca, String acessorio_codBarra,String modelo ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE celular SET codPlaca = ?, acessorio_codBarra = ?  WHERE modelo = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1,codPlaca);
 st.setString(2,acessorio_codBarra);
 st.setString(3,modelo);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera3(String modelo,String codPlaca, String acessorio_codBarra ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE celular SET modelo = ? WHERE codPlaca = ? and acessorio_codBarra = ?   ";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1,modelo);
 st.setString(2,codPlaca);
 st.setString(3,acessorio_codBarra);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera4(String acessorio_codBarra, String modelo, String codPlaca) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE Celular SET acessorio_codBarra = ? WHERE modelo = ? or codPlaca = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1,acessorio_codBarra);
 st.setString(2, modelo);
 st.setString(3, codPlaca);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int exclui1(String codPlaca) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Celular WHERE codPlaca = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, codPlaca);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 } 
public static int exclui2(String modelo) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Celular WHERE modelo = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, modelo);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 } 
public static int exclui3(String codPlaca,String modelo) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Celular WHERE codPlaca =? and modelo = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, codPlaca);
  st.setString(2, modelo);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 } 
public static int exclui4(String acessorio_codBarra,String codPlaca) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Celular WHERE acessorio_codBarra =? or codPlaca = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, acessorio_codBarra);
  st.setString(2, codPlaca);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
}
