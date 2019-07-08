package ec.edu.espe.rest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador
{

    @RequestMapping(value = "/insertarVideo", method = RequestMethod.POST)
    public void insertarPelicula(@RequestBody String body)
    {
        JsonObject JSON = new JsonParser().parse(body).getAsJsonObject();
        String titulo = JSON.get("titulo").getAsString();

        String query = "INSERT INTO videos (titulo) VALUES (?);";
        try
        {
            PreparedStatement preparedStatement = ConexionBD.getConexion().prepareStatement(query);
            preparedStatement.setString(1, titulo);
            preparedStatement.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
