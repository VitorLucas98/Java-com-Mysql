
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Tecnico;

public class TecnicoDAO {
private static Connection connection;
private static PreparedStatement st;
private static ResultSet rs;

public static List<Tecnico> leTodos() throws Exception{
List<Tecnico> listTecnico = new ArrayList<Tecnico>();
try {
String sql = "SELECT * FROM tecnico";
connection = GerenteDeConexao.getConnection();
st = connection.prepareStatement(sql);
rs = st.executeQuery();
while (rs.next()) {
 Tecnico tec = new Tecnico();
 tec.setCpf(rs.getString("cpf"));
 tec.setNome(rs.getString("nome"));
 tec.setSalLiquido(rs.getDouble("salLiquido"));
 tec.setEquipamento(rs.getString("equipamento"));
 tec.setPeca(PecaDAO.leUm1(rs.getInt("Peca_numeracao")));
 listTecnico.add(tec);
 }
st.close();
} catch (Exception e) {
 System.out.println(e.getMessage());
 }
 return listTecnico;
 }

public static Tecnico leUm1(String cpf) throws Exception {
 Tecnico tec = new Tecnico();
 try {
 String sql = "SELECT * FROM tecnico WHERE cpf = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, cpf);
 rs = st.executeQuery();
 if (rs.next()) {
 tec.setCpf(rs.getString("cpf"));
 tec.setNome(rs.getString("nome"));
 tec.setSalLiquido(rs.getDouble("salLiquido"));
 tec.setEquipamento(rs.getString("equipamento"));
 tec.setPeca(PecaDAO.leUm1(rs.getInt("Peca_numeracao")));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return tec;
 }
public static Tecnico leUm2(String nome) throws Exception {
 Tecnico tec = new Tecnico();
 try {
 String sql = "SELECT * FROM tecnico WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 rs = st.executeQuery();
 if (rs.next()) {
tec.setNome(rs.getString("nome")); 
tec.setCpf(rs.getString("cpf"));
tec.setSalLiquido(rs.getDouble("salLiquido"));
tec.setEquipamento(rs.getString("equipamento"));
tec.setPeca(PecaDAO.leUm1(rs.getInt("Peca_numeracao")));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return tec;
 }
public static Tecnico leUm3(String cpf,String nome) throws Exception {
 Tecnico tec = new Tecnico();
 try {
 String sql = "SELECT * FROM tecnico WHERE cpf = ? AND nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, cpf);
  st.setString(2, nome);
 rs = st.executeQuery();
 if (rs.next()) {
tec.setCpf(rs.getString("cpf"));
tec.setNome(rs.getString("nome")); 
tec.setSalLiquido(rs.getDouble("salLiquido"));
tec.setEquipamento(rs.getString("equipamento"));
tec.setPeca(PecaDAO.leUm1(rs.getInt("Peca_numeracao")));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return tec;
 }
public static List<Tecnico>  leUm4(Double salLiquido,String equipamento) throws Exception {
 List<Tecnico> listTecnico = new ArrayList<Tecnico>();
 try {
 String sql = "SELECT * FROM Tecnico WHERE salLiquido = ? OR equipamento = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setDouble(1, salLiquido);
 st.setString(2, equipamento);
 rs = st.executeQuery();
 while (rs.next()) {
 Tecnico tec = new Tecnico();
tec.setSalLiquido(rs.getDouble("salLiquido"));
tec.setEquipamento(rs.getString("equipamento"));
tec.setCpf(rs.getString("cpf"));
tec.setNome(rs.getString("nome")); 
tec.setPeca(PecaDAO.leUm1(rs.getInt("Peca_numeracao")));

 listTecnico.add(tec);
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return listTecnico;
 }
public static int grava(Tecnico tecnico) throws Exception {
 int ret = 0;
 try {
 String sql = "INSERT INTO tecnico (cpf,nome,salLiquido,equipamento,Peca_numeracao) VALUES (?, ?, ?, ?, ?)";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, tecnico.getCpf());
 st.setString(2, tecnico.getNome());
 st.setDouble(3, tecnico.getSalLiquido());
  st.setString(4, tecnico.getEquipamento());
 st.setInt(5, tecnico.getPeca().getNumeracao());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera1(Tecnico tecnico) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE Tecnico SET nome = ?, salLiquido = ?, equipamento = ?, Peca_numeracao = ? WHERE cpf = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, tecnico.getNome());
 st.setDouble(2,tecnico.getSalLiquido());
  st.setString(3, tecnico.getEquipamento());
 st.setInt(4, tecnico.getPeca().getNumeracao());
 st.setString(5, tecnico.getCpf());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera2(String cpf,Double salLiquido, 
         String equipamento, int peca_numeracao,String nome ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE tecnico SET cpf = ?, salLiquido = ?, equipamento = ?, Peca_numeracao = ?  WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
  st.setString(1,cpf);
 st.setDouble(2, salLiquido);
 st.setString(3,equipamento);
 st.setInt(4,peca_numeracao);
 st.setString(5,nome);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
/*public static int altera2(Tecnico tecnico) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE Tecnico SET cpf = ?, salLiquido = ?, equipamento = ?, Peca_numeracao = ? WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, tecnico.getCpf());
 st.setDouble(2,tecnico.getSalLiquido());
 st.setString(3, tecnico.getEquipamento());
 st.setInt(4, tecnico.getPeca().getNumeracao());
 st.setString(5, tecnico.getNome());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }*/
 public static int altera3(String nome,Double salLiquido, 
         String equipamento,String cpf, int peca_numeracao ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE tecnico SET nome = ?, salLiquido = ?, equipamento = ? WHERE cpf = ? and Peca_numeracao = ?   ";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1,nome);
 st.setDouble(2, salLiquido);
 st.setString(3,equipamento);
 st.setString(4,cpf);
 st.setInt(5,peca_numeracao);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
  public static int altera4(String nome,Double salLiquido, 
          int peca_numeracao,String cpf ,String equipamento ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE tecnico SET nome = ?, salLiquido = ?, peca_numeracao = ? WHERE cpf = ? or equipamento = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1,nome);
 st.setDouble(2, salLiquido);
 st.setInt(3,peca_numeracao);
 st.setString(4,cpf);
 st.setString(5,equipamento);

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
 String sql = "DELETE FROM Tecnico WHERE cpf = ?";
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
 String sql = "DELETE FROM Tecnico WHERE nome = ?";
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
 String sql = "DELETE FROM Tecnico WHERE cpf =? and nome = ?";
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
public static int exclui4(int peca_numeracao,String equipamento) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM Tecnico WHERE peca_numeracao =? or equipamento = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, peca_numeracao);
  st.setString(2, equipamento);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 } 
}
