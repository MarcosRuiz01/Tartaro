package ado.edu.itla.tartaro.usuarioNormal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import ado.edu.itla.tartaro.AppConfig;
import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Categoria;
import ado.edu.itla.tartaro.entidad.Tarea;
import ado.edu.itla.tartaro.entidad.Usuario;

public class TareaListViewNorAdapter extends BaseAdapter {

    private Context context;
    private List<Tarea> listItems;
    private View tareaSelect;

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
        TextView fecha = convertView.findViewById(R.id.txt_fecha);
        TextView categoria = convertView.findViewById(R.id.txt_categoria);
        TextView estado = convertView.findViewById(R.id.txt_estado);
        TextView creador = convertView.findViewById(R.id.txt_creador);

        nombre.setText(item.getNombre());
        descripcion.setText(item.getDescripcion());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        fecha.setText(sdf.format(item.getFecha()));
//        categoria.setText(item.getCategoria().toString());
        estado.setText("Estado: " + item.getEstadoTarea().name());
        creador.setText("Creador: " + AppConfig.getConfig().getUsuario().toString());

        return convertView;
    }


}


