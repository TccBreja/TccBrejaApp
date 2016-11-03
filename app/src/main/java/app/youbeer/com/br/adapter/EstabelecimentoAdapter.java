package app.youbeer.com.br.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.youbeer.com.br.appbreja.ListaEstabelecimentoActivity;
import app.youbeer.com.br.appbreja.R;
import app.youbeer.com.br.modelo.Estabelecimento;

/**
 * Created by Ribolli on 12/10/2016.
 */
public class EstabelecimentoAdapter extends BaseAdapter{


    private final List<Estabelecimento> estabelecimentos;
    private final Context context;


    public EstabelecimentoAdapter(Context context, List<Estabelecimento> estabelecimentos) {
        this.context = context;
        this.estabelecimentos = estabelecimentos;
    }

    @Override
    public int getCount() {
        return this.estabelecimentos.size();
    }

    @Override
    public Object getItem(int i) {
        return this.estabelecimentos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.estabelecimentos.get(i).getCodigoEstabelecimento();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Estabelecimento estabelecimento = estabelecimentos.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_item_estabelecimento, parent, false);
        }

        TextView campoNome = (TextView) view.findViewById(R.id.item_nome);
        campoNome.setText(estabelecimento.getNomeEstabelecimento());

        //TextView campoTelefone = (TextView) view.findViewById(R.id.item_telefone);
        //campoTelefone.setText(estabelecimento.getTelefone());

        return view;
    }
}
