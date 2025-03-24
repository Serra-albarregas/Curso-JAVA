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

| Expresión | Significado |
|-----------|------------|
| `(abc)`   | Grupo de captura |
| `(?:abc)` | Grupo sin captura |
| `a|b`     | Alternancia (a o b) |

Ejemplo:
```java
String regex = "(Hola|Adiós), mundo!";
System.out.println("Hola, mundo!".matches(regex));  // true
System.out.println("Adiós, mundo!".matches(regex)); // true
```

---

## 🔹 **Lookahead y Lookbehind**

| Expresión | Significado |
|-----------|------------|
| `(?=X)`   | Lookahead positivo (seguido de X) |
| `(?!X)`   | Lookahead negativo (NO seguido de X) |
| `(?<=X)`  | Lookbehind positivo (precedido por X) |
| `(?<!X)`  | Lookbehind negativo (NO precedido por X) |

Ejemplo:
```java
String regex = "\d(?=kg)"; // Dígito seguido de 'kg'
System.out.println("5kg".matches(regex)); // true
```

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

🚀 **¿Tienes dudas? ¡Déjalas en los comentarios!** 😊

