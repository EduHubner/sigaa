package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.Conexao.Conexao;
import com.classes.DTO.Aula;

public class AulaDAO {
	
	final String NOMEDATABELA = "aula";
		
		public boolean inserir(Aula aula) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "INSERT INTO " + NOMEDATABELA + " (codigoAula, dataAula, cargaHoraria, codigoTurma, registro) VALUES (?, ?, ?, ?, ?);";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, aula.getCodigoAula());
	            ps.setDate(2, aula.getData());
	            ps.setInt(3, aula.getCargaHoraria());
	            ps.setInt(4, aula.getTurmaAula().getCodigoTurma());
	            ps.setInt(5, aula.getProfessorMinistrou().getRegistro());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    public boolean alterar(Aula aula) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "UPDATE " + NOMEDATABELA + " SET cargaHoraria = ? WHERE codigoAula = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, aula.getCargaHoraria());
	            ps.setInt(2, aula.getCodigoAula());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	    public boolean excluir(Aula aula) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE codigoAula = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, aula.getCodigoAula());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	    public Aula procurarPorCodigo(Aula aula) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE codigoAula = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, aula.getCodigoAula());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	Aula obj = new Aula();
	                obj.setCodigoAula(rs.getInt(1));
	                obj.setData(rs.getDate(2));
	                obj.setCargaHoraria(rs.getInt(3));
	                obj.getTurmaAula().setCodigoTurma(rs.getInt(4));
	                obj.getProfessorMinistrou().setRegistro(rs.getInt(5));
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
	    public Aula procurarPorProfessor(Aula aula) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE registro = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, aula.getProfessorMinistrou().getRegistro());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	Aula obj = new Aula();
	            	obj.setCodigoAula(rs.getInt(1));
	                obj.setData(rs.getDate(2));
	                obj.setCargaHoraria(rs.getInt(3));
	                obj.getTurmaAula().setCodigoTurma(rs.getInt(4));
	                obj.getProfessorMinistrou().setRegistro(rs.getInt(5));
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
	    public boolean existe(Aula aula) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE codigoAula = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, aula.getCodigoAula());
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
	    public List<Aula> pesquisarTodos() {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            List<Aula> listObj = montarLista(rs);
	            return listObj;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    public List<Aula> montarLista(ResultSet rs) {
	        List<Aula> listObj = new ArrayList<Aula>();
	        try {
	            while (rs.next()) {
	            	Aula obj = new Aula();
	            	obj.setCodigoAula(rs.getInt(1));
	                obj.setData(rs.getDate(2));
	                obj.setCargaHoraria(rs.getInt(3));
	                obj.getTurmaAula().setCodigoTurma(rs.getInt(4));
	                obj.getProfessorMinistrou().setRegistro(rs.getInt(5));
	                listObj.add(obj);
	            }
	            return listObj;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
}
