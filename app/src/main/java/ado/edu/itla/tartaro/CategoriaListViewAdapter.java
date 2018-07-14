package ado.edu.itla.tartaro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ado.edu.itla.tartaro.entidad.Categoria;

public class CategoriaListViewAdapter extends BaseAdapter {

    private Context context;
    private List<Categoria> listItems;

    public CategoriaListViewAdapter(Context context, List<Categoria> listItems) {
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
            TextView nombre = convertView.findViewById(R.id.txt_tarea);
            TextView fecha = convertView.findViewById(R.id.txt_fecha);
            TextView desc = convertView.findViewById(R.id.txt_descripcion);
            TextView creador = convertView.findViewById(R.id.txt_creador);
            TextView categoria = convertView.findViewById(R.id.txt_categoria);
            TextView estado = convertView.findViewById(R.id.txt_estado);

            nombre.setText(item.getNombre());
            fecha.setText(item.getFecha());
            desc.setText(item.getDescripcion());
            creador.setText(item.getCreador());
            categoria.setText(item.getCategoria());
            estado.setText(item.getEstado());

            return convertView;
        }


    }

