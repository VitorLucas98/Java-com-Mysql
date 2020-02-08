
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

public class ClienteDAO {
    private static Connection connection;
private static PreparedStatement st;
private static ResultSet rs;

public static List<Cliente> leTodos() throws Exception{
List<Cliente> listCliente = new ArrayList<Cliente>();
try {
String sql = "SELECT * FROM Cliente";
connection = GerenteDeConexao.getConnection();
st = connection.prepareStatement(sql);
rs = st.executeQuery();
while (rs.next()) {
 Cliente cli = new Cliente();
 cli.setCpf(rs.getString("cpf"));
 cli.setNome(rs.getString("nome"));
 cli.setEndereco(rs.getString("endereco"));
 cli.setCelular(CelularDAO.leUm1(rs.getString("Celular_codPlaca")));
 cli.setServico(ServicoDAO.leUm1(rs.getString("Servico_codServico")));
 listCliente.add(cli);
 }
st.close();
} catch (Exception e) {
 System.out.println(e.getMessage());
 }
 return listCliente;
 }
public static Cliente leUm1(String cpf) throws Exception {
 Cliente cli = new Cliente();
 try {
 String sql = "SELECT * FROM Cliente WHERE cpf = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, cpf);
 rs = st.executeQuery();
 if (rs.next()) {
 cli.setCpf(rs.getString("cpf"));
 cli.setNome(rs.getString("nome"));
 cli.setEndereco(rs.getString("endereco"));
 cli.setCelular(CelularDAO.leUm1(rs.getString("Celular_codPlaca")));
 cli.setServico(ServicoDAO.leUm1(rs.getString("Servico_codServico")));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return cli;
 }
public static Cliente leUm2(String nome) throws Exception {
 Cliente cli = new Cliente();
 try {
 String sql = "SELECT * FROM Cliente WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 rs = st.executeQuery();
 if (rs.next()) {
cli.setNome(rs.getString("nome")); 
cli.setCpf(rs.getString("cpf"));
cli.setEndereco(rs.getString("endereco"));
cli.setCelular(CelularDAO.leUm1(rs.getString("Celular_codPlaca")));
cli.setServico(ServicoDAO.leUm1(rs.getString("Servico_codServico")));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return cli;
 }
public static Cliente leUm3(String cpf,String nome) throws Exception {
 Cliente cli = new Cliente();
 try {
 String sql = "SELECT * FROM Cliente WHERE cpf = ? AND nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, cpf);
  st.setString(2, nome);
 rs = st.executeQuery();
 if (rs.next()) {
cli.setCpf(rs.getString("cpf"));
cli.setNome(rs.getString("nome")); 
cli.setEndereco(rs.getString("endereco"));
cli.setCelular(CelularDAO.leUm1(rs.getString("Celular_codPlaca")));
cli.setServico(ServicoDAO.leUm1(rs.getString("Servico_codServico")));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return cli;
 }
public static List<Cliente>  leUm4(String celular_codPlaca,String Servico_codServico) throws Exception {
 List<Cliente> listCliente = new ArrayList<Cliente>();
 try {
 String sql = "SELECT * FROM Cliente WHERE salLiquido = ? OR equipamento = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, celular_codPlaca);
 st.setString(2, Servico_codServico);
 rs = st.executeQuery();
 while (rs.next()) {
 Cliente cli = new Cliente();
cli.setCelular(CelularDAO.leUm1(rs.getString("Celular_codPlaca")));
cli.setServico(ServicoDAO.leUm1(rs.getString("Servico_codServico")));
cli.setCpf(rs.getString("cpf"));
cli.setNome(rs.getString("nome")); 
cli.setEndereco(rs.getString("endereco"));
 listCliente.add(cli);
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return listCliente;
 }
public static int grava(Cliente cliente) throws Exception {
 int ret = 0;
 try {
 String sql = "INSERT INTO cliente (cpf,nome,endereco,Celular_codPlaca,Servico_codServico) VALUES (?, ?, ?, ?, ?)";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, cliente.getCpf());
 st.setString(2, cliente.getNome());
 st.setString(3, cliente.getEndereco());
 st.setString(4, cliente.getCelular().getCodPlaca());
 st.setString(5, cliente.getServico().getCodServico());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera1(Cliente cliente) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE Cliente SET nome = ?, endereco = ?, Celular_codPlaca = ?, Servico_codServico = ? WHERE cpf = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, cliente.getNome());
 st.setString(2, cliente.getEndereco());
 st.setString(3, cliente.getCelular().getCodPlaca());
 st.setString(4, cliente.getServico().getCodServico());
 st.setString(5, cliente.getCpf());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera2(String cpf,String endereco, String Celular_codPlaca, 
        String Servico_codServico, String nome) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE Cliente SET cpf = ?, endereco = ?, Celular_codPlaca = ?, Servico_codServico = ?  WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
  st.setString(1,cpf);
 st.setString(2, endereco);
 st.setString(3,Celular_codPlaca);
 st.setString(4,Servico_codServico);
 st.setString(5,nome);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera3(String nome,String endereco, 
         String Celular_codPlaca,String cpf, String Servico_codServico ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE tecnico SET nome = ?, endereco = ?, Celular_codPlaca = ? WHERE cpf = ? and Servico_codServico = ?   ";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1,nome);
 st.setString(2, endereco);
 st.setString(3,Celular_codPlaca);
 st.setString(4,cpf);
 st.setString(5,Servico_codServico);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera4(String nome,String Servico_codServico, 
          String cpf,String Celular_codPlaca ,String endereco ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE cliente SET nome = ?, Servico_codServico = ?, cpf = ? WHERE Celular_codPlaca = ? or endereco = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1,nome);
 st.setString(2, Servico_codServico);
 st.setString(3,cpf);
 st.setString(4,Celular_codPlaca);
 st.setString(5,endereco);

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
 String sql = "DELETE FROM Cliente WHERE cpf = ?";
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
 String sql = "DELETE FROM Cliente WHERE nome = ?";
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
public static int exclui3(String cpf,String nome) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Cliente WHERE cpf =? and nome = ?";
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
public static int exclui4(String Celular_codPlaca,String endereco) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Cliente WHERE Celular_codPlaca =? or endereco = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, Celular_codPlaca);
  st.setString(2, endereco);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 } 
}
