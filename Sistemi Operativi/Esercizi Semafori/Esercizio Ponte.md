# Problema del ponte

Un vecchio ponte consente di attraversare il ponte in solo due direzioni:

1. Nord 🠞 Sud
2. Sud 🠞 Nord

- per ragioni di peso, in ogni istante più di un veicolo non può passare sul ponte;
- se un veicolo trova il ponte occupato, attende che si liberi (non è previsto che il veicolo decida di rinunciare ad attraversare il ponte);
- dopo che un veicolo ha attraversato il ponte in una direzione, se ci sono veicoli in attesa su entrambi i lati allora deve passare per primo un veicolo che viaggia nella direzione opposta.

Programmare il veicolo che viaggia in senso:

- Nord 🠞 Sud (**goingToSouth**);
- Sud 🠞 Nord (**goingToNorth**).

```c
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

```c
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

```c
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
