
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Atendente;

public class AtendenteDAO {
private static Connection connection;
private static PreparedStatement st;
private static ResultSet rs;

public static List<Atendente> leTodos() throws Exception{
List<Atendente> listAtendente = new ArrayList<Atendente>();
try {
String sql = "SELECT * FROM atendente";
connection = GerenteDeConexao.getConnection();
st = connection.prepareStatement(sql);
rs = st.executeQuery();
while (rs.next()) {
 Atendente at = new Atendente();
 at.setCpf(rs.getString("cpf"));
 at.setNome(rs.getString("nome"));
 at.setSalLiquido(rs.getDouble("salLiquido"));
 at.setQtdCliente(rs.getInt("qtdCliente"));
 listAtendente.add(at);
 }
st.close();
} catch (Exception e) {
 System.out.println(e.getMessage());
 }
 return listAtendente;
 }

public static Atendente leUm1(String cpf) throws Exception {
 Atendente at = new Atendente();
 try {
 String sql = "SELECT * FROM atendente WHERE cpf = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, cpf);
 rs = st.executeQuery();
 if (rs.next()) {
 at.setCpf(rs.getString("cpf"));
 at.setNome(rs.getString("nome"));
 at.setSalLiquido(rs.getDouble("salLiquido"));
 at.setQtdCliente(rs.getInt("qtdCliente"));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return at;
 }
public static Atendente leUm2(String nome) throws Exception {
 Atendente at = new Atendente();
 try {
 String sql = "SELECT * FROM atendente WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 rs = st.executeQuery();
 if (rs.next()) {
 at.setNome(rs.getString("nome"));
 at.setCpf(rs.getString("cpf"));
 at.setSalLiquido(rs.getDouble("salLiquido"));
 at.setQtdCliente(rs.getInt("qtdCliente"));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return at;
 }
public static Atendente leUm3(Double salLiquido,int qtdCliente) throws Exception {
 Atendente at = new Atendente();
 try {
 String sql = "SELECT * FROM atendente WHERE salLiquido = ? AND qtdCliente = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setDouble(1, salLiquido);
 st.setInt(2, qtdCliente);
 rs = st.executeQuery();
 if (rs.next()) {
 at.setSalLiquido(rs.getDouble("salLiquido"));
 at.setQtdCliente(rs.getInt("qtdCliente"));
 at.setCpf(rs.getString("cpf"));
 at.setNome(rs.getString("nome"));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return at;
 }
public static List<Atendente>  leUm4(String nome,String cpf) throws Exception {
 List<Atendente> listAtendente = new ArrayList<Atendente>();
 try {
 String sql = "SELECT * FROM atendente WHERE nome = ? OR cpf = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 st.setString(2, cpf);
 rs = st.executeQuery();
 while (rs.next()) {
 Atendente at = new Atendente();
 at.setNome(rs.getString("nome"));
 at.setCpf(rs.getString("cpf"));
 at.setSalLiquido(rs.getDouble("salLiquido"));
 at.setQtdCliente(rs.getInt("qtdCliente"));
 listAtendente.add(at);
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return listAtendente;
 }

public static int grava(Atendente atendente) throws Exception {
 int ret = 0;
 try {
 String sql = "INSERT INTO atendente (cpf,nome,salLiquido,qtdCliente) VALUES (?,?,?,?)";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, atendente.getCpf());
 st.setString(2, atendente.getNome());
 st.setDouble(3, atendente.getSalLiquido());
 st.setInt(4, atendente.getQtdCliente());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera1(String nome,Double salLiquido, int qtdcliente, String cpf) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE atendente SET nome = ?, salLiquido = ?, qtdcliente = ?  WHERE cpf = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1,nome);
 st.setDouble(2,salLiquido);
 st.setInt(3,qtdcliente);
 st.setString(4,cpf);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera2(Double SalLiquido,String cpf, String nome ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE atendente SET salLiquido = ?, cpf = ?  WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setDouble(1, SalLiquido);
 st.setString(2,cpf);
  st.setString(3,nome);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera3(int qtdCliente, String cpf,String nome ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE atendente SET qtdCliente = ? WHERE cpf = ? AND nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
st.setInt(1,qtdCliente);
st.setString(2,cpf);
st.setString(3,nome);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera4(String nome, int qtdCliente,Double salLiquido ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE atendente SET nome = ? WHERE qtdCliente = ? OR salLiquido = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1,nome);
 st.setInt(2,qtdCliente);
 st.setDouble(3, salLiquido);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

public static int exclui1(String cpf) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM atendente WHERE cpf = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, cpf);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int exclui2(String nome) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM atendente WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int exclui3(int qtdCliente,Double salLiquido) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM atendente WHERE qtdCliente = ? AND salLiquido = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, qtdCliente);
 st.setDouble(2, salLiquido);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int exclui4(String cpf,String nome) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM atendente WHERE cpf = ? OR nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, cpf);
 st.setString(2, nome);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
}
