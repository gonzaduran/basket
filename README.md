Basketball Score App - README
Descripción del Proyecto
Tablero Basketball es una aplicación Android desarrollada como proyecto final del primer trimestre. Permite gestionar el marcador de un partido de baloncesto en tiempo real, con funcionalidades completas de puntuación, validación y visualización de resultados finales.
Funcionalidades Principales
MainActivity - Gestión de Marcador

Puntuación por equipos: Marcadores independientes para equipo Local y Visitante
Suma de puntos: Botones +1 y +2 para incrementar el marcador
Resta de puntos: Botón -1 con validación (no permite valores negativos)
Reset del partido: Icono de reloj para reiniciar ambos marcadores a 0
Navegación: Flecha para acceder a la pantalla de resultados finales

ScoreActivity - Pantalla de Resultados

Visualización del marcador final: Formato claro "X - Y"
Cálculo automático del ganador: Detecta victoria local, visitante o empate
Mensajes contextuales: Presenta el resultado de forma clara y comprensible

Tecnologías y Conceptos Aplicados
Data Binding

Eliminación completa de findViewById()
Acceso optimizado a vistas mediante binding generado automáticamente
Mejora en rendimiento, seguridad de tipos y legibilidad del código

Implementación:
java// Configuración en onCreate
binding = ActivityMainBinding.inflate(getLayoutInflater());
setContentView(binding.getRoot());

// Acceso a vistas
binding.tvLocalScore.setText(String.valueOf(localScore));
binding.btnLocalPlusOne.setOnClickListener(v -> addPoints(true, 1));
Explicit Intents y Paso de Datos

Navegación entre activities mediante intents explícitos
Transferencia de datos usando constantes definidas
Uso de Intent.putExtra() y getIntent().getIntExtra()

Implementación:
java// Definición de constantes
public static final String EXTRA_LOCAL_SCORE = "extra_local_score";
public static final String EXTRA_VISITOR_SCORE = "extra_visitor_score";

// Envío de datos desde MainActivity
Intent intent = new Intent(this, ScoreActivity.class);
intent.putExtra(EXTRA_LOCAL_SCORE, localScore);
intent.putExtra(EXTRA_VISITOR_SCORE, visitorScore);
startActivity(intent);

// Recepción de datos en ScoreActivity
int localScore = getIntent().getIntExtra(MainActivity.EXTRA_LOCAL_SCORE, 0);
int visitorScore = getIntent().getIntExtra(MainActivity.EXTRA_VISITOR_SCORE, 0);
```

### Gestión de Recursos
- Todos los textos almacenados en `strings.xml` para facilitar internacionalización
- Uso de recursos Android de forma profesional y centralizada
- Preparación para soporte multiidioma

## Capturas de Pantalla

### MainActivity - Pantalla Principal
![MainActivity](screenshots/main_activity.png)

*Interfaz principal con marcadores de ambos equipos y controles de puntuación*

### ScoreActivity - Resultados Finales
![ScoreActivity](screenshots/score_activity.png)

*Pantalla de resultados mostrando el marcador final y el ganador del partido*

## Estructura del Proyecto
```
app/
├── src/
│   └── main/
│       ├── java/
│       │   └── es.medac.tablerobasketball/
│       │       ├── MainActivity.java
│       │       └── ScoreActivity.java
│       ├── res/
│       │   ├── layout/
│       │   │   ├── activity_main.xml
│       │   │   └── activity_score.xml
│       │   └── values/
│       │       └── strings.xml
│       └── AndroidManifest.xml
└── build.gradle
Configuración y Ejecución
Requisitos Previos

Android Studio (versión recomendada: Hedgehog o superior)
JDK 11 o superior
SDK de Android (mínimo API 24 - Android 7.0)

Pasos para Ejecutar

Clonar o descargar el repositorio
Abrir el proyecto en Android Studio
Esperar a que Gradle sincronice las dependencias
Conectar un dispositivo Android o iniciar un emulador
Ejecutar la aplicación (Run → Run 'app' o Shift + F10)

Configuración de Data Binding
El proyecto ya incluye la configuración necesaria en build.gradle:
kotlinandroid {
    buildFeatures {
        dataBinding = true
    }
}
Decisiones de Diseño
Arquitectura

Separación de responsabilidades: Cada activity gestiona su propia lógica
Métodos auxiliares: Código organizado en funciones pequeñas y específicas
Validaciones: Control estricto de puntuación mínima (no permite negativos)

Interfaz de Usuario

Layout utilizado: ConstraintLayout para diseño responsive
Distribución simétrica: Equipos posicionados lado a lado
Controles intuitivos: Botones claramente etiquetados y organizados
Feedback visual: Actualización inmediata del marcador

Buenas Prácticas Implementadas

Nomenclatura descriptiva y consistente
Comentarios estratégicos en métodos principales
Uso de constantes para claves de Intent
Validación de datos (puntuación mínima)
Gestión centralizada de recursos
Código limpio sin imports innecesarios

Casos de Prueba Realizados

Suma de puntos (+1 y +2) para ambos equipos
Resta de puntos (-1) con validación de no negativos
Reset completo del marcador
Navegación correcta entre activities
Paso de datos mediante Intent
Cálculo correcto del ganador (local gana, visitante gana, empate)
Visualización correcta de resultados finales
Funcionamiento en diferentes tamaños de pantalla

Autor
Gonzalo Durán

Licencia
Proyecto educativo desarrollado como parte del curso de Desarrollo Android.


Aplicación de mejores prácticas de desarrollo

Declaración de Originalidad: Este es un trabajo individual desarrollado de forma autónoma, aplicando los conocimientos adquiridos durante el primer trimestre del curso.
