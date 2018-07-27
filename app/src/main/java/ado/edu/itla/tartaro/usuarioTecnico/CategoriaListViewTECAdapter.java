package ado.edu.itla.tartaro.usuarioTecnico;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Categoria;

public class CategoriaListViewTECAdapter extends BaseAdapter {

    private Context context;
    private List<Categoria> listItems;

    public CategoriaListViewTECAdapter(Context context, List<Categoria> listItems) {
        this.context = context;
        this.listItems = listItems;

    }

        @Override
        public int getCount () {
            return listItems.size();
        }

        @Override
        public Object getItem ( int position){
            return listItems.get(position);
        }

        @Override
        public long getItemId ( int position){
            Categoria cat = listItems.get(position);
            return cat.getId();
        }

        public View getView ( int position, View convertView, ViewGroup parent){
            Categoria item = (Categoria) getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_principal_tecnico, null);

            }
            TextView nombre = convertView.findViewById(R.id.txt_UserName);


            nombre.setText(item.getNombre());


            return convertView;
        }


    }

