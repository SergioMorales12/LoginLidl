# 🔐 Replicación de UI de Login - Lidl 

*Aplicación móvil que replica la interfaz de autenticación de Lidl, implementando buenas prácticas de diseño y funcionalidad.*

---

## 📱 Capturas de Pantalla

### **1. Login**  
![Pantalla de Login](https://github.com/user-attachments/assets/231f6e71-0a5b-4965-a6a4-241b05e4b3aa)  
*Interfaz de inicio de sesión con:*  
- Campos para email/contraseña.  
- Botón de acceso.  
- Enlaces a "¿Olvidaste tu contraseña?" y registro.  

### **2. Registro**  
![Pantalla de Registro](https://github.com/user-attachments/assets/ff141ea8-12e8-44c9-990e-5e66dea07f5a)  
*Formulario de registro con validaciones en tiempo real.*

### **3. Footer**  
![Footer de la App](https://github.com/user-attachments/assets/ec895951-d717-4e74-a1d6-2843111128d5)  
*Barra inferior con navegación y elementos de branding.*

---

## 🛠 Tecnologías Utilizadas  
- **Lenguaje**: Kotlin (Android Nativo)  
- **Arquitectura**: MVVM  
- **Librerías**:  
  - Jetpack Compose (UI)  
  - Dagger Hilt (Inyección de dependencias)  
  - Firebase Auth (Autenticación opcional)  

```kotlin
// Ejemplo de código: Validación de formulario
fun validateForm(email: String, password: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 6
}
```

---

## 🚀 Funcionalidades Clave  
✅ **UI/UX fiel al diseño original** de Lidl.  
✅ **Validaciones en tiempo real** (email, contraseña).  
✅ **Integración con API REST** (mockeada o real).  
✅ **Animaciones fluidas** con Jetpack Compose.  

---

## 📥 Instalación  
1. Clona el repositorio:  
   ```bash
   git clone https://github.com/tu-usuario/lidl-login-clone.git
   ```
2. Abre el proyecto en Android Studio.  
3. Ejecuta en un emulador o dispositivo físico.  

---

## 🌟 Próximas Mejoras  
- [ ] Añadir autenticación biométrica.  
- [ ] Implementar dark mode.  

---

## 📄 Licencia  
MIT © [Tu Nomre](https://github.com/tu-usuario)  
