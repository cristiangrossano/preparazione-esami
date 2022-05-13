# APPUNTI PROGRAMMAZIONE

- generatore di numeri

```java
import java.utili.Random;
Random nome = new Random();
```

#### per la creazione dei valori casuali dell'array

```java
array[i] = random.nextInt(valmax);
```

> Per dare un valore massimo lo si passa nelle parentesi

#### concatenazione delle stringhe

```java
String nome = "";
```

sommando si concatenano valori come ad esempio "

```java
nome = nome + 4
```

Così facendo trasformerò la stringa vuota in " 4 "

#### Split array

```java
import java.util.Arrays;

String[] parole = input.split(" ");
```

**_Per dividere le stringhe dove ci sono degli spazi, con altri caratteri verrà diviso in punti diversi in base ai caratteri o alle parole_**

- Stampa in output l'array con un cast in string

```java
  System.out.println(Arrays.toString(parole));
```

- dichiarazione di un array

```java
  int[] array = new int[];
```

- per le occorrenze nelle stringhe
  utilizziamo

  ```java
  .charAt(index)

  ```

  che avrà il valore del singolo carattere quindi si può confrontare con un if(variabile.charAt(i) == carattere) e si può così trovare un contatore

- parole uniche
  importando Java.util.\*;

dichiarare la lista con

```
List<String> nome = Arrays.asList(nomestringa.split(" "));
```

crea la lista in un array, diviso dove ci sono spazi

```java
Set<String> nome = new Hashset<String>(nomeDellaLista);

for(String w : della map) //con output di w darà in output la parola

import java.util.Arrays;
```

la classe Arrays contiene vari metodi per la manipolazione degli array, tra i quali il sorting e il trasformarli in stringhe, molto utili per gli output.

```java
        System.out.println(Arrays.toString(array1));
```

questo darà in output la stringa dell'array compresa tra delle parentesi graffe, tutto l'array viene trasformato in una stringa per un output più pulito

```java
System.out.printf(tipo, dati)
```

Con printf si da un formato ai dati e si riceve l'output di conseguenza
per esempio con %d / %d = si riceve un formato di una divisione passando due numeri

con la try e la catch si può provare un blocco di codice avendo delle eccezioni controllate

```java
catch (ArithmeticException err) { out.println("non puoi usare numeri di un determinato tipo")
```

- Numero Immaginario
  ricoradare che con

  ```java
  .charAt(indice)
  ```

  si può controllare un determinato carattere di una stringa

  ```java
  Double.parseDouble(Stringa)
  ```

  si ha una conversione della stringa in un double, eccezioni possibili possono essere

1. Null per la stringa
2. Nessun numero trovato

nel caso di questo problema per esempio per identificare un numero immaginario si utilizza la 'j' come primo carattere, di conseguenza si ha un errore di numero errato durante la conversione, per questo motivo con un try e un catch si può sollevare un errore controllato e di conseguenza agire sulla stringa con la funzione charAt per controllare se la stringa inizia con 'j' e poi con la funzione subString per prendere in considerazione una sottostringa della stringa in input.
Con la funzione

```java
nomeStringa.subString(valIniziale, valoreFinale)
```

si prende in considerazione solo una parte della stringa determinata dai due valori che vengono passati.

Esercizio Sequenza.

Definire due sequenze:

1. Double
2. Frazioni

dichiarazione:

```java
Sequenza<tipo> nome = new Sequenza<tipo>();
```

Il metodo sequenza va richiesto dalla libreria "prog.utili.Sequenza".

creazione di un'errore

```java
class Impossibile extends Exception {

    public Impossibile(String message) {
        super(message);
    }

}
//creare un array di frazioni
Frazione[] arrayDiFrazioni = new Frazione[dim];
```
