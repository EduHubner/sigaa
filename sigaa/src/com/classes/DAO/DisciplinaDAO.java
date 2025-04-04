	package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.Conexao.Conexao;
import com.classes.DTO.Disciplina;

public class DisciplinaDAO {

	//ARRUMAR *******************************************
		final String NOMEDATABELA = "disciplina";
			
			public boolean inserir(Disciplina Disciplina) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "INSERT INTO " + NOMEDATABELA + " (codigoDisciplina, nome, cargaHoraria, codigoFase) VALUES (?, ?, ?, ?);";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, Disciplina.getCodigoDisciplina());
		            ps.setString(2, Disciplina.getNome());
		            ps.setInt(3, Disciplina.getCargaHoraria());
		            ps.setInt(4, Disciplina.getFase().getCodigoFase());
		            ps.executeUpdate();
		            ps.close();
		            conn.close();
		            return true;
		        } catch (Exception e) {
		            e.printStackTrace();
		            return false;
		        }
		    }
		    public boolean alterar(Disciplina Disciplina) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ? WHERE codigoDisciplina = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setString(1, Disciplina.getNome());
		            ps.setInt(2, Disciplina.getCodigoDisciplina());
		            ps.executeUpdate();
		            ps.close();
		            conn.close();
		            return true;
		        } catch (Exception e) {
		        	 e.printStackTrace();
		             return false;
		        }
		    }
		    public boolean excluir(Disciplina Disciplina) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE codigoDisciplina = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, Disciplina.getCodigoDisciplina());
		            ps.executeUpdate();
		            ps.close();
		            conn.close();
		            return true;
		        } catch (Exception e) {
		        	 e.printStackTrace();
		             return false;
		        }
		    }
		    public Disciplina procurarPorCodigo(Disciplina Disciplina) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE codigoDisciplina = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, Disciplina.getCodigoDisciplina());
		            ResultSet rs = ps.executeQuery();
		            if (rs.next()) {
		            	Disciplina obj = new Disciplina();
		                obj.setCodigoDisciplina(rs.getInt(1));
		                obj.setNome(rs.getString(2));
		                obj.setCargaHoraria(rs.getInt(3));
		                obj.getFase().setCodigoFase(rs.getInt(4));
		                ps.close();
		                rs.close();
		                conn.close();
		                return obj;
		            } else {
		                ps.close();
		                rs.close();
		                conn.close();
		                return null;
		            }
		        } catch (Exception e) {
		        	 e.printStackTrace();
		             return null;
		        }
		    }
		    public Disciplina procurarPorNome(Disciplina Disciplina) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setString(1, Disciplina.getNome());
		            ResultSet rs = ps.executeQuery();
		            if (rs.next()) {
		            	Disciplina obj = new Disciplina();
		            	obj.setCodigoDisciplina(rs.getInt(1));
		                obj.setNome(rs.getString(2));
		                obj.setCargaHoraria(rs.getInt(3));
		                obj.getFase().setCodigoFase(rs.getInt(4));
		                ps.close();
		                rs.close();
		                conn.close();
		                return obj;
		            } else {
		                ps.close();
		                rs.close();
		                conn.close();
		                return null;
		            }
		        } catch (Exception e) {
		            return null;
		        }
		    }
		    public boolean existe(Disciplina Disciplina) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setString(1, Disciplina.getNome());
		            ResultSet rs = ps.executeQuery();
		            if (rs.next()) {
		                ps.close();
		                rs.close();
		                conn.close();
		                return true;
		            }
		        } catch (Exception e) {
		           e.printStackTrace();
		            return false;
		        }
		        return false;
		    }
		    public List<Disciplina> pesquisarTodos() {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ResultSet rs = ps.executeQuery();
		            List<Disciplina> listObj = montarLista(rs);
		            return listObj;
		        } catch (Exception e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
		    public List<Disciplina> montarLista(ResultSet rs) {
		        List<Disciplina> listObj = new ArrayList<Disciplina>();
		        try {
		            while (rs.next()) {
		            	Disciplina obj = new Disciplina();
		            	obj.setCodigoDisciplina(rs.getInt(1));
		                obj.setNome(rs.getString(2));
		                obj.setCargaHoraria(rs.getInt(3));
		                obj.getFase().setCodigoFase(rs.getInt(4));
		                listObj.add(obj);
		            }
		            return listObj;
		        } catch (Exception e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
}
