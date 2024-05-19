# TrackMoney

TrackMoney es una aplicación móvil diseñada para ayudar a los usuarios a realizar un seguimiento de sus transacciones financieras de manera eficiente y organizada. Con una interfaz intuitiva y fácil de usar, los usuarios pueden agregar, ver y administrar sus transacciones en cualquier momento y lugar.

## Características Principales

- **Gestión de Transacciones:** Permite a los usuarios agregar nuevas transacciones con etiquetas, cantidades y descripciones personalizadas.
- **Visualización de Transacciones:** Muestra una lista de todas las transacciones registradas, proporcionando una visión general clara de los gastos e ingresos.
- **Resumen Financiero:** Proporciona un resumen financiero en tiempo real que muestra el saldo total, el presupuesto y los gastos acumulados.
- **Eliminación y Restauración de Transacciones:** Permite a los usuarios eliminar transacciones con un simple deslizamiento y proporciona la opción de deshacer la acción mediante una función de "deshacer".

## Funcionalidad de la Actividad MainActivity

La MainActivity es la pantalla principal de la aplicación y realiza las siguientes funciones:

- **Visualización de Transacciones:** Muestra una lista de transacciones en un RecyclerView.
- **Interacción con Transacciones:** Permite al usuario eliminar transacciones deslizando hacia la derecha en la lista.
- **Actualización de Dashboard:** Actualiza dinámicamente el resumen financiero en la parte superior de la pantalla.
- **Adición de Transacciones:** Permite al usuario agregar nuevas transacciones haciendo clic en un botón flotante de "Agregar".

## Tecnologías Utilizadas

- **Android Jetpack:** La aplicación hace uso de componentes de Jetpack, como Room para la base de datos y RecyclerView para mostrar la lista de transacciones.
- **Room Database:** Se utiliza para almacenar y recuperar las transacciones.
- **Coroutines:** Se utilizan para realizar operaciones asincrónicas en el hilo principal.
- **Material Design Components:** Se utilizan para un diseño coherente y moderno de la interfaz de usuario, incluidos MaterialCardView y FloatingActionButton.
- **Intents:** Se utilizan para la navegación entre actividades, por ejemplo, para agregar una nueva transacción.
- **Snackbar:** Se utiliza para mostrar mensajes de retroalimentación al usuario, por ejemplo, al deshacer la eliminación de una transacción.

## Diseños

- **Layout de Actividad Principal (activity_main.xml):** Contiene un RecyclerView para mostrar las transacciones, un resumen financiero en la parte superior y un botón flotante para agregar nuevas transacciones.
- **Elemento de Lista de Transacciones (transaction_layout.xml):** Define el diseño de cada elemento de la lista de transacciones, que incluye el nombre de la transacción y su cantidad.
- **Otros Elementos de Diseño:** Se utilizan varios elementos de Material Design, como CardView, para mejorar la apariencia y la experiencia del usuario.

## Buenas Prácticas

- **Separación de Responsabilidades:** La lógica de presentación y la manipulación de datos están claramente separadas utilizando arquitectura MVVM (Modelo-Vista-VistaModelo).
- **Uso de Patrón de Repositorio:** Se utiliza el patrón de repositorio para abstraer la fuente de datos y proporcionar una capa de acceso a datos limpia.
- **Uso de Coroutines:** Se utilizan coroutines para realizar operaciones asincrónicas de forma segura y eficiente.
- **Gestión de Errores:** Se manejan los errores de forma adecuada, por ejemplo, mediante el uso de try-catch en operaciones de base de datos.
- **Optimización de UI:** Se utilizan ViewHolder y DiffUtil para optimizar el rendimiento y la actualización de la lista de transacciones.

### Pantalla Principal                              
<img src="https://github.com/KiritoMoreno/TrackMoneyApp/blob/main/MainBoard.png" style="height: 20%; width:20%;"/> 

### Agregar 
<img src="https://github.com/KiritoMoreno/TrackMoneyApp/blob/main/Add.png" style="height: 20%; width:20%;"/> 

### Actualizar
<img src="https://github.com/KiritoMoreno/TrackMoneyApp/blob/main/Update.png" style="height: 20%; width:20%;"/> 