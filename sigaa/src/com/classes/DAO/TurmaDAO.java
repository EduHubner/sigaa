package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.Conexao.Conexao;
import com.classes.DTO.Turma;

public class TurmaDAO {

	//ARRUMAR *******************************************
		final String NOMEDATABELA = "turma";
			
			public boolean inserir(Turma turma) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "INSERT INTO " + NOMEDATABELA + " (codigoTurma, dataInicio, situacaoTurma, codigoDisciplina) VALUES (?, ?, ?, ?);";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, turma.getCodigoTurma());
		            ps.setDate(2, turma.getDataInicio());
		            ps.setString(3, turma.getSituacaoTurma());
		            ps.setInt(4, turma.getCodigoDisciplina());
		            ps.executeUpdate();
		            ps.close();
		            conn.close();
		            return true;
		        } catch (Exception e) {
		            e.printStackTrace();
		            return false;
		        }
		    }
		    public boolean alterar(Turma turma) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "UPDATE " + NOMEDATABELA + " SET situacaoTurma = ? WHERE codigoTurma = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setString(1, turma.getSituacaoTurma());
		            ps.setInt(2, turma.getCodigoTurma());
		            ps.executeUpdate();
		            ps.close();
		            conn.close();
		            return true;
		        } catch (Exception e) {
		        	 e.printStackTrace();
		             return false;
		        }
		    }
		    public boolean excluir(Turma turma) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE codigoTurma = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, turma.getCodigoTurma());
		            ps.executeUpdate();
		            ps.close();
		            conn.close();
		            return true;
		        } catch (Exception e) {
		        	 e.printStackTrace();
		             return false;
		        }
		    }
		    public Turma procurarPorCodigo(Turma turma) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE codigoTurma = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, turma.getCodigoTurma());
		            ResultSet rs = ps.executeQuery();
		            if (rs.next()) {
		            	Turma obj = new Turma();
		                obj.setCodigoTurma(rs.getInt(1));
		                obj.setDataInicio(rs.getDate(2));
		                obj.setSituacaoTurma(rs.getString(3));		    
		                obj.setCodigoDisciplina(rs.getInt(4));
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
		    public Turma procurarPorSituacao(Turma turma) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE situacaoTurma = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setString(1, turma.getNome());
		            ResultSet rs = ps.executeQuery();
		            if (rs.next()) {
		            	Turma obj = new Turma();
		            	obj.setCodigoTurma(rs.getInt(1));
		                obj.setDataInicio(rs.getDate(2));
		                obj.setSituacaoTurma(rs.getString(3));		    
		                obj.setCodigoDisciplina(rs.getInt(4));
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
		    public boolean existe(Turma turma) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE codigoTurma = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, turma.getCodigoTurma());
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
		    public List<Turma> pesquisarTodos() {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ResultSet rs = ps.executeQuery();
		            List<Turma> listObj = montarLista(rs);
		            return listObj;
		        } catch (Exception e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
		    public List<Turma> montarLista(ResultSet rs) {
		        List<Turma> listObj = new ArrayList<Turma>();
		        try {
		            while (rs.next()) {
		            	Turma obj = new Turma();
		            	obj.setCodigoTurma(rs.getInt(1));
		                obj.setDataInicio(rs.getDate(2));
		                obj.setSituacaoTurma(rs.getString(3));		    
		                obj.setCodigoDisciplina(rs.getInt(4));
		                listObj.add(obj);
		            }
		            return listObj;
		        } catch (Exception e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
}
