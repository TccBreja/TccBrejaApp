package app.youbeer.com.br.appbreja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.youbeer.com.br.adapter.EstabelecimentoAdapter;
import app.youbeer.com.br.modelo.Estabelecimento;

public class ListaEstabelecimentoActivity extends AppCompatActivity {

    private ListView listaEstabelecimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estabelecimento);
        listaEstabelecimento = (ListView) findViewById(R.id.lista_estabelecimentos);
        carregaLista();

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
    private void carregaLista(){

        List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();

        Estabelecimento estabelecimento1 = new Estabelecimento();
        estabelecimento1.setNome("Nome do Estabelecimento 1");
        estabelecimento1.setEndereco("teste 1");
        estabelecimento1.setTelefone("1111111");
        estabelecimento1.setId(1L);

        Estabelecimento estabelecimento2 = new Estabelecimento();
        estabelecimento2.setNome("Nome do Estabelecimento 2");
        estabelecimento2.setEndereco("teste 2");
        estabelecimento2.setTelefone("22222");
        estabelecimento2.setId(2L);

        estabelecimentos.add(estabelecimento1);
        estabelecimentos.add(estabelecimento2);


        EstabelecimentoAdapter adapter = new EstabelecimentoAdapter(this, estabelecimentos);

        listaEstabelecimento.setAdapter(adapter);
    }
}
