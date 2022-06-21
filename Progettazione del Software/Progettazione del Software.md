# Progettazione del software

## Qualità

Lo standart **ISO 9126** definisce la **qualità** del software in termini di 6 caratteristiche:

- funzionalità;
- affidabilità;
- usabilità;
- efficienza;
- manutenibilità;
- portabilità.

ciascuna delle quali è a sua volta definita in varie sottocaratteristiche.

### Funzionalità

_Definizione_: L'insieme di attrivuti che riguardano l'esistenza di un complesso di funzioni e delle specifiche proprietà. Le funzioni sono quelle che soddisfano i requisiti stabiliti ed impliciti.  

Questaè la caratteristica primaria del software: riguarda _cosa_ deve fare l'applicazione (requisiti funzionali), mentre le altre caratteristiche riguardano _come_ (requisiti non funzionali).  

Infatti nella prima versione dello standard, la _funzionalità_ era chiamata _correttezza_.

### Affidabilità

_Definizione_: L'insieme di attributi che riguardano la capacità del prodotto software di mantenere il livello di prestazioni con condizioni e limiti di tempo fissati.  
Questa caratteristica riguarda la frequenza dei malfunzionamenti: nella definizione, la parola "prestazioni" si riferisce al funzionamento corretto ( oppure no) del software e non alla sua velocità.  

Per valutare l'affidabilità, bisogna specificare la probabilità che si verifichi un errore:

- in un dato periodo di tempo, (in un periodo più lungo si ha più probabilità di malfunzionamenti);
- usando il software in un determinato modo (con più funzionalità o con un unso più intenso si alza la probabilità di malfunzionamenti).

Nel caso delle applicazioni critiche questo studio viene effettuato attraverso appositi modelli matematici.

_Osservazione_: L'affidabilità del software ha natura diversa rispetto a quella dei sistemi fisici, perchè il software non si logora.  

### Usabilità

_Definzione_: L'insieme di attributi che riguardano lo sforzo necessario all'uso del prodotto e alla valutazione individuale di tale uso relativamente a un insieme di utenti prefissato o implicito.  

L'usabilità:

- dipende dall'utente per cui il software è stato previsto;
- riguarda non solo gli utenti finali, ma anche installatori, operatori, etc;
- comprende anche lo _sforzo di valutazione_, cioè l'utente deve poter capire se l'applicazione è adatta alle sue esigenze.

### Efficienza

_Definizione_:  L'insieme di attributi che riguardano la relazione esistente tra il livello delle prestazioni del prodotto software e la quantità delle risorse necessarie nell'ambito delle condizioni fissate.  
Questa caratteristica si riferisce all'utilizzo di risorse, tra cui:

- tempo;
- spazio di memoria;
- occupazione della banda (per mezzi di communicazione).

### Manutenibilità

_Definzione_: L'insieme degli attributi che riguardano lo sforzo necessario a eseguire le modifiche.

La manutenzione del software si suddivide in 3 tipologie:

- **correttiva** : correzione dei bug;
- **perfettiva** : miglioramento del software mediante l'aggiunta di funzionalità;
- **adattiva** : adeguamento del software cambiando delle specifiche e/o dell'ambiente circostante.

Le sottocaratteristiche della manutenibilità sono:

1. _analizzabilità_: deve essere possibile indicare le porzioni di software da modificare;
2. _modificabilità_: bisogna poter effettuare facilmente le verifiche;
3. _stabilità_: quando si effettua una modifica a una parte del programma, non devono esserci effetti inattesi che richiedono modifiche anche a altre parti;
4. _testabilità_: il risultato delle modifiche deve poter essere convalidato.

### Portabilità

_Definizione_: L'insieme degli attributi che riguardano la capacità del prodotto softwware di essere trasferito da un ambiente ad un altro.

Le differenze tra ambiti possono essere:

- _organizzative_: esempio -> organizzazioni diverse potrebbero avere flussi di informazioni diverse;
- _software_: esempio -> sistemi operativi diversi, ma anche diverse versioni dello stesso SO;
- _hardware_.

### Uso del modello

1. Per ogni sottocaratteristica, si valuta un insieme di misure;
2. Si calcola il punteggio di ciascuna sottocaratteristica, come somma pesata sulle misure (stabilendo i pesi in base alle esigenze dell'ambiente d'uso dell'applicazione);
3. Si calcola il punteggio di ciascuna caratteristica, corrispondente a una somma pesata dei punteggi delle sue sottocaratteristiche;
4. Da una somma pesata dei punteggi delle varie caratteristiche si ricava il punteggio complessivo del software.

In questo modo, è possibile confrontare prodotti diversi e/o stabilire degli obbiettivi (valori di soglia) che una determinata applicazione deve raggiungere per essere adeguata a particolari esigenze.  

## casi particolari esercizi test e analisi

### DUA (definition use anullament)

- ```int a``` dentro alla funzione è **annullament**, mentre quando è nel prototipo è **definition**;
- int ```a = 0``` è solo **definizione**;
- ```++a``` e ```a++``` da soli corrispondono a ```a=a+1```, quindi ud (use - definition);
- ```b=++a``` corrisponde a ```a=a+1; b=a;``` quindi avremo udu (use - definition - use);
- ```b=a++``` corrisponde a ```b=a; a=a+1;``` quindi avremo uud (use - use - definition);
- ```do{...}while(a>0);``` corrisponde a (...u)*;
- ```while(a>0){...}``` corrisponde a u(...u)*;
- ```if(a>0){...} else{:::}``` corrisponde a ```u(...+:::)``` se ```:::``` non coinvolge a o se non c'è l'```else``` allora avremo u(...+E);
- ```for(a=0;a<n;a++){...}``` corrisponde a du(...udu)*;
- ```return(a++)``` farà il return di a e poi incrementerà, quindi dipende dallo scope in cui a esiste.

### BLACKBOX (testing)

Build (if possible) three sets of test data in such a way as to cover o all statements, but not all branches.

- è possibile solo nel caso in cui ci sia un ```if``` senza un ```else```
  > In questo caso serve inserire un dataset che verifichi la condizione dell'if sempre (per ogni iterazione se dentro un ciclo) o all branches, but not all conditions;
- è possibile solo nel caso ci sia una condizione composta (a&&b);
  > In questo caso serve inserire un dataset che verifichi due di tre delle possibilità di verità della condizione ad esempio (ab,a!b) senza (!ab) o all conditions
- bisogna coprire con il dataset tutte le possibili condizioni

Per dataset si intende anche un insieme di più tuple di input diversi che unendo le coperture vanno a verificare il punto in esame.

Ad esempio se ho dataset A che copre tutti gli statement ma non tutti i branch, B che copre i branch che non copre A e C che copre le condizioni non coperte da A e B in risposta alla prima richiesta posso usare A, per la seconda {A,B}, per la terza {A,B,C}.
