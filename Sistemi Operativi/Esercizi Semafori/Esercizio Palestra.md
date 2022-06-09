```c
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