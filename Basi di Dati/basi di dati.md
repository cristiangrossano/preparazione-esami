# Basi di dati

## Obbiettivo del corso

Imparare i concetti base relativi ai sistmi di gestione dei dati, ovvero:

- Come progettarli
- Come crearli
- Come ottimizzarli
- Come utilizzarli.

> Modello dei dati
> **Relazionali** ➔ usano la struttura dati della relazione come modo di organizzare

## Aspetti Introduttivi

**BASI DI DATI**

> Collezione di dati tra loro correlati, utilizzati per rappresentare le informazioni di interesse in un sistema informativo.

**SISTEMA DI GESTIONE DI BASI DI DATI (BDSM)**

> Sistema di software che fornisce gli strumenti necessari per gestire i dati.

**SISTEMA INFORMATIVO**

> Gestisce e rende disponibili attraverso strumenti, le informazioni di interesse supportato da un calcolatore.

_Componenti_:

- Strumenti per la rappresentazione delle **_informazioni_**, mediante una qualche codifica.
- **_Programmi Applicativi_** e di sistema che realizzano tutte le funzioni necessarie alla gestione delle informazioni.

Informazioni ➔ Sotto forma di **DATI**.

> Hanni bisogno di un contesto interpretativo che permette di estrarre da essi le info di interesse per gli utenti (es. Matricola, Numero_telefono, ecc...)

## DBMS (DATA BASE MANAGEMENT SYSTEM)

Sistema software in grado di gestire collezioni di dati che siano:

- Grandi
- Condivisi
- Persistenti

  > Cioè tempo di vita non limitato a quello dell'esecuzione dei programmi che li utilizzano.

  Assicurando la loro affidabilità e sicurezza.

**_STRUMENTO VINCENTE_** ➔ **_SCHEMA LOGICO_** ➔ Descrive la struttura dei dati.

**_CARATTERISTICHE_**

- Dimensioni maggiori della memoria centrale disponibile;
- Condivisione dei dati tra applicazioni ed utenti, **risorsa integrata**, condivisa da più settori aziendali ➔ Gestisce la concorrenza:
  - Riduzione della ridondanza dei dati;
  - Riduzione delle inconsistenze tra dati;
  - Meccanismo di controllo dell'accesso concorrente.
- Sicuri ➔ Con meccanismo di cloud, backup;
- Efficienza ➔ sia in tempo che in spazio, capacità di svolgere le operazioni utilizzando risorse accettabili dall'utente;
- Efficacia ➔ Capacità di rendere produttive le attività degli utenti.

Estende le funzionalità del file system fornendo più servizi ed in maniera **integrata**.

**Necessità di usare**:

- Insieme di strutture dati;
- Linguaggi per:
  - specificare dati;
  - aggiornare strutture;
  - specificare vincoli su strutture;
  - manipolare/cercare dati.

**Istanza** ➔ Insieme di dati presenti in un determinato momento in una struttura dati.  
**Tuple** ➔ righe quando si parla di **relazioni**.

La rappresentazione dei dati in un **DBSM** opera su due livelli:

- Fisico
- Logico

### INDIPENDENZA DEI DATI

- **Indipendenza Fisica** ➔ l'amministrazione del database può modificare lo schema fisico del database senza alterare lo schema logico e le viste
- **Indipendeza Logica** ➔ la presenza delle visite permette di nascondere modifiche alla rappresentazione dei dati al livello logico delle applicazioni/utenti che vedono la rappresentazione esterna (tramite vista)
  - Esempio: Cambia lo schema logico (aggiunta di un attributo), solo una parte delle viste cambia

### LINGUAGGI DI UN DBMS

#### DATA DEFINITION (DDL)

- Permette di specificare e modificare lo **schema** della base di dati, lo schema delle viste;
- Livello logico ed esterno.

#### DATA MANIPULATION LANGUAGE (DML)

- Permette di creare, modificare ed interrogare attraverso query **l'istanza** della base di dati;
- Livello logico ed esterno.

#### STORAGE DEFINITION LANGUAGE (SDL)

- Definisce lo schema fisico del DB;
- Livello Fisico.

**Il linguaggio SQL ha comandi di entrambi i linguaggi (DDL/DML).**

## IL MODELLO RELAZIONALE

- Proposto nel 1970 per favorire l'indipendenza dei dati, reso disponbile come modello logico in DBMS nel 1981;
- Modello logico più diffuso ed adottato per livelli commerciali.

### CARATTERISTICHE

- Basato su una semplice struttura di dati ➔ **LA RELAZIONE**:
  - **DEF**: Sottoinsieme finito del prodotto cartesiano;
  - si associa un nome a ogni componente delle colonne (**TUPLE**) ➔ **nome di attributo**;
  - ogni relazione è rappresentata in maniera informale sotto forma di **tabella**.
- É caratterizzato da precise basi matematiche;
- Semplice rappresenzione di dati con linguaggi dichiarativi:
  - anche per utenti poco esperti;
  - possibilità di attuare strategie di ottimizzazione.
- Facilità con cui possono essere espresse interrogazioni;
- É possibile rappresentare l'assenza del valore per un attributo poichè non tutte le info sono sempre disponibili:
  - valore speciale ➔ **NULL** ➔ **valore sconosciuto**.

**DOMINIO** ➔ insieme di valori (anche infinito) che i dati possono assumere

> valori nulli non appartengono al dominio

**PRODOTTO CARTESIANO** ➔ insieme di oggetti (tuple) strutturati che hanno **K** componenti, tanti quanti sono i domini), dove il **K-Esimo** valore appartiene al **K-Esimo** dominio

![prodotto cartesiano](https://cdn.discordapp.com/attachments/981502253796040744/981502297475514378/Schermata_del_2022-06-01_12-18-26.png)

**Grado** ➔ Elementi presenti in una tupla (colonne della tabella), **k** domini = grado **k**.  
**Cardinalità** ➔ Numero di tuple (righe della tabella).

### LE CHIAVI

**Vincolo di chiave**  
La chiave di una relazione **è un insieme di attributi che distingue fra loro le tuple della relazione.**

**Proprietà**
Sia S uno schema relazionale:

- Qualsiasi insieme di tuple sia contenuta in S, non devono esistere 2 tuple distinte di S che abbiano lo stesso valore ➔ **_Unicità_**
- Nessun sottoinsime proprio di X degli attributi di S verifica la proprietà 1 ➔ **_Minimalità_**
- **Non** può assumere valori nulli ➔ **_Vincolo di obbligatorietà_**

| Matricola | Nome     | Cognome | DataN     | Anno Immatricolazione |
| --------- | -------- | ------- | --------- | --------------------- |
| 64655     | Marco    | Rossi   | 3/2/1988  | 2008                  |
| 81999     | Anna     | Bianco  | 16/6/1989 | 2008                  |
| 75222     | Giovanni | Gialli  | 4/5/1987  | 2007                  |

L'attributo { Matricola } è univoco e minimale, **quindi è una chiave.**  
L'insieme di attributi { Matricola, Nome } è univoco, ma non minimale (Matricola è univoco anche da solo), quindi è una **super chiave**.

#### Chiavi Candidate

```mermaid
graph TD;
Chiavi_Candidate -➔ Chiave_Primaria;
Chiavi_Candidate -➔ Chiavi_Alternative;
```

- Una relazione può avere più di un insieme di X atributi che verificano le proprietà 1 e 2;
- Una relazione ha sicuramente almeno una chiave;
- Criteri di Scelta:
  - Chiave candidata contenente il minor numero di attributi;
  - Chiave candidata più frequentemente utilizzata nelle query, in modo da velocizzare il carico di lavoro.

#### Chiavi Esterne

Servono per modellare le associazioni (**non** aggiunge ulteriori informazioni), creano un legame tra attributi.

![chiave esterna](https://cdn.discordapp.com/attachments/981502253796040744/981508185250746388/unknown.png)

- Una relazione può contenere **più chiavi esterne** anche verso la stessa tabella;
- Devono essere specificate nello schema della relazione;
- Devono rispettare l'**integrità referenziale** ➔ correttezza violata da:
  - Inserimenti e modifiche del valore della chiave esterna nella relazione referente;
  - Cancellazioni e modifiche del valore della chiave nella relazione riferita:
    - SQL mette a disposizione queste alternative:
      - cancella o modifica tutti i noleggi che si riferiscono al cliente cancellato ➔ ON UPDATE / ON DELETE ➔ CASCADE
      - Non consente la cancellazione o la modifica se ha ancora noleggi in corso ➔ ON UPDATE / ON DELETE ➔ RESTRICT
      - Esegue senza problemi l'inserimento e la cancellazione senza fare altro ➔ ON UPDATE / ON DELETE ➔ NO ACTION
      - Consente la cancellazione o modifiche cambiando il codice cliente con un valore nullo o di default per mantenere noleggi ➔ ON UPDATE / ON DELETE ➔ SET NULL / SET DEFAULT
- possono assumere valore nullo

**ESEMPIO:**

```SQL
CREATE TABLE Autore (
  Nome VARCHAR(50) NOT NULL,
  Cognome VARCHAR (50) NOT NULL,
  Data_Nascita DATE NOT NULL,
  Nazionalità VARCHAR(50) NOT NULL,
  PRIMARY KEY (Nome Cognome)
);
```

```SQL
CREATE TABLE Libro (
  Titolo VARCHAR(50) NOT NULL,
  Nome_Autore VARCHAR (50) NOT NULL,
  Cognome_Autore VARCHAR (50) NOT NULL,
  Lingua VARCHAR(20) NOT NULL,
  FOREIGN KEY AutoreDelLibro (Nome_Autore, Cognome_Autore) REFERENCES Autore(Nome, Cognome)
);
```

### VINCOLI DI INTEGRITA' E ASSERZIONI

#### Vincoli di integrità

Vincoli che esprimono condizioni di correttezza dei dati nelle tabelle, qualsiasi applicazione che accede deve riconoscere questi vincoli, in base alle informazioni di dominio;

- Il **dominio degli attributi** è un vincolo ➔ Int, String, DataSet;
- Vincoli di **obbligarietà di colonne** ➔ NOT NULL
- Vincoli di **chiave** ➔ UNIQUE e PRIMARY KEY
- Vincoli di **integrità referenziale** ➔ FOREIGN KEY

Il linguaggio di query SQL mette a disposizione anche altri costrutti per la specifica di generici **vincoli di integrità**.

- Nel comando **CREATE TABLE**, è possibile definire:
  - Vincoli **CHECK** su colonna seguiti da condizione (anche con sub-query)
    - Si definiscono alla definizione degli attributi.

```SQL
CREATE TABLE Video (
tipo CHAR NOT NULL CHECK (tipo IN('d', 'v'))
)
```

- Vincoli **CHECK** su relazione:
  - Mettono in relazione più colonne o attributi;
  - Si mettono come definizione a parte;

**Cosa succede in presenza di valori nulli?**
SQL usa una logica a 3 valori per valiutare le condizioni (TRUE - FALSE - UNKNOWN)
E' possibile dare un nome ai vincoli (anche a quelli di default) in modo tale da essere inseriti o cancellati, facendo seguire la specifica del vincolo dalla parola **_CONSTRAINT_**.

```SQL
CREATE TABLE Video(
  colloc DECIMAL(4) CONSTRAINT PKey PRIMARY KEY,
  titolo VARCHAR(30) CONSTRAINT Tnn NOT NULL,
  regista VARCHAR(20) CONSTRAINT Rnn NOT NULL,
  tipo CHAR CONSTRAINT Snn NOT NULL DEFAULT 'd' CONSTRAINT Tok CHECK (tipo IN('d','v')),
  CONSTRAINT FK FOREIGN KEY (titolo, regista));

  ALTER TABLE Video DROP CONSTRAINT Tok;
```

Possibilità di definire **ASSERZIONI**.  
Sconsigliabile esprimere tramite vincoli **CHECK** condizioni troppo complesse, poichè altrimenti ci sarà una scarsa comprensibilità dello schema.
Non è possibile, inoltre, specificare tramite vincoli **CHECK** condizioni che richiedono di esaminare tuole di relazioni diverse:

- Sono elementi dello schema, manipolati da comandi **DDL**;
- Servono per esprimere **vincoli d'integrità** che coinvolgono **tuple o relazioni**.

#### Sintassi

```SQL
CREATE ASSERTION <nome asserzione>
CHECK (<condizione>)
```

Esempio:

Uno stesso video non può essere noleggiato contemporaneamente da due clienti.  
Un video non può essere noleggiato prima dell'uscita del film che lo contiene.

```SQL
CREATE ASSERTION DateOk
CHECK (NOT EXISTS SELECT * FROM Noleggio NATURAL JOIN Video NATURAL JOIN Film WHERE EXTRACT (YEAR FROM DataNol) < anno)
```

### LINGUAGGIO SQL

E' un linguaggio **SET-ORIENTED**:

> orientato agli insiemi

- Gli operatori operano su relazioni (insieme di tuple);
- Il risultato è sempre la relazione.

Utilizzabile in due modalità:

- **Interattiva** ➔ query da riga di terminale e DBMS restituisce il risultato
- **Compilativa** ➔ un linguaggio oapite contiene istruzioni SQL

|   Operazione   |  DDL   |  DML   |
| :------------: | :----: | :----: |
|   creazione    | CREATE | INSERT |
|    modifica    | ALTER  | UPDATE |
| cancellazione  |  DROP  | DELETE |
| interrogazione |        | SELECT |

**DDL** (schema logico) ➔ tabella, lista
**DML** (livello d'istanza) ➔ variazioni su tuple della tabella

#### Tipi di stato

Suddivisi in:

- **Tipi predefiniti**:
  - tipi carattere ➔ CHAR - VARCHAR;
  - tipi numerici ➔ DECIMAL (numero totale di numeri, cifre dopo la virgola);
  - tipi temporali ➔ DATA - CURRENT_DATE
    - EXTRACT (YEAR, DAY, MONTH FROM <attributo>) ➔ funzione che serve per estrarre da una data un giorno/ mese/ anno;
  - Booleani;
  - BLOB, CLOB: per grandi immagini e testi.
- **Tipi user-defined** ➔ creare tipi di dato, vanno parte delle caratteristiche obect-relational.

#### DDL : creazione di relazioni

```SQL
CREATE TABLE Prodotti(
  codP CHAR(6) PRIMARY KEY,
  nomeP VARCHAR(20) UNIQUE NOT NULL,
  colore VARCHAR(6),
  taglia SMALLINT,
  magazzino VARCHAR(15)
);
```

- se ci sono due chiavi primarie si scrive ➔ **PRIMARY KEY (A1, A2)**;
- se ci sono 2 chiavi alternativa si scrive ➔ **UNQUE (A1, A2)**;
- la combinazione **UNIQUE NOT NULL** permette di definire una chiave alternativa che non ammette valori **sconosciuti (?)**;

```SQL
CREATE TABLE Video(
  colloc DECIMAL(4) PRIMARY KEY,
  titolo VARCHAR(30) NOT NULL,
  regista VARCHAR(20) NOT NULL,
  tipo CHAR NOT NULL DEFAULT 'd',
  FOREIGN KEY (titolo, regista) REFERENCES Film
);
```

- la specifica di chiave esterna nella definizione della tabella si scrive **FOREIGN KEY**:
  - deve essere accompagnata da nome relazione puntata ➔ **REFERENCES < nome relazione >**

```SQL
CREATE TABLE Noleggio(
  colloc DECIMAL(4) REFERENCES Video ON DELETE CASCADE ON UPDATE CASCADE,
  dataNol DATE DEFAULT CURRENT_DATE,
  codCli DECIMAL(4) NOT NULL REFERENCES Cliente ON DELETE CASCADE ON UPDATE CASCADE,
  dataRest DATE,
  PRIMARY KEY (colloc, dataNol),
  UNIQUE (colloc, dataRest)
);
```

- **CANCELLAZIONE E MODIFICA** di tabelle referenti:

  - **CASCADE** ➔ cancella gli elementi presenti anche nella tabella riferita;
  - **NO ACTION** ➔ non permette la cancellazione;
  - **SET NULL**;
  - **SET DEFAULT**.

#### DDL: gestione delle relazioni

- **CANCELLAZIONE:**
  - **DROP TABLE** < nome relazione >
    - **CASCADE** ➔ cancella le tabelle a cui fa riferimento;
    - **RESTRICT** ➔ elemento _non rimosso_ se è presente in qualche definizione di un altro elemento (di default)
- **MODIFICARE:**
  - **ALTER TABLE** < nome relazione > < operazione di modifica >
    - aggiunta nuova colonna ➔ **ADD < specifica colonna >**;
    - definire/cancellare/modificare valori default per una colonna esistente ➔ **ALTER** < nome colonna >
      - **SET DEFAULT** < valore default >
      - **DROP DEFAULT**
    - eliminazione colonna ➔ DROP < nome colonna >
    - definizione vincolo integrità ➔ **ADD COSTRAINT** [nomevincolo]< specifica vincolo >
    - eliminazione vincolo integrità esistente ➔ **DROP CONSTRAIN** < nome vincolo >
