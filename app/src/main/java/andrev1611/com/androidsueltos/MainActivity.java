package andrev1611.com.androidsueltos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Producto> list;
    Context ctx;
    ArrayAdapter<Producto> adapter;
    TextView tvtitutlo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctx= this;
        /*
        * Personalizar un ListView
        * 1. Añadir el ListView a la actividad XML
        * 2. Luego Añadir un nuevo Layout Resource File sobre layout (donde estan los layout)
        * 3. Diseñar este layout agregado como queremos que se vea cada fila del ListView
        * 4. Crear un ListaAdapter para adaptar la vista diseñada XML dentro del ListView
        * 5. El ListaAdapter sera una lista de algo... en este caso de Productos entonces creamos una Clase Producto
        * 6.
        * */
        ListView listaView = (ListView)findViewById(R.id.lvProductos);
        adapter = new ListaAdapter(MainActivity.this,getListProductos());
        listaView.setAdapter(adapter);
        //adapter.notifyDataSetChanged(); con esto parece que se actualiza el adapter

        //PARA AGREGAR DATOS O ITEMS A ALA LISTA
        //list.add(get("edittext1","edittext2",R.drawable.restaurant));//titulo descripcion y la imagen que en este ejemplo es una que tengo en drawable
        //adapter.notifyDataSetChanged();
        //et/Nombre.getText().clear(); LIMPIANDO LOS TEXT
        //etDescripcion.getText().clear(); LIMPIANDO LOS TEXT

        listaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Holaa",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private List<Producto> getListProductos(){
        //AQUI LLENAMOS LOS DATOS A DIFERENTES ARRAY
        list=new ArrayList<Producto>();

        String [] titulos;
        String [] descripciones;

        titulos = ctx.getResources().getStringArray(R.array.titulos);
        descripciones = ctx.getResources().getStringArray(R.array.descriociones);

        int [] imagenes = new int[]{
                R.drawable.ic_launcher,
                R.drawable.restaurant,
                R.drawable.ic_launcher,
                R.drawable.restaurant,
        };
        //no importa cual escoja parael length  porque tiene el mismo tamaño
        for (int i = 0 ; i<imagenes.length;i++){
            list.add(get(titulos[i],descripciones[i],imagenes[i]));
        }

        return list;
    }
    private Producto get(String t, String d, int iii){
        return new Producto(t,d,iii);
    }
}


//https://www.youtube.com/playlist?list=PLepSKPKAxOCMnf83Zv70HJnKUpt-JzwGu
//con         finish(); se termina una activity osea al llamar a una se podria poner esta luego del
//starActivity para terminar esa pantalla y solo este activa la siguiente

//hay algo que se llama ActivityforResult esto es que se hace un intent hacia una segunda activity
//con el objetivo de que esta devuelva algo a ala primera actividad o actividad que le hizo el intent
// entoncs en el metodo ActionForResult es cuando el intent regresa de la segunda actividad con los datos
//que envie a la primera.

//INTENT EXPLICITOS SON LOS NORMALES DE UNA ACTIVIDAD A OTRA

//LOS  INTENT IMPLICITOS SON LOS QUE ABREN UNA VISTA POR EJEMPLO ABREN UNA WEB - EL CORREO - MAPA ETC ETC
// 1. WEB
        /*Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("www.sdsd.com"));
        startActivity(i);*/

// 2. CORREOS
        /*Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL,new String[]{"recipient@example.com"});
        i.putExtra(Intent.EXTRA_SUBJECT,"Asunto del mensaje");
        i.putExtra(Intent.EXTRA_TEXT,"cuerpo del mensaje");
        try {
            startActivity(Intent.createChooser(i,"mensaje enviado...."));
        }catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"There are no email clientes installed",Toast.LENGTH_SHORT).show();
        }*/
// 3. ABRIR EL MODULO PARA HACER LLAMADAS
       /* Intent i = new Intent(Intent.ACTION_DIAL);
        startActivity(i);*/

// 4. MAPAS
        /*Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("geo:0,0vcvcvcvcvcv=cvcv+Am+Park,+Mountain+View,+California"));
        startActivity(i);*/

//PARA ESTO DE ARRIBA HAY QUE AÑADIR UNAS CATEGORIAS A LA ACTIVITY EN EL MANIFEST
//<category android:name="android.intent.category.APP_BROWSER"/>
//<category android:name="android.intent.category.APP_BROWSER"/>
//<category android:name="android.intent.category.APP_MAPS"/>
//<category android:name="android.intent.category.APP_CONTACTS"/>