# 📚 Streams en Java

## 1️⃣ ¿Qué es un Stream en Java?
Un **Stream** en Java es una secuencia de datos sobre la que puedes realizar operaciones de manera funcional. Se introdujo en **Java 8** y permite trabajar con colecciones de datos de forma eficiente y concisa.

### ✨ Características clave:
- **No almacenan datos**, solo los procesan.
- **Operaciones en cadena** (`map`, `filter`, `reduce`, etc.).
- **Pueden ser secuenciales o paralelos**.
- **No modifican la colección original**.

### 📝 Ejemplo:
```java
List<String> nombres = Arrays.asList("Ana", "Juan", "Pedro", "Maria");

nombres.stream()
       .map(String::toUpperCase)
       .forEach(System.out::println);
```

## 2️⃣ ¿Cómo crear un Stream?
Puedes crear un `Stream` desde varias fuentes:

| Fuente | Ejemplo |
|--------|---------|
| **Lista o Set** | `lista.stream()` |
| **Array** | `Arrays.stream(array)` |
| **Map (clave-valor)** | `map.entrySet().stream()` |
| **String** | `"Hola".chars()` |
| **Ficheros** | `Files.lines(Path.of("archivo.txt"))` |
| **Stream vacío** | `Stream.empty()` |

## 3️⃣ Operaciones en Streams
Los Streams tienen **operaciones intermedias** y **operaciones terminales**.

### 🔹 Operaciones intermedias (Transforman el Stream)
#### `map(Function<T, R>)` → Transforma cada elemento
```java
List<Integer> cuadrados = numeros.stream()
                                 .map(n -> n * n)
                                 .collect(Collectors.toList());
```

#### `filter(Predicate<T>)` → Filtra elementos
```java
List<Integer> pares = numeros.stream()
                             .filter(n -> n % 2 == 0)
                             .collect(Collectors.toList());
```

#### `sorted(Comparator<T>)` → Ordena elementos
```java
List<String> ordenados = nombres.stream()
                                .sorted()
                                .collect(Collectors.toList());
```

#### `distinct()` → Elimina duplicados
```java
List<Integer> unicos = numerosDuplicados.stream()
                                        .distinct()
                                        .collect(Collectors.toList());
```

### 🔹 Operaciones terminales (Finalizan el Stream)
#### `forEach(Consumer<T>)` → Itera sobre cada elemento
```java
numeros.stream().forEach(System.out::println);
```

#### `collect(Collectors.toList())` → Convierte el Stream en lista
```java
List<Integer> lista = numeros.stream()
                             .filter(n -> n > 2)
                             .collect(Collectors.toList());
```

#### `reduce(BinaryOperator<T>)` → Reducción a un solo valor
```java
int suma = numeros.stream()
                  .reduce(0, Integer::sum);
```

#### `count()` → Cuenta los elementos
```java
long cantidad = nombres.stream()
                       .filter(n -> n.startsWith("A"))
                       .count();
```

## 4️⃣ Streams Paralelos (Optimización)
```java
long count = listaNumeros.parallelStream()
                         .filter(n -> n % 2 == 0)
                         .count();
```
✅ **Ventaja**: Usa múltiples hilos, más rápido en grandes volúmenes.  
❌ **Desventaja**: No siempre mejora el rendimiento en listas pequeñas.

## 5️⃣ Aplicación práctica: Filtrar restaurantes por código postal
```java
try (Stream<String> lineas = Files.lines(Path.of("restaurantes.csv"))) {
    lineas.filter(linea -> linea.split(",")[2].startsWith("6"))
          .forEach(System.out::println);
} catch (IOException e) {
    System.err.println("Error al leer el archivo: " + e.getMessage());
}
```
✅ **Usamos `Files.lines()` para leer el CSV línea a línea.**  
✅ **`filter()` para quedarnos solo con los códigos postales que empiezan en "6".**  
✅ **`forEach()` para imprimir los resultados.**  


