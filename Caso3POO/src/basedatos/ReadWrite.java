package basedatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadWrite {
	
	
	
	public void insertData(int id, String name, String status, String age) {
		
		ConectionDB conector = new ConectionDB();
        String sql = "INSERT INTO student_table (id, name, status, age) VALUES (?, ?, ?, ?)";

        // Utilizamos un bloque try-with-resources para garantizar que la conexión se cierre correctamente
        try (Connection conn1 = conector.conectar();
             PreparedStatement Prepst = conn1.prepareStatement(sql)) {

            Prepst.setInt(1, id);
            Prepst.setString(2, name);
            Prepst.setString(3, status);
            Prepst.setString(4, age);
            Prepst.executeUpdate();

            System.out.println("Datos insertados correctamente en la base de datos.");

        } catch (Exception e) {
            System.err.println("Error al insertar datos: " + e.getMessage());
        }
    }
	
	public Registro read(int pidBuscado) {
		ConectionDB conector = new ConectionDB();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		Registro newRegistro = null;
		
		try {
			cn = conector.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("Selected * FROM idAgricultor");
			
			while (rs.next()) {
				//Aqui se extrae cada agricultor segun su asesor, casos y toda la info
				if (rs.getInt(1) == pidBuscado) {
					int idAsesor = rs.getInt(2);
					String asesor = rs.getString(3);
					String descripCaso = rs.getString(4);
					Date fecha = rs.getDate(5);
					newRegistro = new Registro(rs.getInt(1), idAsesor, asesor, fecha, descripCaso);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
            try {
                if (rs != null) rs.close();
                if (stm != null) stm.close();
                if (cn != null) cn.close();
            } catch (Exception e) {
                System.err.println("Error al cerrar conexiones: " + e.getMessage());
            }
        }

        return newRegistro;
	}
}
