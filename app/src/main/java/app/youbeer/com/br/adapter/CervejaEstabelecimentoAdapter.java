package app.youbeer.com.br.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.youbeer.com.br.appbreja.R;
import app.youbeer.com.br.modelo.Cerveja;
import app.youbeer.com.br.modelo.Estabelecimento;

/**
 * Created by Ribolli on 12/10/2016.
 */
public class CervejaEstabelecimentoAdapter extends BaseAdapter{


    private final List<Cerveja> cervejas;
    private final Context context;


    public CervejaEstabelecimentoAdapter(Context context, List<Cerveja> cervejas) {
        this.context = context;
        this.cervejas = cervejas;
    }

    @Override
    public int getCount() {
        return this.cervejas.size();
    }

    @Override
    public Object getItem(int i) {
        return this.cervejas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.cervejas.get(i).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Cerveja cerveja = cervejas.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_item_cerveja, parent, false);
        }

        TextView campoNome = (TextView) view.findViewById(R.id.item_nome);
        campoNome.setText(cerveja.getNome());

        //TextView campoTelefone = (TextView) view.findViewById(R.id.item_telefone);
        //campoTelefone.setText(estabelecimento.getTelefone());

        return view;
    }
}
