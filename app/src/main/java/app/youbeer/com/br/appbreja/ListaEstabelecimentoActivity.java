package app.youbeer.com.br.appbreja;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.youbeer.com.br.adapter.EstabelecimentoAdapter;
import app.youbeer.com.br.modelo.Cerveja;
import app.youbeer.com.br.modelo.Estabelecimento;
import app.youbeer.com.br.receiver.CervejaUtils;
import app.youbeer.com.br.receiver.EstabelecimentoUtils;

public class ListaEstabelecimentoActivity extends AppCompatActivity {

    private ListView listaEstabelecimento;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estabelecimento);

        // Faz o download das informações do servidor
        GetJson download = new GetJson();
        download.execute();

        listaEstabelecimento = (ListView) findViewById(R.id.lista_estabelecimentos);

        listaEstabelecimento.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Estabelecimento estabelecimento = (Estabelecimento) listaEstabelecimento.getItemAtPosition(position);

                Intent intentEstabelecimento = new Intent(ListaEstabelecimentoActivity.this, EstabelecimentoActivity.class);
                intentEstabelecimento.putExtra("estabelecimento",estabelecimento);
                startActivity(intentEstabelecimento);
            }
        });

        listaEstabelecimento.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> lista, View item, int position, long id) {
                Estabelecimento estabelecimento = (Estabelecimento) listaEstabelecimento.getItemAtPosition(position);

                Intent intentEstabelecimento = new Intent(ListaEstabelecimentoActivity.this, EstabelecimentoActivity.class);
                intentEstabelecimento.putExtra("estabelecimento",estabelecimento);
                startActivity(intentEstabelecimento);
                return false;
            }
        });
    }

    protected void onResume(Bundle savedInstanceState) {
        super.onResume();
    }

    //Metodo que carrega a lista de estabelecimentos
    private void carregaLista(List<Estabelecimento> estabelecimentos){

        EstabelecimentoAdapter adapter = new EstabelecimentoAdapter(this, estabelecimentos);

        listaEstabelecimento.setAdapter(adapter);

    }

    private class GetJson extends AsyncTask<Void, Void, List<Estabelecimento>> {

        @Override
        protected void onPreExecute(){
            load = ProgressDialog.show(ListaEstabelecimentoActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected List<Estabelecimento> doInBackground(Void... params) {
            EstabelecimentoUtils util = new EstabelecimentoUtils();

            return util.getInformacao("http://192.168.0.11:8080/WebServerRestful/webserver/listarTodosEstabelecimentos");
        }

        @Override
        protected void onPostExecute(List<Estabelecimento> estabelecimentos ){


            carregaLista(estabelecimentos);


            load.dismiss();
        }
    }
}
