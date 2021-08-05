package com.exampledinamicandcircle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.juang.jplot.PlotPastelito;
import com.juang.jplot.PlotPlanitoXY;
import com.juang.jplot.PlotSemiCircle;

import java.util.Timer;

import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer;
    private PlotPlanitoXY plot;
    private PlotPastelito pastel;


    private LinearLayout pantalla,pantalla2,graphup,graphleft,graphright,graphdown;
    private Button inicia,butpastel,btnMidleCircle;
    Context context;
    int i=0; // contador de datos

    float [] Xd,Yd,Yd2,Xd2,Xd3,Yd3,Xd4,Yd4;
    private float[] X=new float [4000];//almacenado de
    private float[] Y=new float [4000];//datos
    private float[] X2=new float [4000];//almacenado de
    private float[] Y2=new float [4000];//datos
    private float[] X3=new float [4000];//almacenado de
    private float[] Y3=new float [4000];//datos
    private float[] X4=new float [4000];//almacenado de
    private float[] Y4=new float [4000];//datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla= (LinearLayout) (findViewById(R.id.pantalla));
        pantalla2= (LinearLayout) (findViewById(R.id.pantalla2));

        graphup= (LinearLayout) (findViewById(R.id.graphup));
        graphleft= (LinearLayout) (findViewById(R.id.graphleft));
        graphright=(LinearLayout) (findViewById(R.id.graphright));
        graphdown=(LinearLayout) (findViewById(R.id.graphdown));

        inicia =(Button)(findViewById(R.id.inicia));
        butpastel=(Button)(findViewById(R.id.butPastel));
        btnMidleCircle=(Button)(findViewById(R.id.butMidleCircle));


        context=this;

        //boton plot2d
        inicia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                pantalla.setVisibility(View.VISIBLE);
                pantalla2.setVisibility(View.GONE);
                inicia(); // se ejecuta el metodo inicia

            }
        });

        // boton grafica de pastelito

        butpastel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                pantalla.setVisibility(View.VISIBLE);
                pantalla2.setVisibility(View.GONE);
                GraphPastel();

            }
        });


       btnMidleCircle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                pantalla.setVisibility(View.GONE);
                pantalla2.setVisibility(View.VISIBLE);
                plotMidleCircle(view);

            }
        });




    }


    public void GraphPastel(){

        pastel=new PlotPastelito(this,"Ganancias Diarias");
        float[] datapoints = {2,5,8,11,23,7,16};
        String[] etiquetas={"lunes", "martes", "miercoles","jueves","viernes","sabado","domingo"};
        pastel.SetDatos(datapoints,etiquetas);
        pastel.SetHD(true);
        pastel.SetColorDato(5,0,0,0);//el dato 5 o sea "23" de color negro los ultimos 3 enteros son colores rgb
        pastel.SetColorDato(3,255,0,0);//el dato 3 o sea "8" de color rojo los ultimos 3 enteros son colores rgb

        pantalla.removeAllViews();
        pantalla.addView(pastel);






    }


    public void inicia(){
        // inicializamos el grafico dinamico ó serie de tiempo
        plot = new PlotPlanitoXY(context,"xx vs yy","xx","yy");//el "context" si no esta dentro del hilo UI puede simplemente colocarse this
        plot.SetEscalaAutomatica(true);// escala automatica si no se coloca true deben definirse los valores maximos de xmin,xmax,y1min,y1max,y2min,y2max
        plot.SetHD(false);



        timer = new Timer();
        TimerTask task = new TimerTask()
        {
            /* se inicia un hilo en paralelo para ejecutar la tarea asincrona podria usarse tambien la clase AnsycTask y usar su
               su hilo especifico para acceder a la UI */
            @Override
            public void run()
            {
                //hilo para comunicarse con la UI intefaz de usuario y poder pintar el el LinearLayout "pantalla"
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        pantalla.removeAllViews();

                        Xd=new float[i+1]; Xd[0]=3.4f;
                        Yd=new float[i+1];
                        Xd2=new float[i+1];
                        Yd2=new float[i+1];
                        Xd3=new float[i+1];
                        Yd3=new float[i+1];
                        Xd4=new float[i+1];
                        Yd4=new float[i+1];

                        X[i]=i-20;
                        Y[i]=(i-20)*(i-20);
                        for (int j = 0; j < Xd.length; j++) {
                            Xd[j]= X[j];
                            Yd[j] =Y[j];
                        }

                        X2[i]=i;
                        Y2[i]=i+2;
                        for (int j = 0; j < Xd2.length; j++) {
                            Xd2[j]= X2[j];
                            Yd2[j] =Y2[j];
                        }

                        X3[i]=i;
                        Y3[i]=-(i+2);
                        for (int j = 0; j < Xd3.length; j++) {
                            Xd3[j]= X3[j];
                            Yd3[j] =Y3[j];
                        }
                        X4[i]=i-20;
                        Y4[i]=-(i-20)*(i-20);
                        for (int j = 0; j < Xd4.length; j++) {
                            Xd4[j]= X4[j];
                            Yd4[j] =Y4[j];
                        }
                        plot.SetSerie1(Xd,Yd,"graph1",5,true);// el true indica que unira los puntos con recta
                        plot.SetSerie2(Xd2,Yd2,"graph2",5,true,2);// este dato se grafica en el eje y2(lado derecho)
                        plot.SetSerie3(Xd3,Yd3,"graph3",5,true,1);// se grafica en el eje y1(lado izquierdo), tamaño de punto 5
                        plot.SetSerie4(Xd4,Yd4,"graph5",0,true,1);/* se grafica en el eje y1(lado izquierdo), tamaño punto=0 no se ven
                                                                  los puntos solo las lineas que unen los puntos*/

                        pantalla.addView(plot);
                        i=i+1;
                    }//hilo2
                });//hilo para acceder a la intefaz grafica
            }//hilo1
        };
        timer.schedule(task, 1000, 200);// el timer se ejecura despues de 1000ms=1seg de haber precionando el boton "plot2d" y se repite cada 200ms
    }


    public void parar(View v){
        timer.cancel();
    }

    public void plotMidleCircle(View v){

        PlotSemiCircle psleft = new PlotSemiCircle(this,65,'l');
        PlotSemiCircle psright = new PlotSemiCircle(this,74,'r');
        PlotSemiCircle psup = new PlotSemiCircle(this,49,'u');
        PlotSemiCircle psdown = new PlotSemiCircle(this,100,'d');

        //psleft.setColorGradient(Color.BLACK,Color.RED);
        //psleft.setAnimation(5000,1);
        //psleft.setColorText(Color.GREEN);
        //psleft.setAnimation(2000,2);
        //psleft.setHD(true);

        graphleft.addView(psleft);
        graphup.addView(psup);
        graphdown.addView(psdown);
        graphright.addView(psright);

    }



}