package andrev1611.com.androidsueltos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 14/04/2016.
 */
public class ListaAdapter extends ArrayAdapter<Producto>{

    private final List<Producto> list;//Lista de Productos
    private final Context context;// Contexto

    public ListaAdapter(Context context, List<Producto> list){
        super(context, R.layout.lista_fila,list);//aqui pasamos ellayout xml donde esta el diseño de las filas

        this.context =context;
        this.list= list;

    }

    static  class ViewHolder{//Esta clase hace referencia a los elementos que tenemos dentro del xml layout diseñado para las filas
        //almacenamos las referencias a los elementos dentro del layout de fila
        protected ImageView ivProducto;
        protected TextView tvTitulo;
        protected  TextView tvDescripcion;
        protected CheckBox cbTitulo;

    }
    //ALT+INSERT y sobreescribimos el metodo getView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //ESTA VISTA NOS DA LA VISTA DE CADA FILA position una posicion determinada view la vista y parent por si tiene  algun padre por si un elemento esta dentro de otro
        View view = null;
        if (convertView == null){//cada uno de las vistas osea los items en la lista
            //si esta vista osea la fila es null osea no se habia creado antes en el ViewHolder va guardando los datos
            LayoutInflater inflator = LayoutInflater.from(context);//con esto inflamos la vista en el contexto osea en la pantalla donde stamos
            view = inflator.inflate(R.layout.lista_fila,null);//aqui inflamos la vista cada item porque cada item cuando deslizamos desaparecen y otros aparecen
            //creamos un objeto de la clase ViewHolder que creamos arriba
            //si esta vista osea la fila es null osea no se habia creado antes en el AQUIIIIII
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.tvTitulo = (TextView) view.findViewById(R.id.tvTitulo);
            viewHolder.tvDescripcion = (TextView) view.findViewById(R.id.tvDescripcion);
            viewHolder.ivProducto = (ImageView) view.findViewById(R.id.ivProducto);
            viewHolder.cbTitulo = (CheckBox) view.findViewById(R.id.cbTitulo);
            //crea un escuchador para cadavez que se checkee el checbox
            viewHolder.cbTitulo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

                @Override //buttonView es el checbox y el ischeked true o false
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                    Producto element = (Producto) viewHolder.cbTitulo.getTag();//obtenemos elvalor del checkbox
                    element.setSelected(buttonView.isChecked());//y aqui cambiamos el valor que tiene esa vista osea esa fila en su checkbox
                }
            });
            //EL TAG ES UN ESPACIO VIRTUAL DONDE GUARDA INFORMACION
            view.setTag(viewHolder);//aqui almacena dentro de la vista osea fila un viewHolder
            viewHolder.cbTitulo.setTag(list.get(position));//cada checkbox de un viewholder
            //OSEA EN ESTE IF SE GUARDAN LOS DATOS VIRTUALMENTE CUANDO AUN NO HAN SIDO CREADOS POR ESO EL = NULL
        }else{
            //Y AQUI CUANDO YA SE HAN CREADO ALGUNA VEZ
            view = convertView;//MOSTRAMOS LA VISTA
            //ese viewholder en () es porque del holder que tenemos se crean y no se crean de 0 como en el if de arriba
            ((ViewHolder) view.getTag()).cbTitulo.setTag(list.get(position));//aqui segun la posicion decir si esta check o no
        }
        //AQUI ES DONDE YA MOSTRAMOS LOS TEXTOS O DATOS DENTRO DE LOS ELEMENTOS DE LA VISTA
        //EL VIEWHOLDER DE ARRIBA LOS ALMACENA EN UNA LISTA list
        //Y ESTE HOLDER ES PARA MOSTRAR
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.tvTitulo.setText(list.get(position).getTitulo());
        holder.tvDescripcion.setText(list.get(position).getDescripcion());
        holder.ivProducto.setImageResource(list.get(position).getImagen());
        holder.cbTitulo.setChecked(list.get(position).isSelected());

        return view;
    }
}
