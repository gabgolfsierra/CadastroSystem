package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbcadastro?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "megasenha2002";

	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void inserirAtleta(JavaBeans atleta) {
		String create = "insert into atletas (nome,categoria,total) values (?,?,?)";
		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, atleta.getNome());
			pst.setString(2, atleta.getCategoria());
			pst.setString(3, atleta.getTotal());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<JavaBeans> listarAtletas() {
		ArrayList<JavaBeans> atletas = new ArrayList<>();
		String read = "select * from atletas order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String categoria = rs.getString(3);
				String total = rs.getString(4);
				atletas.add(new JavaBeans(idcon, nome, categoria, total));
			}
			con.close();
			return atletas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
	
	public void selecionarAtleta(JavaBeans atleta) {
		String read2 = "select * from atletas where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, atleta.getIdcon());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				atleta.setIdcon(rs.getString(1));
				atleta.setNome(rs.getString(2));
				atleta.setCategoria(rs.getString(3));
				atleta.setTotal(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void alterarAtleta(JavaBeans atleta) {
		String create = "update atletas set nome=?,categoria=?,total=? where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, atleta.getNome());
			pst.setString(2, atleta.getCategoria());
			pst.setString(3, atleta.getTotal());
			pst.setString(4, atleta.getIdcon());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deletarAtleta(JavaBeans atleta) {
		
		String delete = "delete from atletas where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, atleta.getIdcon());
			System.out.println(atleta.getIdcon());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
