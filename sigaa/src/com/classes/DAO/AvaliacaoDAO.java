package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.Conexao.Conexao;
import com.classes.DTO.Avaliacao;

public class AvaliacaoDAO {


		final String NOMEDATABELA = "avaliacao";
			
		public boolean inserir(Avaliacao avaliacao) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "INSERT INTO " + NOMEDATABELA + " (codigoAvaliacao, dataAvaliacao, codigoTurma, registro) VALUES (?, ?, ?, ?);";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, avaliacao.getCodigoAvaliacao());
	            ps.setDate(2, avaliacao.getData());
	            ps.setInt(3, avaliacao.getTurmaAvaliacao().getCodigoTurma());
	            ps.setInt(4, avaliacao.getProfessorMinistrou().getRegistro());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    public boolean alterar(Avaliacao avaliacao) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "UPDATE " + NOMEDATABELA + " SET dataAvaliacao = ? WHERE codigoAvaliacao = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setDate(1, avaliacao.getData());
	            ps.setInt(2, avaliacao.getCodigoAvaliacao());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	    public boolean excluir(Avaliacao avaliacao) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE codigoAvaliacao = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, avaliacao.getCodigoAvaliacao());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	    public Avaliacao procurarPorCodigo(Avaliacao avaliacao) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE codigoAvaliacao = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, avaliacao.getCodigoAvaliacao());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	Avaliacao obj = new Avaliacao();
	                obj.setCodigoAvaliacao(rs.getInt(1));
	                obj.setData(rs.getDate(2));
	                obj.getTurmaAvaliacao().setCodigoTurma(rs.getInt(3));
	                obj.getProfessorMinistrou().setRegistro(rs.getInt(4));
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
	    public Avaliacao procurarPorProfessor(Avaliacao avaliacao) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE registro = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, avaliacao.getProfessorMinistrou().getRegistro());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	Avaliacao obj = new Avaliacao();
	            	obj.setCodigoAvaliacao(rs.getInt(1));
	                obj.setData(rs.getDate(2));
	                obj.getTurmaAvaliacao().setCodigoTurma(rs.getInt(3));
	                obj.getProfessorMinistrou().setRegistro(rs.getInt(4));
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
	    public boolean existe(Avaliacao avaliacao) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE codigoAvaliacao = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, avaliacao.getCodigoAvaliacao());
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
	    public List<Avaliacao> pesquisarTodos() {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            List<Avaliacao> listObj = montarLista(rs);
	            return listObj;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    public List<Avaliacao> montarLista(ResultSet rs) {
	        List<Avaliacao> listObj = new ArrayList<Avaliacao>();
	        try {
	            while (rs.next()) {
	            	Avaliacao obj = new Avaliacao();
	            	obj.setCodigoAvaliacao(rs.getInt(1));
	                obj.setData(rs.getDate(2));
	                obj.getTurmaAvaliacao().setCodigoTurma(rs.getInt(3));
	                obj.getProfessorMinistrou().setRegistro(rs.getInt(4));
	                listObj.add(obj);
	            }
	            return listObj;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
}
