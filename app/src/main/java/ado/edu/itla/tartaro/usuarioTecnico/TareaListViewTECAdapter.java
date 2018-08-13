package ado.edu.itla.tartaro.usuarioTecnico;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import ado.edu.itla.tartaro.AppConfig;
import ado.edu.itla.tartaro.R;
import ado.edu.itla.tartaro.entidad.Categoria;
import ado.edu.itla.tartaro.entidad.Tarea;

public class TareaListViewTECAdapter extends BaseAdapter {

    private Context context;
    private List<Tarea> tareas;
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");


    public TareaListViewTECAdapter(Context context, List<Tarea> tareas) {
        this.context = context;
        this.tareas = tareas;

    }

        @Override
        public int getCount () {
            return tareas.size();
        }

        @Override
        public Object getItem ( int position){
            return tareas.get(position);
        }

        @Override
        public long getItemId ( int position){
//            Categoria cat = tareas.get(position);
            return position;
        }

        public View getView ( int position, View convertView, ViewGroup parent){
            Tarea tarea = (Tarea) getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_principal_tecnico, null);

            }
            TextView nombre = convertView.findViewById(R.id.txt_tarea);
            TextView descripcion = convertView.findViewById(R.id.txt_descripcion);
            TextView fecha = convertView.findViewById(R.id.txt_fecha);
            TextView categoria = convertView.findViewById(R.id.txt_categoria);
            TextView estado = convertView.findViewById(R.id.txt_estado);
            TextView creador = convertView.findViewById(R.id.txt_creador);

            nombre.setText(tarea.getNombre());
            descripcion.setText(tarea.getDescripcion());

            fecha.setText(SIMPLE_DATE_FORMAT.format(tarea.getFecha()));
            categoria.setText(tarea.getCategoria().getNombre());
            estado.setText("Estado: " + tarea.getEstadoTarea().name());
            switch (tarea.getEstadoTarea()){
                case EN_PROCESO:
                    estado.setTextColor(ContextCompat.getColor(context, R.color.PROCESO));
                    break;
                case PENDIENTE:
                    estado.setTextColor(ContextCompat.getColor(context, R.color.PENDIENTE));
                    break;
                case LISTA:
                    estado.setTextColor(ContextCompat.getColor(context, R.color.LISTA));
                    break;
            }
            creador.setText("Creador: " + tarea.getUsuarioCreador());

            return convertView;
        }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}

