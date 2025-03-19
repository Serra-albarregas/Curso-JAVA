# 📂 Comparativa de formas de lectura de ficheros en Java

| Método | Librería | Devuelve | Eficiencia en archivos grandes | Simplicidad | Comentarios |
|--------|---------|----------|-------------------------------|-------------|-------------|
| **`BufferedReader.readLine()`** | `java.io` | `String` línea por línea | ✅ Alta (procesa línea a línea) | ❌ Menos simple (requiere `while`) | Método tradicional, útil si necesitas control sobre la lectura |
| **`Files.readAllLines(Path)`** | `java.nio.file` | `List<String>` con todas las líneas | ❌ Baja (carga todo en memoria) | ✅ Simple | Ideal para archivos pequeños |
| **`Files.lines(Path)`** | `java.nio.file` | `Stream<String>` | ✅ Alta (procesa línea a línea con `Stream`) | ✅ Muy simple | Recomendado para archivos grandes y procesamiento funcional |
| **`Files.readString(Path)`** | `java.nio.file` | `String` con todo el contenido | ❌ Baja (carga todo en memoria) | ✅ Súper simple | Perfecto para archivos pequeños |
| **`FileReader.read()`** | `java.io` | `int` (carácter a carácter) | ❌ Baja (requiere bucle para leer línea a línea) | ❌ Poco práctico | Uso poco recomendado, `BufferedReader` es mejor opción |

## 🔍 ¿Cuál elegir?

📌 **Si el archivo es pequeño:**  
✅ `Files.readAllLines()` o `Files.readString()`, ya que son los más simples.

📌 **Si el archivo es grande:**  
✅ `Files.lines()` o `BufferedReader.readLine()` porque **procesan línea por línea sin cargar todo en memoria**.

📌 **Si necesitas procesamiento funcional (filtrar, mapear, etc.):**  
✅ `Files.lines()`, ya que devuelve un `Stream<String>` y permite usar `filter()`, `map()`, `forEach()`, etc.