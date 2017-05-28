# JPLOT (android Y WindowsMobile10)
JPLOT  es una librería para graficar Puntos(x,y) ya sea graficos estaticos o Series de tiempo, ademas de graficos circulares (ya se desarrolla la opción de graficos de barras). Esta libreria es para Android y Windows mobile 10(en desarrollo). Existen varias librerias para graficar datos en android como AchartEngine, GraphView ,AndroidPlot, AFreeChart etc. ¿porque jplot? "ES LA MAS SIMPLE DE USAR Con 3 lineas ya se tiene un gráfico" Alta personalización en los gráficos y buena estética, ademas esta en Español.

## documentación aun en desarrollo
![GitHub Logo](/imagenes/SerieContinua.png)
![GitHub Logo](/imagenes/graficoPastel.png)
![GitHub Logo](/imagenes/seriePuntos.png)

## Como Agregar a mi proyecto Android Studio
1. descarga el proyecto extrae "jplot.aar"
2. en tu proyecto click derecho sobre app, new-module, "import .jar/.aar package", agregar el archivo "jplot.aar"
![GitHub Logo](/imagenes/p1.png)
3. en tu proyecto click derecho sobre app, "open module settings", app-dependencies, Add-"Module dependency", jplot-"clik ok".   
![GitHub Logo](/imagenes/p2.png)
4. ya puedes crear el primer gráfico ya se estatico o dinámico. 
##  Gráfico con Series de Puntos (x,y)
    en activity_main.xml agregar;
    
    <LinearLayout
            android:id="@+id/pantalla"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="horizontal">
            
     </LinearLayout>
     
En MainActivity.java agregar 

    import com.juang.jplot.PlotPlanitoXY; 
    
    public class MainActivity extends AppCompatActivity {
    
          private PlotPlanitoXY plot;
          private LinearLayout pantalla;
          Context context;
          
          float [] X,Y;
     
          @Override
        protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);
           pantalla= (LinearLayout) (findViewById(R.id.pantalla));
           
           X=new float[4]; Y=new float[4];
           X[0]=3.4f;Y[0]=2.5f;
           X[1]=11.3f;Y[1]=6.6f;
           X[2]=12.4f;Y[2]=7.6f:
           X[3]=20.9f;Y[3]=10.4f;
           plot = new PlotPlanitoXY(context,"Titulo principal del grafico","titulo eje x","titulo eje y");
           plot.SetSerie1(X,Y,"graph 1",5,true);// el 5 es el tamaño de punto "true" es para unir los puntos 
                                                //con una linea
           //antes de mostrar el grafico en pantalla(LinearLayout) deben de ir todos los ajustes "Set" del grafico.                                plot.SetHD(true); //ajustamos la calidad hd que suaviza bordes del grafico.     
           pantalla.addView(plot);                                     
         }
      }
      
 Run app y !LISTO!         
          
### Gráfico Dinámico (Serie de Tiempo)



### Métodos Publicos que ayudan a configurar el panel de graficado
los siguientes 4 metodos se usa para graficar series de Datos
* public void SetSerie1( float[] xvalues, float[] yvalues,String Titulo,int tp,boolean Unirpuntos)  
>grafica la primer serie de datos. Sus parametros son dos flotantes para los valores x,y. "String Titulo" el titulo de la serie1 de datos a mostrar en la leyenda del grafico. "int tp" entero para tamaño de punto si no se desea ver el punto colocar 0. "boolean UnirPuntos" si se coloca true todos los puntos van unidos con una linea, false no se unen los puntos. 
* public void SetSerie2(float[] xvalues, float[] yvalues,String Titulo ,int tp ,boolean Unirpuntos,int eje)
>lo mismo que SetSerie1 con una parametro extra "int eje" establece el ejey en cual van a graficarse los datos, si se coloca 1 graficara en el lado izquierdo, si se coloca 2 graficara en el eje y2 a la derecha. 
* public void SetSerie3(float[] xvalues, float[] yvalues,String Titulo ,int tp ,boolean Unirpuntos,int eje)
>lo mismo que SetSerie2
* public void SetSerie4(float[] xvalues, float[] yvalues,String Titulo ,int tp ,boolean Unirpuntos,int eje)
>lo mismo que SetSerie3
* public void SetSerie5(float[] xvalues, float[] yvalues,String Titulo ,int tp ,boolean Unirpuntos,int eje)
>lo mismo que serie 4
* public void SetEjey2(String tituloy2)
>ajusta el titulo del ejey2(lado derecho) a mostrar en el grafico es de tipo string. si no se llama este metodo por default se llamara Y2
* public void SetEscalaAutomatica(boolean auto)
>ajusta la escala automatica recibe un parametro tipo boolean si se coloca false es recomendable ajustar las escalas en los siguientes tres metodos. 
los siguientes tres metodos ajustan la escala manual recibiendo 2 parametro tipo double.
* public void SetEscalaX(double minX,double maxX)
* public void SetEscalaY1(double minY1,double maxY1)
* public void SetEscalaY2(double minY2,double maxY2)
* public void SetShowEjey2(boolean mostrar)
>muestra el ejey2(lado derecho)
* public void SetHD(boolean hd)
>mejora la calidad de graficos si se coloca true haciendo un suavizado en los bordes, esto consumira mas recursos del dispositivo. para dispositivos con poca ram es recomendable no usar esta opción.
los siguientes metodos ajustan el tamaño de texto reciben como parametro un entero
* public void  SetSizeTextX(int z)
* public void  SetSizeTextY1(int z)
* public void  SetSizeTextY2(int z)
* public void  SetSizeTitulo(int z)
* public void  SetSizeTituloX(int z)
* public void  SetSizeTituloY1(int z)
* public void  SetSizeTituloY2(int z)
* public void SetSizeLeyend(int z)
* public void SetGruesoLinea(int g).
>Ajusta el grueso de la linea que une los puntos

Los siguientes métodos ajustan colores en el gráfico reciben 3 parámetros de tipo entero r=rojo, g=verde, b=azul
* public void SetColorFondo(int r,int g,int b)      
* public void SetColorEjes(int r,int g,int b)        
* public void SetColorCuadricula(int r, int g, int b)
* public void SetColorTitulo(int r,int g,int b)      
* public void SetColorTituloX(int r,int g,int b)    
* public void SetColorTituloY(int r,int g,int b)    
* public void SetColorTituloY2(int r,int g,int b)    
* public void SetColorTextX(int r, int g, int b)   
* public void SetColorTextY1(int r, int g, int b)   
* public void SetColorTextY2(int r, int g, int b)  
* public void SetColorSerie1(int r, int g, int b)
* public void SetColorSerie2(int r, int g, int b)
* public void SetColorSerie3(int r, int g, int b)
* public void SetColorSerie4(int r, int g, int b)



## Gráfico de Pastelito

 en activity_main.xml agregar;
    
     <LinearLayout
            android:id="@+id/pantalla"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="horizontal">
            
     </LinearLayout>
     
En MainActivity.java agregar 

    import com.juang.jplot.PlotPastelito; 
    
    public class MainActivity extends AppCompatActivity {
    
     private PlotPastelito pastel;
     private LinearLayout pantalla; 
     Context context;
     
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla= (LinearLayout) (findViewById(R.id.pantalla));
        pastel=new PlotPastelito(this,"Ganancias Diarias");
        float[] datapoints = {2,5,8,11,23,7,16};
        String[] etiquetas={"lunes", "martes", "miercoles","jueves","viernes","sabado","domingo"};
        pastel.SetDatos(datapoints,etiquetas);
        //antes de mostrar el grafico en pantalla(LinearLayout) deben de ir todos los ajustes "Set" del grafico.
        pastel.SetHD(true); //ajustamos la calidad hd que suaviza bordes del grafico.
        pantalla.addView(pastel);
        
        }
      }
      
  
         
     

### Métodos Publicos que ayudan a configurar el gráfico
* public void SetDatos(float[] datapoints,String [] etiquetas  )
>inicializa el graficado recibiendo los datos con sus respectivas etiquetas. 
* public void SetColorTitulo(int r,int g, int b)
>ajusta el Color del titulo del grafico
* public void SetColorAcot(int r, int g, int b)
>ajusta el color del texto de las acotaciones
* public void SetColorTextGrafico(int r,int g,int b)
>ajusta el color del texto dentro del grafico circular
* public void SetColorFondo(int r, int g,int b)
>ajusta el color de fondo.

los siguientes 3 metodos ajustan el tamaño del texto, del titulo principal, de las acotaciones, del texto dentro del grafico(cada sector).
* public void SetSizeTitulo(int s)
* public void SetSizeAcot(int s)
* public void SetSizeTextGrafico(int s)
* public void SetSizeTitulo(String t)
>ajusta el titulo del grafico recibiendo un string con el titulo.
* public void SetShowPorcentajes(boolean p)
>si se coloca true apareceran dentro del grafico circular los porcentajes de cada sector, si se coloca false aparecera el valor numerico de cada sector. Tambien cambiaran las acotaciones.
* public void SetHD(boolean hd)
>mejora la grafica sualizando los bordes
*public void SetCentro (double c)
>aumenta o disminuye el centro del grafico deben ser valores tipo double entre 0 y 1 ó no se aplicara el ajuste.
       
