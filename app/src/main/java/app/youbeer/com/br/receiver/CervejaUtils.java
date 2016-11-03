package app.youbeer.com.br.receiver;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.youbeer.com.br.modelo.Cerveja;
import app.youbeer.com.br.modelo.Estabelecimento;

/**
 * Created by Evandro on 30/10/2016.
 */
public class CervejaUtils {

    public Cerveja getInformacao(String end){
        String json;
        Cerveja retorno;
        json = WebClient.getJSONFromAPI(end);
        Log.i("Resultado", json);
        retorno = parseJsonCerveja(json);

        return retorno;
    }

    private Cerveja parseJsonCerveja(String json){
        try {
            Cerveja cerveja = new Cerveja();
            JSONObject jsonObj = null;

            try {
                jsonObj = new JSONObject(json);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JSONArray array = jsonObj.getJSONArray("cerveja");
            JSONObject objArray = array.getJSONObject(0);
            cerveja.setCodigoCerveja(objArray.getInt("codigoCerveja"));
            cerveja.setDescricao(objArray.getString("descricao"));
            cerveja.setNomeCerveja(objArray.getString("nomeCerveja"));
            cerveja.setTeorAlcool(objArray.getString("teorAlcool"));
            cerveja.setTipo(objArray.getString("tipo"));
            cerveja.setVolumeLiquido(objArray.getString("volumeLiquido"));

            return cerveja;
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }
}
