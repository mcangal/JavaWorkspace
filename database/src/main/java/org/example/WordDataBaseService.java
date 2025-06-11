package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WordDataBaseService {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD ="";

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
    }

    public boolean addWord(String word){
        String sql = "INSERT INTO cangal.note(id, notes) VALUES(?, ?)";
        try(Connection conn =getConnection();
        PreparedStatement pstmt =conn.prepareStatement(sql)){
            pstmt.setInt(1,1);
            pstmt.setString(2, word);
            pstmt.executeUpdate();
            return true;
        }catch (SQLException e){
            System.err.println("Kelime eklenirken hata oluştu:"+e.getMessage());
            return false;
        }
    }
    public boolean deleteWord(int id){
        String sql ="DELETE FROM cangal.note where id=?";
        try(Connection conn=getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows>0;
        }catch (SQLException e){
            System.err.println("Kelime silinirken hata oluştu:"+e.getMessage());
            return false;
        }
    }
    public List<String> getAllWords(){
            List<String> words = new ArrayList<>();
            String sql="SELECT * FROM cangal.note";
            try(Connection conn = getConnection(); Statement stmt=conn.createStatement();ResultSet rs =stmt.executeQuery(sql)){
                while (rs.next()){
                    words.add(rs.getInt("id")+" :"+rs.getString("notes"));
                }
            }catch (SQLException e){
                System.err.println("Kelimeler listelenirken hata oluştu: " +e.getMessage());
            }
            return words;
        }
    }
