package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.Conexao.Conexao;
import com.classes.DTO.ProfessorDTO;

public class ProfessorDAO {

		final String NOMEDATABELA = "professor";
			
			public boolean inserir(ProfessorDTO professor) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "INSERT INTO " + NOMEDATABELA + " (registro, nome) VALUES (?, ?);";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, professor.getRegistro());
		            ps.setString(2, professor.getNome());
		            ps.executeUpdate();
		            ps.close();
		            conn.close();
		            return true;
		        } catch (Exception e) {
		            e.printStackTrace();
		            return false;
		        }
		    }
		    public boolean alterar(ProfessorDTO professor) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ? WHERE registro = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setString(1, professor.getNome());
		            ps.setInt(2, professor.getRegistro());
		            ps.executeUpdate();
		            ps.close();
		            conn.close();
		            return true;
		        } catch (Exception e) {
		        	 e.printStackTrace();
		             return false;
		        }
		    }
		    public boolean excluir(ProfessorDTO professor) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE registro = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, professor.getRegistro());
		            ps.executeUpdate();
		            ps.close();
		            conn.close();
		            return true;
		        } catch (Exception e) {
		        	 e.printStackTrace();
		             return false;
		        }
		    }
		    public ProfessorDTO procurarPorCodigo(ProfessorDTO professor) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE registro = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, professor.getRegistro());
		            ResultSet rs = ps.executeQuery();
		            if (rs.next()) {
		            	ProfessorDTO obj = new ProfessorDTO();
		                obj.setRegistro(rs.getInt(1));
		                obj.setNome(rs.getString(2));
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
		    public ProfessorDTO procurarPorNome(ProfessorDTO professor) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setString(1, professor.getNome());
		            ResultSet rs = ps.executeQuery();
		            if (rs.next()) {
		            	ProfessorDTO obj = new ProfessorDTO();
		                obj.setRegistro(rs.getInt(1));
		                obj.setNome(rs.getString(2));
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
		    public boolean existe(ProfessorDTO professor) {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE registro = ?;";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, professor.getRegistro());
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
		    public List<ProfessorDTO> pesquisarTodos() {
		        try {
		            Connection conn = Conexao.conectar();
		            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ResultSet rs = ps.executeQuery();
		            List<ProfessorDTO> listObj = montarLista(rs);
		            return listObj;
		        } catch (Exception e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
		    public List<ProfessorDTO> montarLista(ResultSet rs) {
		        List<ProfessorDTO> listObj = new ArrayList<ProfessorDTO>();
		        try {
		            while (rs.next()) {
		            	ProfessorDTO obj = new ProfessorDTO();
		                obj.setRegistro(rs.getInt(1));
		                obj.setNome(rs.getString(2));
		                listObj.add(obj);
		            }
		            return listObj;
		        } catch (Exception e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
}
