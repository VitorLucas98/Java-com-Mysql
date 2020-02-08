
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Servico;

public class ServicoDAO {
private static Connection connection;
private static PreparedStatement st;
private static ResultSet rs;

public static List<Servico> leTodos() throws Exception{
List<Servico> listServico = new ArrayList<Servico>();
try {
String sql = "SELECT * FROM Servico";
connection = GerenteDeConexao.getConnection();
st = connection.prepareStatement(sql);
rs = st.executeQuery();
while (rs.next()) {
 Servico se = new Servico();
 se.setCodServico(rs.getString("codServico"));
 se.setPreco(rs.getDouble("preco"));
 se.setData(rs.getString("data"));
 se.setAtendente(AtendenteDAO.leUm1(rs.getString("Atendente_cpf")));
 listServico.add(se);
 }
st.close();
} catch (Exception e) {
 System.out.println(e.getMessage());
 }
 return listServico;
 }
public static Servico leUm1(String codServico) throws Exception {
 Servico ser = new Servico();
 try {
 String sql = "SELECT * FROM Servico WHERE codServico = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, codServico);
 rs = st.executeQuery();
 if (rs.next()) {
 ser.setCodServico(rs.getString("codServico"));
 ser.setPreco(rs.getDouble("preco"));
 ser.setData(rs.getString("data"));
 ser.setAtendente(AtendenteDAO.leUm1(rs.getString("Atendente_cpf")));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ser;
 }
public static Servico leUm2(String data) throws Exception {
 Servico ser = new Servico();
 try {
 String sql = "SELECT * FROM Servico WHERE data = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, data);
 rs = st.executeQuery();
 if (rs.next()) {
ser.setData(rs.getString("Data")); 
ser.setCodServico(rs.getString("codServico"));
ser.setPreco(rs.getDouble("preco"));
ser.setAtendente(AtendenteDAO.leUm1(rs.getString("Atendente_cpf")));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ser;
 }
public static Servico leUm3(String codServico,String data) throws Exception {
 Servico ser = new Servico();
 try {
 String sql = "SELECT * FROM servico WHERE codServico = ? AND data = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, codServico);
  st.setString(2, data);
 rs = st.executeQuery();
 if (rs.next()) {
ser.setCodServico(rs.getString("codServico")); 
ser.setData(rs.getString("data"));
ser.setPreco(rs.getDouble("preco"));
ser.setAtendente(AtendenteDAO.leUm1(rs.getString("Atendente_cpf")));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ser;
 }
public static List<Servico>  leUm4(Double preco,String atendente_cpf) throws Exception {
 List<Servico> listServico = new ArrayList<Servico>();
 try {
 String sql = "SELECT * FROM Servico WHERE preco = ? OR atendente_cpf = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setDouble(1, preco);
 st.setString(2, atendente_cpf);
 rs = st.executeQuery();
 while (rs.next()) {
 Servico ser = new Servico();
ser.setPreco(rs.getDouble("preco"));
ser.setAtendente(AtendenteDAO.leUm1(rs.getString("Atendente_cpf")));
ser.setCodServico(rs.getString("codServico")); 
ser.setData(rs.getString("data"));

 listServico.add(ser);
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return listServico;
 }
public static int grava(Servico servico) throws Exception {
 int ret = 0;
 try {
 String sql = "INSERT INTO Servico (codServico,preco,data,Atendente_cpf) VALUES (?, ?, ?, ?)";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, servico.getCodServico());
 st.setDouble(2, servico.getPreco());
 st.setString(3, servico.getData());
 st.setString(4, servico.getAtendente().getCpf());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera1(Servico servico) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE Servico SET preco = ?, data = ?, Atendente_cpf = ? WHERE codServico = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setDouble(1,servico.getPreco());
 st.setString(2, servico.getData());
 st.setString(3, servico.getAtendente().getCpf());
 st.setString(4, servico.getCodServico());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera2(String codServico,String data, String atendente_cpf,Double preco ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE Servico SET codServico = ?, data = ?, atendente_cpf = ?  WHERE preco = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
  st.setString(1,codServico);
 st.setString(2,data);
 st.setString(3,atendente_cpf);
 st.setDouble(4, preco);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera3(Double preco,String data,String codServico,String Atendente_cpf ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE Servico SET preco = ?, data = ? WHERE codServico = ? and Atendente_cpf = ?   ";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setDouble(1, preco);
 st.setString(2,data);
 st.setString(3,codServico);
 st.setString(4,Atendente_cpf);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera4(String data,String Atendente_cpf, String codServico,Double preco) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE Servico SET data = ?, Atendente_cpf = ? WHERE codServico = ? or preco = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1,data);
 st.setString(2,Atendente_cpf);
  st.setString(3,codServico);
 st.setDouble(4, preco);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int exclui1(String codServico) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Servico WHERE codServico = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, codServico);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 } 
public static int exclui2(String data) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Servico WHERE data = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, data);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 } 
public static int exclui3(String codServico,String data) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Servico WHERE codServico =? and data = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, codServico);
  st.setString(2, data);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int exclui4(String atendente_cpf,Double preco) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Servico WHERE Atendente_cpf =? or preco = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, atendente_cpf);
  st.setDouble(2, preco);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 } 
}
