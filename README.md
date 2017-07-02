# JPLOT (android Y WindowsMobile10)
JPLOT  es una librería para graficar Puntos(x,y) ya sea graficos estáticos o Series de tiempo, gráficos circulares y de barras . Esta libreria es para Android y Windows mobile 10(en desarrollo). Existen varias librerias para graficar datos en android como AchartEngine, GraphView ,AndroidPlot, AFreeChart etc. ¿porque jplot? "ES LA MAS SIMPLE DE USAR Con 3 lineas ya se tiene un gráfico" Alta personalización en los gráficos y buena estética, además esta en Español.

proximas implementaciones:
-plano polar
-coordendas geograficas latitud longitud sobre mapamundi
-grafico de burbujas



![GitHub Logo](/imagenes/SerieContinua.png)
![GitHub Logo](/imagenes/seriePuntos.png)
![GitHub Logo](/imagenes/pastel.png)
![GitHub Logo](/imagenes/BC.png)
![GitHub Logo](/imagenes/BCA.png)
![GitHub Logo](/imagenes/BCAPI.png)
![GitHub Logo](/imagenes/BCAPI100.png)


# Como Agregar a mi proyecto Android Studio
puedes ver el procedimiento en youtube: https://www.youtube.com/watch?v=PmizMdG3E48&t=59s
1. descarga el proyecto y extrae "jplot1.0.aar" que esta dentro de la carpeta "Libreria Jplot"
2. en tu proyecto click derecho sobre app, new-module, "import .jar/.aar package", agregar el archivo "jplot1.0.aar"
![GitHub Logo](/imagenes/p1.png)
3. en tu proyecto click derecho sobre app, "open module settings", app-dependencies, Add-"Module dependency", jplot1.0-"clik ok".   
![GitHub Logo](/imagenes/p2.png)
4. ya puedes crear el primer gráfico ya se estatico o dinámico, circular o de barras.
#  Gráfico con Series de Puntos (x,y)
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
           context=this;
           pantalla= (LinearLayout) (findViewById(R.id.pantalla));
           
           X=new float[4]; Y=new float[4];// si se desean graficar datos tipo double debe convertirse de "double a float"
           X[0]=3.4f;Y[0]=2.5f;
           X[1]=11.3f;Y[1]=6.6f;
           X[2]=12.4f;Y[2]=7.6f:
           X[3]=20.9f;Y[3]=10.4f;
           plot = new PlotPlanitoXY(context,"Titulo principal del grafico","titulo eje x","titulo eje y");
           plot.SetSerie1(X,Y,"graph 1",5,true);// el 5 es el tamaño de punto "true" es para unir los puntos 
                                                //con una linea
           /*antes de mostrar el grafico en pantalla(LinearLayout) deben de ir todos los ajustes "Set" del grafico.
           Todos los metodos publicos que ayudan a personalizar el grafico se describen cada uno en la siguiente sección */
           
           plot.SetHD(true); //ajustamos la calidad hd que suaviza bordes del grafico. por default esta desactivado 
           plot.SetTouch(true);// activa el touch sobre el grafico no es necesario colocarlo ya que por default esta activado  
           pantalla.addView(plot);                                     
         }
      }
      
 Run app y !LISTO!         
          
### Gráfico Dinámico (Serie de Tiempo)
 
 revisar el codigo ejemplo que esta en la carpeta "Ejemplos usando Jplot"


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

Los siguientes métodos ajustan colores en el gráfico reciben 3 parámetros de tipo entero r=rojo, g=verde, b=azul el color de fondo recibe un parametro mas "int a" a define la transparencia del fondo.
* public void SetColorFondo(int a,int r,int g,int b)      
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



# Gráfico de Pastelito

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
        context=this;
        pantalla= (LinearLayout) (findViewById(R.id.pantalla));
        pastel=new PlotPastelito(context,"Ganancias Diarias");//puedes usar simplemente "this" en lugar de context  
        float[] datapoints = {2,5,8,11,23,7,16};
        String[] etiquetas={"lunes", "martes", "miercoles","jueves","viernes","sabado","domingo"};
        pastel.SetDatos(datapoints,etiquetas);
        
       /*antes de mostrar el grafico en pantalla(LinearLayout) deben de ir todos los ajustes "Set" del grafico.
           Todos los metodos publicos que ayudan a personalizar el grafico se describen cada uno en la siguiente sección */
           
        pastel.SetHD(true); //ajustamos la calidad hd que suaviza bordes del grafico. por default esta desactivado
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
*  public void SetColorDato(int dato,int r,int g,int b)
>cambia el color de una rebanada del gráfico circular que corresponde a "dato" el color se ajusta al proporcionar r,g,b.
*public void SetColorContorno(int r,int g,int b)
>cambia el color del contorno del grafico que es el espacio entre cada rebana y del circulo que encierra el gráfico.

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
* public void SetCentro (double c)
>aumenta o disminuye el centro del grafico deben ser valores tipo double entre 0 y 1 ó no se aplicara el ajuste.
       
# Gráfico de Barras


## Columnas


 en activity_main.xml agregar;
    
     <LinearLayout
            android:id="@+id/pantalla"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="horizontal">
            
     </LinearLayout>
     

 En MainActivity.java agregar 
 

     import com.juang.jplot.PlotBarritas;
    
     public class MainActivity extends AppCompatActivity {
    
     PlotBarritas Columna;
     Context context;
     
     @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        pantalla= (LinearLayout) (findViewById(R.id.pantalla));
        
        String x[]={"lunes","martes","miercoles","jueves","viernes"};
        double y[]={20,30,44,0,-25};
        Columna=new PlotBarritas(context,"Gráfico de Columnas ","articulos vendidos por dia");
                                //en context puede colocarse simplemente this
        //personalizacion del grafico
        Columna.Columna(x,y);// OJO x e y DEBEN SER DEL MISMO TAMAÑO O CAUSARA QUE SE CIERRE LA APLICACION.
        Columna.SetHD(true);
        //cambiemos el color del dato 3 o sea "44" rojo=255,verde=0,Azul=0 los ultimos tres enteros son los colores en rgb
        Columna.SetColorPila(3,255,0,0);//muestra el tercer dato en color rojo

        //mostrando en pantalla
        pantalla.removeAllViews();
        pantalla.addView(Columna);
        
       
        
        }
      }
      
 El resultado es 
 ![GitHub Logo](/imagenes/bc.png)
           
      
## Columnas agrupadas


## Columnas apiladas



## Columnas apiladas al 100%
 
     
     

