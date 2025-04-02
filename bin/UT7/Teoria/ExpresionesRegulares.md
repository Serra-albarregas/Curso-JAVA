# Expresiones regulares y aplicaciones en java

Las **expresiones regulares** (RegEx) son patrones utilizados para buscar, coincidir y manipular texto. En Java, la clase `Pattern` y `Matcher` permiten usarlas de manera eficiente.

---

## 🔹 **Conceptos Básicos**
Las expresiones regulares están compuestas por una combinación de caracteres normales y metacaracteres.  
Los caracteres normales se buscan tal cual en el texto, mientras que los **metacaracteres** tienen un significado especial.

| Expresión | Significado |
|-----------|------------|
| `.`       | Cualquier carácter (excepto nueva línea) |
| `^`       | Inicio de línea |
| `$`       | Fin de línea |
| `\d`      | Dígito (0-9) |
| `\D`      | No es un dígito |
| `\w`      | Carácter alfanumérico (a-z, A-Z, 0-9, _) |
| `\W`      | No es alfanumérico |
| `\s`      | Espacio en blanco |
| `\S`      | No es un espacio en blanco |
| `\b`      | Límite de palabra |

Ejemplo:
```java
String regex = "\d{3}-\d{2}-\d{4}"; // Formato 123-45-6789
String test = "Mi número es 123-45-6789";
System.out.println(test.matches(regex)); // true
```

---

## 🔹 **Cuantificadores**
Los cuantificadores en expresiones regulares permiten especificar cuántas veces un carácter, grupo o clase de caracteres puede aparecer en una cadena.

| Cuantificador | Descripción | Ejemplo | Coincidencias |
|--------------|------------|---------|--------------|
| `*`  | **0 o más** repeticiones | `a*` | `""`, `"a"`, `"aaaa"` |
| `+`  | **1 o más** repeticiones | `a+` | `"a"`, `"aaaa"` |
| `?`  | **0 o 1** repetición | `a?` | `""`, `"a"` |
| `{n}` | Exactamente **n** repeticiones | `a{3}` | `"aaa"` |
| `{n,}` | **n o más** repeticiones | `a{2,}` | `"aa"`, `"aaaa"` |
| `{n,m}` | Entre **n y m** repeticiones | `a{2,4}` | `"aa"`, `"aaa"`, `"aaaa"` |

---

### 🔹 Cuantificadores Codiciosos y No Codiciosos
Los cuantificadores codiciosos intentan abarcar la mayor cantidad de caracteres posible, sin dejar de cumplir con el patrón de la expresión regular. Es la forma por defecto.
Por otro lado, los cuantificadores no codiciosos intentan coincidir con la menor cantidad de caracteres posible. Se usan agregando ? después del cuantificador.

| Tipo de Cuantificador | Ejemplo | Descripción |
|----------------------|---------|-------------|
| **Codicioso (`*`, `+`, `{n,m}`)** | `.*` | Coincide con la mayor cantidad posible de caracteres |
| **No codicioso (`*?`, `+?`, `{n,m}?`)** | `.*?` | Coincide con la menor cantidad posible |

Ejemplo:
```java
String texto = "abcd123d456d";
String regexCodicioso = ".*d";
String regexNoCodicioso = ".*?d";
Pattern patternCod = Pattern.compile(regexCodicioso);
Pattern patternNoCod = Pattern.compile(regexNoCodicioso);
Matcher matcher1 = patternCod.matcher(texto);
Matcher matcher2 = patternNoCod.matcher(texto);

if (matcher1.find()) {
    System.out.println("Coincidencia con patrón codicioso: " + matcher.group());
    // Salida: abcd123d456d
}
if (matcher2.find()) {
    System.out.println("Coincidencia con patrón no codicioso: " + matcher.group());
    // Salida: abcd
}
```

---

## 🔹 **Grupos y Alternancia**
Los **grupos** en expresiones regulares permiten capturar partes específicas de una cadena y usarlas posteriormente. Se definen con paréntesis `()` y pueden ser utilizados para extraer información, aplicar cuantificadores a una sección específica o hacer referencias posteriores.  


Tipo de Grupo | Expresión | Descripción
Grupo Capturador | (expresión) | Guarda la coincidencia para su uso posterior.
Grupo No Capturador | (?:expresión) | Agrupa sin guardar la coincidencia.
Grupo de Referencia | \n | Se refiere a una coincidencia anterior en la misma expresión, donde n es el número del grupo en el orden en el que aparece.

```java
String texto = "Mi número de teléfono es 123-456-7890.";
String regex = "(\\d{3})-(\\d{3})-(\\d{4})";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(texto);

if (matcher.find()) {
    System.out.println("Número completo: " + matcher.group(0)); // 123-456-7890
    System.out.println("Código de área: " + matcher.group(1));  // 123
    System.out.println("Número central: " + matcher.group(2));  // 456
    System.out.println("Número final: " + matcher.group(3));    // 7890
}
```

### 🔹 Referencias a Grupos
Las referencias permiten reutilizar partes capturadas dentro de la misma expresión o en una sustitución.

#### Referencias dentro de la Misma Expresión
Expresión para detectar palabras repetidas:

```java
String regex = "\\b(\\w+)\\s+\\1\\b";
String texto = "hola hola mundo";
System.out.println(texto.matches(regex)); // true
```
Captura entre los paréntesis la primera palabra de la frase, luego se hace referencia a ella mediante \1

#### Referencias en Sustitución
Puede utilizarse el carácter $ para hacer referencias a grupos desde fuera de la expresión regular.
```java
String texto = "Hola Juan, bienvenido Juan";
String resultado = texto.replaceAll("(Juan)", "Sr. $1");
System.out.println(resultado); // Hola Sr. Juan, bienvenido Sr. Juan
```
Reemplaza cada "Juan" con "Sr. Juan" utilizando $1 como referencia.

---

### 🔹 4. Alternancia (|)
La alternancia permite definir múltiples opciones dentro de una expresión. Funciona como un "o lógico" (OR).

```java
String regex = "rojo|azul|verde";
System.out.println("Me gusta el azul".matches(".*" + regex + ".*")); // true
```
Detecta si una cadena contiene "rojo", "azul" o "verde".

---

## 🔹 **Lookahead y Lookbehind**

Los **lookaround assertions** (Lookahead y Lookbehind) son expresiones que permiten realizar **coincidencias condicionales** sin incluir los caracteres en el resultado final. Se utilizan para asegurarse de que un patrón está (o no está) seguido o precedido por otro patrón sin consumirlo.


### 🔹 1. Lookahead

El **lookahead** verifica si un patrón es seguido por otro sin incluirlo en la coincidencia final.  

#### 🔹 Sintaxis  

| Tipo | Expresión | Descripción |
|------|-----------|-------------|
| **Lookahead Positivo** | `X(?=Y)` | Coincide con `X` si **le sigue** `Y`. |
| **Lookahead Negativo** | `X(?!Y)` | Coincide con `X` si **NO le sigue** `Y`. |

---

Ejemplo: Lookahead Positivo 
Encuentra `"apple"` solo si le sigue `"pie"`:  

```java
String texto = "apple pie, apple juice, apple tart";
String regex = "apple(?= pie)";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(texto);

while (matcher.find()) {
    System.out.println("Coincidencia: " + matcher.group());
}
```
Salida:
Coincicencia: apple.

Ejemplo: Lookahead Negativo
Encuentra "apple" solo si NO le sigue "pie":

```java
String texto = "apple pie, apple juice, apple tart";
String regex = "apple(?! pie)";
Matcher matcher = Pattern.compile(regex).matcher(texto);

while (matcher.find()) {
    System.out.println("Coincidencia: " + matcher.group());
}
```
Salida:
Coincidencia: apple
Coincidencia: apple

---

### 🔹 2. Lookbehind

El lookbehind verifica si un patrón es precedido por otro sin incluirlo en la coincidencia.

#### 🔹 Sintaxis

| Tipo | Expresión | Descripción |
|------|-----------|-------------|
| **Lookbehind Positivo** | `(?<=Y)X` | Coincide con `X` si **está precedido por** `Y`. |
| **Lookbehind Negativo** | `(?<!Y)X` | Coincide con `X` si **NO está precedido por** `Y`. |


Ejemplo: Lookbehind positivo
Encuentra "pie" solo si está precedido por "apple".

```java
String texto = "apple pie, banana pie, apple tart";
String regex = "(?<=apple )pie";
Matcher matcher = Pattern.compile(regex).matcher(texto);

while (matcher.find()) {
    System.out.println("Coincidencia: " + matcher.group());
}
```
Salida:
Coincidencia: pie

Ejemplo: Lookbehind negativo
Encuentra "pie" solo si **NO esta precedido** por "apple".

```java
String texto = "apple pie, banana pie, apple tart";
String regex = "(?<!apple )pie";
Matcher matcher = Pattern.compile(regex).matcher(texto);

while (matcher.find()) {
    System.out.println("Coincidencia: " + matcher.group());
}
```
Salida:
Coincidencia: pie

---

## 🔹 **Uso de `Pattern` y `Matcher` en Java**

```java
import java.util.regex.*;

public class RegExExample {
    public static void main(String[] args) {
        String texto = "El precio es $45.99 y la oferta es de $39.50";
        String regex = "\\$\\d+\\.\\d{2}"; // Busca precios en formato $XX.XX

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println("Encontrado: " + matcher.group());
        }
    }
}
```

🔍 **Salida esperada:**
```
Encontrado: $45.99
Encontrado: $39.50
```

---

## 🔥 **Expresiones Regulares Útiles**

| Expresión | Descripción |
|-----------|------------|
| `\d{4}-\d{2}-\d{2}` | Fecha en formato YYYY-MM-DD |
| `[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}` | Correo electrónico |
| `https?://[\w.-]+` | URL con http o https |