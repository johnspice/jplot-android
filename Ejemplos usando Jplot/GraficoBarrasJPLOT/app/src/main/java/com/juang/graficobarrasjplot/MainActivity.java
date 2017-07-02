package com.juang.graficobarrasjplot;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.juang.jplot.PlotBarritas;

public class MainActivity extends AppCompatActivity {
    PlotBarritas Columna;
    PlotBarritas ColumnaAgrupada;
    PlotBarritas ColumnaApilada;
    PlotBarritas ColumnaApilada100;

    Context context;
    private LinearLayout pantalla;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;
        pantalla= (LinearLayout) (findViewById(R.id.grafico));

    }




    public void columna(View v){

        String x[]={"lunes","martes","miercoles","jueves","viernes","sabado","domingo"};
        double y[]={20,30,44,0,-25};
        Columna=new PlotBarritas(context,"Gráfico de Columnas ","articulos vendidos por dia");
                                //en context puede colocarse simplemente this
        //personalizacion del grafico
        Columna.Columna(x,y);
        Columna.SetHD(true);
        //cambiemos el color del dato 3 o sea "44" rojo=255,verde=0,Azul=0 los ultimos res enteros son los colores en rgb
        Columna.SetColorPila(3,255,0,0);//muestra el tercer dato en color rojo

        //mostrando en pantalla
        pantalla.removeAllViews();
        pantalla.addView(Columna);
    }


    public void columna_agru(View v){
        String x[]={"lunes","martes","miercoles","jueves","viernes","sabado","domingo"};
        String Acota[]={"jeans","shorts","shoes"};
        double y[][]={{2 ,3,1},//y[]{]  defina un array de 7 grupos con 3 columnas  puede ser de y[n][m] con n,m cualquier entero
                      {5 ,2,5},
                      {1,3,2},
                      {0 ,3,1},
                      {2 ,4,-1},
                      {2 ,0,-1},
                      {2 ,1,-1}};

        ColumnaAgrupada=new PlotBarritas(this,"Gráfico de Columnas Agrupadas","articulos vendidos por dia");

        //personalizacion de grafico
        ColumnaAgrupada.ColumnaAgrupada(x,y,Acota);
        ColumnaAgrupada.SetSizeAcot(15);
        ColumnaAgrupada.SetSizeTitulo(20);
        ColumnaAgrupada.SetSizeTituloY(12);
        ColumnaAgrupada.SetHD(true);
        ColumnaAgrupada.SetColorContorno(255,0,0);//contorno en rojo
        ColumnaAgrupada.SetColorPila(2,255,0,0);//segunda columna de grupo en rojo

        pantalla.removeAllViews();
        pantalla.addView(ColumnaAgrupada);
    }

    public void columna_apil(View v){
        String x[]={"lunes","martes","miercoles","jueves","viernes","sabado","domingo"};
        String Acota[]={"jeans","shorts","shoes"};
        double y[][]={{2 ,3,1},//y[7]{3]  defina un array de 7 grupos con 3 columnas  puede ser de y[n][m] con n,m cualquier entero
                      {5 ,2,5},
                      {1,3,2},
                      {0 ,3,1},
                      {2 ,4,-1},
                      {2 ,0,-1},
                      {2 ,1,-1}};

        ColumnaApilada=new PlotBarritas(this,"Gráfico de Columnas Agrupadas","articulos vendidos por dia");

        //personalizacion de grafico
        ColumnaApilada.ColumnaApilada(x,y,Acota);
        ColumnaApilada.SetHD(true);
        ColumnaApilada.SetColorContorno(255,0,2355);//contorno en magenta
        ColumnaApilada.SetColorPila(1,0,0,255);//primer pila de columna en azul  recordar que los ultimos 3 enteros son rgb
        ColumnaApilada.SetColorPila(2,0,255,255);//segunda pila de columna en cyan  recordar que los ultimos 3 enteros son rgb
        //puede elegirse el color hasta la pila 44 si es mayor sera generado aleatoriamente

        pantalla.removeAllViews();
        pantalla.addView(ColumnaApilada);
    }



    public void columna_apil100(View v){
        String x[]={"lunes","martes","miercoles","jueves","viernes","sabado","domingo"};
        String Acota[]={"jeans","shorts","shoes"};
        double y[][]={{2 ,3,1},//y[7]{3]  defina un array de 7 grupos con 3 columnas  puede ser de y[n][m] con n,m cualquier entero
                {5 ,2,5},
                {1,3,2},
                {0 ,3,1},
                {2 ,4,-1},
                {2 ,0,-1},
                {2 ,1,-1}};
        ColumnaApilada100=new PlotBarritas(this,"Gráfico de Columnas Agrupadas","articulos vendidos por dia");

        //personalizacion de grafico
        ColumnaApilada100.ColumnaApilada100(x,y,Acota);
        ColumnaApilada100.SetHD(true);
        ColumnaApilada100.SetContorno(0);//sin contorno mayor a cero aparece el contorno por default es blanco a este metodo solo debe pasarsele un valor entre 0 y 10 mayor a eso no se toma en cuenta
        ColumnaApilada100.SetColorPila(1,255,105,180);//primera pila de columna de color hot pink
        ColumnaApilada100.SetColorPila(2,255,255,0);//segunda pila de columna de color amarillo
        pantalla.removeAllViews();
        pantalla.addView(ColumnaApilada100);
    }




}
