import com.google.auth.oauth2.GoogleCredentials;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoogleCredentialsLoader {

    public static GoogleCredentials loadCredentials() throws IOException {
        // Chemin du fichier credentials.json dans le répertoire resources
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/credentials.json");
        // Lecture du contenu du fichier JSON
        JsonObject jsonObject = new Gson().fromJson(new InputStreamReader(fileInputStream), JsonObject.class);
        // Création des GoogleCredentials
        return GoogleCredentials.fromStream(fileInputStream);
    }
}
