package app.youbeer.com.br.appbreja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

import app.youbeer.com.br.adapter.EstabelecimentoAdapter;
import app.youbeer.com.br.modelo.Estabelecimento;

public class CervejaActivity extends AppCompatActivity {

    private ListView listaEstabelecimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerveja);

        TabHost abas = (TabHost) findViewById(R.id.tabhost);
        abas.setup();

        TabHost.TabSpec descritor = abas.newTabSpec("descricao");
        descritor.setContent(R.id.descricao);
        descritor.setIndicator(getString(R.string.descricao));
        abas.addTab(descritor);

        descritor = abas.newTabSpec("ondeEncontrar");
        descritor.setContent(R.id.ondeEncontrar);
        descritor.setIndicator(getString(R.string.ondeEncontrar));
        abas.addTab(descritor);

        listaEstabelecimento = (ListView) findViewById(R.id.lista_estabelecimentos);
        carregaLista();

        listaEstabelecimento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Estabelecimento estabelecimento = (Estabelecimento) listaEstabelecimento.getItemAtPosition(position);

                Intent intentEstabelecimento = new Intent(CervejaActivity.this, EstabelecimentoActivity.class);
                intentEstabelecimento.putExtra("estabelecimento",estabelecimento);
                startActivity(intentEstabelecimento);
            }
        });

        listaEstabelecimento.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> lista, View item, int position, long id) {
                Estabelecimento estabelecimento = (Estabelecimento) listaEstabelecimento.getItemAtPosition(position);

                Intent intentEstabelecimento = new Intent(CervejaActivity.this, EstabelecimentoActivity.class);
                intentEstabelecimento.putExtra("estabelecimento",estabelecimento);
                startActivity(intentEstabelecimento);
                return false;
            }
        });
    }

    //Metodo que carrega a lista de estabelecimentos
    private void carregaLista(){

        List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();

        Estabelecimento estabelecimento1 = new Estabelecimento();
        estabelecimento1.setNomeEstabelecimento("Nome do Estabelecimento 1");
        estabelecimento1.setEndereco("teste 1");
        estabelecimento1.setTelefone("1111111");
        estabelecimento1.setCodigoEstabelecimento(1);

        Estabelecimento estabelecimento2 = new Estabelecimento();
        estabelecimento2.setNomeEstabelecimento("Nome do Estabelecimento 2");
        estabelecimento2.setEndereco("teste 2");
        estabelecimento2.setTelefone("22222");
        estabelecimento2.setCodigoEstabelecimento(2);

        estabelecimentos.add(estabelecimento1);
        estabelecimentos.add(estabelecimento2);


        EstabelecimentoAdapter adapter = new EstabelecimentoAdapter(this, estabelecimentos);

        listaEstabelecimento.setAdapter(adapter);
    }
}
