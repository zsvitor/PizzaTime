package Dados;

import java.sql.*;

public class AppDao {

    Connection conectado;
    PreparedStatement st;
    ResultSet resultado;
    int retorno;

    private void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzaria", "root", "1234");
    }

    /*LOGIN*/
    public ResultSet login(String n, String s) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM funcionario WHERE nome_funcionario = ? AND senha_funcionario = ?");
        st.setString(1, n);
        st.setString(2, s);
        resultado = st.executeQuery();
        return resultado;
    }

    /*CADASTRAR*/
    public void salvarFuncionario(String n, String s, String cpf, String car, String cel) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("INSERT INTO funcionario(nome_funcionario, senha_funcionario, cpf_funcionario, cargo_funcionario, celular_funcionario) values(?, ?, ?, ?, ?)");
        st.setString(1, n);
        st.setString(2, s);
        st.setString(3, cpf);
        st.setString(4, car);
        st.setString(5, cel);
        st.executeUpdate();
    }

    public void salvarCliente(String n, String s, String cpf, String cel, String cep) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("INSERT INTO cliente(nome_cliente, sobrenome_cliente, cpf_cliente, celular_cliente, cep_cliente) values(?, ?, ?, ?, ?)");
        st.setString(1, n);
        st.setString(2, s);
        st.setString(3, cpf);
        st.setString(4, cel);
        st.setString(5, cep);
        st.executeUpdate();
    }

    public void salvarPizza(String n, String d, String p, String t) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("INSERT INTO pizza(nome_pizza, desc_pizza, preco_pizza, tipo_pizza) values(?, ?, ?, ?)");
        st.setString(1, n);
        st.setString(2, d);
        st.setString(3, p);
        st.setString(4, t);
        st.executeUpdate();
    }

    public void salvarBebida(String n, String p, String t) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("INSERT INTO bebida(nome_bebida, preco_bebida, tipo_bebida) values(?, ?, ?)");
        st.setString(1, n);
        st.setString(2, p);
        st.setString(3, t);
        st.executeUpdate();
    }

    /*ALTERAR*/
    public ResultSet alterarBebidaMenu(String n) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM bebida WHERE nome_bebida = ?");
        st.setString(1, n);
        resultado = st.executeQuery();
        return resultado;
    }

    public void alterarBebida(String nom, String pre, String tip) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE bebida SET nome_bebida = ?, preco_bebida = ?, tipo_bebida = ? WHERE nome_bebida = ?");
        st.setString(1, nom);
        st.setString(2, pre);
        st.setString(3, tip);
        st.setString(4, nom);
        st.executeUpdate();
    }

    public ResultSet alterarPizzaMenu(String n) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM pizza WHERE nome_pizza = ?");
        st.setString(1, n);
        resultado = st.executeQuery();
        return resultado;
    }

    public void alterarPizza(String nom, String des, String pre, String tip) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE pizza SET nome_pizza = ?, desc_pizza = ?, preco_pizza = ?, tipo_pizza = ? WHERE nome_pizza = ?");
        st.setString(1, nom);
        st.setString(2, des);
        st.setString(3, pre);
        st.setString(4, tip);
        st.setString(5, nom);
        st.executeUpdate();
    }

    public ResultSet alterarClienteMenu(String n) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM cliente WHERE nome_cliente = ?");
        st.setString(1, n);
        resultado = st.executeQuery();
        return resultado;
    }

    public void alterarCliente(String sob, String cpf, String cel, String cep, String nom) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE cliente SET sobrenome_cliente = ?, cpf_cliente = ?, celular_cliente = ?, cep_cliente = ? WHERE nome_cliente = ?");
        st.setString(1, sob);
        st.setString(2, cpf);
        st.setString(3, cel);
        st.setString(4, cep);
        st.setString(5, nom);
        st.executeUpdate();
    }

    public ResultSet alterarFuncionarioMenu(String n) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM funcionario WHERE nome_funcionario = ?");
        st.setString(1, n);
        resultado = st.executeQuery();
        return resultado;
    }

    public void alterarFuncionario(String sen, String cpf, String car, String cel, String nom) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE funcionario SET senha_funcionario = ?, cpf_funcionario = ?, cargo_funcionario = ?, celular_funcionario = ? WHERE nome_funcionario = ?");
        st.setString(1, sen);
        st.setString(2, cpf);
        st.setString(3, car);
        st.setString(4, cel);
        st.setString(5, nom);
        st.executeUpdate();
    }

    /*EXCLUIR*/
    public int excluirFuncionario(String n) throws ClassNotFoundException, SQLException {
        conectar();
        PreparedStatement st = conectado.prepareStatement("DELETE FROM funcionario WHERE nome_funcionario = ?");
        st.setString(1, n);
        retorno = st.executeUpdate();
        return retorno;
    }

    public int excluirCliente(String n) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("DELETE FROM cliente WHERE nome_cliente = ?");
        st.setString(1, n);
        retorno = st.executeUpdate();
        return retorno;
    }

    public int excluirPizza(String n) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("DELETE FROM pizza WHERE nome_pizza = ?");
        st.setString(1, n);
        retorno = st.executeUpdate();
        return retorno;
    }

    public int excluirBebida(String n) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("DELETE FROM bebida WHERE nome_bebida = ?");
        st.setString(1, n);
        retorno = st.executeUpdate();
        return retorno;
    }

    /*LISTAR*/
    public ResultSet listarPizza() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM pizza");
        resultado = st.executeQuery();
        return resultado;
    }

    public ResultSet buscaPizza(String t) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM pizza WHERE tipo_pizza = ?");
        st.setString(1, t);
        resultado = st.executeQuery();
        return resultado;
    }
    
    public ResultSet listarFuncionario() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM funcionario");
        resultado = st.executeQuery();
        return resultado;
    }
    
    public ResultSet buscaFuncionario(String n) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM funcionario WHERE nome_funcionario = ?");
        st.setString(1, n);
        resultado = st.executeQuery();
        return resultado;
    }
    
    public ResultSet listarCliente() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM cliente");
        resultado = st.executeQuery();
        return resultado;
    }
    
    public ResultSet buscaCliente(String n) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM cliente WHERE nome_cliente = ?");
        st.setString(1, n);
        resultado = st.executeQuery();
        return resultado;
    }
    
    public ResultSet listarBebida() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM bebida");
        resultado = st.executeQuery();
        return resultado;
    }
    
    public ResultSet buscaBebida(String t) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM bebida WHERE tipo_bebida = ?");
        st.setString(1, t);
        resultado = st.executeQuery();
        return resultado;
    }

}
