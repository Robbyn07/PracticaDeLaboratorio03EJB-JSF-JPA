# Practica de Laboratorio 03: EJB-JSF-JPA
##	Sección Publica
#### Página de inicio:

![1](/ImagenesReadme/0.jpg?raw=true "Title")
![1](/ImagenesReadme/1.jpg?raw=true "Title")

  Cuando se inicia el proyecto, esta es la página principal, en donde se encuentra un menú de selección, que permite filtrar los productos ya sea, si se quiere ver los productos generales, los correspondientes a cada bodega o los productos agrupados por su categoría.
  
![1](/ImagenesReadme/2.jpg?raw=true "Title")
  
  Cuando se escoge una opción y se filtra, se presenta una tabla con la información de los productos encontrados, en esta tabla se presenta la información de que bodega viene, a que categoría pertenece, el nombre del producto, el precio y su stock actual.
  
![1](/ImagenesReadme/3.jpg?raw=true "Title")

  El controlador de esta página cuenta con un constructor, el cual permite presentar la información de los productos en general cuando la página recién es cargada por primera vez. 
  
![1](/ImagenesReadme/4.jpg?raw=true "Title")

  Cuando la opción es seleccionada, se invoca a este método el cual decide que método de filtrado llamara.
  
![1](/ImagenesReadme/5.jpg?raw=true "Title")

  Cuando se selecciona filtrar los productos por su categoría, se usa este método el cual busca todas las categorías del sistema, para luego agrupar los productos con sus categorías en común.
  
![1](/ImagenesReadme/6.jpg?raw=true "Title")

  Cuando se quiere visualizar los productos en general, se llama a este método el cual obtiene una búsqueda en la base de datos, tomando en cuenta únicamente los nombres del producto, es decir, no se toma en cuenta de que bodega proviene este producto.
  
![1](/ImagenesReadme/7.jpg?raw=true "Title")

  Si se selecciona una búsqueda de productos por una bodega, se llama a este método, donde recibe el nombre de la bodega, luego realiza una consulta a la base de datos para obtener todos los productos que pertenezcan a una bodega con el nombre ingresado.

### Pagina login:

![1](/ImagenesReadme/8.jpg?raw=true "Title")
![1](/ImagenesReadme/9.jpg?raw=true "Title")

  Para el inicio de sesión, se tienen dos etiquetas del tipo inputText la cuales están conectados con variables dentro de su controlador en donde se guardará su información, además se tiene un botón el cual llamara a un método para validar el correo y la contraseña.
  
![1](/ImagenesReadme/10.jpg?raw=true "Title")

  Este método verifica con la base de datos, que el correo y la contraseña corresponda con un empleado, luego se verifica sus roles para redirigir la página a una página de inicio de un empleado normal o de un administrador, según corresponda.


## Sección Privada
### Empleado
#### Gestionar clientes
#### Creación de cliente:

![1](/ImagenesReadme/11.jpg?raw=true "Title")

  Para la creación de un nuevo cliente, un empleado ingresa esta página, donde se encuentra un formulario con los campos correspondientes a la información necesaria para poder agregar un nuevo cliente a la base de datos.
  
![1](/ImagenesReadme/12.jpg?raw=true "Title")

  Cada uno de estos componentes que permiten ingresar texto está conectado con una variable dentro del controlador donde se guarda la información ingresada para posteriormente invocar al método que permite generar un nuevo cliente.
  
![1](/ImagenesReadme/13.jpg?raw=true "Title")

  Al momento de dar click en el botón de “Agregar cliente”, este método es invocado, donde se comprueba que no exista un usuario repetido, luego realiza la agregación del cliente usando los parámetros ingresados en la vista.

#### Editar cliente:

![1](/ImagenesReadme/14.jpg?raw=true "Title")

  Cuando un empleado requiere editar la información de un cliente, se ingresa a esta página, donde se necesita ingresar la cedula del cliente para verificar que el cliente existe.
  
![1](/ImagenesReadme/15.jpg?raw=true "Title")
![1](/ImagenesReadme/16.jpg?raw=true "Title")

  Cuando se invoca al método para buscar un cliente y lo hace, mediante ajax se despliega un menú con la información actual del cliente para posteriormente modificarla.
  
![1](/ImagenesReadme/17.jpg?raw=true "Title")
![1](/ImagenesReadme/18.jpg?raw=true "Title")

  Una vez se da click para editar el cliente, se obtiene el cliente y se ingresan los nuevos datos, para así posteriormente llamar al método que permite actualizar los datos a nivel de la base de datos.

#### Eliminar cliente:

![1](/ImagenesReadme/19.jpg?raw=true "Title")
![1](/ImagenesReadme/20.jpg?raw=true "Title")

  Para que un empleado elimine un cliente, ingresa a esta página, donde se listan todos los clientes que no han sido eliminados, para realizar esto, se una un dataTable la cual se conecta con una lista de usuarios dentro del controlador.
  
![1](/ImagenesReadme/21.jpg?raw=true "Title")

  Cuando se ingresa a esta página, se llama a este método, el cual busca a todos os clientes habilitados, para luego guardarlo en una lista que usara la vista para poder listar estos clientes dentro de una tabla.
  
![1](/ImagenesReadme/22.jpg?raw=true "Title")

  Cuando un cliente es mandado a eliminar, se llama a este método, donde recibe a la persona elegida para luego cambiar su estado a deshabilitado, luego se manda a actualizar la información del cliente en la base de datos.

#### Gestión de facturas
#### Generación de factura:

![1](/ImagenesReadme/23.jpg?raw=true "Title")
![1](/ImagenesReadme/24.jpg?raw=true "Title")
![1](/ImagenesReadme/25.jpg?raw=true "Title")
![1](/ImagenesReadme/26.jpg?raw=true "Title")
![1](/ImagenesReadme/27.jpg?raw=true "Title")

  Para generar la factura, se implementa campos para ingresar la cedula del cliente y poder presentar la información del mismo.
  
![1](/ImagenesReadme/28.jpg?raw=true "Title")
![1](/ImagenesReadme/29.jpg?raw=true "Title")

  Para seleccionar un producto que se quiere en la factura este se puede filtrar por la bodega que le parezca conveniente al cliente, además, se puede buscar el producto por el nombre, para así agilizar la agregación de un detalle a la factura.
  
![1](/ImagenesReadme/30.jpg?raw=true "Title")
![1](/ImagenesReadme/31.jpg?raw=true "Title")

  También, se presenta una tabla con la información de los productos existentes o filtrados para agregar la cantidad que el cliente desea comprar, luego se presenta un botón que envía la información para agregar el detalle de la compra.
  
![1](/ImagenesReadme/32.jpg?raw=true "Title")
![1](/ImagenesReadme/33.jpg?raw=true "Title")
![1](/ImagenesReadme/34.jpg?raw=true "Title")
![1](/ImagenesReadme/35.jpg?raw=true "Title")

  Para finalizar la vista de esta página, se muestra una tabla con todos los detalles de los productos que se desean comprar y la información del subtotal, IVA y total que costara la compra final.
  
![1](/ImagenesReadme/36.jpg?raw=true "Title")

  Cuando se carga la página, se llama a un método que permite obtener las bodegas existentes y guarda la información en una variable.
  
![1](/ImagenesReadme/37.jpg?raw=true "Title")

  Cuando se filtra la información, el método dentro del controlador, si no existe un producto en específico, el método busca todos los productos de la bodega seleccionada y los guarda en una lista que usara la vista para presentarlos dentro de una tabla, no obstante, si se ingresa información de un producto que se desea buscar, el nombre ingresado se busca en la base de datos, completando el nombre si este no lo está, luego lo devuelve y lo filtra para obtener el producto correspondiente de la bodega adecuada. 
  
![1](/ImagenesReadme/38.jpg?raw=true "Title")

  Para buscar al cliente que realizara la factura, este método usa una variable que contiene la información ingresada en la vista sobre la cedula del cliente, luego realiza una consulta a la base de datos para encontrar al cliente correspondiente y, para finalizar esta información se guarda en distintas variables para que se presente en la vista.
  
![1](/ImagenesReadme/39.jpg?raw=true "Title")

  Cuando se desea agregar un detalle a la factura, este método recibe el producto seleccionado, para luego crear un detalle con la información del stock uy del producto que se generó, además, este método actualiza la información de la cabecera de la factura sobre el subtotal, IVA y total a pagar.
  
![1](/ImagenesReadme/40.jpg?raw=true "Title")

  Cuando se desea terminar de realizar la factura, se ingresan los datos restantes correspondientes a la cabecera de la factura, además, se edita el stock de los productos seleccionados y, para terminar, se genera la factura al cliente correspondiente.

#### Anular factura:

![1](/ImagenesReadme/41.jpg?raw=true "Title")
![1](/ImagenesReadme/42.jpg?raw=true "Title")

  Para realizar la anulación de una factura, esta página implementa 2 métodos de búsqueda de la factura, la primera mediante la cedula del cliente para listar todas sus facturas y escoger la que se desea eliminar: y la segunda es mediante el código de la factura, en el caso de que el cliente viene con su factura física, la búsqueda se agiliza y se encuentra su factura.
  
![1](/ImagenesReadme/43.jpg?raw=true "Title")

  Cuando se encuentra una o varias facturas, sus cabeceras son presentadas en una tabla, donde se ve la información general de la factura, además, se implementa un botón que permite visualizar los detalles de la factura seleccionada.
  
![1](/ImagenesReadme/44.jpg?raw=true "Title")

  Esta tabla muestra la información del detalle de una factura, la información presentada es sobre la bodega de la cual proviene el producto, el producto en mención, la cantidad pedido y el precio que representa.
  
![1](/ImagenesReadme/45.jpg?raw=true "Title")

  Cuando se decide buscar facturas por cedula, se invoca este método, donde realiza un pedido a la base de datos para buscar todas las facturas cabeceras relacionadas con la cedula del cliente, para luego esta información guardarla en una lista y mostrarla en una tabla.
  
![1](/ImagenesReadme/46.jpg?raw=true "Title")

  Cuando se decide buscar una factura por su código, se realiza una consulta en la base de datos para obtener esa factura en específico y presentarla en la tabla correspondiente en la página web, además, los detalles de la factura son guardados en una lista para presentarlos directamente en la vista.
  
![1](/ImagenesReadme/47.jpg?raw=true "Title")

  Cuando se desea ver el detalle de una factura en específico, se invoca este método, el cual obtiene la información que factura es escogida, para luego guardar la información de sus detalles en una lista y presentarlos en la vista dentro de una tabla.
  
![1](/ImagenesReadme/48.jpg?raw=true "Title")

  Cuando se desea anular una factura, este método es llamado, donde obtiene la información de la factura seleccionada, cambia su estado a un estado de anulado y realiza una actualización de la información en la base de datos.

####  Buscar facturas:

![1](/ImagenesReadme/49.jpg?raw=true "Title")
![1](/ImagenesReadme/50.jpg?raw=true "Title")
![1](/ImagenesReadme/51.jpg?raw=true "Title")
![1](/ImagenesReadme/52.jpg?raw=true "Title")

  Cuando se desea únicamente buscar alguna factura, se implementó una página similar a la página de eliminación de un producto, con la única diferencia que esta página no cuenta con la posibilidad de anular una factura.
  
![1](/ImagenesReadme/53.jpg?raw=true "Title")

  De igual forma, los métodos dedicados a la búsqueda y presentación de la información en esta página son reutilizados de la página de anulación de factura, exceptuando el método de anulación, puesto que esta página no cuenta con esta posibilidad.


### Administrador
#### Gestión de Bodegas
#### Consulta de Inventario General 

![1](/ImagenesReadme/54.jpg?raw=true "Title") 
 
  En esta página podemos obtenemos el listado general de los productos de todas las bodegas, donde tenemos la categoría de los productos, los atributos básicos del producto como es el nombre, precio, stock.
  
![1](/ImagenesReadme/55.jpg?raw=true "Title")
![1](/ImagenesReadme/56.jpg?raw=true "Title")

  Para su funcionamiento, tenemos la parte .xhtml y .class, en la parte de .class tenemos el @PostContruct donde mandamos a cargar el listado de los productos generales, donde invoca al método buscarProductosGeneral, el cual obtiene un listado de productos con respecto a su bodega y la sumatoria de su stock en caso de ser el mismo producto.

#### Editar Bodega

![1](/ImagenesReadme/57.jpg?raw=true "Title") 
 
  En la parte de la interfaz témenos tenemos un campo donde ingresamos el nombre de la bodega a editar, lo que nos presenta son los datos de la bodega es la provincia, ciudad, nombre y dirección, los cuales podemos editar.
  
![1](/ImagenesReadme/58.jpg?raw=true "Title")
![1](/ImagenesReadme/59.jpg?raw=true "Title")
![1](/ImagenesReadme/60.jpg?raw=true "Title")

  En la sección del controlador tenemos la parte de xhtml en donde se expone los campos que se presentaran en la parte gráfica, así mismo los inputs correspondientes para editar los atributos de la bodega.
  Estos datos son enviados al controlador en donde tenemos dos métodos de búsqueda y la de editar los cuales son invocados desde el xhtml.

#### Gestión de Productos
#### Agregar Producto

![1](/ImagenesReadme/61.jpg?raw=true "Title")

  La interfaz gráfica presenta los diferentes campos para agregar un producto, como son el nombre, su precio, el stock, la posibilidad de desplegar todas las categorías existentes en la base de datos así mismo la posibilidad de desplegar las bodegas registradas en la base de datos.
  
![1](/ImagenesReadme/62.jpg?raw=true "Title")
![1](/ImagenesReadme/63.jpg?raw=true "Title")

  En el @PostContruct definimos los parámetros a ejecutarse antes de que cargue la página, esto para poder mandar a setear los parámetros que recibe el xhtml.
  
![1](/ImagenesReadme/64.jpg?raw=true "Title")

  En el xhtml tenemos los diferentes inputs que corresponden a los diferentes atributos del producto, una vez llenados e invocar el botón agregar producto esto se va al controlador donde están os diferentes métodos para la agregación del producto y la invocación de todas las categorías y bodega. 

#### Gestionar Productos Por Bodega

![1](/ImagenesReadme/65.jpg?raw=true "Title")

  Para la gestión de los productos por bodega, tenemos un buscador donde podemos buscar los productos por la bodega seleccionada.
  
![1](/ImagenesReadme/66.jpg?raw=true "Title")

  Una vez realizada la búsqueda nos presenta los atributos de los productos los cuales podemos editarlos o simplemente eliminar el producto de la bodega.
  
![1](/ImagenesReadme/67.jpg?raw=true "Title")

  Para tener el listado de las bodegas existentes en la base tenemos la invocación al método de opciones, el cual nos devuelve un listado de las bodegas.
  
![1](/ImagenesReadme/68.jpg?raw=true "Title")

  Una vez que realizamos la busque de la bodega que queremos, tenemos la invocación al listado de productos, el cual contiene un listado de los productos seleccionados por la bodega enviada.
  El botón de editar invoca al método editar() el cual toma los datos seteados de los inputs y los toma el controlador.
  Para la eliminación de del producto, simplemente envía el objeto producto seleccionado de la lista de productos y lo envía al controlador.
  
![1](/ImagenesReadme/69.jpg?raw=true "Title")

  Como primer parte del controlador para la gestión de los productos por bodega, tenemos el postcontruct que es lo que se ejecuta primero antes de cargar la página, dentro de este método constructor() tenemos la invocación para buscar todas las bodegas existentes en la base de datos, también la búsqueda de los productos de la primera bodega registrada en la base. 
  
![1](/ImagenesReadme/70.jpg?raw=true "Title")

  Para el caso de eliminar o editar el producto seleccionado, se invocarían a estos dos métodos de la imagen, en donde recibe como parámetro una variable del tipo Producto, esto para tener la referencia y acceso a todas sus variables, posteriormente se envía a los diferentes métodos donde se ejecutan sentencias jpql.


## Reglas de Navegación y Error
### Navegación

![1](/ImagenesReadme/71.jpg?raw=true "Title")

  Para la implementación de las reglas de navegación se modifica el archivo faces-config.xml que se sitúa dentro de la carpeta web-inf del proyecto, en la imagen podemos apreciar la regla de navegación de login en donde se especifica el nombre de referencia para la redirección hacia otra página, como se muestra en la imagen el nombre de referencia inicioPrincipal nos redireccionaría hacia la página inicio.xhtml

### Pagina de Error

![1](/ImagenesReadme/72.jpg?raw=true "Title")

  El error 404 se presenta cuando no encuentra la pagina de destino o alguna búsqueda realizada.
  
![1](/ImagenesReadme/73.jpg?raw=true "Title")

  Para la implementación de este error se debe editar el archivo web.xml que se encuentra dentro de la carpeta webcontent del proyecto.
  
![1](/ImagenesReadme/74.jpg?raw=true "Title")

  El error 500 se presenta cuando se detecta un error de ejecución de código dentro del xhtml
  
![1](/ImagenesReadme/75.jpg?raw=true "Title")

  De la misma manera que para el error 404, editamos el archivo web.xml para la implementación del error 500.
