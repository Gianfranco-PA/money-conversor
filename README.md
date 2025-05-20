# Money conversor

## Descripción y características

Money Conversor es una aplicación de consola que permite convertir montos entre diferentes divisas usando la API pública de ExchangeRate-API, con un menú interactivo que incluye accesos directos para conversiones frecuentes, cacheo de resultados para reducir llamadas a la API, soporte para selección manual de divisa origen y destino, obtención dinámica de códigos de divisas y tipos de cambio, una interfaz intuitiva basada en consola, configuración externa mediante archivo de propiedades y una arquitectura MVC que separa responsabilidades.

## Requisitos

* Java 11 o superior
* [Gradle](https://gradle.org/) (wrapper incluido)
* Conexión a Internet para acceder a la API de tipos de cambio
* Clave (API key) de ExchangeRate-API (gratuita con registro)

## Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tu_usuario/gianfranco-pa-money-conversor.git
   cd gianfranco-pa-money-conversor
   ```
2. Compila el proyecto con Gradle:

   ```bash
   ./gradlew build
   ```

## Configuración

1. Renombra el archivo de ejemplo `config.properties.example` a `config.properties` en `src/main/resources` (o donde esté en el classpath).
2. Rellena tus credenciales y divisas deseadas:

   ```properties
   # Archivo: config.properties
   exchange.rate.api.key=TU_API_KEY_AQUI
   exchange.rate.api.codes=USD,PEN,MXN,ARS,COP,BRL,CLP,BOB
   ```

    * `exchange.rate.api.key`: tu clave de acceso a la API.
    * `exchange.rate.api.codes`: lista de códigos de divisas separadas por comas.

## Uso

Ejecuta la aplicación desde el directorio raíz:

```bash
./gradlew run
```

Sigue las instrucciones en pantalla para:

1. Seleccionar un acceso directo o escoger manualmente la divisa origen y destino.
2. Introducir el monto a convertir.
3. Ver el resultado y presionar Enter para continuar.

## Images
**Interfaz de menu:**

![Menu](/docs/menu.png)

**Interfaz de resultados:**

![Result](/docs/result.png)

**Interfaz de elección de divisas:**

![Menu](/docs/choice.png)