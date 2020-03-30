# Demo
|Integrantes|Código|
|-----------|-----------|
|Juan Felipe Herrera Poveda|20181020077|
|Juan Esteban Olaya García|20171020135|
|Juan Diego León Moreno|20171020157|

Se finalizan los patrones de diseño, se agregan sprites de bolas de fuego, se activan colisones con bolas de fuego, se agrega cofre de bonus para aumentar el puntaje, se agrega puntaje en la parte superior de la pantalla, se agrega ayuda del juego con controles.


 # DEMO V1
 # Abstract Facory
  Se utiliza la interfaz FabricaPersonaje para definir los métodos que usarán las fábricas concretas de cada personaje.
  En el packpage productos se encuentran las clases que generan la presentación de cada personaje.
  La clase gui muestra una interfaz gráfica para seleccionar e instanciar a cada personaje.
  
 ![UML](https://github.com/Juandials/Demo/blob/master/ab.png)
  
 
  # Builder
  
    Patrón implementado para generar los personajes en el juego, se cuenta con la clase director Animacion, la clase producto Personaje,
    la clase AbstractBuilder PersonajeBuilder y las builder concretos de cada tipo de personaje
    
    La clase director define el personaje que se va a crear a través del método setPersonaje(), luego la clase builder concreto
    inicializa los atributos para finalmente instanciar el producto.
    
   ![UML](https://github.com/Juandials/Demo/blob/master/b.png)
# DEMO V2 

# Decorator

La clase decorator PersonajeDecorator, y los decoradores concretos para cada personaje, la clase decorator selecciona el decorador concreto el cual instanciará un nuevo personaje con los atributos del personaje decorator.

![UML](https://github.com/Juandials/Demo2/blob/master/D.png)



# Prototype

Utilizando la interfaz ClonPersonaje que hereda de la clase Cloneable de Java se hace una copia del personaje instanciado

![UML](https://github.com/Juandials/Demo2/blob/master/p.png)

 # DEMO V3
# ChainResponsanbility

Se utiliza un manejador Hendler y dos manejadores concretos HendlerEscudo y HendlerVida, con una clase cliente Verificar, la clase cliente tomará el personaje instanciado y enviará los valores de escudo y vida a los manejadores para que los valores de vida y escudo que se muestran encima del personaje sean actualizados. 

   ![UML](https://github.com/EstebanOG/Demo_de_personajes_V3/blob/master/c.png)


# Strategy

Se utiliza Strategy Strategy y dos Strategy concretos StrategyNormal y StrategyDecorado, las estrategias son para definir la cantidad de vida que pierde el personaje dependiendo del valor del escudo.

   ![UML](https://github.com/EstebanOG/Demo_de_personajes_V3/blob/master/s.png)
  
   # DEMO V4
# State

Se utiliza un estado Estado, un contexto EstadoPersonaje y tres estados concretos moribundo, herido y vigoroso; a partir del contexto se seleccionará un estado el cual cambiará el valor de daño del personaje.

![UML](https://github.com/EstebanOG/Demo_de_personajes_V4/blob/master/st.png)

# Observer

Se utiliza un sujeto subject, un Observador AlarmaPocima y un oberver colisionPocima; cada vez que el personaje haga colison con una pocima del juego, accederá al método de colisión para ejecutar el método Update() en la lista de observadores.

![UML](https://github.com/EstebanOG/Demo_de_personajes_V4/blob/master/o.png)

