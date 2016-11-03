package app.youbeer.com.br.appbreja;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.youbeer.com.br.adapter.CervejaEstabelecimentoAdapter;
import app.youbeer.com.br.modelo.Cerveja;
import app.youbeer.com.br.receiver.CervejaUtils;

public class EstabelecimentoActivity extends AppCompatActivity {

    private ListView listaCerveja;
    private ProgressDialog load;
    private List<Cerveja> cervejas = new ArrayList<Cerveja>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estabelecimento);

        GetJson download = new GetJson();

        listaCerveja = (ListView) findViewById(R.id.lista_cerveja);

        //Chama Async Task
        download.execute();

        carregaLista();

        listaCerveja.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Cerveja cerveja = (Cerveja) listaCerveja.getItemAtPosition(position);

                Intent intentCerveja = new Intent(EstabelecimentoActivity.this, CervejaActivity.class);
                intentCerveja.putExtra("cerveja",cerveja);
                startActivity(intentCerveja);
            }
        });

        listaCerveja.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> lista, View item, int position, long id) {
                Cerveja cerveja = (Cerveja) listaCerveja.getItemAtPosition(position);

                Intent intentCerveja = new Intent(EstabelecimentoActivity.this, CervejaActivity.class);
                intentCerveja.putExtra("cerveja",cerveja);
                startActivity(intentCerveja);
                return false;
            }
        });


    }

    protected void onResume(Bundle savedInstanceState) {
        super.onResume();
    }

    //Metodo que carrega a lista de estabelecimentos
    private void carregaLista(){

        //List<Cerveja> cervejas = new ArrayList<Cerveja>();
        Cerveja cerveja = new Cerveja();
        cerveja.setCodigoCerveja(66);
        cerveja.setNomeCerveja("Dos brothers");

        cervejas.add(cerveja);

        CervejaEstabelecimentoAdapter adapter = new CervejaEstabelecimentoAdapter(this, cervejas);

        listaCerveja.setAdapter(adapter);
    }


    private class GetJson extends AsyncTask<Void, Void, Cerveja> {

        @Override
        protected void onPreExecute(){
            load = ProgressDialog.show(EstabelecimentoActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected Cerveja doInBackground(Void... params) {
            CervejaUtils util = new CervejaUtils();

            return util.getInformacao("http://192.168.0.248:8080/WebServerRestful/webserver/listarCervejas");
        }

        @Override
        protected void onPostExecute(Cerveja cerveja){

            cervejas.add(cerveja);

            load.dismiss();
        }
    }

}
