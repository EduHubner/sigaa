package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.Conexao.Conexao;
import com.classes.DTO.Fase;

public class FaseDAO {

	//ARRUMAR *******************************************
		final String NOMEDATABELA = "fase";
			
			public boolean inserir(Fase fase) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "INSERT INTO " + NOMEDATABELA + " (codigoFase, ano, semestre, codigoCurso) VALUES (?, ?, ?, ?);";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, fase.getCodigoFase());
		            ps.setInt(2, fase.getAno());
		            ps.setInt(3, fase.getSemestre());
		            ps.setInt(4, fase.getCurso().getCodigoCurso());
		            ps.executeUpdate();
		            ps.close();
		            conn.close();
		            return true;
		        } catch (Exception e) {
		            e.printStackTrace();
		            return false;
		        }
		    }
		    public boolean alterar(Fase fase) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "UPDATE " + NOMEDATABELA + " SET semestre = ? WHERE codigoFase = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, fase.getSemestre());
		            ps.setInt(2, fase.getCodigoFase());
		            ps.executeUpdate();
		            ps.close();
		            conn.close();
		            return true;
		        } catch (Exception e) {
		        	 e.printStackTrace();
		             return false;
		        }
		    }
		    public boolean excluir(Fase fase) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE codigoFase = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, fase.getCodigoFase());
		            ps.executeUpdate();
		            ps.close();
		            conn.close();
		            return true;
		        } catch (Exception e) {
		        	 e.printStackTrace();
		             return false;
		        }
		    }
		    public Fase procurarPorCodigo(Fase fase) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE codigoFase = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, fase.getCodigoFase());
		            ResultSet rs = ps.executeQuery();
		            if (rs.next()) {
		            	Fase obj = new Fase();
		                obj.setCodigoFase(rs.getInt(1));
		                obj.setAno(rs.getInt(2));
		                obj.setSemestre(rs.getInt(3));
		                obj.getCurso().setNome(rs.getString(4));;
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
		    public Fase procurarPorAno(Fase fase) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE ano = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, fase.getAno());
		            ResultSet rs = ps.executeQuery();
		            if (rs.next()) {
		            	Fase obj = new Fase();
		            	obj.setCodigoFase(rs.getInt(1));
		                obj.setAno(rs.getInt(2));
		                obj.setSemestre(rs.getInt(3));
		                obj.getCurso().setNome(rs.getString(4));;
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
		    public boolean existe(Fase fase) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE codigoFase = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, fase.getCodigoFase());
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
		    public List<Fase> pesquisarTodos() {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ResultSet rs = ps.executeQuery();
		            List<Fase> listObj = montarLista(rs);
		            return listObj;
		        } catch (Exception e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
		    public List<Fase> montarLista(ResultSet rs) {
		        List<Fase> listObj = new ArrayList<Fase>();
		        try {
		            while (rs.next()) {
		            	Fase obj = new Fase();
		            	obj.setCodigoFase(rs.getInt(1));
		                obj.setAno(rs.getInt(2));
		                obj.setSemestre(rs.getInt(3));
		                obj.getCurso().setNome(rs.getString(4));;
		                listObj.add(obj);
		            }
		            return listObj;
		        } catch (Exception e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
}
