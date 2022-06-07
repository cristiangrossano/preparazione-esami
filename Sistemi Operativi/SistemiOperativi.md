# Sistemi Operativi

## Cos'è un sistema operativo?

Non esiste una riposta effettiva a questa domanda, però si può provare a darne una almeno dal punto di vista tecnico.

I livelli sono **_HARDWARE_**, **_SO_** (precedentemente citati) e **_GUI_**.

L'HARDWARE opera in due modalità

1. user (GUI);
2. kernel (SO) .

La modalità viene determinata da un bit nel registro **_PSW_** (Program Status Word)

**_Il sistema operativo esegue in modalità kernel_**.
Ogni altro programma esegue in modalità **_user_**.

Esempio: Cambio di programma sul PC.
Assumendo che voglio passare dall'applicazione di Spotify a quella di Chrome, la sequenza delle azioni sarà la seguente.

1. Spotify in modalità user.
2. Il sistema operativo viene eseguito in modalità kernel.
3. Chrome viene avviato in modalità user.

Quando utilizzo un computer non interagisco con il SO, ma con la GUI.

- La GUI esegue in modalità user.
- Non fa parte del SO, anche se tutti i SO hanno una GUI.
- NON è indispensabile.
- Esistono dei programmi che girano in USER, ma comunque aiutano il SO.

> La GUI **_non è indispensabile_** percchè ogni programma potrebbe comunque essere eseguito ugualmente in _Shell/CMD_

---

## Cosa fa un sistema operativo?

- Consente la multiprogrammazione
- Realizza la memoria virtuale
- Realizza un ambiente multiutente

> Nella **_multiprogrammazione_** il processore viene utilizzato a turno dai diversi programmi.
>
> Con la **_Memoria Virtuale_** l'elaboratore viene illuso di avere una RAM che in realtà non ha.

Considerando una macchina fisica con un processore, una ram e senza fil esiste un "macchina virtuale" che ci gira sopra, questo viene creato dal sistema operativo (S.O.).
Questa macchina virtuale ha _n_ processori, una RAM _teoricamente_ infinita nella quale i file sono una realtà esistente.
Esso, fondamentalmente, svolge due compiti:

1. Gestisce i file;
2. Gestisce i processi (multiprogrammazione).

Il **Kernel level** e **User level** communicano tramite **_system call interface_**.

Esempio.
Per la riga di codice:

```java
system.out.println("ciao")
```

Non abbiamo Java che 'magicamente' scrive "ciao", bensì, per eseguire questa azione deve richiedere l'intervento del Sistema Operativo tramite **_system call interface_**.
Ovviamente per questo intervento il calcolatore passerà in modalità kernel.

---

## Storia dei sistemi operativi

Per comprendere al meglio come funzionano i sistemi operativi attuale, necessitiamo di conoscere i sistemi operativi degli anni '60.

### Sistema Batch

Le macchine venfono utilizzate per **calcoli scientifici**.
Il programma viene **_inciso_** su una scheda, che prende il nome di **_JOB_**.

> Job = processo degli anni '60.

Le istruzioni che utilizzano il sistema operativo vengono precedute dal simbolo **'$'**.

- **_$JOB_** = Inizio del processo;
- **_$FORTRAN_** per compilare il codice;
  > ovviamente si usa questo comando se il linguaggio viene scritto in FORTRAN, un po' come quando utilizziamo il comando javac, per
  > compilare java.
- **_$LOAD_** per caricare l'eseguibile in RAM;
- **_$RUN_** per eseguire;
- **_$END_** fine del processo.

Tutti i programmi di quel periodo storico servivano per trasformare dei dati forniti in INPUT.
Nella END i dati venivano sempre forniti in OUTPUT.

Ovviamente ci sono macchine diverse:

- legge le schede che contengono i programmi e le mette in un nastro di input;
- Legge il nastro e usa il SO per eseguire i programmi, carica i dati sul nastro di output.
  > Questa macchina comprende il compilatore nel **_nastro di sistema_**
- Stampa il nastro output.

Il SO batch divide la ram in system area e user area.
La user area può **_eseguire solo un JOB alla volta_**, quello in esecuzione.
Quindi nella RAM sono sempre presenti:

- codice e dati del sistema operativo;
- codice e dati dell'unico JOB in esecuzione.

> Con il tempo la user area diventerà disponibile sempre a più programmi, non più uno solo.

**_Grazie ai batch i tempi di utilizzo della CPU vengono ridotti_**.

Ai tempi i processori erano veramente costosi, non ci si poteva permettere di non utilizzarli.
Con questo sistema a tre macchine si mettevano sul nastro di lettura 10/20 programmi, facendo in modo che il processore non si fermasse mai, eseguendo 20 processi uno dopo l'altro.
I sistemi di batch quindi consentono un utilizzo **_efficiente della CPU_** a discapito del servizio dell'utente.

Le funzioni del sistema di batch sono:

- scheduling banale, processi eseguiti nell'ordine in cui viene letto il nastro
- gestione memoria banale
  - una parte al SO
  - una parte al JOB
- Protezione, anche se due JOB non possono coesistere in memoria, è necessaria la protezione perchè:
  - un job non può utilizzare la locazione di memoria destinata ad un altro job
  - un job non può accedere alla system area, quindi non può accedere a locazioni di memoria destinate al sistema.

---

### Terza generazione, Circuiti integrati

Nascono gli editor, le macchine vengono utilizzate per calcoli scientifici che richiedono parecchia CPU.
Ci sono le interfacce, consentito l'utilizzo della tastiera.
**_Il sistema operativo può eseguire programmazione_**, prende il nome di kernel.

Ora la memoria viene partizionata, più job vengono caricati in memoria.

- System Area
  - kernel
- User Area
  - JOB 1
  - JOB fino a n
  - Free memory

Se JOB 1 richiede la memoria di un registro (lenta), il sistema operativo si occupa di questa lettura **_mentre_** il processore si occupa del JOB 2.
**_L'hardware deve quindi consentire a CPU e dispositivi di lavorare in parallelo_**.
Il periodo di I/O è un tempo 'morto', per questo in quel momento viene consentita l'esecuzione del JOB 2.
Questo diventa possibile perchè ci sono più job caricati in memoria.
Quando l'operazione di I/O viene conclusa, il JOB torna a quellu schedulabili, questo significa che prima o poi il processore verrà nuovamente utilizzato da lui.

Da sottolineare la differenza tra:

- **_CPU BOUND_**
  > sono dei programmi che fanno dei calcoli, utilizzo alto di CPU e basso di I/O.
- **_I/O BOUND_**
  > sono dei programmi che utilizzano dati, utilizzo alto di I/O e basso di CPU.

L'operazione in cui il sistema operativo scheglie a chi dare la CPU tra chi la richiede, si chiama scheduling.

**_IMPORTANTE_**  
Nessun programma deve uscire dalla memoria che gli è stata dedicata.
Job 2 deve utilizzare solo i registri di memoria che si trovano nella sua parte di RAM.

Il processore contiene due registri (_lower e upper bound_) che contengono i due registri estremi di un determinato processo.
Il confronto degli indirizzi di memoria viene eseguito da un modulo hardware che controlla se il registro con il quale si vuole interagire è compreso tra upper e lower bound.
Se non viene trovata nessuna corrispondenza questo viene communicato all'hardware.
Il segnale di interruzione arriva al processore, bloccando la sua esecuzione.
In pratica il processore viene stroatto al jobn ed entra in gioco il SO.

Vi sono due modalità di gestione:

- partitioning (statico) a tutti la stessa memoria.
- pooling (dinamico) a seconda di quanta memoria richiede un job viene separata.

Ovviamente il pooling **_è più efficace_** si evita di avere troppi registri non usati e non si rischia di non avere abbastanza spazio per un job.

**_Il rapporto tra programmi eseguiti e spazio utilizzato si chiama throughput_**.  
Per massimizzarlo bisogna creare le condizioni affinchè tutti i programmi vadano in parallelo.
Lo scheduler di conseguenza deve privileggiare i programmi che fanno uno di I/O, in modo da spostarsi da un JOB ad un altro ogni volta che viene rischiesta una interazione di lettura/scrittura.

**_Con i sistemi multiprogrammati vengono introdotti due concetti:_**

1. _program priority_, ad ogni programma viene assegnata una priorità;
2. _preemption_, il processore viene tolto forzatatamente al processo che lo stava utilizzando;
   1. Se è in esecuzione un programma di CPU BOUND e un processo di I/O BOUND ha finito la sua operazione di input/outout allora il processore tornerà forzatamente a questo
   2. **_Viene fatto per migliorare il throughput_**

In questo periodo storico nascono gli **_hard disk_**, quindi non vi è più la necessità di utilizzare i natsri di lettura.
Questo concede alla multiprogrammazione di arricchirsi con lo **_spooling_**.
I programmi quindi sono caricati in memoria, nel momento in cui un job termina, il suo contenuto **viene spostato** nell'hard disk e sulla RAM viene caricato un nuovo programma.

Nasce il concetto di avere più terminali collegati allo stesso calcolatore.
Diventa estremamente importante dare ad ogni soggetto che utilizza un terminale l'idea di star interagendo continuamente con il calcolatore.
Nasce di conseguenza il concetto di **time-sharing**, ogni tot tempo il processore passa da un terminale ad un altro.

**Multiprogrammazione:** priorità, preemption throughput.

**Time Sharing:** Round robin, time slice, tempi di risposta.

**_IMPORTANTE_**  
Quando lo scheduled è _in funzione_, quindi quando sta passando da un processo ad un altro o da un terminale ad un altro, utilizza il processore togliendo tempo all'esecuzione.
Si parla, in questo caso, di **overhead**.

Quindi ad esempio avere un context switch frequente garantisce maggiore interattività ma ovviamente danneggia il throughput.

---

### Quarta generazione, Circuiti Integrati

A partire dagli anni '80 si diffondono i PC.  
I computer diventano quindi personali (Personal Computer) quindi bisogna renderne più facile l'utilizzo.  
Per questo vengono introdotte le **GUI**.

#### Richiami di architettura e system call

Il SO interagisce direttamente con l'hardware.  
Il progettista del SO deve conoscere l'hardaware su cui gira il SO.

**_CPU_**

Preleva delle istruzioni dalla memoria, le decodifica e le esegue, il suo tradizionale ciclo:

```mermaid
graph TD;
Fetch --> Decode;
Decode --> Execute;
Execute --> Goto;
Goto --> Fetch;
```

Il processore possiede registri generali e registri di controllo.

- **_Registri Generali_** = utilizzati dalla ALU (primo livello della gerarchia di memoria)
- **_Registri di Controllo_** = servono per far funzionare la CPU

I principali registri della CPU sono:

- **_Program Counter_** (PC): Indirizzo dell'istruzione da prelevare
- **_Stack Pointer_** (SP): Puntatore al top dello stack, contenente i frame delle procedure già iniziate, ma non ancora terminate
- **_Program Status Word_** (PSW):
  - **_Privileged Mode_** (PM): bit di modalità user/kernel
  - **_Condition Mode_** (CC): codici di condizione impostati da istruzioni di confronto/codici di proprietà di operazioni aritmetiche
  - **_Interruct Mask_** (IM): bit usati per gestire interrupt
  - **_Interrupt Code_** (IC): bit usati per gestire interrupt
- **_Memory Protection Information_** (MPI): informazioni sulla porzione di memoria accessibile.

I primi due registri contengono indirizzi di memoria.  
I registri di Upper e Lower Bound sono parte del **PSW**.

Le istruzioni privilegiate sono quelle che permettono di nodificare i valori del registro PSW.  
Quest'ultime sono eseguibili solo in modalità kernel.  
Ovviamente i programmi non possono modificare parametri necessari al funzionamento del processore.

#### Interruzioni

Il SO entra in gioco in due maniere:

- quando viene chiamato dal programma
- quando un programma sta svolgendo un'azione non contemplata e di conseguenza va fermato;

**L'interruzione è un meccanismo che informa il processore dell'accadimento di qualcosa che deve essere trattato.**  
L'obbiettivo dell'interruzione è duplice:

1. si ferma il normale ciclo di intervento della CPU, interrompere l'esecuzione del programma
2. richiedo intervento del SO

**Come si manifesta l'INTERRUPT?**  
Viene eseguito da un segnale hardware, sulla linea del BUS.  
Il segnale può essere inviato dal programma in esecuzione oppure dal clock/controller di un dispositivo.

**Interruzioni HARDWARE**  
Si tratta di eventi asincroni rispetto al programma in esecuzione.

- interruzioni I/O (utilizzate per notificare qualcosa al processore)
- interruzioni timer (segnale inviato dal clock quando il tempo messo a disposizione al programma termina)

**Nel momento in cui un job termina la sua operazione I/O necessita del processore.**
**La fine del I/O del job causa una interruzione, questa permette di far fronte al job tra quelli schedulabili.**

Nel momento in cui si verifica una interrupt **il processore** non esegue più come istruzione successiva quella localizzata nel PC ma va ad eseguire la prima del interrupt handler.  
Quando il sistema operativo ha svolto il suo compito allora il programma che era in esecuzione prima potrà ripartire dall’istruzione che si trova nel pc.  
**Nell’interrupt handler si trova che cosa bisogna fare per gestire l’interruzione.**

Può capitare che mentre è in esecuzione l’interrupt handler si verifichi un’altra interrupt;

succede la stessa identica cosa:
Nel caso di salto tra i due handlers non c’è il passaggio da user a kernel dato che siamo già in modalità kernel.
Quando si torna ai programmi in modalità user sarà lo scheduler a decidere se quando si è verificata la interrupt era in esecuzione word non è detto che ricomincerà l’esecuzione di word.

**Gestione interrupt a cascata.**

Gli interrupt vengono organizzati in classi di priorità

- quando si gestisce una certa richiesta di interrupt, tutte quelle della stessa classe o di classi inferiori vengono ignorate. Tali richieste (quelle ignorate) rimangono pendenti.

**In che modo vengono ignorati gli interrupt con priorità minore?**  
Tramite l'**IM** (interrupt mask).  
Questa sequenza di bit dice quali interruzioni sono trattabili (enabled) e quali invece non lo sono (Masked Off).  
Quando il programma gira in modalità user tutti gli interrupt sono abilitati, inoltre il programma non può cambiare i valori del PSW, quindi di conseguenza nemmeno quelli del IM.

Per ogni **classe di interrupt** si trova un **interrupt vector**, situato nella locazione di memoria riservata al SO.  
Il vettore contiene l'indirizzo alla prima istruzione della interruzione relativa.  
Ovviamente quando questo indirizzo viene caricato sul PC, allora la prossima istruzione eseguita sarà proprio quella.  
Sempre nell'interrupt handler **sono contenuti** i valori che devono prendere i registri della PSW.

Per ogni classe di interrupt si ha una **SRIA** che serve a memorizzare i valori seguenti nei registri:

- PC
- SP
- PSW

**Cosa succede quando arriva una interruzione abilitata?**

Viene inviato un segnale via hardware.  
Questo segnale importa l'**IC** della **PSW** che serve a comunicare al SO, le cause dell'interruzione.  
I valori dei registri dei PC, SP, PSW relativi al programma P vengono salvati nella **SRIA**.

> Vengono salvati i valori che avevano i vari registri, così una volta terminata l'interrupt si torna alla normale esecuzione

I registri PC e PSW vengono quindi impostati in base a ciò che veniva trasmesso deel relativo interrupt vector.  
L'interrupt handler può quindi far ripartire.

**Cosa fa l'interrupt handler?**

Quando vengono eseguite le primissime istruzioni dell'IH vengono salvate nella RAM le informazioni dei registri generali (quelli del programma in esecuzione prima dell'interrupt).  
Con registri generali si intendono tutti quelli che non devono essere salvati via hardware.  
**Una volta fatto questo valori del programma P sono stati salvati.**  
Successivamente l'handler esegue il codice apposito per gestire l'interruzione.  
Il codice sfrutta il valore dell'IC.  
Terminate le sue operazioni **salta allo scheduler**, che selezionerà il programma P', dato che non è detto che **P = P'.**

**Cosa fa lo scheduler dopo che ha selezionato P'?**

I valori dei registri generali erano stati salvati da qualche parte, vanno recuperati.  
Vanno ripristinati anche tutti i registri di controllo, spesso l'architettura offre l'istruzione **IRET** che permette di recuperare tutti i registri in un colpo.  
**A differenza del salvataggio, i registri di controllo possono essere ripristinati via software.**

### DISPOSITIVI DI I/O e IMA

**Come il processore interagisce con i dispoitivi.**  
Tutti i dispositivi vanno visti come una coppia dispositivo/controllore.  
Il SO interagisce solamente con i controllori ( solo in modaità kernel).  
Il **controller** è una componente elettronica che communica con il processore (e le altre unità) **tramite bus**.  
Il controller gestisce i dispositivi.  
**Può gestire più dispositivi contemporaneamente.**  
L'interfaccia tra CPU e controller viene usata dai componenti del SO. (**i driver**).  
I'interfaccia contiene:

- porte i/p, dette anche registri di controllo

  > usati dalla dalla CPU per communicare con il controller (dare/ricevere informazioni)

- buffer
  > serve a memorizzaare i dati durante le operazioni di I/O

Ci sono due possibili soluzioni per communicazioni tra CPU e porte I/O:

1. Porte di I/O gestite con istruzioni macchina

> le communicazioni sono di due tipi:
>
> dalle porte di I/O ai registri del processore e viceversa.
> Questre istruzioni devono essere **privilegiate**, per impedire che in modalità user si riesca ad accedere ai dispositivi.

2. Memory Mapped I/O
   > Ad ogni porta I/O viene assegnato un indirizzo di memoria, non servono istruzioni ad hoc.
   > Gli indirizzi non sono visibili dai programmi che dovranno invocare il SO per fare le oerazioni di I/O.
   >
   > In questa soluzione i driver possono essere scritti in **C**.

**Il modo con cui avvengono le communicazioni tra CPU e dispositivi non è univoco, cu sono 3 metodi diversi.**.

> Le prime due hanno dei problemi, sono obsolete, ma conoscerle aiuta nel comprendere il terzo metodo.

**Soluzione 1 - Programmed I/O.**

```java
  for (i = 0; i < n; i++){
    while(device_status_reg != READY){
      //busy waiting
    }
    buffer = b[i]
  }
```

Il driver del dispositivo tramite il **device status register** vede se il dispositivo è pronto ad eseguire una nuova operazione oppure no.  
Questo stato è definito da dei BIT.  
Il cidce mostra che quando il dispositivo è 'ready' allora nel buffer del dispositivo verranno trasferiti byte di b, **uno alla volta.**

**Il grande problema di questo metodo è che fino a quando il dispositivo è occupato il processore è inutilizzato. Non si sfruttano gli interrupt.**

Con **busy waiting** si intende il periodo di attesa in cui il processore viene utilizzato per aspettare.

**Soluzione 2 - Interrupt Driven I/O.**

```java
while(device_status_reg != READY){
  // busy waiting solo all'inizio
}
buffer = b[0];
c = 1;
i = 1;
scheduler() // P lascia la CPU, la riotterrà a operazione conclusa
```

> Nel motodo precedente il **busy waiting** c'era sempre, anche tra un Byte e l'altro (da b[i] a b[i + 1])  
> Adesso c'è solo nella prima interazione, poi non è più presente.

```java
if(c==n){
  unblock_user(); // il programma P può ripartire
} else {
  buffer = b[i] //chiedo al device il prossimo transfer ed attendo il prossimo interrupt
  i = i + 1;
  c = c + 1;
}
return_from_interrupt()
```

Questo è il codice eseguito dall'interrupt handler.  
Quando il trasferimento di ogni byte viene controllato, il controllore manda un interrupt.  
In questo momento ricominciano le iterazioni del handleer che tra il trasferimento di un byte e quello successivo permette di far andare avanti un programma.  
Il processo è decisamente troppo macchinoso, per **n byte** ci sono **n interrupt**.

**Soluzione 3**

L'architettura prevede un controllore **Direct Memory Access (DMA)**, capace di accedere direttamente alla memoria e di lavorare in parallelo con la CPU.  
Il processore dice al controllore del DMA di trasferire i dati.  
Il controllore del disco manderà sempre una interruzione per ogni byte, questa volta però la interrupt arrivano al controllore del DMA.  
Il controllore del DMA farà praticamete lo stesso che faceva l'handler nella soluzione 2.  
**Quando tutto il trasferimento termina allora il controllore del DMA manderà unn interrupt al processore.**

```java
set_up_DMA_CONTROLLER(); // IMPOSTO REGISTRI DEL CONTROLLER
scheduler(); // P lascio la CPU, la riotterrò ad operazione conclusa
```

Si usano le porte di I/O del cntrollore DMA per dirgli che cosa fare (le istruzioni vengono salvate nelle porte).

Lo scheduler schedula un diagramma diverso che verrà eseguito dalla CPU in parallelo alle operazioni eseguite dal DMA.

### Program Interrupt

Oltre agli hardware interrupt, esistono due tipi di program interrupt:

- eccezioni;
- software interrupt.

Eccezioni:

- eccezioni aritmetiche;
- eccezioni di indirizzamento;
- violazioni delle protezioni di memoria.

**Contrariamente agli interrupt hardware, le eccezioni non sono eventi asincroni rispetto alla esecuzione del programma.**
Sono eventi causati da situazione anomale verificatosi all'interno del programma. devono essere trattate dal SO.  
Può essere che il SO imponga la terminazione immediata del programma.

**Software Interrupt (trap)**  
Sono causati da una istruzione apposita, chiamata trap.  
Sono interventi usati per chiedere esplicitamente l'intervento del SO.

> **NOTA BENE** > **TRAP** = Istruzione linguaggio macchina;
> **trap** = Software interrupt instruction.

L'istruzione TRAP è l'unica che permette di chiedere l'intervento del sistema operativo, per questo motivo sono necessario definire, in qualche modo, che tipo di servizio si vuole richiedere.

- la TRAP ha un **parametro** che specifica il tipo di intervento richiesto (individua il servizio). Può essere passato in due modi:
  - come operando della TRAP ( se quest'ultima pretende operandi);
  - ponendolo sullo stack.

Gerarchia:

1. Machine Error;
2. Clock Interrupt;
3. Disk Interrupt;
4. Fast Device Interrupt;
5. Slow Device Interrupt;
6. Exception;
7. Trap.

Le program iinterrupt hanno gerarchi inferiore rispetto alle hardware interrupt.

Il vettore relativo alle program interruption è il Program Interrupt Vector che: (Fase 2):

- contiene il riferimento al primo bit del relativo handler quindi **PC = aaa**;
- sposta il bit nella modalità su kernel quindi **PM = 1**.

L'interrupt handler (Fase 3):

- salva il contenuto dei registri generali;
- controllo l'IC per individuare il parametro;
- esegue le sue funzioni;
- invoca lo scheduler.

Una **Systema Call** è una richiesta al sistema operativo effettuata da un programma.

- le system call sono strumenti messi a disposizione dei programma per avvalersi dei servizi offerti dal SO;
- vengono realizzate con la TRAP:
  - per ogni parametro c'è una system call diversa. Se i bit del IC sono n, ci saranno 2^n system call.

In corrispondenza ad ogni chiamata di sistema si ha una funzione di libreria (utilizzata dai linguaggi di programmazione).
Le funzioni di libreria invocano la TRAP.

## PROCESSI

### Memory Layout dei programmi

L'esecuzione di un programma necessita di tre aree di memoria, tradizionalmente dette **regioni**:

- area di testo
  - contiene il testo del programma in un linguaggio macchina, non è modificabile dall'esecuzione del programma;
- area di dati:
  - contiene le variabili globali del programma, quelle condivide da tutte le procedure (metodi). I valori variano in un contenuto e in dimensione;
- area di stack
  - contiene i record di attivazione delle procedure già chiamate, ma non ancora terminate. Anche qui il contenuto è varibile sia in contenuto sia in dimensione

Per le strutture dati dinamiche delle procedure si usa una particolare dell'area dati, detta **area heap**.

> In Java i valori di un array vengono memorizzati proprio in questa area.

**Il codice di un programma contiene indirizzi di memoria che si riferiscono a ognuna di queste zone.**
Gli indirizzi sono **virtuali**, sarà la MMU a tradurli nei veri indirizzi.

La memoria virtuale è resa possibile da un registro della architettura, il **Relocatione Register (RR)**.
Questo permette alla MMU di tradurre gli indirizzi giusti.
Supponendo che io voglia mettere dei dati nell'indirizzo 1 e questo occupato.
Il SO non mi dice che è occupato.
Cerca un indirizzo libero e memorizza il dato li.
Nel Relocation Register viene salvato di quanto è stato spostato l'indirizzo.
Se da 1 l'indirizzo passa a a1001 allora il RR avrà valore 1000.
Quindi nella memoria virtuale il registro sarà 1 mentre nella memoria effettiva 1001.

### Definizione Processo

**Un processo è un'istanza di un programma in esecuzione.**
Ci possono essere più processi relativi allo stesso programmma. Possono infatti esserci anche più esecuzioni in contemporanea dello stesso programma.
E' importante che le diverse esecuzioni non si diano fastidio a vicenda, per questo è necessario che ogni processo possa modificare/leggere solo le sue locazioni di memoria.

Il programma in se è quindi una entità passiva, non esegue nessuna azione.
L'esecuzione del programma, chiamata processo, **concretizza le azioni** del programma.
**Le entità schedulate dal SO, sono perciò processi, non i programmi.**
Anche le aree di memoria viste in precedenza sono associate al **programma in esecuzione** quindi ad un processo.

**Un processo consiste delle seguenti componenti:**

- stato della CPU;
- Area di Testo;
- Area Dati;
- Area di Stack;
- Risorse Fisiche (hardware) e logiche assegnate al processo.

### Parallelismo e Concorrenza

In generale si dice che due eventi sono paralleli se occorrono nello stesso momento.
CHiaramente disponendo di una macchina con solo un processore non è possibile che i processi associati a questi programmi vengano eseguiti in parallelo da che un processore può eseguire una sola istruzione per volta.
**La concorrenza è l'illusione del parallelismo**

## Esercizi Semafori

### Problema dello sleeping barber

In un barber shop lavora un solo barbiere, vi è una sola sedia adibita al taglio, e vi sono N sedie per i clienti in attesa.
Assumiamo N=20.

#### Comportamento del barbiere

- all'apertura del negozio si mette a dormire nella sedia adibita al taglio, in attesa che un cliente entri e lo svegli;
- quando ci sono clienti in attesa, il barbiere li chiama e li serve uno alla volta;
- quando non ci sono clienti in attesa, il barbiere si rimette a dormire nella sedia adibita al taglio.

#### Comportamento del cliente

- quando entra nel negozio, se non ci sono sedie libere va a cercarsi un
  altro barbiere;
- quando entra nel negozio, se c'è almeno una sedia libera ne occupa una, svegliando il barbiere se sta dormendo, ed attendendo di essere chiamato dal barbiere per il taglio.

#### Programmare il barbiere ed il singolo cliente

```java
semaphore clients_in_shop = 0;
barber_free = 0;
mutex = 1;

int waiting_clients = 0; //variabile condivisa

final int CHAIRS = 20;

barbiere(){
  while(true){
    wait(clients_in_shop);
    wait(mutex);
    waiting_clients = waiting_clients - 1;
    signal(barber_free);
    signal(mutex);
    cut_hair()
  }
}

cliente(){
  wait(mutex);
  if(waiting_clients < CHAIRS){
    waiting_clients = waiting_clients + 1;
    signal(client_in_shops);
    signal(mutex);
    receive_cut();
  } else {
    signal(mutex)
  }
}
```

### Problema del ponte

Un vecchio ponte consente di attraversare il ponte in solo due direzioni:

1. Nord 🠞 Sud
2. Sud 🠞 Nord

- per ragioni di peso, in ogni istante più di un veicolo non può passare sul ponte;
- se un veicolo trova il ponte occupato, attende che si liberi (non è previsto che il veicolo decida di rinunciare ad attraversare il ponte);
- dopo che un veicolo ha attraversato il ponte in una direzione, se ci sono veicoli in attesa su entrambi i lati allora deve passare per primo un veicolo che viaggia nella direzione opposta.

Programmare il veicolo che viaggia in senso:

- Nord 🠞 Sud (**goingToSouth**);
- Sud 🠞 Nord (**goingToNorth**).

```java
semaphore mutex = 1;
toNorth = 0;
to South = 0;
boolean bridgeFree = true;
int bookToNorth = 0;
int bookToSouth = 0;

enteringNorth(){
  wait(mutex);
  if(bridgeFree){
    bridgeFree = false;
    signal(mutex)
  } else {
    bookToSouth++;
    signal(mutex);
    wait(toSouth);
  }
}

exitingSouth(){
  wait(mutex);
  if(bookToNorth > 0){
    bookToNorth--;
    signal(toNorth);
  } else {
    if(bookToSouth > 0){
      bookToSouth--;
      signal(toSouth);
    } else {
      bridgeFree = true;
    }
  }
  signal(mutex);
}

goingToSouth(){
    enteringNorth();
    crossingToSouth();
    exitingSouth();
  }

goingToNorth(){
  enteringSouth();
  crossingToSouth();
  exitingNorth();
}
```

Supponiamo che il ponte abbia problemi di peso e possa reggere più veicoli, ma abbia una sola corsia:

- essendoci una sola corsia, in ogni istante tutti i veicoli sul ponte devono andare nella medesima direzione;
- un veicolo può entrare sul ponte nei seguenti casi:
  - il ponte è libero;
  - sul ponte ci sono veicoli che stanno andando nella medesima direzione e dall'altro lato del ponte non ci sono veicoli in attesa.

```java
semaphore mutex = 1;
toNorth = 0;
toSouth = 0;
int bookToNorth = 0;
int bookToSouth = 0;
int goingToNorth = 0;
int goingToSouth = 0;

enteringNorth(){
  wait(mutex);
  if(goingToNorth = 0 & bookToNorth = 0){
    goingToSouth++;
    signal(mutex);
  } else {
    bookToSouth++;
    signal(mutex);
    wait(toSouth)
  }
}

exitingSouth(){
  wait(mutex);
  goingToSouth--;
  if(goingToSouth = 0){
    while(bookToNorth > 0){
      goingToNorth++;
      bookToNorth--;
      signal(toNorth);
    }
  }
  signal(mutex);
}
```

Per smaltire il traffico con maggior efficienza, supponiamo ora che quando un veicolo è in attesa ad un lato del ponte perché altri veicoli stanno andando verso il lato in cui si trova, sia consentito ad ulteriori 10 veicoli di entrare dal lato opposto.

```java
semaphore mutex = 1;
toNorth = 0;
toSouth = 0;
boolean bridgeFree = true;
int bookToNorth = 0;
int bookToSouth = 0;
int goingToNorth = 0;
int goingToSouth = 0;
extraToNorth = 0;
extraToSouth = 0;

enteringNorth(){
  wait(mutex);
  if(goingToNorth = 0 & bookToNorth = 0){
    goingToSouth++;
    signal(mutex);
  } else {
  if(goingToSouth > 0 & extraToSouth < 10){
    extraToSouth++;
    goingToSouth++;
    signal(mutex);
    } else {
      bookToSouth++;
      signal(mutex);
      wait(toSouth)
    }
  }
}

exitingSouth(){
  wait(mutex);
  goingToSouth--;
  if(goingToSouth = 0){
   if(extraToSouth = 0){
     extraToSouth = 0;
   }
   while(bookToNorth > 0){
     goingToNorth++;
     bookToNorth--;
     signal(toNorth);
   }
  }
  signal(mutex)
}

```

### Parcheggio

Un parcheggio ha 30 posti, due ingressi con sbarra, A e B, ed infine un'uscita.

Quando un veicolo si presenta ad uno dei due ingressi, se c'è almeno un posto entra, parcheggia ed esce dal parcheggio, altrimenti prenota l'ingresso ed attende di poter entrare.  
Se ci sono veicoli in attesa ad entrambi gli ingressi, vengono fatti entrare quando altri veicoli escono dal parcheggio, aprendo le due sbarre alternativamente.  
Quando un veicolo esce dal parcheggio, se ci sono veicoli in attesa almeno uno dei due ingresssi, ne fa entrare uno.

```java
semaphore mutex = 1;
gateA = 0;
gateB = 0;
int bookA = 0;
int bookB = 0;
freeSlots = 30;
turn = 0;

enteringA(){
  wait(mutex);
  if(freeSlots > 0){
    freeslots--;
    signal(mutex);
  } else {
    bookA++;
    signal(mutex);
    wait(gateA);
  }
}

enteringB(){
  wait(mutex);
  if(freeSlots > 0){
    freeslots--;
    signal(mutex);
  } else {
    bookA++;
    signal(mutex);
    wait(gateB);
  }
}

inA(){
  enteringA();
  park();
  exiting();
}

inB(){
  enteringB();
  park();
  exiting();
}

exiting(){
  wait(mutex);
  if(freeSlots = 0){
    if((turn = 0 | book == 0) & bookA > 0){
      bookA--;
      turn = 1;
      signal(gateA);
    } else {
      if(bookB > 0){
        bookB--;
        turn = 0;
        signal(gateB)
      } else {
        freeSlots++;
      }
    } else {
      freeSlots++;
    }
    signal(mutex);
  }
}

```
