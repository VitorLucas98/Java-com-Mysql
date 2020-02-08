
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Acessorio;

public class AcessorioDAO {
        private static Connection connection;
private static PreparedStatement st;
private static ResultSet rs;

public static List<Acessorio> leTodos() throws Exception{
List<Acessorio> listAcessorio = new ArrayList<Acessorio>();
try {
String sql = "SELECT * FROM acessorio";
connection = GerenteDeConexao.getConnection();
st = connection.prepareStatement(sql);
rs = st.executeQuery();
while (rs.next()) {
 Acessorio ac = new Acessorio();
 ac.setCodBarra(rs.getString("codBarra"));
 ac.setDescricao(rs.getString("descricao"));
 listAcessorio.add(ac);
 }
st.close();
} catch (Exception e) {
 System.out.println(e.getMessage());
 }
 return listAcessorio;
 }

public static Acessorio leUm1(String codBarra) throws Exception {
 Acessorio acessorio = new Acessorio();
 try {
 String sql = "SELECT * FROM acessorio WHERE codBarra = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, codBarra);
 rs = st.executeQuery();
 if (rs.next()) {
 acessorio.setCodBarra(rs.getString("codBarra"));
 acessorio.setDescricao(rs.getString("descricao"));
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return acessorio;
 }
public static Acessorio leUm2(String descricao) throws Exception {
 Acessorio acessorio = new Acessorio();
 try {
 String sql = "SELECT * FROM acessorio WHERE descricao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, descricao);
 rs = st.executeQuery();
 if (rs.next()) {
 acessorio.setDescricao(rs.getString("descricao"));
 acessorio.setCodBarra(rs.getString("codBarra")); 
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return acessorio;
 }
public static Acessorio leUm3(String codBarra,String descricao) throws Exception {
 Acessorio ac = new Acessorio();
 try {
 String sql = "SELECT * FROM acessorio WHERE codBarra = ? AND descricao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, codBarra);
 st.setString(2, descricao);
 rs = st.executeQuery();
 if (rs.next()) {
 ac.setCodBarra(rs.getString("codBarra"));
 ac.setDescricao(rs.getString("descricao"));
 
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ac;
 }
public static List<Acessorio>  leUm4(String codBarra,String descricao) throws Exception {
 List<Acessorio> listAcessorio = new ArrayList<Acessorio>();
 try {
 String sql = "SELECT * FROM acessorio WHERE codBarra = ? OR descricao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, codBarra);
 st.setString(2, descricao);
 rs = st.executeQuery();
 while (rs.next()) {
 Acessorio ac = new Acessorio();
 ac.setCodBarra(rs.getString("codBarra"));
 ac.setDescricao(rs.getString("descricao"));
 listAcessorio.add(ac);
 }
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return listAcessorio;
 }

public static int grava(Acessorio acessorio) throws Exception {
 int ret = 0;
 try {
 String sql = "INSERT INTO acessorio (codBarra,descricao) VALUES (?, ?)";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, acessorio.getCodBarra());
 st.setString(2, acessorio.getDescricao());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera1(String descricao,String codBarra) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE acessorio SET descricao = ? WHERE codBarra = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1,descricao);
  st.setString(2,codBarra);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera2(String codBarra,String descricao ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE acessorio SET codBarra = ?  WHERE descricao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, codBarra);
 st.setString(2,descricao);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera3(String descricao1,String codBarra, String descricao ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE acessorio SET descricao = ? WHERE codBarra = ? AND descricao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, descricao1);
 st.setString(2, codBarra);
 st.setString(3,descricao);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera4(String descricao1, String codBarra,String descricao ) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE acessorio SET descricao = ? WHERE codBarra = ? OR descricao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1,descricao1);
 st.setString(2,codBarra);
 st.setString(3,descricao);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

public static int exclui1(String codBarra) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM acessorio WHERE codBarra = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, codBarra);
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
 String sql = "DELETE FROM acessorio WHERE descricao = ?";
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
public static int exclui3(String codBarra,String descricao) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM acessorio WHERE codBarra = ? AND descricao = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, codBarra);
 st.setString(2, descricao);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int exclui4(String descricao,String codBarra) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM acessorio WHERE descricao = ? OR codBarra = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, descricao);
 st.setString(2, codBarra);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
}
