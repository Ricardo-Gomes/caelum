package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDao {
	
	private Connection connection;
	
	public FuncionarioDao(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Funcionario funcionario){
		String sql = "insert into funcionarios (nome,usuario,senha) values(?,?,?)";
		try {
			//prepared statement para inser��o
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//seta os valores
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			
			//executa
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Funcionario> getLista(){
		try {
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			PreparedStatement stmt = this.connection.prepareStatement("Select * from funcionarios");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				//criando o objeto Funcionario
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
				
				//adicionando o objeto � lista
				funcionarios.add(funcionario);
			}
			rs.close();
			stmt.close();
			return funcionarios;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Funcionario funcionario){
		String sql = "update funcionarios set nome=?, usuario=?, senha=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Funcionario funcionario){
		
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from funcionarios where id=?");
			
			stmt.setLong(1, funcionario.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
