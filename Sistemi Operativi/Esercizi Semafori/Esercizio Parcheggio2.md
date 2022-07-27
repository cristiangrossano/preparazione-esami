# Parcheggio

Un parcheggio ha 30 posti, due ingressi con sbarra, A e B, ed infine un'uscita.

Quando un veicolo si presenta ad uno dei due ingressi, se c'è almeno un posto entra, parcheggia ed esce dal parcheggio, altrimenti prenota l'ingresso ed attende di poter entrare.  
Se ci sono veicoli in attesa ad entrambi gli ingressi, vengono fatti entrare quando altri veicoli escono dal parcheggio, aprendo le due sbarre alternativamente.  
Quando un veicolo esce dal parcheggio, se ci sono veicoli in attesa almeno uno dei due ingresssi, ne fa entrare uno.

```c
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