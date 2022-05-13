# Programmazione concorrente e distribuita

## Pacchetto java.io.\*

- Definisce le impostazion in di ingresso ed uscita nei flussi (**_stream_**)
- Gli **_stream_** sono **_sequenze ordinate di dati_**, cioè hanno una **_sorgente_** e una **_destinazione_**
- Nasconde i dettagli del sistema operativo e dei dispositivi coinvolti nelle operazioni

1. **_Flussi di Input_**
   Per ricevere dati, l'applicaione apre uno stream collegato ad una sorgente - la sorgente può essere memoria, disco o anche remota
2. **_Flussi di Output_**
   Per esportare i dati invece si apre uno stream verso una destinazione e vi scrive _sequenzialmente_ le informazioni
   - la destinazione può essere memoria, disco o anche remota

Il pacchetto è composto da due sezioni principali

1. Flussi di Byte (Byte Stream)
    - L'unità gestita è il byte (8- bit)
    - I/O binario: immagini, dati di formato binario
    - le classi che realizzano stream di byte sono indicate come:
      1. Stream di ingresso (input)
      2. Stream di uscita (output)
2. Flussi di caratteri (character stream)
    - L'unità gestita sono caratteri Unicode (16- bit)
    - I/O testuale
    - le classi che realizzano stream di caratteri sono:
      1. lettori (reader)
      2. scrittori (writer)

---

Si utilizzano i byte stream quando si elaborano informazioni di tipo binario o per un carattere alla volta.
File composti da caratteri rappresentati da un solo byte (codifica ASCII).
Mentre si utilizzano **writer e reader** per elaborare informazioni di tipo testuale, codificata **_UNICODE_**.

---

Nel caso di file che non esistano oppure se il file è protetto dalla scrittura

IOException
Errore lanciato in caso di errore nei flussi di input e output.
Se non entra l'eccezione il flusso dello stream cambia lo stato di quest'ultima.

- Ingresso da file binari
  Per leggere un file formato binario si utilizza un oggetto della classe FileInputStream
  Per aprire un file di cui si conosce il nome si utilizza ->

  ```java
  FileInputStream nome = new FileInputStream(nomeFile);
  ```

  Invece per leggere un byte si utilizza il metodo

  ```java
  read()
  ```

  che restituisce un int con il byte letto inserito negli 8 bit meno significativi.
  All'EOF il metodo restituisce il valore -1.
  Al termine delle operazioni il file deve essere chiuso con il metodo

  ```java
  close()
  ```

- Scrittura su file binari
  Per scrivere su un file binario si utilizza

  ```java
  FileOutputStream()
  ```

  Il file in uscita viene aperto invocando il costruttore

  ```java
  FileOutputStream nome = new FileOutputStream(nome);
  ```

  Per scrivere un byte si utilizza il metodo

  ```java
  write(int c);
  ```

  Il metodo usa un solo parametro **_int_** del quale vengono trasferiti in uscita gli 8 bit meno significativi.
  Al termine delle operazioni di uscita il file deve essere chiuso sempre con il metodo

  ```java
  close()
  ```

- Lettura di un file di testo
  Per implemtentare il reader viene fornita la **_classe FileReader_**

  ```java
  public class FileReader extends InputStreamReader
  ```

  - classe per leggere i file di caratteri
  - FileReader è fatto per leggere stream di caratteri. -> Per stream di Byte raw si usa FileInputStream.

Costruttore (uno dei tanti):

```java
public FileReader(String fileName) throws FileNotFoundException
```

Crea un nuovo FileReader, dato il nome del file da cui leggere.
Il parametro è il nome del file
Throws: FileNotFoundException - se il nome del file non esiste, se è una cartella invece di un file normale o altre ragioni per cui non può essere aperto e letto.

```java
public int read() throws IOException;
```

Legge un singolo carattere dello stream e ne restituisce il codice sotto forma di intero compreso tra [0 - 65535] -> numeri interi rappresentabili con 16-bit
Alla fine del file il metodo restituisce -1;

```java
public int read (char[] buf) throws IOException;
```

Legge dallo stream una sequenza di caratteri della stessu lunghezza dell'array ceh ha come argomento e li memorizza nelle posizioni successive dell'array;

```java
public void close() throws IOException;
```

Chiude lo stream che esegue il metodo.
Viene invocato per chiudere il file.
Dopo la chiusura metodi come read() restituiscono la IOException.

Leggere e scrivere un solo carattere per volta è scomodo e poco efficiente.
I testi di caratteri sono spesso costituiti da righe.
Obbiettivo: leggere e scrivere una riga per volta-

Il file di testo è composto da caratteri, alla fine della riga troviamo un carattere che si chiama EndOfLine -> \n

-

```java
 Classe BufferedReader(Reader in) //Prende un reader e restituisce un BufferedReader
```

Costruttore:

```java
public BufferedReader (Reader in)
```

Metodi:

```java
public String readLine() throws IOException;
```

Legge una riga di testo; - una riga sono i caratteri compresi tra i caratteri di fine riga.

Se al momento dell'invocazione è stata raggiunta la fine dello stream, il metodo restituisce null.
Altrimenti, il metodo restituisce la linea di caratteri letta

---

Thread e Multi thread

I processi hanno degli spazzi negli indirizzi
processi diversi contemporaneamente
La CPU viene divisa in processi diversi, tempi diversi ma molto ravvicinati

I processi vedono i processi come se fossero interamente dedicati a lui, lo stesso vale per la memoria
I processi comunicano attraverso il sistema operativo

Processi leggeri (thread) che condividono lo stesso spazio di indirizzamento.
La collaborazione tra processi è molto più semplice, si scambiano informazioni attraverso la memoria condivisa.

Java ha una macchina virtuale che gestisce i thread, senza SO.
