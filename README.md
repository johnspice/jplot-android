# JPLOT [android(java) - IOS (swift)]
JPLOT  es una librería .aar para graficar Puntos(x,y) ya sea graficos estáticos o Series de tiempo, gráficos circulares y de barras . Esta libreria es para Android y Windows mobile 10(cancelada) IOS(en construccion). Existen varias librerias para graficar datos en android como AchartEngine, GraphView ,AndroidPlot, AFreeChart etc. ¿porque jplot? "ES LA MAS SIMPLE DE USAR Con 3 lineas ya se tiene un gráfico" Alta personalización en los gráficos y buena estética, además esta en Español.

![GitHub Logo](/imagenes/fondo0.png)
![GitHub Logo](/imagenes/muestra2.png)
![GitHub Logo](/imagenes/muestra3.png)
![GitHub Logo](/imagenes/midlecircle.gif)


APPS QUE USAN JPLOT.
* https://play.google.com/store/apps/details?id=com.troyasoft.pro.serialplot&hl=es_419
* https://play.google.com/store/apps/details?id=fourierfft.pro.troyapps.com.fourierfft&hl=es_419

proximas implementaciones:
* plano polar
* Graficos usando dias o meses
* Reconocimiento y evaluación de funciones del tipo "2*x+3*cos(3*x+2)" ->(ya esta implementado revisa la wiki)
* grafico de burbujas
* Todos graficos podran aceptar texturas para mejorar las graficas ->(ya implementado para los fondos de los graficos) 
* LA IMPLEMENTACION DE JPLOT PARA IOS CON SWIFT ESTA en construccion.
![GitHub Logo](/imagenes/iphone.png)

# Agregar a mi proyecto Android Studio
## usando Gradle
en el archivo build.gradle(:app) agrega lo siguiente 


    
    repositories {
        maven {
            url "https://dl.cloudsmith.io/public/troysoft/jplot/maven/"
        }
    }

    dependencies {
      implementation 'com.gabrielopez.plot:jplot:1.7'
    }


## Descargando el archivo .aar
puedes ver el procedimiento en youtube: https://www.youtube.com/watch?v=PmizMdG3E48&t=59s
1. clona el proyecto y extrae "jplot1.7.aar" que esta dentro de la carpeta "Libreria Jplot"
2. copia "jplot1.7.aar" dentro de tu proyecto:  yourProject/app/libs  debe tener la siguiente ubicacion:
![GitHub Logo](/imagenes/paso1.png)
3. en tu proyecto click derecho sobre app, "open module settings",app-dependencies, Add "Jar-Dependency", escribe libs, ok, apply-ok.   
![GitHub Logo](/imagenes/paso2.png)
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
           X[2]=12.4f;Y[2]=7.6f;
           X[3]=20.9f;Y[3]=10.4f;
           plot = new PlotPlanitoXY(context,"Titulo principal del grafico","titulo eje x","titulo eje y");
           plot.SetSerie1(X,Y,"graph 1",5,true);// el 5 es el tamaño de punto "true" es para unir los puntos 
                                                //con una linea
           /*antes de mostrar el grafico en pantalla(LinearLayout) deben de ir todos los ajustes "Set" del grafico.
           Todos los metodos publicos que ayudan a personalizar el grafico se describen cada uno en la siguiente sección */
           
           /*
           //agregando imagem.png al fondo de la cuadricula que esta en la carpeta "drawable" del proyecto.
           Drawable myDrawable = getResources().getDrawable(R.drawable.fneon);//debe cambiarse "fneon" por tu imagen
           Bitmap myFondo = ((BitmapDrawable) myDrawable).getBitmap();
           plot.SetImagFondo1(myFondo);
           */
           
           plot.SetHD(true); //ajustamos la calidad hd que suaviza bordes del grafico. por default esta desactivado 
           plot.SetTouch(true);// activa el touch sobre el grafico no es necesario colocarlo ya que por default esta activado  
           pantalla.addView(plot);                                     
         }
      }
      
 Run app y !LISTO!         
          
### Gráfico Dinámico (Serie de Tiempo)
 
 revisar el codigo ejemplo que esta en la carpeta "Ejemplos usando Jplot"


### Métodos Publicos que ayudan a configurar el Gráfico de puntos (x,y) 
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
* public void SetImagFondo0(Bitmap b)
>ajusta un Bitmap al Fondo de todo el gráfico cubriendo todo el layout donde esta contenido.
![GitHub Logo](/imagenes/fondo00.png)
* public void SetImagFondo1(Bitmap b)
>ajusta un Bitmap al Fondo del gráfico, pero solo la cuadricula
![GitHub Logo](/imagenes/fondo11.png)



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
      
  
         
     

### Métodos Publicos que ayudan a configurar el gráfico de Pastel
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
* public void SetColorDato(int dato,int r,int g,int b)
>cambia el color de una rebanada del gráfico circular que corresponde a "dato" el color se ajusta al proporcionar r,g,b.
* public void SetColorContorno(int r,int g,int b)
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
* public void SetImagFondo(Bitmap b)
>ajusta una imagen de fondo, pasandole un bitmap. el bitmap puede obtenerse de los recursos en la aplicacion ejemplo:
    Drawable myDrawable = getResources().getDrawable(R.drawable.fondo);
    Bitmap myFondo = ((BitmapDrawable) myDrawable).getBitmap();
    fondo debe cambiarse por tu imagen que esta en la carpeta res/drawable de tu proyecto, myFondo ya puede ser pasado al metodo.
* public void SetImagFondoCentro(Bitmap b)
>ajusta imagen de fondo unicamente al centro del circulo del pastelito. Recibe bitmap igual que el metodo "SetImagFondo" 
       
# Gráfico de Barras
hay codigo fuente para android studio de ejemplo en la carpeta "Ejemplos usando Jplot" descargalo y encontraras los 4 ejemplos de gráfico de barras posibles.

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
    
    import com.juang.jplot.PlotBarritas;
    
     public class MainActivity extends AppCompatActivity {
    
     PlotBarritas ColumnaAgrupada;
     
     @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        pantalla= (LinearLayout) (findViewById(R.id.pantalla));
        String x[]={"lunes","martes","miercoles","jueves","viernes","sabado","domingo"};
        String Acota[]={"jeans","shorts","shoes"};
        double y[][]={{2 ,3,1},//y[][]  define un array de 7 grupos con 3 columnas  puede ser de y[i][j] con i,j cualquier entero
                      {5 ,2,5},
                      {1,3,2},
                      {0 ,3,1},
                      {2 ,4,-1},
                      {2 ,0,-1},
                      {2 ,1,-1}};

        ColumnaAgrupada=new PlotBarritas(this,"Gráfico de Columnas Agrupadas","articulos vendidos por dia");

        //personalizacion de grafico
        ColumnaAgrupada.ColumnaAgrupada(x,y,Acota); /*OJO x[] debe tener tamaño i e Acota[] tamaño j. i=filas de y[][] e j=columnas             de y [][]. para este caso i=7 y j=3. si no se tiene cuidado con los tamaño puede provocar errores o que se cierre la app */
        ColumnaAgrupada.SetSizeAcot(15);
        ColumnaAgrupada.SetSizeTitulo(20);
        ColumnaAgrupada.SetSizeTituloY(12);
        ColumnaAgrupada.SetHD(true);
        ColumnaAgrupada.SetColorContorno(255,0,0);//contorno en rojo
        ColumnaAgrupada.SetColorPila(2,255,0,0);//segunda columna de grupo en rojo

        pantalla.removeAllViews();
        pantalla.addView(ColumnaAgrupada);
        
       }
      } 


El resultado es 
 ![GitHub Logo](/imagenes/bca.png)
 
  

## Columnas apiladas

     import com.juang.jplot.PlotBarritas;
    
     public class MainActivity extends AppCompatActivity {
    
     PlotBarritas     ColumnaApilada;
     
     @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        pantalla= (LinearLayout) (findViewById(R.id.pantalla));

        String x[]={"lunes","martes","miercoles","jueves","viernes","sabado","domingo"};
        String Acota[]={"jeans","shorts","shoes"};
        double y[][]={{2 ,3,1},//y[7]{3]  define un array de 7 grupos con 3 columnas  puede ser de y[n][m] con n,m cualquier entero
                      {5 ,2,5},
                      {1,3,2},
                      {0 ,3,1},
                      {2 ,4,-1},
                      {2 ,0,-1},
                      {2 ,1,-1}};

        ColumnaApilada=new PlotBarritas(this,"Gráfico de Columnas Apiladas","articulos vendidos por dia");

        //personalizacion de grafico
        ColumnaApilada.ColumnaApilada(x,y,Acota);/*OJO x[] debe tener tamaño i e Acota[] tamaño j. i=filas de y[][] e j=columnas                 de y [][]. para este caso i=7 y j=3. si no se tiene cuidado con los tamaño puede provocar errores o que se cierre la app */
        
        ColumnaApilada.SetHD(true);
        ColumnaApilada.SetColorContorno(255,0,2355);//contorno en magenta
        ColumnaApilada.SetColorPila(1,0,0,255);//primer pila de columna en azul  recordar que los ultimos 3 enteros son rgb
        ColumnaApilada.SetColorPila(2,0,255,255);//segunda pila de columna en cyan  recordar que los ultimos 3 enteros son rgb
        //puede elegirse el color hasta la pila 44 si es mayor sera generado aleatoriamente

        pantalla.removeAllViews();
        pantalla.addView(ColumnaApilada);
        
       }
      } 


El resultado es 
 ![GitHub Logo](/imagenes/bcapi100.png)


## Columnas apiladas al 100%

     import com.juang.jplot.PlotBarritas;
    
     public class MainActivity extends AppCompatActivity {
    
     PlotBarritas     ColumnaApilada100;
     
     @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        pantalla= (LinearLayout) (findViewById(R.id.pantalla));
        
         String x[]={"lunes","martes","miercoles","jueves","viernes","sabado","domingo"};
        String Acota[]={"jeans","shorts","shoes"};
        double y[][]={{2 ,3,1},//y[7]{3]  defina un array de 7 grupos con 3 columnas  puede ser de y[n][m] con n,m cualquier entero
                {5 ,2,5},
                {1,3,2},
                {0 ,3,1},
                {2 ,4,-1},
                {2 ,0,-1},
                {2 ,1,-1}};
        ColumnaApilada100=new PlotBarritas(this,"Gráfico de Columnas Apiladas al 100%","articulos vendidos por dia");

        //personalizacion de grafico
        ColumnaApilada100.ColumnaApilada100(x,y,Acota);/*OJO x[] debe tener tamaño i e Acota[] tamaño j. i=filas de y[][] e j=columnas           de y [][]. para este caso i=7 y j=3. si no se tiene cuidado con los tamaño puede provocar errores o que se cierre la app */
        
        ColumnaApilada100.SetHD(true);
        ColumnaApilada100.SetContorno(0);/*sin contorno mayor a cero aparece el contorno por default es blanco a este metodo solo debe           pasarsele un valor entre 0 y 10 mayor a eso no se toma en cuenta*/
        ColumnaApilada100.SetColorPila(1,255,105,180);//primera pila de columna de color hot pink
        ColumnaApilada100.SetColorPila(2,255,255,0);//segunda pila de columna de color amarillo
        
        pantalla.removeAllViews();
        pantalla.addView(ColumnaApilada100);
              
       }
     }  
 
 El resultado es 
 ![GitHub Logo](/imagenes/bcapi.png)    
 
### Métodos Publicos que ayudan a configurar los Graficos de Barras
 
* public void SetTitulo(String t)
>Ajusta el titulo principal del grafico recibe String con el titulo.
* public void SetSizeTitulo(int z)
>ajusta el tamaño del Titulo principal, recibe entero z tal que 6<z<51, si se pasa otro valor de z se asignara por default z=26
* public void SetSizeTextX(int z)
>ajusta el tamaño del texto del ejeX, recibe entero z tal que, 6<z<26. si pasa otro valor de z se asiganra por default z=11 
* public void SetSizeNumbersY(int z)
>ajusta el tañano del texto en el ejeY (escala), recibe entero z tal que 6<z<26, si se pasa otro valor de z se asignara por default z=11
* public void SetSizeTituloY(int z)
>ajusta el tañano del titulo del ejeY, recibe entero z tal que 6<z<41, si se pasa otro valor de z se asignara por default z=16
* public void SetSizeAcot(int z)
>ajusta tamaño de las acotaciones, recibe entero z tal que 6<z<26, si se pasa otro valor de z se asignara por default z=10 
* public void SetValuePorcent(char vp)(Solo aplica para barras apiladas al 100%)
>recibe una char 'v' ó 'p'. Si se pasa 'v' pondrá en cada barra el valor que representa esa barra, si recibe 'p' mostrara en las barras el tanto porciento que representa cada barra.
* public void SetHD(boolean hd)
>ajusta el dibujado haciendo un alisamiento en los bordes al dibujar, para suavizar los dibujos. recibe booleano true o false.
* public void SetColorTextX(int r,int g, int b)
>ajusta el color al texto en el ejeX, recibe tres enteros r,g,b deben ser valores entre 0 y 255.
* public void SetColorFondo(int a,int r,int g,int b)
>ajusta color de fondo, solo si no se ajusto el metodo "SetImagFondo0". recibe 3 enteros de color RGB.
* public void SetColorNumbersY(int r,int g, int b)
>ajusta color de los numeros(escala) en el ejeY. recibe 3 enteros de color RGB.
* public void SetColorLineasY(int r,int g,int b)
>ajusta color de las lineas(escala) en el ejeY. recibe 3 enteros de color RGB.
* public void SetColorTitulo(int r,int g, int b)
>ajusta color del titulo principal. Recibe 3 enteros de color RGB.
* public void SetColorTituloY(int r,int g, int b)
>ajusta el color al titulo del ejeY. Recibe 3 colores RGB.
* public void SetColorAcot(int r,int g,int b)
>ajusta el color de las acotaciones. Recibe 3 colores RGB.
* public void SetColorEjeX(int r,int g,int b)
> ajusta el color del texto(escala o texto) del ejeX. Recibe 3 colores RGB.
* public void SetColorTextBarras(int r,int g,int b)
>ajusta el color del texto en las barras que muestra el valor numerico que representa la barra. Recibe 3 colores RGB.
* public void SetColorContorno(int r,int g,int b)
>ajusta el color del contorno de cada barra. Recibe 3 colores RGB.
* public void SetColorPila(int i,int r,int g,int b)
>cambia el color del dato "i" o columna "i" pasabdole el color en RGB. 
* public void SetContorno(int w)
>ajusta el grueso del controno de las barras si recibe un w=0 no tendran contorno las barras 
* public void SetTouch(boolean t)
>activa o desactiva el touch en pantalla. recibe booleano true o false.
* public void SetImagFondo0(Bitmap b)
>ajusta una imagen de fondo, pasandole un bitmap. el bitmap puede obtenerse de los recursos en la aplicacion ejemplo:
    Drawable myDrawable = getResources().getDrawable(R.drawable.fneon);
    Bitmap myFondo = ((BitmapDrawable) myDrawable).getBitmap();
fneon debe cambiarse por tu imagen que esta en la carpeta res/drawable de tu proyecto, myFondo ya puede ser pasado al metodo.
* public void SetImagFondo1(Bitmap b)
>ajusta imagen de fondo unicamente a la cuadricula. recibe un bitmap.
 

     

