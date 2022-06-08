# Esercizi Semafori

## Problema dello sleeping barber

In un barber shop lavora un solo barbiere, vi è una sola sedia adibita al taglio, e vi sono N sedie per i clienti in attesa.
Assumiamo N=20.

### Comportamento del barbiere

- all'apertura del negozio si mette a dormire nella sedia adibita al taglio, in attesa che un cliente entri e lo svegli;
- quando ci sono clienti in attesa, il barbiere li chiama e li serve uno alla volta;
- quando non ci sono clienti in attesa, il barbiere si rimette a dormire nella sedia adibita al taglio.

### Comportamento del cliente

- quando entra nel negozio, se non ci sono sedie libere va a cercarsi un
  altro barbiere;
- quando entra nel negozio, se c'è almeno una sedia libera ne occupa una, svegliando il barbiere se sta dormendo, ed attendendo di essere chiamato dal barbiere per il taglio.

### Programmare il barbiere ed il singolo cliente

```c++
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

```c++
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

```c++
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

```c++
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

```c++
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

```c++
/*
Una palestra può ospitare al massimo 40 clienti. Esistono due tipologie di cliente:
- regular
- premium
Un cliente premium può essere ammesso alla palestra solo se c’è almeno un posto libero.
Un cliente regular può essere ammesso alla palestra solo se sono verificate entrambe le seguenti due condizioni:
- c’è almeno un posto libero;
- la palestra ha meno di 20 posti occupati, altrimenti, se la palestra ha già almeno 20 posti occupati, allora almeno la metà dei posti occupati deve essere occupata da clienti premium.
Programmare l’ingresso e l’uscita dalla palestra per entrambi i tipi di processo cliente, nel rispetto di quanto segue:
- Se un cliente non può entrare, va messo in attesa.
- Non può capitare che un cliente sia in attesa e il suo eventuale ingresso non violerebbe le regole sopra precisate.
*/

mutex = 1, clientiR = 0, clientiP = 0;
int posti = 40, codaR = 0, codaP = 0, premiumIn = 0, regularIn = 0;

regular(){
 entraR();
 allenamento();
 esceR();
}

premium(){
 entraP();
 allenamento();
 esceP();
}

entraP(){
 wait(mutex);
 if(posti > 0){
  posti--;
  premiumIn++;
  signal(mutex);
 }else{
  codaP++;
  signal(mutex);
  wait(clientiP);
 }
}

entraR(){
 wait(mutex);
 if(posti > 0){
  if(premiumIn + regularIn < 20 || posti > 20 && premiumIn >= posti/2){
   posti--;
   regularIn++;
   signal(mutex);
  }else{
   codaR++;
   signal(mutex);
   wait(clientiR);
  }
 }else{
  codaR++;
  signal(mutex);
  wait(clientiR);
 }
}

esceP(){
 wait(mutex);
 posti++;
 premiumIn--;
 if(codaP > 0){
  posti--;
  codaP--;
  premiumIn++;
  signal(clientiP);
 }else{
  if(codaR > 0){
   if(posti > 0){
    if(premiumIn + regularIn < 20 || posti > 20 && premiumIn >= posti/2){
     posti--;
     codaR--;
     regularIn++;
     signal(clientiR);
    }
   }
  }
 }
 signal(mutex);
}

esceR(){
 wait(mutex);
 posti++;
 regularIn--;
 if(codaR > 0){
  if(posti > 0){
   if(premiumIn + regularIn < 20 || posti > 20 && premiumIn >= posti/2){
    posti--;
    codaR--;
    regularIn++;
    signal(clientiR);
   }
  }
 }else{
  if(codaP > 0){
   posti--;
   codaP--;
   premiumIn++;
   signal(clientiP);
  }
 }
 signal(mutex);
}
```

```c++
/*
Un'area giochi è accessibile da gruppi formati da 2, 3, 4 persone.
L'area giochi può ospitare al massimo 50 persone.
Programmare l'ingresso e l'uscita di ognuno dei 3 tipi di gruppo,
assicurando quanto segue:
- un gruppo di N persone, con N in {2, 3, 4}, non può accedere all'area giochi e
deve essere messo in attesa se i posti disponivili sono meno di N.
- un gruppo di N persone non può essere in attesa se ci sono almeno N
posti disponibili nell'area giochi.
*/

mutex = 1;
gruppoD = 0;
gruppoT = 0;
gruppoQ = 0;

int posti = 50, int attesaD = 0, int attesaT = 0, int attesaQ = 0;

GruppiDue(){
 entraD();
 gioca();
 esceD();
}

GruppiTre(){
 entraT();
 gioca();
 esceT();
}

GruppiQuattro(){
 entraQ();
 gioca();
 esceQ();
}

entraD(){
 wait(mutex);
 if(posti >= 2){
  posti = posti - 2;
  signal(mutex);
 }else{
  attesaD++
  signal(mutex);
  wait(gruppoD);
 }
}

entraT(){
 wait(mutex);
 if(posti >= 3){
  posti = posti - 3;
  signal(mutex);
 }else{
  attesaT++
  signal(mutex);
  wait(gruppoT);
 }
}

entraQ(){
 wait(mutex);
 if(posti >= 4){
  posti = posti - 4;
  signal(mutex);
 }else{
  attesaQ++
  signal(mutex);
  wait(gruppoQ);
 }
}

esceD(){
 wait(mutex);
 posti = posti + 2;
 while (posti >= 2 && attesaD > 0){
  posti = posti - 2;
  attesaD--;
  signal(mutex);
  signal(gruppoD);
  wait(mutex);
 }
 while (posti >= 3 && attesaT > 0){
  posti = posti - 3;
  attesaT--;
  signal(mutex);
  signal(gruppoT);
  wait(mutex);
 }
 while (posti >= 4 && attesaQ > 0){
  posti = posti - 4;
  attesaQ--;
  signal(mutex);
  signal(gruppoQ);
  wait(mutex);
 }
 signal(mutex);
}

esceT(){
 wait(mutex);
 posti = posti + 3;
 while (posti >= 3 && attesaT > 0){
  posti = posti - 3;
  attesaT--;
  signal(mutex);
  signal(gruppoT);
  wait(mutex);
 }
 while (posti >= 4 && attesaQ > 0){
  posti = posti - 4;
  attesaQ--;
  signal(mutex);
  signal(gruppoQ);
  wait(mutex);
 }
 while (posti >= 2 && attesaD > 0){
  posti = posti - 2;
  attesaD--;
  signal(mutex);
  signal(gruppoD);
  wait(mutex);
 }


 signal(mutex);
}

esceQ(){
 wait(mutex);
 posti = posti + 4;
 while (posti >= 4 && attesaQ > 0){
  posti = posti - 4;
  attesaQ--;
  signal(mutex);
  signal(gruppoQ);
  wait(mutex);
 }
 while (posti >= 3 && attesaT > 0){
  posti = posti - 3;
  attesaT--;
  signal(mutex);
  signal(gruppoT);
  wait(mutex);
 }

 while (posti >= 2 && attesaD > 0){
  posti = posti - 2;
  attesaD--;
  signal(mutex);
  signal(gruppoD);
  wait(mutex);
 }


 signal(mutex);
}
```

```c++
/* 
Un parcheggio può ospitare motoveicoli e autoveicoli.

I posti disponibili sono 100.

Un motoveicolo occupa 1 posto. Un autoveicolo occupa 2 posti.

Quando i veicoli intendono entrare nel parcheggio, possono essere ammessi nel rispetto delle seguenti regole:

1. Nel parcheggio non sono ammessi veicoli se non c'è posto sufficiente a ospitarli.

2. Nel parcheggio sono ammessi al massimo 90 motoveicoli.

3. Nel parcheggio sono ammessi al massimo 45 autoveicoli.

Chi vuol parcheggiare e non può perché altrimenti verrebbero violate le regole sopra elencate, deve essere messo in attesa.

Scrivere le procedure di ingresso e uscita dal parcheggio per i motoveicoli e per gli autoveicoli. 
*/

mutex = 1, moto = 0, auto = 0;
int posti = 100, int codaA = 0, codaM = 0, autoIn = 0, motoIn = 0;

automobile(){
 entraA();
 sosta();
 esceA();
}
motocicletta(){
 entraM();
 sosta();
 esceM();
}

entraA(){
 wait(mutex);
 if (posti >= 2 && autoIn <=45){
  posti = posti - 2;
  autoIn++;
  signal(mutex);
 }else{
  codaA++;
  signal(mutex);
  wait(auto);
 }
}

entraM(){
 wait(mutex);
 if (posti >= 1 && motoIn <=90){
  posti = posti - 1;
  motoIn++;
  signal(mutex);
 }else{
  codaM++;
  signal(mutex);
  wait(moto);
 }
}

esceA(){
 wait(mutex);
 posti = posti + 2;
 autoIn--;
 if(codaA > 0 && autoIn < 45){
  posti = posti - 2;
  codaA--;
  autoIn++;
  signal(auto);
 }else if(codaM > 0){
  if(posti > 0 && motoIn < 90){
   posti--;
   codaM--;
   motoIn++;
   signal(moto);
  }
 }
 signal(mutex);
}

esceM(){
 wait(mutex);
 posti = posti + 1;
 motoIn--;
 if(codaM > 0 && motoIn < 90){
  posti--;
  codaM--;
  motoIn++;
  signal(moto);
 }else if(codaA > 0){
  if(posti > 0 && autoIn < 45){
   posti = posti - 2;
   codaA--;
   autoIn++;
   signal(auto);
  }
 }
 signal(mutex);
}
```

```c++
/*
Un negozio può ospitare al massimo 50 clienti, che sono classificati come "clienti con green pass
base" e " clienti con green pass rafforzato". Programmare l'ingresso nel negozio ed uscita dal negozio dei
thread "cliente con green pass base" e "cliente con green pass rafforzato".
E' necessario rispettare i seguenti vincoli:
 a. Se nel negozio sono già presenti 50 clienti, nessun cliente può entrare.
 
 b. Anche nel caso in cui nel negozio ci siano meno di 50 clienti, i clienti con green pass base non
 possono entrare se nel negozio sono già presenti almeno 10 clienti con green pass base oppure se il 
 negozio ospita già almeno 18 clienti e la frazione di clienti con green pass base è maggiore di 1/3.
 
 c. Il cliente che desidera entrare nel negozio ma non può farlo deve essere messo in attesa
 
 d. Se un cliente è in attesa di entrare in negozio allora il suo ingresso violerebbe la condizione
 "a" oppure la condizione "b" (no attese senza ragione).
*/

mutex = 1, gpBase = 0, gpRafforzato = 0;
int posti = 50, frazione = 3, attesaBase = 0, attesaRafforzato = 0, gpBaseIn = 0, gpRafforzatoIn = 0;

greenpassBase(){
 entraGPBase();
 compra();
 esceGPBase();
}

greenpassRafforzato(){
 entraGPRafforzato();
 compra();
 esceGPRafforzato();
}

entraGPBase(){
 wait(mutex);
 if(posti < 50 && gpBaseIn <= 10 || posti < 50 && gpBaseIn <= posti / frazione){
  gpBaseIn++;
  posti--;
  signal(mutex);
 }else{
  attesaBase++;
  signal(mutex);
  wait(gpBase);
 }
}

entraGPRafforzato(){
 wait(mutex);
 if(posti < 50){
  posti--;
  gpRafforzatoIn++;
  signal(mutex);
 }else{
  attesaRafforzato++;
  signal(mutex);
  wait(gpRafforzato);
 }
}

esceGPBase(){
 wait(mutex);
 posti--;
 gpBaseIn--;
 if(attesaBase > 0 || attesaRafforzato > 0){
  if(attesaRafforzato >= attesaBase){
   posti--;
   gpRafforzatoIn++;
   signal(gpRafforzato);
  }else{
   if(posti < 50 && gpBaseIn <= 10 || posti < 50 && gpBaseIn <= posti / frazione){
    gpBaseIn++;
    posti--;
    signal(gpRafforzato);
   }
  }
 }
 signal(mutex);
}

esceGPRafforzato(){
 wait(mutex);
 posti--;
 gpRafforzatoIn--;
 if(attesaBase > 0 || attesaRafforzato > 0){
  if(attesaRafforzato >= attesaBase){
   posti--;
   gpRafforzatoIn++;
   signal(gpRafforzato);
  }else{
   if(posti < 50 && gpBaseIn <= 10 || posti < 50 && gpBaseIn <= posti / frazione){
    gpBaseIn++;
    posti--;
    signal(gpRafforzato);
   }
  }
 }
 signal(mutex);
}
```

```c++

```

```c++

```
