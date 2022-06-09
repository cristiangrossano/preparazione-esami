```c
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
