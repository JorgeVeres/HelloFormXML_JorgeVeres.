# 👋 HelloFormXML

Una pequeña aplicación Android creada en **Kotlin** que muestra cómo usar un formulario simple con:
- Un campo de texto (`EditText`)
- Un botón (`Button`)
- Un mensaje de saludo (`TextView`)
- Un contador de caracteres en tiempo real

---

## 🚀 Características

✅ Muestra un saludo personalizado al escribir tu nombre.  
✅ El botón **“Saludar”** se habilita solo cuando el campo no está vacío.  
✅ Muestra un contador de caracteres (`0 / 20`).  
✅ Oculta el teclado al pulsar el botón.  
✅ Restaura la interfaz al salir de la actividad.  

---

## 🧠 Funcionamiento

1. El usuario escribe su nombre en el `EditText`.
2. El `TextWatcher` detecta los cambios y actualiza el contador.
3. Si el campo no está vacío, el botón **Saludar** se habilita.
4. Al pulsar el botón:
   - Se muestra un mensaje tipo **“Hola, [nombre]”**.
   - Se oculta el teclado automáticamente.
   - El campo pierde el foco para evitar que el teclado vuelva a aparecer.
5. Al salir de la app, la interfaz se reinicia.

---

## 🧩 Estructura del proyecto

```
app/
└── src/
    └── main/
        ├── java/com/example/helloformxml/
        │   └── MainActivity.kt
        └── res/
            └── layout/
                └── activity_main.xml
```

## ⚙️ Requisitos

- Android Studio **Arctic Fox (2020.3.1)** o superior  
- SDK mínimo: **Android 7.0 (API 24)**  
- Lenguaje: **Kotlin**

---
