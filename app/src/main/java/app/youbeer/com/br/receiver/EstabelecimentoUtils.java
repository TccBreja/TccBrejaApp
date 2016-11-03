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
 * Created by Evandro on 02/11/2016.
 */
public class EstabelecimentoUtils {

    public List<Estabelecimento> getInformacao(String end){
        String json;
        List<Estabelecimento> retorno;
        json = WebClient.getJSONFromAPI(end);
        Log.i("Resultado", json);
        retorno = parseJsonEstabelecimento(json);

        return retorno;
    }


    private List<Estabelecimento> parseJsonEstabelecimento(String json){
        try {
            // Declarações
            List<Estabelecimento> listaEstabelecimentos = new ArrayList<Estabelecimento>();
            JSONObject jsonObj = null;
            int codigoEstabelecimento = 0;

            // Obtém o json Object
            try {
                jsonObj = new JSONObject(json);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            // Obtém o array json de estabalecimentos
            JSONArray arrayEstabelecimentoJson = jsonObj.getJSONArray("estabelecimento");

            for ( int i = 0 ; i < 1; i++ ){

                // Obtém o objeto objEstabelecimentoJson
                JSONObject objEstabelecimentoJson = arrayEstabelecimentoJson.getJSONObject(i);

                // Adiciona um novo estabelecimento a lista
                Estabelecimento estabelecimento = new Estabelecimento();
                listaEstabelecimentos.add(estabelecimento);

                // Popula o estabelecimento
                estabelecimento.setCodigoAdmin(objEstabelecimentoJson.getInt("codigoAdmin"));
                estabelecimento.setCodigoEstabelecimento(objEstabelecimentoJson.getInt("codigoEstabelecimento"));
                estabelecimento.setNomeEstabelecimento(objEstabelecimentoJson.getString("nomeEstabelecimento"));
                estabelecimento.setDescricao(objEstabelecimentoJson.getString("descricao"));
                estabelecimento.setEndereco(objEstabelecimentoJson.getString("endereco"));
                estabelecimento.setTelefone(objEstabelecimentoJson.getString("telefone"));
                estabelecimento.setSite(objEstabelecimentoJson.getString("site"));
                estabelecimento.setTipoEstabelecimento(objEstabelecimentoJson.getString("tipoEstabelecimento"));
                estabelecimento.setHorarioAbertura(objEstabelecimentoJson.getString("horarioAbertura"));
                estabelecimento.setHorarioFechamento(objEstabelecimentoJson.getString("horarioFechamento"));

                try {
                    // Obtém o array json da lista de cervejas para o estabelecimento
                    JSONArray arrayListaCervejasJson = objEstabelecimentoJson.getJSONArray("listaCervejas");

                    for ( int j = 0 ; j < arrayListaCervejasJson.length(); j++ ){

                        // Obtém o objeto objCervejaJson
                        JSONObject objCervejaJson = arrayListaCervejasJson.getJSONObject(i);

                        // Popula a cerveja e adiciona a lista
                        Cerveja cerveja = new Cerveja();
                        cerveja.setCodigoCerveja(objCervejaJson.getInt("codigoCerveja"));
                        cerveja.setNomeCerveja(objCervejaJson.getString("nomeCerveja"));
                        cerveja.setDescricao(objCervejaJson.getString("descricao"));
                        cerveja.setTipo(objCervejaJson.getString("tipo"));
                        cerveja.setTeorAlcool(objCervejaJson.getString("teorAlcool"));
                        cerveja.setVolumeLiquido(objCervejaJson.getString("volumeLiquido"));
                        cerveja.setValor(objCervejaJson.getString("valor"));
                        estabelecimento.getListaCervejas().add(cerveja);

                    }

                } catch (JSONException e) {
                    // Obtém o objeto json da lista de cervejas para o estabelecimento
                    JSONObject objListaCervejasJson = objEstabelecimentoJson.getJSONObject("listaCervejas");

                    // Popula a cerveja e adiciona a lista
                    Cerveja cerveja = new Cerveja();
                    cerveja.setCodigoCerveja(objListaCervejasJson.getInt("codigoCerveja"));
                    cerveja.setNomeCerveja(objListaCervejasJson.getString("nomeCerveja"));
                    cerveja.setDescricao(objListaCervejasJson.getString("descricao"));
                    cerveja.setTipo(objListaCervejasJson.getString("tipo"));
                    cerveja.setTeorAlcool(objListaCervejasJson.getString("teorAlcool"));
                    cerveja.setVolumeLiquido(objListaCervejasJson.getString("volumeLiquido"));
                    cerveja.setValor(objListaCervejasJson.getString("valor"));
                    estabelecimento.getListaCervejas().add(cerveja);

                }
            }

            return listaEstabelecimentos;

        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }
}
