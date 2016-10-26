package app.youbeer.com.br.appbreja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.youbeer.com.br.adapter.CervejaEstabelecimentoAdapter;
import app.youbeer.com.br.adapter.EstabelecimentoAdapter;
import app.youbeer.com.br.modelo.Cerveja;
import app.youbeer.com.br.modelo.Estabelecimento;

public class EstabelecimentoActivity extends AppCompatActivity {

    private ListView listaCerveja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estabelecimento);
        listaCerveja = (ListView) findViewById(R.id.lista_cerveja);
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

        List<Cerveja> cervejas = new ArrayList<Cerveja>();

        Cerveja cerveja1 = new Cerveja();
        cerveja1.setNome("Nome da Cerveja 1 - Lata");
        cerveja1.setId(1L);

        Cerveja cerveja2 = new Cerveja();
        cerveja2.setNome("Nome do Estabelecimento 2");
        cerveja2.setId(2L);

        cervejas.add(cerveja1);
        cervejas.add(cerveja2);
        cervejas.add(cerveja1);
        cervejas.add(cerveja2);


        CervejaEstabelecimentoAdapter adapter = new CervejaEstabelecimentoAdapter(this, cervejas);

        listaCerveja.setAdapter(adapter);
    }
}
