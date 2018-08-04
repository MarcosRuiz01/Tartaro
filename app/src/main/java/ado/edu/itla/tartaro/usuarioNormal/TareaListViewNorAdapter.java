package ado.edu.itla.tartaro.usuarioNormal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Tarea;

public class TareaListViewNorAdapter extends BaseAdapter {

    private Context context;
    private List<Tarea> listItems;

    public TareaListViewNorAdapter(Context context, List<Tarea> listItems) {
        this.context = context;
        this.listItems = listItems;

    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        Tarea task = listItems.get(position);
        return task.getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tarea item = (Tarea) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_principal_tecnico, null);

        }
        TextView nombre = convertView.findViewById(R.id.txt_tarea);
        TextView descripcion = convertView.findViewById(R.id.txt_descripcion);




        nombre.setText(item.getNombre());
        descripcion.setText(item.getDescripcion());



        return convertView;
    }
}
