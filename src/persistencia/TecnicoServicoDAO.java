
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Servico;
import modelo.Tecnico;

public class TecnicoServicoDAO {
private static Connection connection;
private static PreparedStatement st;
private static ResultSet rs;

public static List<Servico> leTodosPorTecnico(String cpf) throws Exception{
List<Servico> listServico = new ArrayList<Servico>();
try {
String sql = "SELECT * FROM servico s INNER JOIN " +
"tecnico_servico ts ON s.codServico = ts.servico_codServico " +
"WHERE ts.tecnico_cpf = ?";
connection = GerenteDeConexao.getConnection();
st = connection.prepareStatement(sql);
st.setString(1, cpf);
rs = st.executeQuery();
while (rs.next()) {
Servico ser = new Servico();
ser.setCodServico(rs.getString("codServico"));
ser.setPreco(rs.getDouble("preco"));
ser.setData(rs.getString("data"));
ser.setAtendente(AtendenteDAO.leUm1(rs.getString("Atendente_cpf")));
listServico.add(ser);
}
st.close();
} catch (Exception e) {
System.out.println(e.getMessage());
}
return listServico;
}
public static List<Tecnico> leTodosPorServico(String codServico) throws Exception{
List<Tecnico> listTecnico = new ArrayList<Tecnico>();
try {
String sql = "SELECT * FROM tecnico t INNER JOIN " +
"tecnico_servico ts ON t.cpf = ts.tecnico_cpf " +
"WHERE ts.servico_codServico = ?";
connection = GerenteDeConexao.getConnection();
st = connection.prepareStatement(sql);
st.setString(1, codServico);
rs = st.executeQuery();
while (rs.next()) {
Tecnico te = new Tecnico();
te.setCpf(rs.getString("cpf"));
te.setNome(rs.getString("nome"));
te.setSalLiquido(rs.getDouble("salLiquido"));
te.setEquipamento(rs.getString("equipamento"));
te.setPeca(PecaDAO.leUm1(rs.getInt("Peca_numeracao")));
listTecnico.add(te);
}
st.close();
} catch (Exception e) {
System.out.println(e.getMessage());
}
return listTecnico;
}
public static int grava(String cpf,String codServico) throws Exception {
int ret = 0;
try {
String sql = "INSERT INTO Tecnico_Servico (Tecnico_cpf,Servico_codServico) VALUES ( ?, ?)";
connection = GerenteDeConexao.getConnection();
st = connection.prepareStatement(sql);
st.setString(1, cpf);
st.setString(2, codServico);
ret = st.executeUpdate();
st.close();
} catch (SQLException e) {
System.out.println(e.getMessage());
}
return ret;
}
public static int alteraPorTecnico(String novoServico,String cpf,String
codServico) throws Exception {
int ret = 0;
try {
String sql = "UPDATE tecnico_servico set servico_codServico = ?" +
"WHERE tecnico_cpf = ? and servico_codServico = ?";
connection = GerenteDeConexao.getConnection();
st = connection.prepareStatement(sql);
st.setString(1, novoServico);
st.setString(2, cpf);
st.setString(3, codServico);
ret = st.executeUpdate();
st.close();
} catch (SQLException e) {
System.out.println(e.getMessage());
}
return ret;
}
public static int alteraPorServico(String novoCpf,String novoServico,String cpf,String
codServico) throws Exception {
int ret = 0;
try {
String sql = "UPDATE tecnico_servico set tecnico_cpf = ?, servico_codservico = ? " +
"WHERE tecnico_cpf = ? and servico_codServico = ?";
connection = GerenteDeConexao.getConnection();
st = connection.prepareStatement(sql);
st.setString(1, novoCpf);
st.setString(2,novoServico);
st.setString(3, cpf);
st.setString(4, codServico);
ret = st.executeUpdate();
st.close();
} catch (SQLException e) {
System.out.println(e.getMessage());
}
return ret;
}

public static int excluiPorTecnico(String cpf) throws Exception {
int ret = 0;
try {
String sql = "DELETE FROM tecnico_servico WHERE Tecnico_cpf = ?";
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
public static int excluiPorServico(String codServico) throws Exception {
int ret = 0;
try {
String sql = "DELETE FROM tecnico_servico WHERE servico_codServico = ?";
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

public static int excluiPorTecnicoServico(String cpf,String codServico) throws Exception {
int ret = 0;
try {
String sql = "DELETE FROM tecnico_servico WHERE tecnico_cpf =?  AND servico_codServico = ?";
connection = GerenteDeConexao.getConnection();
st = connection.prepareStatement(sql);
st.setString(1, cpf);
st.setString(2, codServico);
ret = st.executeUpdate();
st.close();
} catch (SQLException e) {
System.out.println(e.getMessage());
}
return ret;
}
}